package fr.wemove.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class DAO<T>
{
	@PersistenceContext
	protected EntityManager em;
	
	public EntityManager getEntityManager() {
		return em;
	}
	
	public abstract T find(int id);
	public abstract List<T> findAll();
	public abstract T save(T object);
	public abstract boolean delete(T object);
}