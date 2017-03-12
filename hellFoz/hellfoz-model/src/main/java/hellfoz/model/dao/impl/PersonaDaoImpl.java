/**
 * 
 */
package hellfoz.model.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import hellfoz.model.AbstractBaseGenericDaoImpl;
import hellfoz.model.dao.PersonaDao;
import hellfoz.model.entities.Persona;

/**
 * @author hevacho
 *
 */
@Repository
public class PersonaDaoImpl extends
		AbstractBaseGenericDaoImpl<Persona, Integer> implements PersonaDao {

	/* (non-Javadoc)
	 * @see hellfoz.model.dao.PersonaDao#getEmailsFromIdPedido(java.lang.Integer)
	 */
	@Override
	public List<String> getEmailsFromIdPedido(Integer pedido) {
	
		String sql = "Select p.email From persona p where p.id_pedido=:pedido";
		Query query = getEntityManager().createNativeQuery(sql);
		query.setParameter("pedido", pedido);
		return query.getResultList();
		
	}

}
