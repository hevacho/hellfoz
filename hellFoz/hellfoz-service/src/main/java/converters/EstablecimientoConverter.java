/**
 * 
 */
package converters;

import java.util.LinkedList;
import java.util.List;

import hellfoz.dto.EstablecimientoDto;
import hellfoz.model.entities.Establecimiento;

/**
 * @author hevacho
 *
 */
public class EstablecimientoConverter {
	
	public static EstablecimientoDto toDto(Establecimiento e){
		EstablecimientoDto toRet = null;
		
		if(e!=null){
			toRet = new EstablecimientoDto();
			toRet.setIdEstablecimiento(e.getIdEstablecimiento());
			toRet.setNombre(e.getNombre());
			toRet.setTexto(e.getTexto());
			toRet.setUrl(e.getUrl());
			toRet.setGoogleMapsUrl(e.getGoogleMapsUrl());
		}
		return toRet;
	}
	
	public static List<EstablecimientoDto> toDto(List<Establecimiento> elements){
		List<EstablecimientoDto> toRet = null;
		
		if(elements!=null){
				toRet = new LinkedList<EstablecimientoDto>();
			for (Establecimiento establecimiento : elements) {
				toRet.add(toDto(establecimiento));
			}
			
		}
		return toRet;
	}

}
