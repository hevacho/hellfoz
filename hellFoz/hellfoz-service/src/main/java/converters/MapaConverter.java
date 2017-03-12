/**
 * 
 */
package converters;

import hellfoz.dto.MapaDto;
import hellfoz.model.entities.Mapa;

/**
 * @author hevacho
 *
 */
public class MapaConverter {
	
	public static MapaDto toDto(Mapa entity){
		MapaDto toRet = null;
		
		if(entity!=null){
			toRet = new MapaDto();
			toRet.setIdMapa(entity.getIdMapa());
			toRet.setLatitud(entity.getLatitud());
			toRet.setLongitud(entity.getLongitud());
			toRet.setZoom(entity.getZoom());
			toRet.setMarkers(MarkerConverter.toDto(entity.getMarkers()));
		}
		
		
		return toRet;
	}

}
