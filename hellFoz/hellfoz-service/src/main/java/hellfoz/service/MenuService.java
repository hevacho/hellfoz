/**
 * 
 */
package hellfoz.service;

import hellfoz.dto.ElementoMenuDto;

import java.util.List;

/**
 * @author hevacho
 *
 */
public interface MenuService {

	/**
	 * Retorna la lista de menus activos con sus submenus
	 * @return 
	 */
	List<ElementoMenuDto> obtenerMenusActivos();

}
