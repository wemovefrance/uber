
package fr.wemove.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
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

import fr.wemove.dao.NotificationDAO;
import fr.wemove.dao.TrajetDAO;
import fr.wemove.dao.UtilisateurDAO;
import fr.wemove.dao.VehiculeDAO;
import fr.wemove.model.Conducteur;
import fr.wemove.model.Notification;
import fr.wemove.model.Trajet;
import fr.wemove.model.Utilisateur;
import fr.wemove.model.Vehicule;
import fr.wemove.validator.TrajetValidator;
import fr.wemove.validator.UtilisateurSubscribeValidator;

@Controller
@RequestMapping("/utilisateur")
public class UtilisateurController {
	
	@Autowired
	private UtilisateurDAO utilisateurDAO;
	

	@Autowired
	private VehiculeDAO vehiculeDAO;
	@Autowired
	private TrajetDAO trajetDAO;
	
	@Autowired 
	private NotificationDAO notificationDAO;
	
	@RequestMapping(value = "monprofil")
	public String accueil(Model model) {
		return "utilisateuraccueil";
	}

	@RequestMapping(value = "demandecourse", method= RequestMethod.GET)
	public String carte (Model model) {
		
		model.addAttribute("nouveauTrajet",new Trajet());
		return "demandecourse";
	}

	
	@RequestMapping(value = "demandecourse", method= RequestMethod.POST)
	public String carte(@ModelAttribute("nouveauTrajet") Trajet trajet , BindingResult result, Model model, HttpSession session ) throws UnsupportedEncodingException {

		new TrajetValidator().validate(trajet, result);
		
		if ( result.hasErrors()) {	
			
			return "demandecourse";
		} 
		 
		Conducteur conducteur = (Conducteur) session.getAttribute("conducteurOnClick");
		Utilisateur utilisateur =(Utilisateur) session.getAttribute("utilisateur");
		
		trajet.setUtilisateur(utilisateur);
		trajet.setConducteur(conducteur);
		trajet.setStatut(1);
		this.trajetDAO.save(trajet);
		
		// envoi mail 
		
		final String username = "wemove.france.contact@gmail.com";
		final String password = "08080808";

			try {
		            Properties props = new Properties();
		            props.put("mail.smtp.auth", "true");
		            props.put("mail.smtp.starttls.enable", "true");
		            props.put("mail.smtp.host", "smtp.gmail.com");
		            props.put("mail.smtp.port", "587");

		            Session sessionmail = Session.getInstance(props,
		          		  new javax.mail.Authenticator() {
		          			protected PasswordAuthentication getPasswordAuthentication() {
		          				return new PasswordAuthentication(username, password);
		          			}
		          		  });

		            String message = "Bonjour " + conducteur.getPrenom() + ", <br /> Vous avez recu une nouvelle demande de trajet ! <br /> <br /> <a href='http://localhost:8080/frWeMove/accueil'> Acc�der � votre espace personnel </a> pour consulter votre notification ! <br /> <br /> A votre service, <br/> L'�quipe WeMove  ";
		            
		            Message msg = new MimeMessage(sessionmail);
		            msg.setFrom(new InternetAddress("wemove.france@gmail.com", "WeMove France"));
		            msg.addRecipient(Message.RecipientType.TO,
		                             new InternetAddress(utilisateur.getEmail()));
		            msg.setSubject("  Notifications : nouvelle demande de trajet de " + utilisateur.getLogin());
		            msg.setContent(message, "text/html");
		            msg.saveChanges();
		            //msg.setText(message);
		            Transport.send(msg);
		        } catch (MessagingException e) {
		            e.printStackTrace();
		        }

		
		return "redirect:/utilisateur/monprofil";
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
		
		String message = "modification(s) enregistr�e(s)!";
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
	public String notifications(Model model, HttpSession session, HttpServletRequest request) {
		Utilisateur utilisateur = (Utilisateur) session.getAttribute("utilisateur");
		System.out.println("**************************"+utilisateur.getId_user()+"**************************");
		List<Trajet> listeTrajets = (List<Trajet>) trajetDAO.findByPassagerId(utilisateur.getId_user());
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
		return "utilisateurnotifications";
	}
	

	@RequestMapping(value = "/annulerCourse", method = RequestMethod.POST)
	public String accepterRefuserCourse(HttpSession session, Model model, HttpServletRequest request) {
		int idTraj = Integer.parseInt(request.getParameter("idTraj")) ;
			trajetDAO.updateStatus(idTraj,0);
		return "redirect:/utilisateur/notifications" ;
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
