/**
 * 
 */
package hellfoz.service;

import hellfoz.dto.EventoDto;

import java.util.List;

/**
 * @author hevacho
 *
 */
public interface EventoService {

	/**
	 * Retorna la lista de eventos ordenados por fecha
	 * @return
	 */
	List<EventoDto> obtenerEventos();

}
