package com.Learn.eduTrack.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailSender {

    private JavaMailSender emailSender;
    
    @Autowired
    public EmailSender ( JavaMailSender emailSender ) {
    	this.emailSender = emailSender;
    }
 
    public void sendSimpleMessage( String to, long password) {
       
        SimpleMailMessage message = new SimpleMailMessage(); 
        
        message.setFrom("noreply@yajuvendra0404.com");
        message.setTo(to); 
        message.setSubject("Change Password"); 
        message.setText("Hi \n Your temporary password is " + password + ". \n please change the password after you login.");
        
        emailSender.send(message);
       
    }
	
}
