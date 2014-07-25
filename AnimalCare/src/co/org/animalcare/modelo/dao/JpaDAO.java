package co.org.animalcare.modelo.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


public abstract class JpaDAO< T extends Serializable > {
	   private Class< T > clazz;
	   @PersistenceContext
	   private EntityManager entityManager;
	   
	   public void setClazz( final Class< T > clazzToSet ){
	      this.clazz = clazzToSet;
	   }
	   public T findOne( final int id ){
	      return entityManager.find( clazz, id );
	   }
	   @SuppressWarnings("unchecked")
	   public List< T > findAll(){
		   System.err.println(entityManager);
	      return entityManager.createQuery( "from " + clazz.getName() )
	       .getResultList();
	   }
	   public void save( final T entity ){
	      entityManager.persist( entity );
	   }
	   public void update( final T entity ){
	      entityManager.merge( entity );
	   }
	   public void delete( final T entity ){
	      entityManager.remove( entity );
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