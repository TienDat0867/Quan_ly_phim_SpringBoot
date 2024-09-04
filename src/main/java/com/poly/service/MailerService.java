package com.poly.service;





import org.springframework.stereotype.Service;

import com.poly.model.MailInfo;

import jakarta.mail.MessagingException;
@Service
public interface MailerService {
	void send(MailInfo mail) throws MessagingException;
	void send(String to, String subject, String body) throws MessagingException;
	void queue(MailInfo mail);
	void queue(String to, String subject, String body);
}
