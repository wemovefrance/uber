package fr.wemove.dao;

import java.util.List;

import fr.wemove.model.Paiement;

public class PaiementDAO extends DAO<Paiement> {

	@Override
	public Paiement find(int id) {
		return this.em.find(Paiement.class, id);
	}

	@Override
	public List<Paiement> findAll() {
		return this.em.createQuery("SELECT p FROM paiements p", Paiement.class).getResultList();
	}

	@Override
	public Paiement save(Paiement object) {
		return this.em.merge(object);
	}

	@Override
	public boolean delete(Paiement object) {
		try {
			this.em.remove(this.em.merge(object));
			return true;
		}
		
		catch (Exception ex) {
			return false;
		}
	}
}
