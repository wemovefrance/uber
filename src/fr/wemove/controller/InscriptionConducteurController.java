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
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import fr.wemove.dao.UtilisateurDAO;
import fr.wemove.model.Adresse;
import fr.wemove.model.Conducteur;
import fr.wemove.validator.ConducteurSubscribeValidator;
import fr.wemove.validator.UtilisateurSubscribeValidator;


@Controller
public class InscriptionConducteurController {
	
	
	@Autowired
	private UtilisateurDAO utilisateurDao;
	
	@Autowired
	private ConducteurSubscribeValidator conducteurSubscribeValidator;

	
	@RequestMapping(value = "/accueil/inscriptionConducteur", method = RequestMethod.GET)
	public String devenirPartenaire ( Model model) {
		
		model.addAttribute("driver", new Conducteur());
		
		return "accueildevenirconducteur";
	}
	
	
	@RequestMapping ( value = "/accueil/inscriptionConducteur", method = RequestMethod.POST)
	public String inscriptionUtilisateur (@ModelAttribute("driver") Conducteur conducteur, BindingResult result, Model model) throws UnsupportedEncodingException{
		
		conducteurSubscribeValidator.validate(conducteur, result);
		
		if ( result.hasErrors()) {	
			
			return "accueildevenirconducteur";
		} 
	
		try {
		utilisateurDao.save(conducteur);
		} catch ( Exception e) {
			
			e.printStackTrace();
		}
		
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

		            String message = "Bonjour " + conducteur.getPrenom() + ", <br /> votre inscription au service WeMove est validée! <br /> <br /> <a href='frWeMove/accueil'> Accéder à votre espace personnel </a> pour bénéficier des services WeMove ! <br /> <br /> A votre service, <br/> L'équipe WeMove  ";

		            Message msg = new MimeMessage(session);
		            msg.setFrom(new InternetAddress("wemove.france@gmail.com", "Administrateur"));
		            msg.addRecipient(Message.RecipientType.TO,
		                             new InternetAddress(conducteur.getEmail()));
		            msg.setSubject("Bienvenue sur WeMove !");
		            msg.setContent(message, "text/html");
		            msg.saveChanges();
		            //msg.setText(message);
		            Transport.send(msg);
		        } catch (MessagingException e) {
		            e.printStackTrace();
		        }
		
		
		return "redirect:/accueil";
		
		
	}

}
