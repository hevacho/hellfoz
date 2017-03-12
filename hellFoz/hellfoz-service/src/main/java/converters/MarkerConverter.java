/**
 * 
 */
package converters;

import java.util.ArrayList;
import java.util.List;

import hellfoz.dto.MarkerDto;
import hellfoz.model.entities.Marker;

/**
 * @author hevacho
 *
 */
public class MarkerConverter {
	
	public static MarkerDto toDto(Marker entity){
		MarkerDto toRet = null;
		
		if(entity!=null){
			toRet = new MarkerDto();
			toRet.setIdMarker(entity.getIdMarker());
			toRet.setLatitud(entity.getLatitud());
			toRet.setLongitud(entity.getLongitud());
			toRet.setTexto(entity.getTexto());
		}
		
		
		return toRet;
	}
	
	public static List<MarkerDto> toDto(List<Marker> entities){
		List<MarkerDto> toRet = null;
		
		if(entities!=null){
			toRet = new ArrayList<MarkerDto>();
			for (Marker marker : entities) {
				toRet.add(toDto(marker));
			}
		}
		
		return toRet;
	}

}
