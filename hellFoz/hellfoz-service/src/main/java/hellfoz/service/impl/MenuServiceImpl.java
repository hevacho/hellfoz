/**
 * 
 */
package hellfoz.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import converters.MenuConverter;
import hellfoz.dto.ElementoMenuDto;
import hellfoz.model.dao.ElementoMenuDao;
import hellfoz.model.entities.ElementoMenu;
import hellfoz.service.MenuService;

/**
 * @author hevacho
 *
 */
@Service("MenuServiceImpl")
@Transactional(propagation=Propagation.SUPPORTS, isolation=Isolation.READ_COMMITTED)
public class MenuServiceImpl implements MenuService {
	
	@Autowired
	private ElementoMenuDao elementoMenuDao;
	
	@Override
	public List<ElementoMenuDto> obtenerMenusActivos(){
		
		List<ElementoMenu> elementos = elementoMenuDao.obtenerElementosActivos();
		return MenuConverter.toDto(elementos);
	}

}
