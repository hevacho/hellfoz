/**
 * 
 */
package hellfoz.model.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import hellfoz.model.AbstractBaseGenericDaoImpl;
import hellfoz.model.dao.BandaDao;
import hellfoz.model.entities.Banda;

/**
 * @author hevacho
 *
 */
@Repository
public class BandaDaoImpl extends AbstractBaseGenericDaoImpl<Banda, Integer>
		implements BandaDao {
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Banda> getAllBandsOrdered(){
		String jqpl = "SELECT b FROM Banda b order by b.orden";
		Query query = getEntityManager().createQuery(jqpl);
		return query.getResultList();
	}

}
