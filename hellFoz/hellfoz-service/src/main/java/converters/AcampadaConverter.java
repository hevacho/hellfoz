/**
 * 
 */
package converters;

import java.util.Date;

import hellfoz.dto.DatosAcampadaDto;
import hellfoz.model.entities.Acampada;

/**
 * @author hevacho
 *
 */
public class AcampadaConverter {
	
	public static Acampada toAcampada(DatosAcampadaDto dto){
		Acampada toRet = null;
		
		if(dto!=null){
			toRet = new Acampada();
			toRet.setApellido1(dto.getApellido1());
			toRet.setApellido2(dto.getApellido2());
			toRet.setNombre(dto.getNombre());
			toRet.setEmail(dto.getEmail());
			toRet.setFechaHoraAlta(new Date());
			toRet.setNumeroPersonas(dto.getNumeroPersonas());
			
		}
		return toRet;
	}

}
