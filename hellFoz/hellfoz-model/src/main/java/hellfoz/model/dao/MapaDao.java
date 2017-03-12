/**
 * 
 */
package hellfoz.model.dao;

import hellfoz.model.BaseGenericDao;
import hellfoz.model.entities.Mapa;

/**
 * @author hevacho
 *
 */
public interface MapaDao extends BaseGenericDao<Mapa, Integer> {

	/**
	 * Retorna un mapa con sus marcadores
	 * @param clave nombre del mapa para buscarlo
	 * @return
	 */
	Mapa getMapaByClave(String clave);

}
