package fr.wemove.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "notifications")
public class Notification implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "NOTIFICATION_ID")
	private Integer id_not;

	@Column(name = "MESSAGE")
	private String message;

	@Column(name = "STATUT")
	private String statut;

	@Column(name = "DATE_ENVOI")
	private Date envoi;

	@ManyToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name = "NOTIFICATION_TRAJET_ID")
	private Trajet trajet;

	public Notification() {
		super();
	}

	public Trajet getTrajet() {
		return trajet;
	}

	public void setTrajet(Trajet trajet) {
		this.trajet = trajet;
	}
	
	public void setId_not(Integer id_not) {
		this.id_not = id_not;
	}

	public int getId_not() {
		return id_not;
	}

	public void setId_not(int id_not) {
		this.id_not = id_not;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public Date getEnvoi() {
		return envoi;
	}

	public void setEnvoi(Date envoi) {
		this.envoi = envoi;
	}

}
