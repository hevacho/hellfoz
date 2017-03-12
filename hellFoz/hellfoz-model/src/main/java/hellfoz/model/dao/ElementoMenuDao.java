/**
 * 
 */
package hellfoz.model.dao;

import java.util.List;

import hellfoz.model.BaseGenericDao;
import hellfoz.model.entities.ElementoMenu;

/**
 * @author hevacho
 *
 */
public interface ElementoMenuDao extends BaseGenericDao<ElementoMenu, Integer> {

	/**
	 * Obtiene los elementos del menu activos ordenados por el campo orden
	 * @return
	 */
	List<ElementoMenu> obtenerElementosActivos();
}
