/**
 * 
 */
package hellfoz.web;

import hellfoz.service.VariosService;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import utiles.Constants;

/**
 * @author hevacho
 *
 */

@ManagedBean(name = "tiempoConciertoBean")
@ViewScoped
public class TiempoConciertoBean implements Serializable {

	
	private static final long serialVersionUID = 1L;
	private Long tiempoConcierto;
	
	@ManagedProperty("#{VariosServiceImpl}")
	private transient VariosService variosService;

	@PostConstruct
	public void init() {
		obtenerFecha();
	}

	private void obtenerFecha() {
		try {
			SimpleDateFormat sf = new SimpleDateFormat("dd-MM-yyyy-hh-mm");
			String fecha = variosService.obtenerParametroCacheado(Constants.CLAVE_PARAMETRO_FECHA_CONCIERTO).getValor();
			Date fechaConcierto = sf.parse(fecha);
			Long aux = 0l;
			
			Date hoy = new Date();
			aux = (fechaConcierto.getTime()-hoy.getTime())/1000;

			if (aux <= 0l) {
				aux = 0l;
			}

			tiempoConcierto = aux;
		} catch (ParseException e) {
			tiempoConcierto = 0L;
		}

	}

	/**
	 * @return the tiempoConcierto
	 */
	public Long getTiempoConcierto() {
		return tiempoConcierto;
	}

	/**
	 * @return the variosService
	 */
	public VariosService getVariosService() {
		return variosService;
	}

	/**
	 * @param variosService the variosService to set
	 */
	public void setVariosService(VariosService variosService) {
		this.variosService = variosService;
	}

	

}
