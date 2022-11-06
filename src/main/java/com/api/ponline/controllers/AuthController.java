package com.api.ponline.controllers;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.ponline.dto.ApiResponse;
import com.api.ponline.dto.AuthResponse;
import com.api.ponline.dto.user.LoginRequest;
import com.api.ponline.dto.user.ResetPasswordRequest;
import com.api.ponline.dto.user.SignUpRequest;
import com.api.ponline.exception.BadRequestException;
import com.api.ponline.exception.ResourceNotFoundException;
import com.api.ponline.model.user.AuthProvider;
import com.api.ponline.model.user.User;
import com.api.ponline.model.user.UserRole;
import com.api.ponline.repository.user.UserRepository;
import com.api.ponline.security.TokenProvider;
import com.api.ponline.util.PonTools;

import net.bytebuddy.utility.RandomString;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private TokenProvider tokenProvider;

    @Autowired
    private JavaMailSender mailSender;
    
    private PonTools ponTools;
    
    public AuthController(){
        this.ponTools = new PonTools();
    }
    
    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) throws UnsupportedEncodingException, MessagingException {

        User user = userRepository.findOneByEmail(loginRequest.getEmail());

        if (user!=null) {
            if (user.getEmailVerified()) {
                Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginRequest.getEmail(),
                            loginRequest.getPassword()
                    )
                );
    
                SecurityContextHolder.getContext().setAuthentication(authentication);
    
                String token = tokenProvider.createToken(authentication);
                return ResponseEntity.ok(new AuthResponse(token));
            }else{
                String token = RandomString.make(64);
                user.setTokEmailVerified(token);
                userRepository.save(user);
                
                ponTools.sendMailWithButton(
                    mailSender, 
                    user, 
                    "PONLINE SUPPORT ○ verify email", 
                    "Click the button below to verify your email.", 
                    "", 
                    "", 
                    "If the 'Verify Email' button cannot be used, click on the following link: ",
                    "Verify Email", 
                    ponTools.ponlineBaseUrl()+"/auth/verifymail?token=" + token
                    );

                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse(false, "Akun anda belum diverifikasi, Silahkan cek email untuk memverifikasi akun anda"));
            }
            
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse(false, "Akun anda belum terdaftar"));
        }
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpRequest signUpRequest) throws UnsupportedEncodingException, MessagingException {
        if(userRepository.existsByEmail(signUpRequest.getEmail())) {
            throw new BadRequestException("Alamat email sudah terdaftar");
        }
        
        User user = new User();
        user.setName(signUpRequest.getName());
        user.setEmail(signUpRequest.getEmail());
        user.setPassword(signUpRequest.getPassword());
        user.setProvider(AuthProvider.local);
        user.setRole(UserRole.ROLE_USER);

        String token = RandomString.make(64);
        user.setEmailVerified(false);
        user.setTokEmailVerified(token);

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        ponTools.sendMailWithButton(
            mailSender, 
            user, 
            "PONLINE SUPPORT ○ verify email", 
            "Click the button below to verify your email.", 
            "", 
            "", 
            "If the 'Verify Email' button cannot be used, click on the following link: ",
            "Verify Email", 
            ponTools.ponlineBaseUrl()+"/auth/verifymail?token=" + token
            );

        return ResponseEntity.ok(new ApiResponse(true, "Berhasil mendaftar, Silahkan cek email untuk verifikasi"));
    }

    @GetMapping("/verifymail")
    public ResponseEntity<?> verifymail(@RequestParam String token) {

        if(userRepository.findByTokEmailVerified(token).isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(false, "User not Found"));
        }

        User user = userRepository.findByTokEmailVerified(token).get(0);
        user.setEmailVerified(true);
        user.setTokEmailVerified(null);
        userRepository.save(user);
        return ResponseEntity.ok(new ApiResponse(true, "Berhasil memverifikasi email"));
    }

    @GetMapping("/forgotpassword")
    public ResponseEntity<?> forgotpassword(@RequestParam String email, HttpServletRequest request) throws UnsupportedEncodingException, MessagingException {
        if(!userRepository.existsByEmail(email)) {
            throw new ResourceNotFoundException("User", "Email", email);
        }

        User user = userRepository.findOneByEmail(email);
        String token = RandomString.make(64);
        user.setTokResetPassword(token);
        userRepository.save(user);
        ponTools.sendMailWithButton(
            mailSender, 
            user, 
            "PONLINE SUPPORT ○ forgot password", 
            "You are receiving this email because we received a password reset request for your account.", 
            "This password reset link will expire in 60 minutes.", 
            "If you did not request a password reset, no further action is required.", 
            "If you're having trouble clicking the \"Reset Password\" button, copy and paste the URL below into your web browser: ",
            "Reset Password", 
            ponTools.ponlineBaseUrl()+"/auth/resetpassword?token=" + token
            );

        return ResponseEntity.ok(new ApiResponse(true, "Silahkan cek email untuk mereset password anda"));

    }

    @PostMapping("/resetpassword")
    public ResponseEntity<?> resetPasswordUser(@RequestParam String token, @Valid @RequestBody ResetPasswordRequest resetPasswordRequest) {

        if(userRepository.findByTokResetPassword(token).isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(false, "User tidak di temukan"));
        }

        User user = userRepository.findByTokResetPassword(token).get(0);
        user.setPassword(passwordEncoder.encode(resetPasswordRequest.getPassword()));
        user.setTokResetPassword(null);
        userRepository.save(user);
        return ResponseEntity.ok(new ApiResponse(true, "Berhasil memperbarui password"));
    }

}
