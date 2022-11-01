package com.api.ponline.controllers;

import java.io.UnsupportedEncodingException;
import java.net.URI;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
import com.nimbusds.oauth2.sdk.http.HTTPResponse;

import net.bytebuddy.utility.RandomString;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private TokenProvider tokenProvider;


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
                sendMailVerification(user, "http://localhost:8080/auth");
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
        sendMailVerification(user, "http://localhost:8080/auth");


        // URI location = ServletUriComponentsBuilder
        //         .fromCurrentContextPath().path("/user/me")
        //         .buildAndExpand(result.getId()).toUri();

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
        sendMailForgotPassword(user, "http://localhost:8080/auth");
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

    private void sendMailForgotPassword(User user, String siteURL) throws UnsupportedEncodingException, MessagingException {
        String toAddress = user.getEmail();
        String fromAddress = "support@ponline.com";
        String senderName = "PONLINE SUPPORT ○ reset password";
        String subject = "Please verify your registration";
        String content = "Dear [[name]],<br>"
                + "Mohon cek link di bawah untuk membuat password baru<br>"
                + "<h3><a href=\"[[URL]]\" target=\"_self\">RESET</a></h3>"
                + "Thank you,<br>"
                + "PONLINE Teams.";
         
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
         
        helper.setFrom(fromAddress, senderName);
        helper.setTo(toAddress);
        helper.setSubject(subject);
         
        content = content.replace("[[name]]", user.getName());
        String resetLink = siteURL + "/resetpassword?token=" + user.getTokResetPassword();
         
        content = content.replace("[[URL]]", resetLink);
         
        helper.setText(content, true);
         
        mailSender.send(message);
    }

    private void sendMailVerification(User user, String siteURL) throws UnsupportedEncodingException, MessagingException {
        String toAddress = user.getEmail();
        String fromAddress = "support@ponline.com";
        String senderName = "PONLINE SUPPORT ○ reset password";
        String subject = "Please verify your registration";
        String content = "Dear [[name]],<br>"
                + "Mohon cek email di bawah untuk memverifikasi email anda :<br>"
                + "<h3><a href=\"[[URL]]\" target=\"_self\">VERIFY</a></h3>"
                + "Thank you,<br>"
                + "PONLINE Teams.";
         
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
         
        helper.setFrom(fromAddress, senderName);
        helper.setTo(toAddress);
        helper.setSubject(subject);
         
        content = content.replace("[[name]]", user.getName());
        String resetLink = siteURL + "/verifymail?token=" + user.getTokEmailVerified();
         
        content = content.replace("[[URL]]", resetLink);
         
        helper.setText(content, true);
         
        mailSender.send(message);
    }

}
