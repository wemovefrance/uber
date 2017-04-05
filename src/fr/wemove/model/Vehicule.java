package fr.wemove.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "vehicules")
public class Vehicule implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "VEHICULE_ID")
	private int id;

	@Column(name = "VOLUME_COFFRE")
	private int volumeCoffre;
	@Column(name = "MARQUE")
	private String marque;
	@Column(name = "MODELE")
	private String modele;
	@Column(name = "TYPE")
	private String typeVehicule;

	@ManyToMany(mappedBy = "vehicules")
	private List<Conducteur> conducteurs;

	public List<Conducteur> getConducteurs() {
		return conducteurs;
	}

	public void setConducteurs(List<Conducteur> conducteurs) {
		this.conducteurs = conducteurs;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getVolumeCoffre() {
		return volumeCoffre;
	}

	public void setVolumeCoffre(int volumeCoffre) {
		this.volumeCoffre = volumeCoffre;
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
