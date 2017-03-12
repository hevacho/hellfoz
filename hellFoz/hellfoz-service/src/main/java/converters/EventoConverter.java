/**
 * 
 */
package converters;

import hellfoz.dto.EventoDto;
import hellfoz.model.entities.Evento;

import java.util.ArrayList;
import java.util.List;

import utiles.FechaUtil;

/**
 * @author hevacho
 *
 */
public class EventoConverter {
	
	
	
	public static EventoDto toDTO (Evento evento){
		EventoDto toRet = null;
		
		if(evento!=null){
			toRet = new EventoDto();
			toRet.setIdEvento(evento.getIdEvento());
			
			//formateamos la fecha
			String fecha = FechaUtil.convertirFecha(evento.getFechaEvento());
			toRet.setFechaEvento(fecha);
			
			toRet.setCiudad(evento.getCiudad());
			toRet.setTexto(evento.getTexto());
			toRet.setTitulo(evento.getTitulo());
			
		}
		return toRet;
		
	}
	
	public static List<EventoDto> toDTO (List<Evento> eventos){
		List<EventoDto> toRet = null;
		
		if(eventos!=null){
			toRet = new ArrayList<EventoDto>();
			for (Evento evento : eventos) {
				if(evento!=null){
					toRet.add(toDTO(evento));
				}
			}
		}
		
		return toRet;
	}

}
