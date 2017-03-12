/**
 * 
 */
package hellfoz.service.impl;

import java.util.Date;

import javax.mail.MessagingException;

import hellfoz.dto.DatosAcampadaDto;
import hellfoz.model.dao.AcampadaDao;
import hellfoz.model.entities.Acampada;
import hellfoz.service.AcampadaService;
import hellfoz.service.MailService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import converters.AcampadaConverter;
import utiles.NoRollBackException;

/**
 * @author hevacho
 *
 */
@Service("AcampadaServiceImpl")
@Transactional(propagation=Propagation.SUPPORTS, isolation=Isolation.READ_COMMITTED)
public class AcampadaServiceImpl implements AcampadaService {
	
	private static final Logger LOG = LoggerFactory.getLogger(AcampadaServiceImpl.class);
	
	@Autowired
	private MailService mailService;
	
	@Autowired
	private AcampadaDao acampadaDao;
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED, noRollbackFor={NoRollBackException.class})
	public void saveAcampada(DatosAcampadaDto datos) throws NoRollBackException {
		
		LOG.debug("Salvando acampada :"+datos.toString());
		
		Acampada acampada = AcampadaConverter.toAcampada(datos);
		
		acampada = acampadaDao.create(acampada);
		try{
			//enviaremos email
			mailService.enviarEmailAcampada(acampada);
			acampada.setFechaHoraEnvio(new Date());
			acampadaDao.update(acampada);
		}catch (Exception e){
			LOG.error("Error enviando email", e);
			throw new NoRollBackException();
		}
		
	}

}
