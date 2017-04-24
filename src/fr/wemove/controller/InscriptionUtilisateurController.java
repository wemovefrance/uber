package fr.wemove.controller;


import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.wemove.dao.UtilisateurDAO;
import fr.wemove.model.Conducteur;
import fr.wemove.model.Utilisateur;
import fr.wemove.validator.UtilisateurSubscribeValidator;

@Controller
public class InscriptionUtilisateurController {

	
	
	@Autowired
	private UtilisateurDAO utilisateurDao;
	
	@Autowired
	private UtilisateurSubscribeValidator utilisateurSubscribeValidator;

	
	@RequestMapping(value = "/accueil/inscriptionUtilisateur", method = RequestMethod.GET)
	public String devenirPartenaire ( Model model) {
		
		model.addAttribute("user", new Utilisateur());
		
		return "accueildevenirutilisateur";
	}
	
	@RequestMapping ( value = "/accueil/inscriptionUtilisateur", method = RequestMethod.POST)
	public String inscriptionUtilisateur (@ModelAttribute("user") Utilisateur utilisateur, BindingResult result, Model model ) throws UnsupportedEncodingException{
		
		utilisateurSubscribeValidator.validate(utilisateur, result);
		
		if ( result.hasErrors()) {	
			
			return "accueildevenirutilisateur";
		} 
	
		
		this.utilisateurDao.save(utilisateur);
		
		final String username = "wemove.france.contact@gmail.com";
		final String password = "08080808";

			try {
		            Properties props = new Properties();
		            props.put("mail.smtp.auth", "true");
		            props.put("mail.smtp.starttls.enable", "true");
		            props.put("mail.smtp.host", "smtp.gmail.com");
		            props.put("mail.smtp.port", "587");

		            Session session = Session.getInstance(props,
		          		  new javax.mail.Authenticator() {
		          			protected PasswordAuthentication getPasswordAuthentication() {
		          				return new PasswordAuthentication(username, password);
		          			}
		          		  });

		            String message = "Bonjour votre inscription au service WeMove est validée!";

		            Message msg = new MimeMessage(session);
		            msg.setFrom(new InternetAddress("wemove.france@gmail.com", "Administrateur"));
		            msg.addRecipient(Message.RecipientType.TO,
		                             new InternetAddress(utilisateur.getEmail()));
		            msg.setSubject("Bienvenue sur WeMove !");
		            msg.setText(message);
		            Transport.send(msg);
		        } catch (MessagingException e) {
		            e.printStackTrace();
		        }

		return "redirect:/accueil";
		
		
	}
	
	
}
