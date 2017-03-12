/**
 * 
 */
package hellfoz.model.dao.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import hellfoz.model.AbstractBaseGenericDaoImpl;
import hellfoz.model.dao.FicheroVarioDao;
import hellfoz.model.entities.FicheroVario;

/**
 * @author hevacho
 *
 */
@Repository
public class FicheroVarioDaoImpl extends
		AbstractBaseGenericDaoImpl<FicheroVario, Integer> implements
		FicheroVarioDao {
	
	@SuppressWarnings("unchecked")
	@Override
	public List<FicheroVario> getFicheroVario(String clave){
		String sql = "SELECT f FROM FicheroVario f where f.clave=:clave and ((f.fechaDesde<=:fechaHoy or f.fechaDesde is null) and (f.fechaHasta>=:fechaHoy or f.fechaHasta is null)) ";
		Query query = getEntityManager().createQuery(sql);
		query.setParameter("clave", clave);
		query.setParameter("fechaHoy", new Date());
		
		return query.getResultList();
		
	}

}
