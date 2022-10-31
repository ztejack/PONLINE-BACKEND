package com.api.ponline.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

public class MailSender {

    @Autowired
    private JavaMailSender mailSender;

    private PonTools ponTools;

    public void sendMailForgotPassword(String emailRecipient, String link) {
        
        SimpleMailMessage message = new SimpleMailMessage();
 
        message.setFrom(ponTools.getPonlineEmail());
        message.setTo(emailRecipient);

        String contentRaw = "<div style='width: 100%; display:flex; justify-content:center;'> <div style='width: 350px; display: flex; flex-direction: column; align-items: center; border-radius: 10px;'> <div style='width: 100%; display: flex; flex-direction: row; align-items: center;'> <img src='../images/logo_ponline_v1.png' alt='PONLINE' width='150px'> <div> <h1 style='color: #2ba5e0; margin: 0; padding: 0; text-align: center;'>PONLINE</h1> <span style='color: #2ba5e0; margin: 0; padding: 0; text-align: center;letter-spacing: 2.1px;'>future fish pond</span> </div> </div> <div style=' width: 100%; display: flex; align-items: center; flex-direction: column;'> <span>Tekan tombol di bawah untuk reset passwordmu guiss. <b> Jangan lupa banyak makan ikan biar ga pikun </b></span> <br><br> <a style='text-align: justify; text-decoration: none; font-weight: bold; background-color: #2ba5e0; padding: 10px; border-radius: 5px; border: none; color: azure; font-size: 10pt; cursor: pointer;' id='link_'>LABEL</a> </div> </div> </div>";
        String content = contentRaw.replace("id='link_'>LABEL", "id="+link+">RESET");
        message.setSubject("PONLINE SUPPORT • reset password ");
        message.setText(content);
        
        mailSender.send(message);
    }
    
}
