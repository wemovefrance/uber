package fr.wemove.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "paiement")
public class Paiement implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PAIEMENT_ID")
	private Integer id_pa;

	@Column(name = "MONTANT")
	private int montant;
	

	public int getId_pa() {
		return id_pa;
	}

	public void setId_pa(Integer id_pa) {
		this.id_pa = id_pa;
	}

	public void setId_pa(int id_pa) {
		this.id_pa = id_pa;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getMontant() {
		return montant;
	}

	public void setMontant(int montant) {
		this.montant = montant;
	}

}
