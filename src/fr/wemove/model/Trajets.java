package fr.wemove.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="trajet")
public class Trajets implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="TRAJET_ID")
	private int id;
	
	private Adresse depart;
	private Adresse arrivee;
	private int note;
	private String commentaire;
	
	
	

}
