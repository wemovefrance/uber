
package fr.wemove.controller;

import java.io.IOException;
import java.util.ArrayList;

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

import fr.wemove.dao.UtilisateurDAO;
import fr.wemove.model.Conducteur;
import fr.wemove.model.Trajet;
import fr.wemove.model.Utilisateur;

@Controller
@RequestMapping("/utilisateur")
public class UtilisateurController {
	
	@Autowired
	private UtilisateurDAO utilisateurDAO;
	
	@RequestMapping(value = "monprofil")
	public String accueil(Model model) {
		return "utilisateuraccueil";
	}

	@RequestMapping(value = "demandecourse", method= RequestMethod.GET)
	public String carte (Model model) {
		
		return "utilisateurdemandecourse";
	}

	
	@RequestMapping(value = "demandecourse", method= RequestMethod.POST)
	public String carte(@ModelAttribute("trajet") Trajet trajet , BindingResult result, Model model) {
		
		return "utilisateurdemandecourse";
	}

	@RequestMapping(value = "evaluationcourse")
	public String course(Model model) {
		return "utilisateurevaluationcourse";
	}
	
	@RequestMapping(value = "gestionprofil")
	public String gestionprofil(Model model) {
		return "utilisateurgestionprofil";
	}

	@RequestMapping(value = "gestiontrajets")
	public String trajets (Model model) {
		return "utilisateurgestiontrajets";
	}
	
	@RequestMapping(value = "gestiontransactions")
	public String paiements(Model model) {
		return "utilisateurgestiontransactions";
	}

	@RequestMapping(value = "notifications")
	public String notifications(Model model) {
		return "utilisateurnotifications";
	}
	
	@RequestMapping(value = "profilchauffeur", method= RequestMethod.GET)
	public String chauffeur(Model model, HttpServletRequest request) {
		
		Integer idConducteur = Integer.parseInt ( request.getParameter("userId") );
		
		Utilisateur conducteur = this.utilisateurDAO.find(idConducteur);
		
		request.getSession().setAttribute("conducteurOnClick", conducteur); 
		
		return "utilisateurprofilchauffeur";
	}
	
	@RequestMapping ( value="/deconnexion")
	public void deconnexion ( HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		request.getSession().invalidate();
		
		response.sendRedirect ( request.getContextPath() + "/accueil");
		
	}

	
}
