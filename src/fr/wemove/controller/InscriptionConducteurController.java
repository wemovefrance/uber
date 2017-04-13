package fr.wemove.controller;

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
	public String inscriptionUtilisateur (@ModelAttribute("driver") Conducteur conducteur, BindingResult result, Model model){
		
		new ConducteurSubscribeValidator().validate(conducteur, result);
		
		if ( result.hasErrors()) {	
			
			return "accueildevenirconducteur";
		} 
	
		try {
		utilisateurDao.save(conducteur);
		} catch ( Exception e) {
			
			e.printStackTrace();
		}
		return "redirect:/accueil";
		
		
	}

}
