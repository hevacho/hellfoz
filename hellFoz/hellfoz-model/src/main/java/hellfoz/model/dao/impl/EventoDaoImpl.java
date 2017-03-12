/**
 * 
 */
package hellfoz.model.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import hellfoz.model.AbstractBaseGenericDaoImpl;
import hellfoz.model.dao.EventoDao;
import hellfoz.model.entities.Evento;

/**
 * @author hevacho
 *
 */
@Repository
public class EventoDaoImpl extends AbstractBaseGenericDaoImpl<Evento, Integer>
		implements EventoDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Evento> obtenerEventosOrdenadosFecha(){
		String jqpl="SELECT e FROM Evento e order by e.fechaEvento desc";
		Query query = getEntityManager().createQuery(jqpl);
		return query.getResultList();
	}
	
}
