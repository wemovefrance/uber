package fr.wemove.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "vehicules")
public class Vehicule implements Serializable {

	public void setId_vehi(Integer id_vehi) {
		this.id_vehi = id_vehi;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "VEHICULE_ID")
	private Integer id_vehi;

	@Column(name = "VOLUME_COFFRE")
	private double volumeCoffre;
	@Column(name = "MARQUE")
	private String marque;
	@Column(name = "MODELE")
	private String modele;
	@Column(name = "TYPE")
	private String typeVehicule;

	@ManyToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name = "VEHICULE_COND_ID")
	private Conducteur conducteur;

	public Conducteur getConducteur() {
		return conducteur;
	}

	public void setConducteur(Conducteur conducteurs) {
		this.conducteur = conducteurs;
	}



	public int getId_vehi() {
		return id_vehi;
	}

	public void setId_vehi(int id_vehi) {
		this.id_vehi = id_vehi;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public double getVolumeCoffre() {
		return volumeCoffre;
	}

	public void setVolumeCoffre(double d) {
		this.volumeCoffre = d;
	}

	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public String getModele() {
		return modele;
	}

	public void setModele(String modele) {
		this.modele = modele;
	}

	public String getTypeVehicule() {
		return typeVehicule;
	}

	public void setTypeVehicule(String typeVehicule) {
		this.typeVehicule = typeVehicule;
	}

}
