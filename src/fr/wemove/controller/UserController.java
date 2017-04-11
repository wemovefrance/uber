
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
@RequestMapping("/utilisateur")
public class UserController {
	
	@RequestMapping(value = "")
	public String accueil(Model model) {
		return "utilisateuraccueil";
	}

	@RequestMapping(value = "trajet")
	public String trajet(Model model) {
		return "utilisateurtrajet";
	}
	
	@RequestMapping(value = "profilConducteur")
	public String profilConducteur(Model model) {
		return "utilisateurprofilchauffeur";
	}
	
	@RequestMapping(value = "demandeCourse")
	public String demandeCourse(Model model) {
		return "utlisateurdemandecourse";
	}
	
	@RequestMapping(value = "noteSourse")
	public String noteSourse(Model model) {
		return "utlisateurnotecourse";
	}

	@RequestMapping(value = "paiements")
	public String paiements(Model model) {
		return "utilisateurpaiements";
	}

	@RequestMapping(value = "notifications")
	public String notifications(Model model) {
		return "utilisateurnotifications";
	}

	@RequestMapping(value = "gestionprofil")
	public String gestionprofil(Model model) {
		return "utilisateurgestionprofil";
	}
}
