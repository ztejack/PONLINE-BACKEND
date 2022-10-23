package com.api.ponline.Services.Users;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.api.ponline.Models.Entity.Users.User;
import com.api.ponline.Models.Entity.Users.UserProvider;
import com.api.ponline.Models.Entity.Users.UserRole;
import com.api.ponline.Models.Repo.Users.UserRepo;

import net.bytebuddy.utility.RandomString;

@Service
@Transactional
public class UserService implements UserDetailsService{

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private JavaMailSender mailSender;

    @Override
    public User loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepo.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException(String.format("User with email '%s' not found", email)));
    }

    public User registeUser(User user, String siteURL) throws UnsupportedEncodingException, MessagingException {
        boolean userExist = userRepo.findByEmail(user.getEmail()).isPresent();

        if (userExist) {
            throw new RuntimeException(
                String.format("Pengguna dengan email '%s' sudah terdaftar", user.getEmail())
            );
        }
        // else if(user.getUserRole().equals(UserRole.PQOWNEDR)){
        //     throw new RuntimeException(
        //         String.format("Hubungi Admin Untuk Mendaftar Dengan Peran Tersebut")
        //     );
        // }

        String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        String randomCode = RandomString.make(64);
        user.setTokenVerification(randomCode);
        user.setIsVerify(false);
        user.setUserProvider(UserProvider.LOCAL);
        user.setDateCreated(new Date());
        user.setDateUpdate(new Date());
        userRepo.save(user);
        sendVerificationEmail(user, siteURL);
        return user;
    }

    private void sendVerificationEmail(User user, String siteURL) throws UnsupportedEncodingException, MessagingException {
        String toAddress = user.getEmail();
        String fromAddress = "support@ponline.com";
        String senderName = "PONLINE SUPPORT";
        String subject = "Please verify your registration";
        String content = "Dear [[name]],<br>"
                + "Please click the link below to verify your registration:<br>"
                + "<h3><a href=\"[[URL]]\" target=\"_self\">VERIFY</a></h3>"
                + "Thank you,<br>"
                + "PONLINE Teams.";
         
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
         
        helper.setFrom(fromAddress, senderName);
        helper.setTo(toAddress);
        helper.setSubject(subject);
         
        content = content.replace("[[name]]", user.getFullName());
        String verifyURL = siteURL + "/users/verify?token=" + user.getTokenVerification();
         
        content = content.replace("[[URL]]", verifyURL);
         
        helper.setText(content, true);
         
        mailSender.send(message);
    }

    public boolean userVerify(String verificationToken) {
        User user = userRepo.findByVerificationToken(verificationToken);
         
        if (user == null || user.isEnabled()) {
            return false;
        } else {
            user.setTokenVerification(null);
            user.setIsVerify(true);
            userRepo.save(user);
             
            return true;
        }
         
    }

    public Iterable<User> findAll() {
        return userRepo.findAll();
    }

    public List<User> findByUserRole(UserRole userRole) {
        return userRepo.findByUserRole(userRole);
    }


    
}
