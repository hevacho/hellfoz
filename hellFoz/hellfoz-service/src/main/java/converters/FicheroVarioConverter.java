/**
 * 
 */
package converters;

import hellfoz.dto.FicheroDto;
import hellfoz.model.entities.FicheroVario;

/**
 * Clase para convertir un ficheroVario en un ficheroDto
 * @author hevacho
 *
 */
public class FicheroVarioConverter {
	
	
	public static FicheroDto toDTO(FicheroVario entity){
		FicheroDto toRet = null;
		if(entity!=null){
			toRet = new FicheroDto();
			toRet.setIdFicheroVarios(entity.getIdFicheroVarios());
			toRet.setDescripcion(entity.getDescripcion());
			toRet.setClave(entity.getClave());
			toRet.setFichero(entity.getFichero());
			toRet.setMimeType(entity.getMimeType());
			toRet.setNombreFichero(entity.getNombreFichero());
		}
		
		return toRet;
		
	}

}
