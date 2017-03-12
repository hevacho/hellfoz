/**
 * 
 */
package hellfoz.web;

import hellfoz.dto.BandaDto;
import hellfoz.service.BandaService;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 * @author hevacho
 *
 */
@ManagedBean(name="bandaBean")
@ViewScoped
public class BandaBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@ManagedProperty("#{BandaServiceImpl}")
	private transient BandaService bandaService;

	
	private List<BandaDto> bandas;
	
	@PostConstruct
	public void init(){
		
		bandas = bandaService.getAllBandsOrdered();
		
		FacesContext context = FacesContext.getCurrentInstance();
		
		//cargamos las bandas y las identificaremos por "band" + id de la foto
		if(bandas!=null && !bandas.isEmpty()){
			for (BandaDto banda : bandas) {
				if(banda.getFoto()!=null){
					context.getExternalContext().getSessionMap().put("band"+banda.getFoto().getIdImagen(), banda.getFoto());
				}
				
			}
			
		}
		
		
	}
	
	
	/**
	 * @param bandaService the bandaService to set
	 */
	public void setBandaService(BandaService bandaService) {
		this.bandaService = bandaService;
	}


	/**
	 * @return the bandas
	 */
	public List<BandaDto> getBandas() {
		return bandas;
	}
	
	
	
	

}
