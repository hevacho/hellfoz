/**
 * 
 */
package hellfoz.model.dao;

import java.util.List;

import hellfoz.model.BaseGenericDao;
import hellfoz.model.entities.Evento;

/**
 * @author hevacho
 *
 */
public interface EventoDao extends BaseGenericDao<Evento, Integer> {

	/**
	 * Retorna la lista de eventos ordenados por fecha
	 * @return
	 */
	List<Evento> obtenerEventosOrdenadosFecha();

}
