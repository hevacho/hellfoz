/**
 * 
 */
package converters;

import java.util.LinkedList;
import java.util.List;

import hellfoz.dto.ImagenDto;
import hellfoz.model.entities.ImagenInicio;

/**
 * @author hevacho
 *
 */
public class ImagenConverter {

	/**
	 * Transforma una imagen de inicio en dto, el array es el mismo
	 * @param imagenInicio
	 * @return
	 */
	public static ImagenDto toDto(ImagenInicio imagenInicio){
		ImagenDto toRet = new ImagenDto();
		toRet.setIdImagen(imagenInicio.getIdImagenInicio());
		toRet.setFoto(imagenInicio.getFoto());
		toRet.setDescripcion(imagenInicio.getDescripcion());
		
		return toRet;
	}
	
	public static List<ImagenDto> toDto(List<ImagenInicio> imagenesInicio){
		List<ImagenDto> toRet = new LinkedList<ImagenDto>();
		for (ImagenInicio imagenInicio : imagenesInicio) {
			toRet.add(toDto(imagenInicio));
		}
		
		return toRet;
	}
}
