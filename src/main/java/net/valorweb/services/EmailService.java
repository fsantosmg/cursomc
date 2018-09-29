package net.valorweb.services;

import org.springframework.mail.SimpleMailMessage;

import net.valorweb.domain.Pedido;

public interface EmailService {

	void sendOrderConfirmationEmail(Pedido pedido);
	
	void sendEmail(SimpleMailMessage msg);
}
