/**
 * 
 */
package hellfoz.model.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import hellfoz.model.AbstractBaseGenericDaoImpl;
import hellfoz.model.dao.EstablecimientoDao;
import hellfoz.model.entities.Establecimiento;

/**
 * @author hevacho
 *
 */

@Repository
public class EstablecimientoDaoImpl extends
		AbstractBaseGenericDaoImpl<Establecimiento, Integer> implements
		EstablecimientoDao {
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Establecimiento> getEstablecimientosTipo(Integer idTipoEstablecimiento){
		String jqpl = "SELECT e FROM Establecimiento e where e.tipoEstablecimiento.idTipoEstablecimiento=:idTipoEstablecimiento";
		Query query = getEntityManager().createQuery(jqpl);
		query.setParameter("idTipoEstablecimiento", idTipoEstablecimiento);
		
		return query.getResultList();
	}

}
