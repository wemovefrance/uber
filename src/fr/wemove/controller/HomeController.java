
package fr.wemove.controller;

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

import fr.wemove.exception.WrongUsernameOrPasswordException;
import fr.wemove.dao.UtilisateurDAO;
import fr.wemove.model.Conducteur;
import fr.wemove.model.Utilisateur;
import fr.wemove.validator.PartnerLoginValidator;
import fr.wemove.validator.UtilisateurSubscribeValidator;

@Controller
@RequestMapping("/accueil")
public class HomeController {

	@Autowired
	UtilisateurDAO utilisateurDAO;

	@RequestMapping(value = "")
	public String home(Model model, HttpSession session) {

		model.addAttribute("partner", new Utilisateur());
		session.setAttribute("partenaire", new Utilisateur());
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

		model.addAttribute("partner", new Utilisateur());

		return "acceuil";
	}

	@RequestMapping(value = "/connexion", method = RequestMethod.POST)
	public String loginPartenaire(@ModelAttribute("partner") Utilisateur utilisateur, BindingResult result, Model model,
			HttpSession session) {

		new PartnerLoginValidator().validate(utilisateur, result);

		if (!result.hasErrors()) {

			try {

				List<Conducteur> listeConducteur = this.utilisateurDAO.findAllConducteurs();

				utilisateur = this.utilisateurDAO.findByLogin(utilisateur.getLogin(), utilisateur.getMotDePasse());

				if (utilisateur != null) {

					for (Conducteur conducteur : listeConducteur) {

						if (utilisateur.getId_user() == conducteur.getId_user()) {

							session.setAttribute("partenaire", conducteur);

							return "driverprofil";
						}

					}

					session.setAttribute("partenaire", utilisateur);

					return "utilisateuraccueil";
				}
			} catch (WrongUsernameOrPasswordException ex) {
				result.rejectValue("motDePasse", ex.getCode(), ex.getMessage());
			}

		}

		return "accueil";
	}

}
