/**
 * 
 */
package hellfoz.service;

import hellfoz.dto.FicheroDto;
import hellfoz.dto.PersonaEntradaDto;
import hellfoz.dto.TarjetaDto;

import java.util.List;

import com.paypal.base.rest.PayPalRESTException;

/**
 * @author hevacho
 *
 */
public interface EntradasService {

	/**
	 * @param personasEntradas
	 * @return
	 */
	Integer salvarPedidoInicial(List<PersonaEntradaDto> personasEntradas);

	/**
	 * @param tarjeta
	 * @param numeroPedido
	 * @throws PayPalRESTException
	 */
	void realizarPedidoPaypal(TarjetaDto tarjeta, Integer numeroPedido)
			throws PayPalRESTException;

	/**
	 * @param numeroPedido
	 * @return
	 */
	FicheroDto generarEntradasPedido(Integer numeroPedido);


	/**
	 * @return
	 */
	List<Integer> idsPedidosEstadoPagoCompletado();

	/**
	 * @param idPedido
	 */
	void enviarEntradasCorreo(Integer idPedido);

}
