/**
 * 
 */
package hellfoz.model.dao.impl;

import java.util.Date;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import hellfoz.model.AbstractBaseGenericDaoImpl;
import hellfoz.model.dao.ParametroVarioDao;
import hellfoz.model.entities.ParametroVario;

/**
 * @author hevacho
 *
 */
@Repository
public class ParametroVarioDaoImpl extends
		AbstractBaseGenericDaoImpl<ParametroVario, Integer> implements
		ParametroVarioDao {
	
	@Override
	public ParametroVario findByClaveAndTimeNow(String clave){
		String jpql = "Select p FROM ParametroVario p where p.clave=:clave and p.fechaDesde<:fechaAhora and (p.fechaHasta>:fechaAhora or p.fechaHasta is null)";
		Query query = getEntityManager().createQuery(jpql);
		query.setParameter("clave", clave);
		query.setParameter("fechaAhora", new Date());
		
		return (ParametroVario) query.getResultList().get(0);
		
	}

}
