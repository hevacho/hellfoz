/**
 * 
 */
package converters;

import hellfoz.dto.ParametroVarioDto;
import hellfoz.model.entities.ParametroVario;

/**
 * @author hevacho
 *
 */
public class ParametroConverter {

	public static ParametroVarioDto toDto (ParametroVario p){
		ParametroVarioDto toRet = null;
		
		if(p!=null){
			toRet = new ParametroVarioDto();
			toRet.setIdParametrosVarios(p.getIdParametrosVarios());
			toRet.setClave(p.getClave());
			toRet.setDescripcion(p.getDescripcion());
			toRet.setFechaDesde(p.getFechaDesde());
			toRet.setFechaHasta(p.getFechaHasta());
			toRet.setValor(p.getValor());
		}
		
		return toRet;
	}
}
