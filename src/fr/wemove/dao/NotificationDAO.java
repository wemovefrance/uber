package fr.wemove.dao;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.wemove.model.Notification;
import fr.wemove.model.Vehicule;

@Repository
@Transactional
public class NotificationDAO extends DAO<Notification> {

	@Override
	public Notification find(int id) {
		return this.em.find(Notification.class, id);
	}

	@Override
	public List<Notification> findAll() {
		return this.em.createQuery("SELECT p FROM notifications p", Notification.class).getResultList();
	}
	
	public List<Notification> findByTrajetId(int idInput){
		Query myQuery = em.createQuery("SELECT p FROM Notification p where p.trajet.id_trajet=:id") ;
		myQuery.setParameter("id", idInput) ;
		return (List<Notification>) myQuery.getResultList();
		
	}

	@Override
	public Notification save(Notification object) {
		return this.em.merge(object);
	}

	@Override
	public boolean delete(Notification object) {
		try {
			this.em.remove(this.em.merge(object));
			return true;
		}
		
		catch (Exception ex) {
			return false;
		}
	}
}
