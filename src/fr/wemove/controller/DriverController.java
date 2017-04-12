
package fr.wemove.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.wemove.dao.UtilisateurDAO;
import fr.wemove.dao.VehiculeDAO;
import fr.wemove.model.Conducteur;
import fr.wemove.model.Utilisateur;
import fr.wemove.model.Vehicule;
import fr.wemove.validator.UtilisateurSubscribeValidator;

@Controller
@RequestMapping("/conducteur")
public class DriverController {

	@Autowired
	VehiculeDAO vehiculeDAO;

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

	@RequestMapping(value = "/gestionprofil")
	public String gestionprofil(Model model) {
		return "drivergestionprofil";
	}

	@RequestMapping(value = "/drivergestionvehicule", method = RequestMethod.POST)
	public String gestionvehiculespost(@ModelAttribute("nouveauVehicule") Vehicule vehicule, BindingResult result,
			HttpSession session, Model model) {

		System.out.println(vehicule.getMarque());
		System.out.println(vehicule.getModele());
		vehicule.setConducteur((Conducteur) session.getAttribute("conducteur"));
		this.vehiculeDAO.save(vehicule);

		List<Vehicule> listeVehicule = (List<Vehicule>) vehiculeDAO.findByDriverId(3);
		session.setAttribute("listeVehicule", listeVehicule);

		return "drivergestionvehicule";
	}

	@RequestMapping(value = "/drivergestionvehicule", method = RequestMethod.GET)
	public String gestionvehicules(HttpSession session, Model model) {
		System.out.println("***************************************");
		List<Vehicule> listeVehicule = (List<Vehicule>) vehiculeDAO.findByDriverId(3);
		session.setAttribute("listeVehicule", listeVehicule);
		model.addAttribute("nouveauVehicule", new Vehicule());
		return "drivergestionvehicule";
	}

	@RequestMapping(value = "/removeVehicule")
	public String removeVehicule(HttpSession session, Model model, HttpServletRequest request) {
		int idcar = Integer.parseInt(request.getParameter("idcar")) ;
		vehiculeDAO.delete(vehiculeDAO.find(idcar));		
		return "redirect:/conducteur/drivergestionvehicule";
	}

	@RequestMapping(value = "/deconnexion")
	public void deconnexion(HttpServletRequest request, HttpServletResponse response) throws IOException {

		request.getSession().invalidate();

		response.sendRedirect(request.getContextPath() + "/accueil");

	}

}
