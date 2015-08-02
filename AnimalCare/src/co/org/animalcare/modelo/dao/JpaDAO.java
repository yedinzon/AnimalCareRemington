package co.org.animalcare.modelo.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

@Repository
public abstract class JpaDAO<T extends Serializable> {
	private Class<T> clazz;
	@PersistenceContext(type=PersistenceContextType.EXTENDED)
	private EntityManager entityManager;
	private Session session;

	
	public Session getSession() {		
		return session;
	}

	public void setSession(Session session) {		
		this.session = session;
	}

	public void setClazz(final Class<T> clazzToSet) {
		this.clazz = clazzToSet;
	}

	public T findOne(final Long id) {		
//		T ent = entityManager.find(clazz, id);
//		if(ent != null) {
//			session = entityManager.unwrap(Session.class);
//			System.out.println(session);
//			session.update(ent);
//		}		
//		return ent;
		try {
			return entityManager.find(clazz, id);
		} catch (Exception e) {
			return null;
		}		
	}

	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		System.err.println(entityManager);
		return entityManager.createQuery("from " + clazz.getSimpleName())
				.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<T> findAll(Long codigo, String columna) {
		System.err.println(entityManager);
		System.out.println(codigo + " - " + columna);
		return entityManager.createQuery(
				"from " + clazz.getName() + " where " + columna + " = "
						+ codigo).getResultList();
	}

	public void save(final T entity) {
		entityManager.persist(entity);
	}

	public void update(final T entity) {
		entityManager.merge(entity);
	}

	public void delete(final T entity) {
		entityManager.remove(entity);
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public Class<T> getClazz() {
		return clazz;
	}

}