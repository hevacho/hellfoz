/**
 * 
 */
package hellfoz.web;

import hellfoz.dto.MapaDto;
import hellfoz.dto.MarkerDto;
import hellfoz.service.MapaService;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

import utiles.Constants;

/**
 * @author hevacho
 *
 */
@ManagedBean(name="mapaBean")
@ViewScoped
public class MapaBean implements Serializable {

	
	private static final long serialVersionUID = 7192133040098162661L;

	@ManagedProperty("#{MapaServiceImpl}")
	private transient MapaService mapaService;
	
	private MapaDto mapa;
	//variable para usar los markadores
	private MapModel simpleModel;
	
	@PostConstruct
	public void init(){
		
		simpleModel = new DefaultMapModel();
		mapa = mapaService.obtenerMapa(Constants.CLAVE_MAPA_FOZ);
		
		//si contiene marcadores
		if(mapa!=null && mapa.getMarkers()!=null && !mapa.getMarkers().isEmpty()){
			
			for (MarkerDto marker : mapa.getMarkers()) {
				simpleModel.addOverlay(new Marker(new LatLng(marker.getLatitud(), marker.getLongitud()), marker.getTexto()));
			}
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

		
	
	
}
