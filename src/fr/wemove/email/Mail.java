package fr.wemove.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;


@Service("email")
public class Mail {
	
	//@Autowired 
	private MailSender emailConfirmInscription;
	
	
	public void sendEmail(String toAddress, String fromAddress, String subject, String msgBody) {
		 
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(fromAddress);
		message.setTo(toAddress);
		message.setSubject(subject);
		message.setText(msgBody);
		emailConfirmInscription.send(message);
	}

}
