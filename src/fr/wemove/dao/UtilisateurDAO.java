package fr.wemove.dao;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.wemove.exception.*;
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
		return this.em.createQuery("SELECT p FROM Utilisateur p", Utilisateur.class).getResultList();
	}
	
	public List<Conducteur> findAllConducteurs() {
		return (List<Conducteur>) this.em.createQuery("SELECT c FROM Conducteur c", Conducteur.class).getResultList();
	}

	
	public Utilisateur findByLogin(String login, String motDePasse) throws WrongUsernameOrPasswordException {
		
		try {
		Query query = this.em.createQuery("from Utilisateur u where u.login = :login and u.motDePasse = :motDePasse");
		
		query.setParameter("login", login);
		query.setParameter("motDePasse", motDePasse);
		return (Utilisateur) query.getSingleResult();
		
		} catch (Exception e) {
			throw new WrongUsernameOrPasswordException();
		}
		
	}
	/*
	public ArrayList<Double> findConducteursLat() {
		ArrayList<Conducteur> conducteurs = new ArrayList<Conducteur>() ;
		conducteurs = (ArrayList<Conducteur>) findAllConducteurs();
		ArrayList<Double> latitudeListe = new ArrayList<Double>() ;
		for (int ii=0 ; ii<conducteurs.size() ; ii++){	
			latitudeListe.add((double) conducteurs.get(ii).getAdresse().getLatitude()) ;
			System.out.println(conducteurs.get(ii).getAdresse().getLatitude());
			}		
		return (ArrayList<Double>) latitudeListe ;
	}	
	
	public ArrayList<Double> findConducteursLong() {
		ArrayList<Conducteur> conducteurs = (ArrayList<Conducteur>) findAllConducteurs();
		ArrayList<Double> longitudeListe = new ArrayList<Double>() ;
		for (int ii=0 ; ii<conducteurs.size() ; ii++){	
			longitudeListe.add((double) conducteurs.get(ii).getAdresse().getLongitude()) ;
			}		
		return longitudeListe ;
	}
	
	public ArrayList<String> findConducteursLogin() {
		ArrayList<Conducteur> conducteurs = (ArrayList<Conducteur>) findAllConducteurs();
		ArrayList<String> loginListe = new ArrayList<String>() ; ;
		for (int ii=0 ; ii<conducteurs.size() ; ii++){	
			loginListe.add((String) conducteurs.get(ii).getLogin()) ;
			}		
		return loginListe ;
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
