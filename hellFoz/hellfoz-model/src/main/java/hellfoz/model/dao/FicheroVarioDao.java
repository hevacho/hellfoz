/**
 * 
 */
package hellfoz.model.dao;

import java.util.List;

import hellfoz.model.BaseGenericDao;
import hellfoz.model.entities.FicheroVario;

/**
 * @author hevacho
 *
 */
public interface FicheroVarioDao extends BaseGenericDao<FicheroVario, Integer> {
	
	/**
	 * Retorna la lista de ficheros varios que coinciden con la clave y se encuentran activos
	 * @param clave
	 * @return
	 */
	public List<FicheroVario> getFicheroVario(String clave);

}
