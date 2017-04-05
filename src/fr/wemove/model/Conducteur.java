package fr.wemove.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="client")
@PrimaryKeyJoinColumn(name="CLI_ID", referencedColumnName="PER_ID")
public class Conducteur extends Utilisateur {
	
	@Column(name="COND_NOTE")
	private int noteMoyenne;

	public int getNoteMoyenne() {
		return noteMoyenne;
	}

	public void setNoteMoyenne(int noteMoyenne) {
		this.noteMoyenne = noteMoyenne;
	}	
	
}
