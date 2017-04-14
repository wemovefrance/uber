package fr.wemove.dao;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.wemove.model.Trajet;
import fr.wemove.model.Utilisateur;
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
		return this.em.createQuery("SELECT p FROM Trajet p", Trajet.class).getResultList();
	}
	
	public List<Trajet> findByUserId(int id) {
        Query myQuery = em.createQuery("SELECT p FROM Trajet p where p.id_trajet =:id") ;
        myQuery.setParameter("id", id) ;
        return (List<Trajet>) myQuery.getResultList();
    }

	@Override
	public Trajet save(Trajet object) {
		return this.em.merge(object);
	}
	
	public Trajet update (int id, Trajet object) {
		
		Trajet trajet = this.em.find( Trajet.class, id);
		
		if ( object == null) {
			
			throw new IllegalArgumentException("Unknown Employee id");
		}
		
		trajet.setNote(object.getNote());
		
		return this.em.merge(trajet);	
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
