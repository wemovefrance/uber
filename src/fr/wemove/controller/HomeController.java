
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
	public String accueilfaq() {
		return "accueilfaq";
	}
	
	@RequestMapping(value = "/contact")
	public String accueilcontact() {
		return "contact";
	}


	@RequestMapping(value = "/quisommesnous")
	public String accueilquisommesnous() {
		return "accueilquisommesnous";
	}
	
	@RequestMapping(value = "/devenirpartenaire")
	public String devenirPartenaire () {
		return "accueildevenirpartenaire";
	}
}



