/**
 * 
 */
package converters;

import java.util.LinkedList;
import java.util.List;

import hellfoz.dto.BandaDto;
import hellfoz.dto.ImagenDto;
import hellfoz.model.entities.Banda;

/**
 * Clase auxiliar para transformar las bandas
 * @author hevacho
 *
 */
public class BandaConverter {

	public static BandaDto toDto(Banda entity){
		BandaDto toRet = null;
		
		if(entity!=null){
			toRet = new BandaDto();
			
			//imagen
			if(entity.getFoto()!=null && entity.getFoto().length>0){
				ImagenDto foto = new ImagenDto();
				foto.setIdImagen(entity.getIdBanda());
				foto.setFoto(entity.getFoto());
				toRet.setFoto(foto);
			}
			
			toRet.setIdBanda(entity.getIdBanda());
			toRet.setNombre(entity.getNombre());
			toRet.setOrden(entity.getOrden());
			toRet.setTexto(entity.getTexto());
			toRet.setUrl(entity.getUrl());
		}
		
		
		return toRet;
		
	}
	
	public static List<BandaDto> toDto(List<Banda> entities){
		List<BandaDto> toRet = null;
		
		if(entities!=null){
			toRet = new LinkedList<BandaDto>();
			for (Banda banda : entities) {
				toRet.add(toDto(banda));
			}
			
		}
		return toRet;
	}
}
