/**
 * 
 */
package hellfoz.service;

import hellfoz.dto.FicheroDto;
import hellfoz.model.entities.Acampada;

import javax.mail.MessagingException;

/**
 * @author hevacho
 *
 */
public interface MailService {

	/**
	 * 
	 */
	void pruebaMail();

	/**
	 * @param acampada
	 * @throws MessagingException
	 */
	void enviarEmailAcampada(Acampada acampada) throws MessagingException;

	/**
	 * @param to
	 * @param cc
	 * @param entradas
	 * @throws MessagingException
	 */
	void enviarEmailEntradas(String to, String[] cc, FicheroDto entradas)
			throws MessagingException;

}
