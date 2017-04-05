package fr.wemove.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import antlr.collections.List;

@Entity
@Table(name="personne")
@Inheritance(strategy=InheritanceType.JOINED)
public class Utilisateur implements Serializable {


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="PER_ID")
	private int id;
	
	@Column(name="PER_NOM")
	private String nom;
	
	@Column(name="PER_PRENOM")
	private String prenom;
	
	@Column(name="MAIL")
	private String email;
	
	@Column(name="LOGIN")
	private String login;
	
	@Column(name="PASS")
	private String motDePasse;

	@Column(name="ADRESSE")
	private Adresse adresse; //!!!!!!
	
	private List<Trajets> trajets;

	public List<Trajets> getTrajets() {
		return trajets;
	}

	public void setTrajets(List<Trajets> trajets) {
		this.trajets = trajets;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}
	
}
