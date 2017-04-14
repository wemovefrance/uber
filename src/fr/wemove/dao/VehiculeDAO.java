package fr.wemove.dao;

import java.util.List;

import javax.persistence.Query;

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
	
	public List<Vehicule> findByDriverId(int idInput) {
        Query myQuery = em.createQuery("SELECT p FROM Vehicule p where p.conducteur.id_user=:id") ;
        myQuery.setParameter("id", idInput) ;
        return (List<Vehicule>) myQuery.getResultList();
    }

	@Override
	public List<Vehicule> findAll() {
		return this.em.createQuery("SELECT p FROM Vehicule p", Vehicule.class).getResultList();
	}
	
	public List<Vehicule> findByDriverId(int idInput) {
		Query myQuery = em.createQuery("SELECT p FROM Vehicule p where p.conducteur.id_user=:id") ;
		myQuery.setParameter("id", idInput) ;
		return (List<Vehicule>) myQuery.getResultList();
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
