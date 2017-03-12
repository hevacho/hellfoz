/**
 * 
 */
package hellfoz.model.dao;

import java.util.List;

import hellfoz.model.BaseGenericDao;
import hellfoz.model.entities.Banda;

/**
 * @author hevacho
 *
 */
public interface BandaDao extends BaseGenericDao<Banda, Integer> {

	/**
	 * Retorna la lista de bandas ordenadas 
	 * @return
	 */
	List<Banda> getAllBandsOrdered();

}
