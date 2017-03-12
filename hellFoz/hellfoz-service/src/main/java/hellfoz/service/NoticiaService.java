/**
 * 
 */
package hellfoz.service;

import hellfoz.dto.NoticiaDto;
import hellfoz.dto.NoticiasPagina;

/**
 * @author hevacho
 *
 */
public interface NoticiaService {

	/**
	 * Retorna la lista de noticias 
	 * @param inicio
	 * @param tamanho
	 * @return
	 */
	NoticiasPagina obtenerNoticias(int inicio, int tamanho);
	
	/**
	 * Retorna la noticia para mostrarla en grande
	 * @param idNoticia
	 * @return
	 */
	NoticiaDto obtenerNoticia(Integer idNoticia);

}
