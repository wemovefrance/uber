package fr.wemove.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fr.wemove.dao.*;
import fr.wemove.model.*;

@RestController
@RequestMapping("/api/generator")
public class GeneratorController {
	private static final long serialVersionUID = 1L;

	@Autowired
	private UtilisateurDAO UtilisateurDAO;

	@Autowired
	private VehiculeDAO VehiculeDAO;

	@RequestMapping(value="", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity generate() {
		Conducteur myConducteur = null;
		Utilisateur myUtilisateur = null;
		Vehicule myVehicule = null;
		
		
		/* CREATION DES Adresses */
		Adresse adresseUn = new Adresse();
		Adresse adresseDeux = new Adresse();
		Adresse adresseTrois = new Adresse();
		Adresse adresseQuatre = new Adresse();
		
		adresseUn.setCodePostal(83);
		adresseUn.setVille("Toulon");
		adresseUn.setRue("Hotel de ville");
		adresseUn.setNumero(22);
		adresseUn.setLatitude(43.120366);
		adresseUn.setLongitude(5.932212);
		
		adresseDeux.setCodePostal(84);
		adresseDeux.setVille("Gordes");
		adresseDeux.setRue("Chemin du puits");
		adresseDeux.setNumero(25);
		adresseDeux.setLatitude(43.828619);
		adresseDeux.setLongitude(5.209146);
		
		adresseTrois.setCodePostal(13);
		adresseTrois.setVille("Aix");
		adresseTrois.setRue("Place des quarts d'heure");
		adresseTrois.setNumero(4);
		adresseTrois.setLatitude(43.529941);
		adresseTrois.setLongitude(5.446263);
		
		adresseQuatre.setCodePostal(69);
		adresseQuatre.setVille("Lyon");
		adresseQuatre.setRue("Boulevard Garibaldi");
		adresseQuatre.setNumero(45);
		adresseQuatre.setLatitude(45.759122);
		adresseQuatre.setLongitude(4.851118); 
		
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
		myConducteur = (Conducteur)this.UtilisateurDAO.update(myConducteur);
		
		myVehicule = new Vehicule();
		myVehicule.setMarque("Citroën");
		myVehicule.setModele("Jumpy");
		myVehicule.setTypeVehicule("Fourgon");
		myVehicule.setVolumeCoffre(5);
		myVehicule.setConducteur(myConducteur);
		myVehicule = this.VehiculeDAO.save(myVehicule);

		return new ResponseEntity(HttpStatus.OK);
	}
}