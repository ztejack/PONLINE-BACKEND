package com.api.ponline.util;


import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import com.api.ponline.model.Entity.user.User;
import com.api.ponline.util.Templates.EmailContentTemplate;

public class PonTools {
    
    public EmailContentTemplate emailContentTemplate;
    

    public PonTools(){
        this.emailContentTemplate = new EmailContentTemplate();
    }
    
    public String ponlineEmail(){
        return "fredihermawan1211@gmail.com";
    }

    public String ponlineBaseUrl(){
        return "http://localhost:8080";
    }
    
    public void sendMailWithButton(
        JavaMailSender mailSender, User user, 
        String subject, String contentBody1, String contentBody2, String contentBody3, String contentBody4, 
        String labelButton, String link
        ) throws UnsupportedEncodingException, MessagingException {

        String content = emailContentTemplate.getMailButton(
            subject,
            link,
            labelButton,
            contentBody1,contentBody2,contentBody3,contentBody4

        );

         
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
         
        helper.setFrom("support@ponline.com", "PONLINE SUPPORT");
        helper.setTo(user.getEmail());
        helper.setSubject(subject);         
        helper.setText(content, true);
         
        mailSender.send(message);
    }
       
}
