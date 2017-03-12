/**
 * 
 */
package hellfoz.service;

import hellfoz.dto.DatosAcampadaDto;

import javax.mail.MessagingException;

import utiles.NoRollBackException;

/**
 * @author hevacho
 *
 */
public interface AcampadaService {

	/**
	 * @param datos
	 * @throws MessagingException 
	 * @throws NoRollBackException 
	 */
	void saveAcampada(DatosAcampadaDto datos) throws NoRollBackException;

	

}
