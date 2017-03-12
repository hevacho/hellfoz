/**
 * 
 */
package hellfoz.model.dao;

import hellfoz.model.BaseGenericDao;
import hellfoz.model.entities.ParametroVario;

/**
 * @author hevacho
 *
 */
public interface ParametroVarioDao extends
		BaseGenericDao<ParametroVario, Integer> {

	/**
	 * @param clave
	 * @return
	 */
	ParametroVario findByClaveAndTimeNow(String clave);

}
