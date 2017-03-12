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

import converters.MapaConverter;
import hellfoz.dto.MapaDto;
import hellfoz.model.dao.MapaDao;
import hellfoz.model.entities.Mapa;
import hellfoz.service.MapaService;

/**
 * @author hevacho
 *
 */
@Service("MapaServiceImpl")
@Transactional(propagation=Propagation.SUPPORTS, isolation=Isolation.READ_COMMITTED)
public class MapaServiceImpl implements MapaService {
	
	@Autowired
	private MapaDao mapaDao;
	
	@Override
	public MapaDto obtenerMapa(String clave){
		Mapa mapa = mapaDao.getMapaByClave(clave);
		return MapaConverter.toDto(mapa);
	}

}
