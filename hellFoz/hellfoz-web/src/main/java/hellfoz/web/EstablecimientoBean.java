/**
 * 
 */
package hellfoz.web;

import hellfoz.dto.EstablecimientosTotal;
import hellfoz.service.EstablecimientoService;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

/**
 * @author hevacho
 *
 */
@ManagedBean(name="establecimientoBean")
@ViewScoped
public class EstablecimientoBean implements Serializable{
	

	private static final long serialVersionUID = 1L;
	
	
	@ManagedProperty("#{EstablecimientoServiceImpl}")
	private transient EstablecimientoService establecimientoService;
	
	private EstablecimientosTotal establecimientosTotal;
	
	@PostConstruct
	public void init(){
		
		establecimientosTotal = establecimientoService.obtenerEstablecimientos();
		
		
	}
	
	

	/**
	 * @param establecimientoService the establecimientoService to set
	 */
	public void setEstablecimientoService(
			EstablecimientoService establecimientoService) {
		this.establecimientoService = establecimientoService;
	}



	/**
	 * @return the establecimientosTotal
	 */
	public EstablecimientosTotal getEstablecimientosTotal() {
		return establecimientosTotal;
	}



	/**
	 * @param establecimientosTotal the establecimientosTotal to set
	 */
	public void setEstablecimientosTotal(EstablecimientosTotal establecimientosTotal) {
		this.establecimientosTotal = establecimientosTotal;
	}
	
	
	
	

}
