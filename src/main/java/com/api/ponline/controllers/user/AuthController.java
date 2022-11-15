package com.api.ponline.controllers.user;

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

import com.api.ponline.dao.Request.LoginRequest;
import com.api.ponline.dao.Request.ResetPasswordRequest;
import com.api.ponline.dao.Request.SignUpRequest;
import com.api.ponline.dao.Response.ApiResponse;
import com.api.ponline.dao.Response.AuthResponse;
import com.api.ponline.dao.exception.BadRequestException;
import com.api.ponline.dao.exception.ResourceNotFoundException;
import com.api.ponline.model.Entity.user.AuthProvider;
import com.api.ponline.model.Entity.user.User;
import com.api.ponline.model.Entity.user.UserRole;
import com.api.ponline.model.repository.user.UserRepository;
import com.api.ponline.security.TokenProvider;
import com.api.ponline.util.PonTools;

import net.bytebuddy.utility.RandomString;

// REST CONTROLLER API AUTHENTIFIKASI
@RestController
@RequestMapping("/auth")
public class AuthController {

    // AuthenticationManager => untuk manajemen autentifikasi
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
    
    // ENDPOINT LOGIN LOKAL
    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) throws UnsupportedEncodingException, MessagingException {

        // Cari user di database berdasarkan email
        User user = userRepository.findOneByEmail(loginRequest.getEmail());

        // jika user ada di database
        if (user!=null) {
            // jika email user sudah terverifikasi
            if (user.getEmailVerified()) {
                // buat autentifikasi baru
                Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginRequest.getEmail(),
                            loginRequest.getPassword()
                    )
                );
                
                // Setting autentifikasi 
                SecurityContextHolder.getContext().setAuthentication(authentication);
                // buat bareer token untuk akses
                String token = tokenProvider.createToken(authentication);

                // Respon 200 dan kembalikan token autentifikasi
                return ResponseEntity.ok(new AuthResponse(token));
            
                // jika email belum terverifikasi
            }else{
                // Buat token verifikasi email
                String token = RandomString.make(64);
                user.setTokEmailVerified(token);
                userRepository.save(user);
                
                // Kirimkan link untuk verifikasi email (media:kirim email)
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
                
                // response 500 dan kembalikan pesan untuk memverifikasi email
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse(false, "Akun anda belum diverifikasi, Silahkan cek email untuk memverifikasi akun anda"));
            }
        // Jika user tidak ada di database
        }else{
            // response 500 dan kembalikan pesan bahwa akun belum terdaftar
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse(false, "Akun anda belum terdaftar"));
        }
    }

    // ENPOINT REGISTER LOKAL
    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpRequest signUpRequest) throws UnsupportedEncodingException, MessagingException {
        // Jika user sudah ada di database
        if(userRepository.existsByEmail(signUpRequest.getEmail())) {
            // Respon 500, pesan user sudah terdaftar
            throw new BadRequestException("Alamat email sudah terdaftar");
        }
        
        // Jika belum terdaftar
        // Buat objek user
        User user = new User();
        user.setName(signUpRequest.getName());
        user.setEmail(signUpRequest.getEmail());
        user.setPassword(signUpRequest.getPassword());
        user.setProvider( AuthProvider.local);
        user.setRole(UserRole.ROLE_USER);

        // Buat token verifikasi email
        String token = RandomString.make(64);
        user.setEmailVerified(false);
        user.setTokEmailVerified(token);

        // Enkripsi password user
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        
        // Simpan user ke database
        userRepository.save(user);

        // Kirimkan email verifikasi
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

            // Respon 200, pesan perintahkan verifikasi email
        return ResponseEntity.ok(new ApiResponse(true, "Berhasil mendaftar, Silahkan cek email untuk verifikasi"));
    }

    // ENDPOINT verifikasi email
    @GetMapping("/verifymail")
    public ResponseEntity<?> verifymail(@RequestParam String token) {
        // Cek apakah user ada di database atau tidak
        if(userRepository.findByTokEmailVerified(token).isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(false, "User not Found"));
        }

        // Jika user ada setting email verifikasi = true
        User user = userRepository.findByTokEmailVerified(token).get(0);
        user.setEmailVerified(true);
        user.setTokEmailVerified(null);
        userRepository.save(user);
        // response 200
        return ResponseEntity.ok(new ApiResponse(true, "Berhasil memverifikasi email"));
    }

    // ENDPOINT lupa password
    @GetMapping("/forgotpassword")
    public ResponseEntity<?> forgotpassword(@RequestParam String email, HttpServletRequest request) throws UnsupportedEncodingException, MessagingException {
        // Cek user ada atau tidak
        if(!userRepository.existsByEmail(email)) {
            throw new ResourceNotFoundException("User", "Email", email);
        }
        
        // jika ada, buat token untuk reset password
        User user = userRepository.findOneByEmail(email);
        String token = RandomString.make(64);
        user.setTokResetPassword(token);
        userRepository.save(user);

        // Kirimkan link/token untuk reset password
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

        // respon 200
        return ResponseEntity.ok(new ApiResponse(true, "Silahkan cek email untuk mereset password anda"));

    }

    // ENDPOINT proses buat/ubah password
    @PostMapping("/resetpassword")
    public ResponseEntity<?> resetPasswordUser(@RequestParam String token, @Valid @RequestBody ResetPasswordRequest resetPasswordRequest) {
        // Cek user ada atau tidak
        if(userRepository.findByTokResetPassword(token).isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(false, "User tidak di temukan"));
        }

        // Jika ada, ganti password menjadi password baru
        User user = userRepository.findByTokResetPassword(token).get(0);
        user.setPassword(passwordEncoder.encode(resetPasswordRequest.getPassword()));
        user.setTokResetPassword(null);
        userRepository.save(user);
        
        // respon 200
        return ResponseEntity.ok(new ApiResponse(true, "Berhasil memperbarui password"));
    }

}
