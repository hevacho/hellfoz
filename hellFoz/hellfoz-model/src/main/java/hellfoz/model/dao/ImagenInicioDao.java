package hellfoz.model.dao;

import java.util.List;

import hellfoz.model.BaseGenericDao;
import hellfoz.model.entities.ImagenInicio;

public interface ImagenInicioDao extends BaseGenericDao<ImagenInicio, Integer> {
	
	/**
	 * Obtiene las imagenes de inicio 
	 * @return
	 */
	List<ImagenInicio> getImagenesInicioActivas();
}
