
package fr.wemove.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.wemove.dao.AdresseDAO;
import fr.wemove.dao.UtilisateurDAO;
import fr.wemove.model.Adresse;
import fr.wemove.model.Conducteur;
import fr.wemove.model.Utilisateur;
import fr.wemove.validator.ConducteurSubscribeValidator;
import fr.wemove.validator.UtilisateurSubscribeValidator;

@Controller
@RequestMapping("/conducteur")
public class DriverController {
	
	@Autowired
	private UtilisateurDAO utilisateurDAO;
	
	@Autowired
	private AdresseDAO adresseDAO;
	
	@RequestMapping(value = "monprofil")
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

	@RequestMapping(value = "/gestionprofil", method = RequestMethod.GET)
	public String gestionprofil(Model model) {
		
		model.addAttribute("driverUpdate", new Conducteur());
		
		return "drivergestionprofil";
	}
	
	@RequestMapping(value = "/gestionprofil", method = RequestMethod.POST)
	public String gestionprofil(@ModelAttribute("driverUpdate") Conducteur driverUpdate, BindingResult result, Model model, HttpSession session, HttpServletRequest request) {
		
		new ConducteurSubscribeValidator().validate(driverUpdate, result);
		
		if ( result.hasErrors()) {	
			
			return "drivergestionprofil";
		}
		
		String message = "modification(s) enregistrée(s)!";
		request.setAttribute("message", message);
		
		Conducteur conducteur = (Conducteur) session.getAttribute("conducteur");
		Adresse adresse = ( Adresse ) session.getAttribute("adresse");
		Adresse adresseUpdate = driverUpdate.getAdresse();
		//adresseUpdate = this.adresseDAO.update(adresse.getId_adresse(), adresseUpdate); 
		driverUpdate = this.utilisateurDAO.updateCond( conducteur.getId_user(),  driverUpdate);
		
		session.setAttribute("conducteur", driverUpdate);
		session.setAttribute("adresse", adresseUpdate);
		
		

		return "drivergestionprofil";
	}
	
	
	@RequestMapping ( value="/deconnexion")
	public void deconnexion ( HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		request.getSession().invalidate();
		
		response.sendRedirect ( request.getContextPath() + "/accueil");
		
	}
	
}
