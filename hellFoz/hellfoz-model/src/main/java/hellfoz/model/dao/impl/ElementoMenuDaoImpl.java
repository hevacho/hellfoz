/**
 * 
 */
package hellfoz.model.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import hellfoz.model.AbstractBaseGenericDaoImpl;
import hellfoz.model.dao.ElementoMenuDao;
import hellfoz.model.entities.ElementoMenu;

/**
 * @author hevacho
 *
 */
@Repository
public class ElementoMenuDaoImpl extends
		AbstractBaseGenericDaoImpl<ElementoMenu, Integer> implements
		ElementoMenuDao {

	/* (non-Javadoc)
	 * @see hellfoz.model.dao.ElementoMenuDao#obtenerElementosActivos()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<ElementoMenu> obtenerElementosActivos() {
		
		String jpql = "Select e FROM ElementoMenu e where e.activo = true order by e.orden asc";
		Query query = getEntityManager().createQuery(jpql);
		
		return query.getResultList();
		
	}

}
