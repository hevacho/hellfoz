/**
 * 
 */
package hellfoz.service;

import hellfoz.dto.BandaDto;

import java.util.List;

/**
 * @author hevacho
 *
 */
public interface BandaService {

	/**
	 * Retorna toda la lista de bandas ordenadas
	 * @return
	 */
	List<BandaDto> getAllBandsOrdered();

}
