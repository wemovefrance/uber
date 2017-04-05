package fr.wemove.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.wemove.model.Trajet;

@Repository
@Transactional
public class TrajetDAO extends DAO<Trajet> {
	
	@Override
	public Trajet find(int id) {
		return this.em.find(Trajet.class, id);
	}

	@Override
	public List<Trajet> findAll() {
		return this.em.createQuery("SELECT p FROM trajets p", Trajet.class).getResultList();
	}

	@Override
	public Trajet save(Trajet object) {
		return this.em.merge(object);
	}

	@Override
	public boolean delete(Trajet object) {
		try {
			this.em.remove(this.em.merge(object));
			return true;
		}
		
		catch (Exception ex) {
			return false;
		}
	}
}
