package fr.wemove.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "trajets")
public class Trajet implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TRAJET_ID")
	private Integer id_trajet;
	//@Embedded
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="DEPART_ADRESSE_ID",referencedColumnName="ADRESSE_ID")
	private Adresse depart;
	//@Embedded
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="ARRIVEE_ADRESSE_ID",referencedColumnName="ADRESSE_ID")
	private Adresse arrivee;
	public void setId_trajet(Integer id_trajet) {
		this.id_trajet = id_trajet;
	}

	@Column(name = "NOTE")
	private int note;
	@Column(name = "COMMENTAIRES")
	private String commentaire;
	@Column(name = "DATE")
	private String dateDuTrajet;
	
	@Column(name = "DISTANCE")
	private double distance;

	@Column(name = "PRIX")
	private double prix;
	
	@Column(name = "POIDS")
	private double poids;
	
	@Column(name = "STATUT")
	private int statut;

	@ManyToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name = "COND_TRAJET_ID")
	private Conducteur conducteur;

	@ManyToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name = "USER_TRAJET_ID")
	private Utilisateur utilisateur;

	@OneToMany(mappedBy = "trajet", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
	private List<Notification> notification;
	
	public int getStatut() {
		return statut;
	}

	public void setStatut(int statut) {
		this.statut = statut;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public double getPoids() {
		return poids;
	}

	public void setPoids(double poids) {
		this.poids = poids;
	}

	public String getDateDuTrajet() {
		return dateDuTrajet;
	}

	public void setDateDuTrajet(String dateDuTrajet) {
		this.dateDuTrajet = dateDuTrajet;
	}

	public Conducteur getConducteur() {
		return conducteur;
	}

	public void setConducteur(Conducteur conducteur) {
		this.conducteur = conducteur;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public List<Notification> getNotification() {
		return notification;
	}

	public void setNotification(List<Notification> notification) {
		this.notification = notification;
	}


	public int getId_trajet() {
		return id_trajet;
	}

	public void setId_trajet(int id_trajet) {
		this.id_trajet = id_trajet;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Adresse getDepart() {
		return depart;
	}

	public void setDepart(Adresse depart) {
		this.depart = depart;
	}

	public Adresse getArrivee() {
		return arrivee;
	}

	public void setArrivee(Adresse arrivee) {
		this.arrivee = arrivee;
	}

	public int getNote() {
		return note;
	}

	public void setNote(int note) {
		this.note = note;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

}
