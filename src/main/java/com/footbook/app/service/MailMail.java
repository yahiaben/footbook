package com.footbook.app.service;

import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

public class MailMail
{
	/**
	 * mailSender
	 */
	private MailSender mailSender;
	
	/**
	 * modifie le mail du mailSender
	 * @param mailSender
	 */
	public void setMailSender(MailSender mailSender) {
		this.mailSender = mailSender;
	}
	
	/**
	 * envoie le mail
	 * @param from mail de l'envoyeur
	 * @param to mail du recepteur
	 * @param subject sujet du mail
	 * @param msg message du mail
	 */
	public void sendMail(String from, String to, String subject, String msg) {

		SimpleMailMessage message = new SimpleMailMessage();
		message.setReplyTo(from);
		message.setFrom(from);
		message.setTo(to);
		message.setSubject(subject);
		message.setText(msg);
		mailSender.send(message);	
	}
}
