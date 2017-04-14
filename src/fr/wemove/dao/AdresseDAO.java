package fr.wemove.dao;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.wemove.model.Adresse;
import fr.wemove.model.Vehicule;

@Repository
@Transactional
public class AdresseDAO extends DAO<Adresse> {
	
	@Override
	public Adresse find(int id) {
		return this.em.find(Adresse.class, id);
	}

	public Adresse findByDriverId(int id) {
	
        Query myQuery = em.createQuery("SELECT p FROM Adresse p where p.conducteur.id_user=:id") ;
        myQuery.setParameter("id", id) ;
        return (Adresse) myQuery.getSingleResult();
    }
	
	@Override
	public List<Adresse> findAll() {
		return this.em.createQuery("SELECT p FROM adresses p", Adresse.class).getResultList();
	}

	@Override
	public Adresse save(Adresse object) {
		return this.em.merge(object);
	}

	public Adresse update ( Integer id, Adresse object) {
		
		Adresse adresse = this.em.find(Adresse.class, id);
		
		if ( adresse == null) {
			
			throw new IllegalArgumentException("Unknown id");
		}
		
		adresse.setNom(object.getNom());
		
		return this.em.merge(adresse);
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
