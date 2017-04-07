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
import fr.wemove.validator.ConducteurSubscribeValidator;


@Controller
public class InscriptionConducteurController {
	
	
	@Autowired
	private UtilisateurDAO utilisateurDao;
	

	
	@RequestMapping(value = "/accueil/inscriptionConducteur", method = RequestMethod.GET)
	public String devenirPartenaire ( Model model) {
		
		model.addAttribute("driver", new Conducteur());
		 
		return "accueildevenirconducteur";
	}
	
	
	@RequestMapping ( value = "/accueil/inscriptionConducteur", method = RequestMethod.POST)
	public String inscriptionUtilisateur (@ModelAttribute("driver") Conducteur conducteur, BindingResult result, Model model ){
		
		new ConducteurSubscribeValidator().validate(conducteur, result);
		
		if ( result.hasErrors()) {	
			
			return "accueildevenirconducteur";
		} 
	
		utilisateurDao.save(conducteur);
		
		return "accueil";
		
		
	}
	
	

}
