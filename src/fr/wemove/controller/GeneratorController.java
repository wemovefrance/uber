package fr.wemove.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fr.wemove.dao.NotificationDAO;
import fr.wemove.dao.TrajetDAO;
import fr.wemove.dao.UtilisateurDAO;
import fr.wemove.dao.VehiculeDAO;
import fr.wemove.model.Adresse;
import fr.wemove.model.Conducteur;
import fr.wemove.model.Notification;
import fr.wemove.model.Trajet;
import fr.wemove.model.Utilisateur;
import fr.wemove.model.Vehicule;

@RestController
@RequestMapping("/api/generator")
public class GeneratorController {
	private static final long serialVersionUID = 1L;

	@Autowired
	private UtilisateurDAO UtilisateurDAO;

	@Autowired
	private VehiculeDAO VehiculeDAO;
	
	@Autowired
	private NotificationDAO NotificationDAO;
	
	@Autowired
	private TrajetDAO TrajetDAO;

	@RequestMapping(value="", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity generate() {
		Conducteur myConducteur = null;
		Utilisateur myUtilisateur = null;
		Vehicule myVehicule = null;
		Notification myNotification = null;
	
		/* CREATION DES Adresses */
		Adresse adresseUn = new Adresse();
		Adresse adresseDeux = new Adresse();
		Adresse adresseTrois = new Adresse();
		Adresse adresseQuatre = new Adresse();
		Adresse adresseCinq = new Adresse();
		Adresse adresseSix = new Adresse();
		Adresse adresseSept = new Adresse();
		Adresse adresseHuit = new Adresse();
		Adresse adresseNeuf = new Adresse();

		adresseUn.setCodePostal(83);
		adresseUn.setVille("Toulon");
		adresseUn.setRue("Place de la Liberté");
		adresseUn.setNumero(22);
		adresseUn.setLatitude(43.120366);
		adresseUn.setLongitude(5.932212);
		adresseUn.setNom("Place de la Liberté, Toulon");
		
		adresseDeux.setCodePostal(84);
		adresseDeux.setVille("Gordes");
		adresseDeux.setRue("Chemin du puits");
		adresseDeux.setNumero(25);
		adresseDeux.setLatitude(43.828619);
		adresseDeux.setLongitude(5.209146);
		adresseDeux.setNom("Gordes");
		
		adresseTrois.setCodePostal(13);
		adresseTrois.setVille("Aix");
		adresseTrois.setRue("Place des quarts d'heure");
		adresseTrois.setNumero(4);
		adresseTrois.setLatitude(43.529941);
		adresseTrois.setLongitude(5.446263);
		adresseTrois.setNom("Aix-en-provence");
		
		adresseQuatre.setCodePostal(69);
		adresseQuatre.setVille("Lyon");
		adresseQuatre.setRue("Rue Garibaldi");
		adresseQuatre.setNumero(45);
		adresseQuatre.setLatitude(45.759122);
		adresseQuatre.setLongitude(4.851118); 
		adresseQuatre.setNom("Rue Garibaldi, Lyon");
		
		adresseCinq.setCodePostal(69);
		adresseCinq.setVille("Lyon");
		adresseCinq.setRue("Rue Garibaldi");
		adresseCinq.setNumero(45);
		adresseCinq.setLatitude(45.759122);
		adresseCinq.setLongitude(4.851118); 
		adresseCinq.setNom("Rue Garibaldi, Lyon");
		
		adresseSix.setCodePostal(69);
		adresseSix.setVille("Lyon");
		adresseSix.setRue("Rue Garibaldi");
		adresseSix.setNumero(45);
		adresseSix.setLatitude(45.759122);
		adresseSix.setLongitude(4.851118); 
		adresseSix.setNom("Rue Garibaldi, Lyon");
		
		adresseSept.setCodePostal(69);
		adresseSept.setVille("Lyon");
		adresseSept.setRue("Rue Garibaldi");
		adresseSept.setNumero(45);
		adresseSept.setLatitude(45.759122);
		adresseSept.setLongitude(4.851118); 
		adresseSept.setNom("Rue Garibaldi, Lyon");
		
		adresseHuit.setCodePostal(69);
		adresseHuit.setVille("Lyon");
		adresseHuit.setRue("Rue Garibaldi");
		adresseHuit.setNumero(45);
		adresseHuit.setLatitude(45.759122);
		adresseHuit.setLongitude(4.851118); 
		adresseHuit.setNom("Rue Garibaldi, Lyon");
		
		adresseNeuf.setCodePostal(13);
		adresseNeuf.setVille("Marseille");
		adresseNeuf.setRue("Avenue du Prado");
		adresseNeuf.setNumero(45);
		adresseNeuf.setLatitude(43.270357);
		adresseNeuf.setLongitude(5.387613); 
		adresseNeuf.setNom("Avenue du Prado, Marseille");
		
		/*Conducteur */
		
		Conducteur nouveauConducteur = new Conducteur();
		nouveauConducteur.setAdresse(adresseNeuf);
		nouveauConducteur.setNom("Bond");
		nouveauConducteur.setPrenom("James");
		nouveauConducteur.setLogin("007");
		nouveauConducteur.setEmail("007@nightfire.com");
		nouveauConducteur.setMotDePasse("mdp");
		

		Vehicule nouveauVehicule = new Vehicule();
		
		nouveauVehicule.setMarque("BMW");
		nouveauVehicule.setModele("007series");
		nouveauVehicule.setTypeVehicule("Sport");
		nouveauVehicule.setVolumeCoffre(2);
		nouveauVehicule.setConducteur(nouveauConducteur);
	
		
		
		
		/* CREATION D'UN Utilisateur */
		myUtilisateur = new Utilisateur();
		myUtilisateur.setNom("PERROUAULT");
		myUtilisateur.setPrenom("Jérémy");
		myUtilisateur.setEmail("jeremy.perrouault@gmail.com");
		myUtilisateur.setLogin("Jérémy");
		myUtilisateur.setMotDePasse("mdp");
		myUtilisateur.setAdresse(adresseUn);
		myUtilisateur = (Utilisateur)this.UtilisateurDAO.save(myUtilisateur);
		
		/* CREATION D'UN Utilisateur */
		myUtilisateur = new Utilisateur();
		myUtilisateur.setNom("DUPONT");
		myUtilisateur.setPrenom("Jean");
		myUtilisateur.setEmail("jean.dupont@gmail.com");
		myUtilisateur.setLogin("jean");
		myUtilisateur.setMotDePasse("mdp");
		myUtilisateur.setAdresse(adresseQuatre);
		myUtilisateur = (Utilisateur)this.UtilisateurDAO.save(myUtilisateur);
		
		
		/* CREATION D'UN Conducteur ET DE VehiculeS */
		myConducteur = new Conducteur();
		myConducteur.setNom("DUPRES");
		myConducteur.setPrenom("Alissa");
		myConducteur.setEmail("alissa.dupres@gmail.com");
		myConducteur.setLogin("alissa");
		myConducteur.setMotDePasse("mdp");
		myConducteur.setAdresse(adresseDeux);
		myConducteur = (Conducteur)this.UtilisateurDAO.save(myConducteur);
		
		myVehicule = new Vehicule();
		myVehicule.setMarque("Peugeot");
		myVehicule.setModele("3008");
		myVehicule.setTypeVehicule("4X4");
		myVehicule.setVolumeCoffre(0.52);
		myVehicule.setConducteur(myConducteur);
		this.VehiculeDAO.save(myVehicule);
		
		myVehicule = new Vehicule();
		myVehicule.setMarque("Renault");
		myVehicule.setModele("Trafic");
		myVehicule.setTypeVehicule("Camionette");
		myVehicule.setVolumeCoffre(4.2);
		myVehicule.setConducteur(myConducteur);
		myVehicule = this.VehiculeDAO.save(myVehicule);
		
		
		/* CREATION D'UN DEUXIEME Conducteur ET D'UN Vehicule */
		myConducteur = new Conducteur();
		myConducteur.setNom("CESBRON");
		myConducteur.setPrenom("Martin");
		myConducteur.setEmail("martin.cesbron@gmail.com");
		myConducteur.setLogin("martin");
		myConducteur.setMotDePasse("mdp");
		myConducteur.setAdresse(adresseTrois);
	
		myVehicule = new Vehicule();
		myVehicule.setMarque("Citroën");
		myVehicule.setModele("Jumpy");
		myVehicule.setTypeVehicule("Fourgon");
		myVehicule.setVolumeCoffre(5);
		myVehicule.setConducteur(myConducteur);
		myVehicule = this.VehiculeDAO.save(myVehicule);
		
			/* CREATION D'UN TRAJET */
		Trajet TrajetUn = new Trajet();
		Trajet TrajetDeux = new Trajet();
		
		TrajetUn.setCommentaire("Je dois déplacer un frigo de x m3 et de y kg. On peut se retrouver à 14h");
		TrajetUn.setDateDuTrajet("04/14/2017");
		TrajetUn.setArrivee(adresseCinq);
		TrajetUn.setDepart(adresseSix);
		TrajetUn.setConducteur(nouveauConducteur);
		TrajetUn.setUtilisateur(myUtilisateur);	
		
		TrajetDeux.setCommentaire("Je dois déplacer un frigo de x m3 et de y kg. On peut se retrouver à 14h");
		TrajetDeux.setDateDuTrajet("09/14/2017");
		TrajetDeux.setArrivee(adresseSept);
		TrajetDeux.setDepart(adresseHuit);
		TrajetDeux.setConducteur(nouveauConducteur);
		TrajetDeux.setUtilisateur(myUtilisateur);
		
		/* CREATION DES NOTIFICATIONS */
		
		myNotification = new Notification();
		myNotification.setMessage("Vous avez une demande de trajet");
		myNotification.setStatutConducteur("nonLu");
		myNotification.setStatutUtilisateur("lu");
		myNotification.setTrajet(TrajetUn);
		myNotification = this.NotificationDAO.save(myNotification);
		
		myNotification = new Notification();
		myNotification.setMessage("Trajet Confirmé");
		myNotification.setStatutConducteur("nonLu");
		myNotification.setStatutUtilisateur("lu");
		myNotification.setTrajet(TrajetUn);
		myNotification = this.NotificationDAO.save(myNotification);
		
		myNotification = new Notification();
		myNotification.setMessage("Trajet annulé");
		myNotification.setStatutConducteur("nonLu");
		myNotification.setStatutUtilisateur("lu");
		myNotification.setTrajet(TrajetUn);
		myNotification = this.NotificationDAO.save(myNotification);

		
		myNotification = new Notification();
		myNotification.setMessage("Vous avez une demande de trajet");
		myNotification.setStatutConducteur("nonLu");
		myNotification.setStatutUtilisateur("lu");
		myNotification.setTrajet(TrajetDeux);
		myNotification = this.NotificationDAO.save(myNotification);


		return new ResponseEntity(HttpStatus.OK);
	}
}