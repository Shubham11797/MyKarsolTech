package com.MyKarsol.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.MyKarsol.Entity.EmailDetail;



@Service
public class SendEmailService {

	@Autowired
	private JavaMailSender sender;
	
	@Value("$(spring.mail.username)")
	private String fromEmailId; 
	
	/*
	 * This Method is used to send the simple emails and we want to send data then use can use MimeMessageHelper() 
	 * */
	public void sendEmail(EmailDetail email) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(fromEmailId);
		message.setTo(email.getRecipient());
		message.setSubject(email.getSubject());
		message.setText(email.getBody());
		
		sender.send(message);
	}
}

