/**
 * 
 */
package hellfoz.web;

import hellfoz.dto.FicheroDto;
import hellfoz.service.EntradasService;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

import utiles.Constants;

/**
 * @author hevacho
 *
 */
@ManagedBean(name = "imprimirEntradasBean")
@ViewScoped
public class ImprimirEntradasBean implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	
	
	private FicheroDto fichero;
	
	@ManagedProperty("#{EntradasServiceImpl}")
	private transient EntradasService entradasService;
	
	@PostConstruct
	public void init(){
		
		RequestContext.getCurrentInstance().execute(
				"PF('statusDialog').show();");
		
		FacesContext context = FacesContext.getCurrentInstance();
		 fichero = (FicheroDto) context.getExternalContext().getSessionMap().get(Constants.ENTRADAS);
		 
		context.getExternalContext().getSessionMap().remove(Constants.ENTRADAS);
		 
		context.getExternalContext().getSessionMap()
				.put("fichero", fichero);
		
		RequestContext.getCurrentInstance().execute(
				"PF('statusDialog').hide();");
		
	}

	
	
	

	/**
	 * @param entradasService the entradasService to set
	 */
	public void setEntradasService(EntradasService entradasService) {
		this.entradasService = entradasService;
	}

	/**
	 * @return the fichero
	 */
	public FicheroDto getFichero() {
		return fichero;
	}
	
 
    	
	

}


