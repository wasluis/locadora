package br.com.framework.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

public abstract class BaseDAOImpl<T> implements BaseDAO<T>{
	
	@PersistenceContext
	private EntityManager entityManager;

	private Class<T> type;
	
	public EntityManager getEntityManager() {
		return entityManager;
	}
	
	public T insert(T bean){
		entityManager.persist(bean);
		return bean;
	}
	
	protected Session getSession(){
		return entityManager.unwrap(Session.class);
	}
	
	@SuppressWarnings("unchecked")
	private Class<T> getType() {
		if (type == null) {
			ParameterizedType superClass = ((java.lang.reflect.ParameterizedType) 
					this.getClass().getGenericSuperclass());
			type = (Class<T>) superClass.getActualTypeArguments()[0];
		}
		return type;
	}
	
	public List<T> findAll() {
		try {
			Class<T> type = getType();
			CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
			CriteriaQuery<T> query = builder.createQuery(type);
			
			Root<T> root = query.from(type);
			query.select(root);
	
			TypedQuery<T> typedQuery = getEntityManager().createQuery(query);
			return typedQuery.getResultList();
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public void remove(T bean){
		bean = getEntityManager().merge(bean);
		getEntityManager().remove(bean);
	}
	
	public void update(T bean){
		getEntityManager().merge(bean);
	}
	
}
