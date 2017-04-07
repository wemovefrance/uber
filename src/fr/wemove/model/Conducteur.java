package fr.wemove.model;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "conducteurs")
@PrimaryKeyJoinColumn(name = "COND_ID", referencedColumnName = "USER_ID")
public class Conducteur extends Utilisateur {


	private static final long serialVersionUID = 1L;

	@Column(name = "COND_NOTE")
	private Integer noteMoyenne;

	@OneToMany(cascade = CascadeType.ALL,mappedBy = "conducteur")//, fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
	private List<Vehicule> vehicules;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "conducteur")//, fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
	private List<Trajet> trajets;
	
	public List<Trajet> getTrajets() {
		return trajets;
	}

	public void setTrajets(List<Trajet> trajets) {
		this.trajets = trajets;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setNoteMoyenne(Integer noteMoyenne) {
		this.noteMoyenne = noteMoyenne;
	}

	public Conducteur() {
		super();
	}

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
