package fr.wemove.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="vehicule")
public class Vehicule implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="VEHICULE_ID")
	private int id;
	
	private int volumeCoffre;
	private String marque;
	private String modele;
	
	
	

}
