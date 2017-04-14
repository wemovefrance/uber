
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import fr.wemove.dao.NotificationDAO;
import fr.wemove.dao.TrajetDAO;
import fr.wemove.dao.VehiculeDAO;
import fr.wemove.model.Conducteur;
import fr.wemove.model.Notification;
import fr.wemove.model.Trajet;
import fr.wemove.model.Vehicule;
import fr.wemove.dao.UtilisateurDAO;
import fr.wemove.model.Conducteur;
import fr.wemove.model.Utilisateur;
import fr.wemove.validator.ConducteurSubscribeValidator;
import fr.wemove.validator.UtilisateurSubscribeValidator;

@Controller
@RequestMapping("/conducteur")
public class DriverController {

	@Autowired
	VehiculeDAO vehiculeDAO;

	@Autowired
	NotificationDAO notificationDAO;

	@Autowired
	TrajetDAO trajetDAO;
	
	@Autowired
	private UtilisateurDAO utilisateurDAO;
	
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
	 
    @RequestMapping(value = "/findnotifications", method = RequestMethod.GET)
    public @ResponseBody
    ArrayList<String> findnotifications(@RequestParam("id_traj") int idTraj) {
		List<Notification> listeNotifications = notificationDAO.findByTrajetId(idTraj);
		
		ArrayList<String> result = new ArrayList<String>() ;
		for (Notification notif : listeNotifications) {
			result.add(notif.getMessage()+" de "+notif.getTrajet().getUtilisateur().getLogin()+" : "+notif.getTrajet().getDepart().getVille()+" à "+notif.getTrajet().getArrivee().getVille());
		}
        return result;
    }
    
    
	/*
	@RequestMapping(value = "/findnotifications", method = RequestMethod.GET))
	public ModelAndView findnotifications(@RequestParam("id_traj") int idTraj, String fdate, String tdate) {
		System.out.println(idTraj);
		ModelAndView mav = new ModelAndView("/findnotifications");
		List<Notification> listeNotifications = notificationDAO.findByTrajetId(idTraj);
		System.out.println("*******"+listeNotifications+"***************") ;
		mav.addObject("listeNotifications", listeNotifications);
		System.out.println("@@@@@@@@@@@@@@@@@"+mav+"@@@@@@@@@@@@@@@@@@@@") ;
		return mav;
	}*/
		
	/*
	public ModelAndView findnotifications(@RequestParam("id_traj") int idTraj, Model model) {
		ModelAndView mav = new ModelAndView("/findnotifications");
		List<Notification> listeNotifications = notificationDAO.findByTrajetId(idTraj);
		System.out.println("*******"+listeNotifications+"***************") ;
		mav.addObject("listeNotifications", listeNotifications);
		System.out.println("@@@@@@@@@@@@@@@@@"+mav+"@@@@@@@@@@@@@@@@@@@@") ;
		return mav;
	}
*/
	@RequestMapping(value = "notifications", method = RequestMethod.GET)
	public String notifications(Model model, HttpSession session, HttpServletRequest request) {
		Conducteur conducteur = (Conducteur) session.getAttribute("conducteur");
		List<Trajet> listeTrajets = (List<Trajet>) trajetDAO.findByConducteurId(conducteur.getId_user());
		ArrayList<String> listeVilleDepartTrajets = new ArrayList<String>();
		ArrayList<String> listeVilleArriveeTrajets = new ArrayList<String>();
		for (Trajet Traj : listeTrajets) {
			listeVilleDepartTrajets.add(Traj.getDepart().getVille());
			listeVilleArriveeTrajets.add(Traj.getArrivee().getVille());
			System.out.println(Traj.getDepart().getVille());
		}
		request.setAttribute("listeVilleDepartTrajets", listeVilleDepartTrajets);
		request.setAttribute("listeVilleArriveeTrajets", listeVilleArriveeTrajets);
		request.setAttribute("listeTrajets", listeTrajets);

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
		
		String message = "modification(s) enregistr�e(s)!";
		request.setAttribute("message", message);
		
		Conducteur conducteur = (Conducteur) session.getAttribute("conducteur");

		driverUpdate = this.utilisateurDAO.updateCond( conducteur.getId_user(),  driverUpdate);
		
		session.setAttribute("conducteur", driverUpdate);
		
		

		return "drivergestionprofil";
	}

	@RequestMapping(value = "/drivergestionvehicule", method = RequestMethod.POST)
	public String gestionvehiculespost(@ModelAttribute("nouveauVehicule") Vehicule vehicule, BindingResult result,
			HttpSession session, Model model) {

		System.out.println(vehicule.getMarque());
		System.out.println(vehicule.getModele());
		vehicule.setConducteur((Conducteur) session.getAttribute("conducteur"));
		this.vehiculeDAO.save(vehicule);
		Conducteur conducteur = (Conducteur) session.getAttribute("conducteur");
		List<Vehicule> listeVehicule = (List<Vehicule>) vehiculeDAO.findByDriverId(conducteur.getId_user());
		session.setAttribute("listeVehicule", listeVehicule);

		return "drivergestionvehicule";
	}

	@RequestMapping(value = "/drivergestionvehicule", method = RequestMethod.GET)
	public String gestionvehicules(HttpSession session, Model model) {
		Conducteur conducteur = (Conducteur) session.getAttribute("conducteur");
		List<Vehicule> listeVehicule = (List<Vehicule>) vehiculeDAO.findByDriverId(conducteur.getId_user());
		session.setAttribute("listeVehicule", listeVehicule);
		model.addAttribute("nouveauVehicule", new Vehicule());
		return "drivergestionvehicule";
	}
	

	@RequestMapping(value = "/accepterRefuserCourse", method = RequestMethod.POST)
	public String accepterRefuserCourse(HttpSession session, Model model, HttpServletRequest request) {
		String choix = (String) request.getParameter("choix") ;
		int idTraj = Integer.parseInt(request.getParameter("idTraj")) ;
		System.out.println(choix);
		System.out.println(idTraj);
		
		Trajet trajet = trajetDAO.find(idTraj) ;
		if (choix.equals("accepter")){
			trajetDAO.updateStatus(idTraj,2);
		} else if (choix.equals("refuser")){
			trajetDAO.updateStatus(idTraj,0);
		}
		return "redirect:/conducteur/notifications";
		
	}

	@RequestMapping(value = "/annulerCourse", method = RequestMethod.POST)
	public String annulerCourse(HttpSession session, Model model, HttpServletRequest request) {
		int idTraj = Integer.parseInt(request.getParameter("idTraj")) ;
			trajetDAO.updateStatus(idTraj,0);
		return "redirect:/conducteur/notifications";
	}
	
	@RequestMapping(value = "/removeVehicule")
	public String removeVehicule(HttpSession session, Model model, HttpServletRequest request) {
		int idcar = Integer.parseInt(request.getParameter("idcar"));
		vehiculeDAO.delete(vehiculeDAO.find(idcar));
		return "redirect:/conducteur/drivergestionvehicule";
	}

	@RequestMapping ( value="/deconnexion")
	public void deconnexion ( HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		request.getSession().invalidate();

		response.sendRedirect(request.getContextPath() + "/accueil");

	}

}
