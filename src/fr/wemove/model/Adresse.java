package fr.wemove.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.NumberFormat;

@Entity
@Table(name = "adresses")
//@Embeddable
public class Adresse implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ADRESSE_ID")
	private Integer id_adresse;
	@Column(name = "VILLE")
	private String ville;
	@Column(name = "RUE")
	private String rue;
	@Column(name = "NUMERO")
	private int numero;
	@Column(name = "CODE_POSTAL")
	private int codePostal;
	@Column(name = "LATITUDE")
	private double latitude;
	@Column(name = "LONGITUDE")
	private double longitude;
	
	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public Adresse() {
		super();
	}

	public Integer getId_adresse() {
		return id_adresse;
	}

	public void setId_adresse(Integer id_adresse) {
		this.id_adresse = id_adresse;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}

}
