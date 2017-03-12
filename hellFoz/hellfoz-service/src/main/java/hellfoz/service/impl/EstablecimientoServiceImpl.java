/**
 * 
 */
package hellfoz.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import converters.EstablecimientoConverter;
import utiles.Constants;
import hellfoz.dto.EstablecimientosTotal;
import hellfoz.model.dao.EstablecimientoDao;
import hellfoz.model.entities.Establecimiento;
import hellfoz.service.EstablecimientoService;

/**
 * @author hevacho
 *
 */
@Service("EstablecimientoServiceImpl")
@Transactional(propagation=Propagation.SUPPORTS, isolation=Isolation.READ_COMMITTED )
public class EstablecimientoServiceImpl implements EstablecimientoService {
	
	@Autowired
	private EstablecimientoDao establecimientoDao;
	
	@Override
	public EstablecimientosTotal obtenerEstablecimientos(){
		
		EstablecimientosTotal toRet = new EstablecimientosTotal();
		
		List<Establecimiento> hoteles = establecimientoDao.getEstablecimientosTipo(Constants.ID_TIPO_ESTABLECIMIENTO_HOTELES);
		List<Establecimiento> bares = establecimientoDao.getEstablecimientosTipo(Constants.ID_TIPO_ESTABLECIMIENTO_BARES);
		List<Establecimiento> supermercados = establecimientoDao.getEstablecimientosTipo(Constants.ID_TIPO_ESTABLECIMIENTO_SUPERMERCADO);
		List<Establecimiento> tiendas = establecimientoDao.getEstablecimientosTipo(Constants.ID_TIPO_ESTABLECIMIENTO_TIENDAS);
		
		toRet.setHoteles(EstablecimientoConverter.toDto(hoteles));
		toRet.setBares(EstablecimientoConverter.toDto(bares));
		toRet.setSupermercados(EstablecimientoConverter.toDto(supermercados));
		toRet.setTiendas(EstablecimientoConverter.toDto(tiendas));
		
		return toRet;
		
	}

}
