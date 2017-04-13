
package fr.wemove.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
import fr.wemove.dao.VehiculeDAO;
import fr.wemove.model.Conducteur;
import fr.wemove.model.Trajet;
import fr.wemove.model.Utilisateur;
import fr.wemove.model.Vehicule;
import fr.wemove.validator.UtilisateurSubscribeValidator;

@Controller
@RequestMapping("/utilisateur")
public class UtilisateurController {
	
	@Autowired
	private UtilisateurDAO utilisateurDAO;
	

	@Autowired
	private VehiculeDAO vehiculeDAO;
	
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
	
	@RequestMapping(value = "gestionprofil", method= RequestMethod.GET)
	public String gestionprofil(Model model) {
		
		model.addAttribute("utilisateurUpdate", new Utilisateur());
		
		return "utilisateurgestionprofil";
	}
	
	@RequestMapping(value = "gestionprofil", method= RequestMethod.POST)
	public String gestionprofil(@ModelAttribute("utilisateurUpdate") Utilisateur utilisateurUpdate, BindingResult result, Model model, HttpSession session, HttpServletRequest request) {
		
		new UtilisateurSubscribeValidator().validate(utilisateurUpdate, result);
		
		if ( result.hasErrors()) {	
			
			return "utilisateurgestionprofil";
		} 
		
		String message = "modification(s) enregistrée(s)!";
		request.setAttribute("message", message);
		
		Utilisateur utilisateur = (Utilisateur) session.getAttribute("utilisateur");
		
		

		utilisateurUpdate = this.utilisateurDAO.updateUtil( utilisateur.getId_user(),  utilisateurUpdate);
		
		session.setAttribute("utilisateur", utilisateurUpdate);
		
		
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
		
		Conducteur conducteur = (Conducteur) this.utilisateurDAO.find(idConducteur);
		
		List <Vehicule> listeVehicule = new ArrayList <Vehicule>();
		listeVehicule = vehiculeDAO.findByDriverId(idConducteur);
		request.getSession().setAttribute("vehiculeByConducteur", listeVehicule);
		request.getSession().setAttribute("conducteurOnClick", conducteur); 
		
		return "utilisateurprofilchauffeur";
	}
	
	@RequestMapping ( value="/deconnexion")
	public void deconnexion ( HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		request.getSession().invalidate();
		
		response.sendRedirect ( request.getContextPath() + "/accueil");
		
	}

	
}
