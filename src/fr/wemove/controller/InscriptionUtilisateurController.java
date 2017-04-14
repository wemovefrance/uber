package fr.wemove.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.wemove.dao.UtilisateurDAO;
import fr.wemove.email.Mail;
import fr.wemove.model.Conducteur;
import fr.wemove.model.Utilisateur;
import fr.wemove.validator.UtilisateurSubscribeValidator;

@Controller
public class InscriptionUtilisateurController {

	
	
	@Autowired
	private UtilisateurDAO utilisateurDao;
	
	
	
	String fromAddr = "wemove.france@gmail.com";
	String subject = "WeMove : confirmation de votre inscription !";
	String body = "Bonjour, votre inscription à WEMOVE est validée";

	
	@RequestMapping(value = "/accueil/inscriptionUtilisateur", method = RequestMethod.GET)
	public String devenirPartenaire ( Model model) {
		
		model.addAttribute("user", new Utilisateur());
		
		return "accueildevenirutilisateur";
	}
	
	@RequestMapping ( value = "/accueil/inscriptionUtilisateur", method = RequestMethod.POST)
	public String inscriptionUtilisateur (@ModelAttribute("user") Utilisateur utilisateur, BindingResult result, Model model ){
		
		new UtilisateurSubscribeValidator().validate(utilisateur, result);
		
		if ( result.hasErrors()) {	
			
			return "accueildevenirutilisateur";
		} 
	
		
		this.utilisateurDao.save(utilisateur);
		
		
		String confFile = "config-bean.xml";
		
		@SuppressWarnings("resource")
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(confFile);
		
		Mail mail = (Mail) context.getBean("email");
		mail.sendEmail( utilisateur.getEmail(), fromAddr, subject, body );
		
		return "redirect:/accueil";
		
		
	}
	
	
}
