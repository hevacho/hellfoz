/**
 * 
 */
package hellfoz.model.dao.impl;

import org.springframework.stereotype.Repository;

import hellfoz.model.AbstractBaseGenericDaoImpl;
import hellfoz.model.dao.EntradaDao;
import hellfoz.model.entities.Entrada;

/**
 * @author hevacho
 *
 */
@Repository
public class EntradaDaoImpl extends
		AbstractBaseGenericDaoImpl<Entrada, Integer> implements EntradaDao {

}
