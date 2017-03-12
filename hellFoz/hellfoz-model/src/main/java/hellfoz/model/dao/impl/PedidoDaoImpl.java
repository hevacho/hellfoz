/**
 * 
 */
package hellfoz.model.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import hellfoz.model.AbstractBaseGenericDaoImpl;
import hellfoz.model.dao.PedidoDao;
import hellfoz.model.entities.Pedido;

/**
 * @author hevacho
 *
 */
@Repository
public class PedidoDaoImpl extends AbstractBaseGenericDaoImpl<Pedido, Integer>
		implements PedidoDao {

	/* (non-Javadoc)
	 * @see hellfoz.model.dao.PedidoDao#obtenerPedidosByIdEstado(java.lang.Integer)
	 */
	@Override
	public List<Pedido> obtenerPedidosByIdEstado(Integer idEstado) {
		String hql = "Select p From Pedido p where p.estado.idEstado=:idEstado";
		Query query = getEntityManager().createQuery(hql);
		query.setParameter("idEstado", idEstado);
		
		return query.getResultList();
		
	}
	
	@Override
	public List<Integer> idsPedidosByEstado(Integer idEstado){
		String sql = "Select p.id_pedido from hellfoz.pedido p where p.id_estado=:idEstado";
		Query query = getEntityManager().createNativeQuery(sql);
		query.setParameter("idEstado", idEstado);
		
		return query.getResultList();
	}

}
