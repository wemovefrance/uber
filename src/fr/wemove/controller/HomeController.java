
package fr.wemove.controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.wemove.dao.UtilisateurDAO;
import fr.wemove.model.Conducteur;
import fr.wemove.model.Utilisateur;

@Controller
@RequestMapping("/accueil")
public class HomeController {
	
	@RequestMapping(value = "",method = RequestMethod.GET)
	public String home(HttpServletRequest request) {
		/*
		UtilisateurDAO utilisateurDAO = new UtilisateurDAO(); 
		List <Double> latitudesConducteurs = utilisateurDAO.findConducteursLat() ;
		List <Double> longitudesConducteurs = utilisateurDAO.findConducteursLong() ;
		request.getSession().setAttribute("latitudesConducteurs",latitudesConducteurs) ;
		request.getSession().setAttribute("longitudesConducteurs",longitudesConducteurs) ;
		*/	
		ArrayList <Double> latitudesConducteurs = new ArrayList() ; 
		ArrayList <Double> longitudesConducteurs = new ArrayList() ;
		HttpSession session = request.getSession();
		latitudesConducteurs.add(43.456343) ;
		longitudesConducteurs.add(6.535101) ;
		latitudesConducteurs.add(43.409486) ;
		longitudesConducteurs.add(6.085163) ;
		session.setAttribute("latitudesConducteurs",latitudesConducteurs) ;
		session.setAttribute("longitudesConducteurs",longitudesConducteurs) ;
		System.out.println(longitudesConducteurs);
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



