package fr.wemove.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

//import java.util.List;

@Entity
@Table(name = "utilisateurs")
@Inheritance(strategy = InheritanceType.JOINED)
public class Utilisateur implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USER_ID")
	private Integer id_user;

	@Column(name = "NOM")
	private String nom;

	@Column(name = "PRENOM")
	private String prenom;

	@Column(name = "MAIL")
	private String email;

	@Column(name = "LOGIN")
	private String login;

	@Column(name = "PASS")
	private String motDePasse;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="USER_ADRESSE_ID",referencedColumnName="ADRESSE_ID")
	private Adresse adresse;
	
	@OneToMany(mappedBy = "utilisateur") //, fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
	private List<Trajet> trajets;

	public List<Trajet> getTrajets() {
		return trajets;
	}

	public void setTrajets(List<Trajet> trajets) {
		this.trajets = trajets;
	}

	public void setId_user(Integer id_user) {
		this.id_user = id_user;
	}

	
//	private List<Trajet> trajet;
	
	
	public Adresse getAdresse() {
		return adresse;
	}

	public Utilisateur() {
	super();
}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

//	public List<Trajet> getTrajets() {
//		return trajet;
//	}
//
//	public void setTrajets(List<Trajet> trajets) {
//		this.trajet = trajets;
//	}

	public String getNom() {
		return nom;
	}

	public int getId_user() {
		return id_user;
	}

	public void setId_user(int id_user) {
		this.id_user = id_user;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
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
