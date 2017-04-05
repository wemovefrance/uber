package fr.wemove.dao;

import java.util.List;

import fr.wemove.model.Adresse;

public class AdresseDAO extends DAO<Adresse> {
	
	@Override
	public Adresse find(int id) {
		return this.em.find(Adresse.class, id);
	}

	@Override
	public List<Adresse> findAll() {
		return this.em.createQuery("SELECT p FROM adresses p", Adresse.class).getResultList();
	}

	@Override
	public Adresse save(Adresse object) {
		return this.em.merge(object);
	}

	@Override
	public boolean delete(Adresse object) {
		try {
			this.em.remove(this.em.merge(object));
			return true;
		}
		
		catch (Exception ex) {
			return false;
		}
	}

}
