
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
@RequestMapping("/conducteur")
public class DriverController {
	
	@RequestMapping(value = "")
	public String accueil(Model model) {
		return "driveraccueil";
	}

	@RequestMapping(value = "carte")
	public String carte(Model model) {
		return "drivercarte";
	}

	@RequestMapping(value = "trajet")
	public String trajet(Model model) {
		return "drivertrajet";
	}

	@RequestMapping(value = "paiements")
	public String paiements(Model model) {
		return "driverpaiements";
	}

	@RequestMapping(value = "notifications")
	public String notifications(Model model) {
		return "drivernotifications";
	}

	@RequestMapping(value = "gestionprofil")
	public String gestionprofil(Model model) {
		return "drivergestionprofil";
	}
}
