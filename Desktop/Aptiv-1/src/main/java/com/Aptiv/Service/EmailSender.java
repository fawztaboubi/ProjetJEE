package com.Aptiv.Service;


import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailSender {

	 @Autowired
	    private JavaMailSender mailSender;

	    public void sendSimpleEmail(String toEmail,
	                                String body,
	                                String subject) {
	        SimpleMailMessage message = new SimpleMailMessage();

	        message.setFrom("fawztaboubi66@gmail.com");
	        message.setTo(toEmail);
	        message.setText(body);
	        message.setSubject(subject);

	        mailSender.send(message);
	        System.out.println("Mail Send...");
	    }

	   
	

}
