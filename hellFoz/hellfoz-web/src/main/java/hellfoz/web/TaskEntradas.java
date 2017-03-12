/**
 * 
 */
package hellfoz.web;

import java.util.List;

import hellfoz.service.EntradasService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author hevacho
 *
 */
@Component
public class TaskEntradas {

	@Autowired
	private EntradasService entradasService;
	
	@Scheduled(fixedRate=60000)
	public void enviarEntradas(){
		
		List<Integer> idsPedidosPagados = entradasService.idsPedidosEstadoPagoCompletado(); 
		
		if(idsPedidosPagados!=null){
			
			for (Integer idPedido : idsPedidosPagados) {
				entradasService.enviarEntradasCorreo(idPedido);
			}
			
		}
		
		
	}
}
