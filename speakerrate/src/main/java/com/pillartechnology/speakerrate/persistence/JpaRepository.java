package com.pillartechnology.speakerrate.persistence;

import java.lang.reflect.ParameterizedType;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;

public abstract class JpaRepository<E> implements Repository<E> {

	private EntityManager entityManager;
	private Class<E> entityClass;
	
	@SuppressWarnings("unchecked")
	public JpaRepository(){
		ParameterizedType genericSuperclass = (ParameterizedType) this.getClass().getGenericSuperclass();
		this.entityClass = (Class<E>) genericSuperclass.getActualTypeArguments()[0];
	}
	
	@Override
	public Set<E> findAll() {
		CriteriaQuery<E> query = entityManager.getCriteriaBuilder().createQuery(entityClass);
		query.from(entityClass);
		return new HashSet<E>(entityManager.createQuery(query).getResultList());
	}

	@Override
	public E findById(long id) {
		return entityManager.find(entityClass,id);
	}

	@Override
	public void persist(E transientEntity) {
		entityManager.persist(transientEntity);
	}

	@Override
	public void remove(E entity) {
		entityManager.remove(entity);
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

}
