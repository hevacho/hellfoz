/**
 * 
 */
package hellfoz.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import converters.EventoConverter;
import hellfoz.dto.EventoDto;
import hellfoz.model.dao.EventoDao;
import hellfoz.model.entities.Evento;
import hellfoz.service.EventoService;

/**
 * @author hevacho
 *
 */
@Service("EventoServiceImpl")
@Transactional(propagation=Propagation.SUPPORTS, isolation=Isolation.READ_COMMITTED)
public class EventoServiceImpl implements EventoService {
	
	@Autowired
	private EventoDao eventoDao;
	
	@Override
	public List<EventoDto> obtenerEventos(){
		
		List<Evento> eventos = eventoDao.obtenerEventosOrdenadosFecha();
		
		if(eventos!=null && !eventos.isEmpty()){
			return EventoConverter.toDTO(eventos);
		}else{
			return new ArrayList<EventoDto>();
		}
		
	}

}
