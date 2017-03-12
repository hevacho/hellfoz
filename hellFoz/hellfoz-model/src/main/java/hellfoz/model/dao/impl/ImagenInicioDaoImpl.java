package hellfoz.model.dao.impl;

import hellfoz.model.AbstractBaseGenericDaoImpl;
import hellfoz.model.dao.ImagenInicioDao;
import hellfoz.model.entities.ImagenInicio;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

/**
 * 
 * @author hevacho
 *
 */
@Repository
public class ImagenInicioDaoImpl extends AbstractBaseGenericDaoImpl<ImagenInicio, Integer> implements ImagenInicioDao {

	/* (non-Javadoc)
	 * @see hellfoz.model.dao.ImagenInicioDao#getImagenesInicioActivas()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<ImagenInicio> getImagenesInicioActivas() {
		
		String jpql = "SELECT a FROM ImagenInicio a where a.activo=true";
		Query query = getEntityManager().createQuery(jpql);
		
		return query.getResultList();
		
	}



}
