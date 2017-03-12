/**
 * 
 */
package hellfoz.model.dao;

import java.util.List;

import hellfoz.model.BaseGenericDao;
import hellfoz.model.entities.Establecimiento;

/**
 * @author hevacho
 *
 */
public interface EstablecimientoDao extends
		BaseGenericDao<Establecimiento, Integer> {

	/**
	 * Retorna la lista de establecimientos por tipo
	 * @param idTipoEstablecimiento
	 * @return
	 */
	List<Establecimiento> getEstablecimientosTipo(Integer idTipoEstablecimiento);

}
