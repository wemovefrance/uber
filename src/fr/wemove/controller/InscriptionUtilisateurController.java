package fr.wemove.controller;


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
	
		System.out.println(utilisateur.getEmail());
		System.out.println(utilisateur.getNom());
		
		this.utilisateurDao.save(utilisateur);
		
		return "redirect:/accueil";
		
		
	}
	
	
}
