/**
 * 
 */
package hellfoz.service;

import hellfoz.dto.ImagenDto;

import java.util.List;

/**
 * @author hevacho
 *
 */
public interface ImagenesService {
	
	/**
	 * Obtiene las imagenes de inicio
	 * 
	 * @return
	 */
	public List<ImagenDto> obtenerImagenesInicio();

}
