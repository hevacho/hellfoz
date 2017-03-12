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

import converters.BandaConverter;
import hellfoz.dto.BandaDto;
import hellfoz.model.dao.BandaDao;
import hellfoz.model.entities.Banda;
import hellfoz.service.BandaService;

/**
 * @author hevacho
 *
 */

@Service("BandaServiceImpl")
@Transactional(propagation=Propagation.SUPPORTS, isolation=Isolation.READ_COMMITTED)
public class BandaServiceImpl implements BandaService {
	
	@Autowired
	private BandaDao bandaDao;
	
	@Override
	public List<BandaDto> getAllBandsOrdered(){
		
		List<Banda> bandasOrdenadas = bandaDao.getAllBandsOrdered();
		return BandaConverter.toDto(bandasOrdenadas);
		
	}

}
