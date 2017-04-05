package fr.wemove.dao;

import java.util.List;

import fr.wemove.model.Notification;

public class NotificationDAO extends DAO<Notification> {

	@Override
	public Notification find(int id) {
		return this.em.find(Notification.class, id);
	}

	@Override
	public List<Notification> findAll() {
		return this.em.createQuery("SELECT p FROM notifications p", Notification.class).getResultList();
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
