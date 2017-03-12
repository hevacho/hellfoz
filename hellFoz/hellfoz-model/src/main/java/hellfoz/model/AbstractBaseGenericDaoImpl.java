package hellfoz.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class AbstractBaseGenericDaoImpl<T, K extends Serializable>
		implements BaseGenericDao<T, K> {

	@PersistenceContext(unitName = "persistenceUnit")
	private EntityManager entityManager;

	@Override
	public T create(final T entity) {
		getEntityManager().persist(entity);
		getEntityManager().flush();
		return entity;
	}
	
	

	@Override
	public T update(final T entity) {
		return getEntityManager().merge(entity);
	}

	@Override
	public T findById(final Class<T> clase, final K key) {
		return getEntityManager().find(clase, key);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll(final Class<T> clase) {
		String sqlString = "select t from " + clase.getSimpleName() + " t ";
		return getEntityManager().createQuery(sqlString).getResultList();
	}

	@Override
	public void delete(final T entity) {
		getEntityManager().remove(entity);
		getEntityManager().flush();
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

}