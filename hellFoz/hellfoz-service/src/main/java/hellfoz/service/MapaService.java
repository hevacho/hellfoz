/**
 * 
 */
package hellfoz.service;

import hellfoz.dto.MapaDto;

/**
 * @author hevacho
 *
 */
public interface MapaService {

	/**
	 * Obtiene un mapa con sus marcadores en funcion de una clave
	 * @param clave
	 * @return
	 */
	MapaDto obtenerMapa(String clave);

}
