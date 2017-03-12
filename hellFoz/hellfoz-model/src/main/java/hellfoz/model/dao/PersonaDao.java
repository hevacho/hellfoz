/**
 * 
 */
package hellfoz.model.dao;

import java.util.List;

import hellfoz.model.BaseGenericDao;
import hellfoz.model.entities.Persona;

/**
 * @author hevacho
 *
 */
public interface PersonaDao extends BaseGenericDao<Persona, Integer> {

	List<String> getEmailsFromIdPedido(Integer pedido);
}
