/**
 * 
 */
package hellfoz.model.dao;

import java.util.List;

import hellfoz.model.BaseGenericDao;
import hellfoz.model.entities.Pedido;

/**
 * @author hevacho
 *
 */
public interface PedidoDao extends BaseGenericDao<Pedido, Integer> {
	
	List<Pedido> obtenerPedidosByIdEstado(Integer idEstado);

	/**
	 * @param idEstado
	 * @return
	 */
	List<Integer> idsPedidosByEstado(Integer idEstado);
	
	

}
