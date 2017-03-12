/**
 * 
 */
package hellfoz.model.dao.impl;

import hellfoz.model.AbstractBaseGenericDaoImpl;
import hellfoz.model.dao.MapaDao;
import hellfoz.model.entities.Mapa;

import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * @author hevacho
 *
 */
@Repository
public class MapaDaoImpl extends AbstractBaseGenericDaoImpl<Mapa, Integer>
		implements MapaDao {
	
    private static final Logger LOG = LoggerFactory.getLogger(MapaDaoImpl.class);
	
    @Override
    public Mapa getMapaByClave(String clave){
		
		String jpql = "SELECT m FROM Mapa m WHERE m.clave like :parametro";
		Query query = getEntityManager().createQuery(jpql);
		query.setParameter("parametro", clave);
		
		try{
			return (Mapa) query.getSingleResult();
		} catch(NoResultException | NonUniqueResultException e){
			LOG.error("Error al buscar el mapa con clave: "+clave, e);
			return null;
		}
		
	}

}
