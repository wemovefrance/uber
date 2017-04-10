package fr.wemove.dao;


import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.wemove.model.Adresse;
import fr.wemove.model.Conducteur;
import fr.wemove.model.Utilisateur;

@Repository
@Transactional
public class UtilisateurDAO extends DAO<Utilisateur>
{

	
	@Override
	public Utilisateur find(int id) {
		return this.em.find(Utilisateur.class, id);
	}

	@Override
	public List<Utilisateur> findAll() {
		return this.em.createQuery("SELECT p FROM utilisateurs p", Utilisateur.class).getResultList();
	}
	
	public List<Conducteur> findAllConducteurs() {
		return this.em.createQuery("SELECT c FROM Conducteur c", Conducteur.class).getResultList();
	}
	/*
	public HashMap<Double,Double> findHashmapConducteurCoordinates() {
		List<Conducteur> conducteurs = findAllConducteurs();
		HashMap<String,String> listeCoordonnees ;
		for (int ii=0 ; ii<conducteurs.size() ; ii++){
			Adresse adresseConducteur = conducteurs.get(ii).getAdresse() ;
			listeCoordonnees.put(adresseConducteur.getLatitude(),adresseConducteur.getLongitude()) ;
		}		
		return listeCoordonnees ;
	}
*/
	@Override
	public Utilisateur save(Utilisateur object) {
		return this.em.merge(object);
	}

	public Utilisateur update(Utilisateur object) {
		this.em.persist(object);
		return object;
	}
	
	@Override
	public boolean delete(Utilisateur object) {
		try {
			this.em.remove(this.em.merge(object));
			return true;
		}
		
		catch (Exception ex) {
			return false;
		}
	}
}