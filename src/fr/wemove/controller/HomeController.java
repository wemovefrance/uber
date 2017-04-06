
package fr.wemove.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.wemove.model.Conducteur;
import fr.wemove.model.Utilisateur;

@Controller
@RequestMapping("/accueil")
public class HomeController {
	
	@RequestMapping(value = "")
	public String home(Model model) {
		return "accueil";
	}
	
	@RequestMapping(value = "/faq")
	public String accueilfaq(Model model) {
		return "accueilfaq";
	}
	
	@RequestMapping(value = "/inscription", method = RequestMethod.GET)
	public String devenirPartenaire ( Model model) {
		
		model.addAttribute("utilisateur", new Utilisateur());
		model.addAttribute("conducteur", new Conducteur());
		
		return "accueildevenirpartenaire";
	}
	
	@RequestMapping ( value = "/inscription", method = RequestMethod.POST)
	public String inscriptionUtilisateur (@Valid @ModelAttribute ("utilisateur") Utilisateur utilisateur, BindingResult result, Model model) {
		if ( result.hasErrors()) {
			
			return "accueil_inscription";
			
		} 
		
		return "utilisateur_accueil";
	}
	
	@RequestMapping ( value = "/inscription", method = RequestMethod.POST)
	public String inscriptionConducteur (@ Valid @ModelAttribute ("conducteur") Conducteur conducteur, BindingResult result, Model model) {
		
	if ( result.hasErrors()) {
			
			return "accueil_inscription";
		
	}
	
	return "driver_account";
	}
	
	@RequestMapping(value = "/QuiSommesNous", method = RequestMethod.GET)
	public String quisommesnous ( Model model) {
		
		return "quisommesnous";
	}

}



