package org.fi.fullaplication.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMessage.RecipientType;

@Service
public class MailServiceImpl implements MailService {

	@Autowired
	JavaMailSender mailSender;
	
	
	
	
	@Override
	public boolean sendMail(String from, String to, String subject, String message) {
		
		try {
			MimeMessage email = mailSender.createMimeMessage();
			email.addFrom(new InternetAddress[] {new InternetAddress(from)});
			email.addRecipient(RecipientType.TO, new InternetAddress(to));
			
			email.setSubject(subject);
			email.setContent(message,"text/html");
			mailSender.send(email);
		} catch (MailException | MessagingException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
