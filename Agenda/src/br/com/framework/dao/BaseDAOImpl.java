package br.com.framework.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class BaseDAOImpl<T> implements BaseDAO<T>{
	
	@PersistenceContext
	private EntityManager entityManager;

	public EntityManager getEntityManager() {
		return entityManager;
	}
	
	public T insert(T bean){
		entityManager.persist(bean);
		return bean;
	}
	
}
