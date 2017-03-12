/**
 * 
 */
package hellfoz.service;

import hellfoz.dto.FicheroDto;
import hellfoz.dto.ParametroVarioDto;

/**
 * @author hevacho
 *
 */
public interface VariosService {

	/**
	 * Obtiene el fichero pdf con los horarios de los grupos
	 * @return
	 */
	FicheroDto obtenerHorarioGrupos();

	/**
	 * @param clave
	 * @return
	 */
	ParametroVarioDto obtenerParametroClaveNow(String clave);

	/**
	 * @param clave
	 * @return
	 */
	ParametroVarioDto obtenerParametroCacheado(String clave);

}
