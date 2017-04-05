package fr.wemove.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "trajets")
public class Trajet implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TRAJET_ID")
	private int id;

	@Column(name = "DEPART")
	private Adresse depart;
	@Column(name = "ARRIVEE")
	private Adresse arrivee;
	@Column(name = "NOTE")
	private int note;
	@Column(name = "COMMENTAIRES")
	private String commentaire;
	@Column(name = "DATE")
	private Date dateDuTrajet;

	@OneToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "CONDUCTEUR_TRAJET_ID", referencedColumnName = "COND_ID")
	private Conducteur conducteur;

	@OneToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "UTILISATEUR_TRAJET_ID", referencedColumnName = "USER_ID")
	private Utilisateur utilisateur;

	@OneToMany(mappedBy = "trajets", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
	private List<Notification> notification;

	public Date getDateDuTrajet() {
		return dateDuTrajet;
	}

	public void setDateDuTrajet(Date dateDuTrajet) {
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
