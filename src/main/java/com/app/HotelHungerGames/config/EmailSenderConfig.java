package com.app.HotelHungerGames.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailSenderConfig {
    private final JavaMailSender mailSender;


    @Autowired
    public EmailSenderConfig(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendEmail(SimpleMailMessage email) {
        mailSender.send(email);
    }


    public void sendEmailToWinner(String email) {
        SimpleMailMessage passwordResetEmail = new SimpleMailMessage();
        passwordResetEmail.setFrom("support@demo.com");
        passwordResetEmail.setTo(email);
        passwordResetEmail.setSubject("Auction in Hotel Hunger Games");
        passwordResetEmail.setText("Congratulations, you won auction!");
        sendEmail(passwordResetEmail);
    }
}