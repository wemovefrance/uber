package fr.wemove.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "conducteurs")
@PrimaryKeyJoinColumn(name = "COND_ID", referencedColumnName = "USER_ID")
public class Conducteur extends Utilisateur {

	@Column(name = "COND_NOTE")
	private int noteMoyenne;

	@ManyToMany(fetch = FetchType.EAGER) // (cascade=CascadeType.MERGE)
	@JoinTable(name = "conducteur_vehicules", joinColumns = @JoinColumn(name = "COND_ID", referencedColumnName = "COND_ID"), inverseJoinColumns = @JoinColumn(name = "VEHICULE_ID", referencedColumnName = "VEHICULE_ID"))
	private List<Vehicule> vehicules;

	public List<Vehicule> getVehicules() {
		return vehicules;
	}

	public void setVehicules(List<Vehicule> vehicules) {
		this.vehicules = vehicules;
	}

	public int getNoteMoyenne() {
		return noteMoyenne;
	}

	public void setNoteMoyenne(int noteMoyenne) {
		this.noteMoyenne = noteMoyenne;
	}

}
