/**
 * 
 */
package hellfoz.web;

import hellfoz.dto.DatosAcampadaDto;
import hellfoz.dto.MapaDto;
import hellfoz.dto.MarkerDto;
import hellfoz.service.AcampadaService;
import hellfoz.service.MapaService;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.primefaces.context.RequestContext;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import utiles.Constants;
import utiles.NoRollBackException;

/**
 * @author hevacho
 *
 */
/**
 * @author hevacho
 *
 */
@ManagedBean(name="acampadaBean")
@ViewScoped
public class AcampadaBean implements Serializable{
	
	private static final Logger LOG = LoggerFactory.getLogger(AcampadaBean.class);
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ManagedProperty("#{MapaServiceImpl}")
	private transient MapaService mapaService;
	
	@ManagedProperty("#{AcampadaServiceImpl}")
	private transient AcampadaService acampadaService;
	
	private MapaDto mapa;
	//variable para usar los markadores
	private MapModel simpleModel;
	private List<String> images;
	
	private DatosAcampadaDto datosAcampada;
	
	@PostConstruct
	public void init(){
		
		simpleModel = new DefaultMapModel();
		mapa = mapaService.obtenerMapa(Constants.CLAVE_MAPA_ACAMPADA);
		
		//si contiene marcadores
		if(mapa!=null && mapa.getMarkers()!=null && !mapa.getMarkers().isEmpty()){
			
			for (MarkerDto marker : mapa.getMarkers()) {
				simpleModel.addOverlay(new Marker(new LatLng(marker.getLatitud(), marker.getLongitud()), marker.getTexto()));
			}
		}
		
		//inicializamos las imagenes
		images= new ArrayList<String>();
		for (int i = 1; i <=3 ; i++) {
			images.add("acampada"+i+".jpg");
		}
		
		inicializarFormularioAcampada();
		
	}

	/**
	 * 
	 */
	private void inicializarFormularioAcampada() {
		datosAcampada = new DatosAcampadaDto();
		datosAcampada.setNumeroPersonas(1);
	}

	public void onButtonAction(ActionEvent e) {
		RequestContext.getCurrentInstance().execute(
				"PF('captchaDlgWar').hide(); Recaptcha.reload();");

		try {
			
			 
			
			acampadaService.saveAcampada(datosAcampada);
			RequestContext
					.getCurrentInstance()
					.showMessageInDialog(
							new FacesMessage(
									FacesMessage.SEVERITY_INFO,
									"Info",
									UtilMessages.getMessage("acampada.ok")));
									

			// guardaremos y reiniciamos el form
			datosAcampada.setNombre("");
			datosAcampada.setApellido1("");
			datosAcampada.setApellido2("");
			datosAcampada.setEmail("");
			datosAcampada.setNumeroPersonas(1);
		} catch (NoRollBackException e1){
			RequestContext
			.getCurrentInstance()
			.showMessageInDialog(
					new FacesMessage(
							FacesMessage.SEVERITY_WARN,
							"Warning",
							UtilMessages.getMessage("acampada.warn")));
		} catch (Exception e2) {
			RequestContext
					.getCurrentInstance()
					.showMessageInDialog(
							new FacesMessage(
									FacesMessage.SEVERITY_ERROR,
									"Error",
									UtilMessages.getMessage("acampada.error")));
			
			LOG.error("Error al rellenar formulario acampada",e2);
			
		}

	}
	
	/**
	 * @return the mapa
	 */
	public MapaDto getMapa() {
		return mapa;
	}

	/**
	 * @param mapaService the mapaService to set
	 */
	public void setMapaService(MapaService mapaService) {
		this.mapaService = mapaService;
	}

	/**
	 * @return the simpleModel
	 */
	public MapModel getSimpleModel() {
		return simpleModel;
	}

	/**
	 * @return the images
	 */
	public List<String> getImages() {
		return images;
	}

	/**
	 * @return the datosAcampada
	 */
	public DatosAcampadaDto getDatosAcampada() {
		return datosAcampada;
	}

	/**
	 * @param datosAcampada the datosAcampada to set
	 */
	public void setDatosAcampada(DatosAcampadaDto datosAcampada) {
		this.datosAcampada = datosAcampada;
	}

	/**
	 * @param acampadaService the acampadaService to set
	 */
	public void setAcampadaService(AcampadaService acampadaService) {
		this.acampadaService = acampadaService;
	}
	
	

}
