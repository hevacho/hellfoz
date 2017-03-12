/**
 * 
 */
package hellfoz.model.dao;

import java.util.List;

import hellfoz.model.BaseGenericDao;
import hellfoz.model.entities.Noticia;

/**
 * @author hevacho
 *
 */
public interface NoticiaDao extends BaseGenericDao<Noticia, Integer> {

	/**
	 * Obtiene la lista de noticias
	 * @param inicio posicion del cursor para la primera tupla
	 * @param tamanhoBloque numero de elementos que se quiere 
	 * traer en la consulta
	 * @return
	 */
	List<Noticia> getNoticiasPeq(int inicio, int tamanhoBloque);

	/**
	 * Tamanho total de las noticias
	 * @return
	 */
	int getTotalNoticias();

}
