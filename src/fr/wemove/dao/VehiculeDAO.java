package fr.wemove.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.wemove.model.Vehicule;

@Repository
@Transactional
public class VehiculeDAO extends DAO<Vehicule> {

	@Override
	public Vehicule find(int id) {
		return this.em.find(Vehicule.class, id);
	}

	@Override
	public List<Vehicule> findAll() {
		return this.em.createQuery("SELECT p FROM vehicules p", Vehicule.class).getResultList();
	}

	@Override
	public Vehicule save(Vehicule object) {
		return this.em.merge(object);
	}

	@Override
	public boolean delete(Vehicule object) {
		try {
			this.em.remove(this.em.merge(object));
			return true;
		}
		
		catch (Exception ex) {
			return false;
		}
	}
}
