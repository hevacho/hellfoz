/**
 * 
 */
package hellfoz.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import converters.ImagenConverter;
import hellfoz.dto.ImagenDto;
import hellfoz.model.dao.ImagenInicioDao;
import hellfoz.model.entities.ImagenInicio;
import hellfoz.service.ImagenesService;

/**
 * @author hevacho
 *
 */
@Service("ImagenesServiceImpl")
@Transactional(propagation=Propagation.SUPPORTS, isolation=Isolation.READ_COMMITTED)
public class ImagenesServiceImpl implements ImagenesService {
	
	@Autowired
	private ImagenInicioDao imagenesInicioDao;

	/* (non-Javadoc)
	 * @see hellfoz.service.ImagenesService#obtenerImagenesInicio()
	 */
	@Override
	@Cacheable(value="fotosCache")
	public List<ImagenDto> obtenerImagenesInicio() {
		
		List<ImagenInicio> imagenesActivas = imagenesInicioDao.getImagenesInicioActivas();
		
		return ImagenConverter.toDto(imagenesActivas);
		
	}

	
}
