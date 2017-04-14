package fr.wemove.dao;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.wemove.model.Trajet;
import fr.wemove.model.Vehicule;

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

	public List<Trajet> findByConducteurId(int idInput){
		Query myQuery = em.createQuery("SELECT p FROM Trajet p where p.conducteur.id_user=:id") ;
		myQuery.setParameter("id", idInput) ;
		return (List<Trajet>) myQuery.getResultList();
		
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
