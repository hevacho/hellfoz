/**
 * 
 */
package hellfoz.web;

import hellfoz.dto.EventoDto;
import hellfoz.dto.ImagenDto;
import hellfoz.service.EventoService;
import hellfoz.service.ImagenesService;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author hevacho
 *
 */

@ManagedBean(name="inicioBean")
@ViewScoped
public class InicioBean implements Serializable{
	

	private static final long serialVersionUID = 1L;
	
	private static final Logger LOG = LoggerFactory.getLogger(InicioBean.class);
	
	private static final int TAMANHO_EVENTOS=7;

	@ManagedProperty("#{ImagenesServiceImpl}")
	private transient ImagenesService imagenesService;
	
	@ManagedProperty("#{EventoServiceImpl}")
	private transient EventoService eventoService;
	
	private List<String> images;
	private List<EventoDto> eventos;
	private EventoDto eventoSeleccionado;
	
	@PostConstruct
	public void init(){
		obtenerImagenesInicio();
		eventos = eventoService.obtenerEventos();
		ajustarTablaEventos();
		
	}

	/**
	 * Rellenamos con eventos vacios para obtener el tamanho adecuado de la tabla
	 */
	private void ajustarTablaEventos() {
		int calculoSobrantes = 0;
		if(eventos==null || eventos.isEmpty()){
			calculoSobrantes=TAMANHO_EVENTOS;
		}else{
			calculoSobrantes = TAMANHO_EVENTOS - eventos.size() % TAMANHO_EVENTOS;
		}
		
		for (int i = 0; i < calculoSobrantes; i++) {
			EventoDto e = new EventoDto();
			eventos.add(e);
		}
	}

	/**
	 * Obtiene las imagenes para el switch 
	 */
	private void obtenerImagenesInicio() {
		images= new ArrayList<String>();
		List<ImagenDto> imagenes = imagenesService.obtenerImagenesInicio();
		FacesContext context = FacesContext.getCurrentInstance();
		
		int i = 1;
		for (ImagenDto imagenDto : imagenes) {
			
			String claveFoto = "inicio"+i;
			context.getExternalContext().getSessionMap().put(claveFoto, imagenDto);
			images.add(claveFoto);
			i++;
			
		}
	}

	/**
	 * @return the imagenesService
	 */
	public ImagenesService getImagenesService() {
		return imagenesService;
	}

	/**
	 * @param imagenesService the imagenesService to set
	 */
	public void setImagenesService(ImagenesService imagenesService) {
		this.imagenesService = imagenesService;
	}

	/**
	 * @return the images
	 */
	public List<String> getImages() {
		return images;
	}

	/**
	 * @param images the images to set
	 */
	public void setImages(List<String> images) {
		this.images = images;
	}

	/**
	 * @return the eventoService
	 */
	public EventoService getEventoService() {
		return eventoService;
	}

	/**
	 * @param eventoService the eventoService to set
	 */
	public void setEventoService(EventoService eventoService) {
		this.eventoService = eventoService;
	}

	/**
	 * @return the eventos
	 */
	public List<EventoDto> getEventos() {
		return eventos;
	}

	/**
	 * @param eventos the eventos to set
	 */
	public void setEventos(List<EventoDto> eventos) {
		this.eventos = eventos;
	}

	/**
	 * @return the eventoSeleccionado
	 */
	public EventoDto getEventoSeleccionado() {
		return eventoSeleccionado;
	}

	/**
	 * @param eventoSeleccionado the eventoSeleccionado to set
	 */
	public void setEventoSeleccionado(EventoDto eventoSeleccionado) {
		this.eventoSeleccionado = eventoSeleccionado;
	}
	
	
	
}
