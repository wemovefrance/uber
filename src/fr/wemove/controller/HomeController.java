
package fr.wemove.controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import fr.wemove.dao.UtilisateurDAO;
import fr.wemove.exception.WrongUsernameOrPasswordException;
import fr.wemove.model.Conducteur;
import fr.wemove.model.Utilisateur;
import fr.wemove.validator.PartnerLoginValidator;


@Controller
@RequestMapping("/accueil")
public class HomeController {

	@Autowired
	UtilisateurDAO utilisateurDAO;

	@RequestMapping(value = "")
	public String home(Model model, HttpSession session, HttpServletRequest request) {

		model.addAttribute("partner", new Utilisateur());
		List<Conducteur> listeConducteurs = new ArrayList<Conducteur>() ;
		listeConducteurs = this.utilisateurDAO.findAllConducteurs() ;
		ArrayList<Double> latitudesConducteurs = new ArrayList<Double>() ;
		ArrayList<Double> longitudesConducteurs = new ArrayList<Double>() ;
		ArrayList<String> usernamesConducteurs = new ArrayList<String>() ;
		ArrayList<Integer> userIdConducteurs = new ArrayList<Integer>() ;
		
		for (int ii=0 ; ii<listeConducteurs.size() ; ii++){	
			latitudesConducteurs.add((double) listeConducteurs.get(ii).getAdresse().getLatitude()) ;
			longitudesConducteurs.add((double) listeConducteurs.get(ii).getAdresse().getLongitude()) ;
			usernamesConducteurs.add((String) listeConducteurs.get(ii).getLogin()) ;
			userIdConducteurs.add((Integer) listeConducteurs.get(ii).getId_user()) ;
			}		
		session.setAttribute("latitudesConducteurs",latitudesConducteurs) ;
		session.setAttribute("longitudesConducteurs",longitudesConducteurs) ;
		session.setAttribute("usernamesConducteurs",usernamesConducteurs) ;
		session.setAttribute("userIdConducteurs",userIdConducteurs) ;
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



	@RequestMapping(value = "/connexion", method = RequestMethod.GET)
	public String login(Model model) {


		return "accueil";
	}

	@RequestMapping(value = "/connexion", method = RequestMethod.POST)
	public String loginPartenaire(@ModelAttribute("partner") Utilisateur utilisateur, BindingResult result, Model model,
			HttpSession session, HttpServletRequest request, RedirectAttributes attr)  {

		new PartnerLoginValidator().validate(utilisateur, result);
		

		if (!result.hasErrors()) {

			try {

				List<Conducteur> listeConducteur = this.utilisateurDAO.findAllConducteurs();

				utilisateur = this.utilisateurDAO.findByLogin(utilisateur.getLogin(), utilisateur.getMotDePasse());

				if (utilisateur != null) {

					for (Conducteur conducteur : listeConducteur) {

						if (utilisateur.getId_user() == conducteur.getId_user()) {

							session.setAttribute("conducteur", conducteur);	
							return "redirect:/conducteur/monprofil";
						}

					}

					session.setAttribute("utilisateur", utilisateur);
					return "redirect:/utilisateur/monprofil";
				}
			} catch (WrongUsernameOrPasswordException ex) {
				result.rejectValue("motDePasse", ex.getCode(), ex.getMessage());
			}

		}
	
		return "accueil";
	}

	
	@RequestMapping ( value="/deconnexion")
	public void deconnexion ( HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		request.getSession().invalidate();
		
		response.sendRedirect ( request.getContextPath() + "/accueil");
		
	}
	
	
	@RequestMapping(value = "/conducteur/monprofil", method = RequestMethod.GET)
	public String showdriverProfil(final Model model)
	{
	    return "driveraccueil";
	}

	@RequestMapping(value = "/utilisateur/monprofil", method = RequestMethod.GET)
	public String showutilisateuraccueil(final Model model)
	{
	    return "utilisateuraccueil";
	}

	
	
	
	
}
