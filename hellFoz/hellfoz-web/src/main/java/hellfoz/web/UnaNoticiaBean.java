/**
 * 
 */
package hellfoz.web;

import java.io.IOException;
import java.io.Serializable;

import hellfoz.dto.NoticiaDto;
import hellfoz.service.NoticiaService;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import utiles.Constants;

/**
 * @author hevacho
 *
 */
@ManagedBean(name="unaNoticiaBean")
@ViewScoped
public class UnaNoticiaBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@ManagedProperty("#{NoticiaServiceImpl}")
	private transient NoticiaService noticiaService;
	
	private NoticiaDto noticia;
	private Integer numeroPagina;
	
	@PostConstruct
	public void init(){
		
		//obtenemos los parametros de noticiaBean y recuperamos la noticia
		FacesContext fc = FacesContext.getCurrentInstance();
		Integer numeroPagina = (Integer) fc.getExternalContext().getSessionMap().get(Constants.NUMERO_PAGINA);
		fc.getExternalContext().getSessionMap().remove(Constants.NUMERO_PAGINA);
		
		if(numeroPagina!=null){
			this.numeroPagina = numeroPagina;
		}
		
		
		Integer idNoticia = (Integer) fc.getExternalContext().getSessionMap().get(Constants.ID_NOTICIA);
		fc.getExternalContext().getSessionMap().get(Constants.ID_NOTICIA);
		
		if(idNoticia!=null){
		 noticia = noticiaService.obtenerNoticia(idNoticia);
		 
		 	//cargamos las noticias y las identificaremos por peq + el id de la foto
			if(noticia!=null && noticia.getFotoGrande()!=null && noticia.getFotoGrande().getFoto()!=null){
				fc.getExternalContext().getSessionMap().put("grd"+noticia.getFotoGrande().getIdImagen(), noticia.getFotoGrande());
			}
		 
		}
		
		
	}
	
	public void volverBusqueda(){
		try {
		FacesContext fc = FacesContext.getCurrentInstance();
		fc.getExternalContext().getSessionMap().put(Constants.NUMERO_PAGINA, numeroPagina);
		
			fc.getExternalContext().redirect("noticias.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @return the noticia
	 */
	public NoticiaDto getNoticia() {
		return noticia;
	}

	/**
	 * @param noticia the noticia to set
	 */
	public void setNoticia(NoticiaDto noticia) {
		this.noticia = noticia;
	}

	/**
	 * @param noticiaService the noticiaService to set
	 */
	public void setNoticiaService(NoticiaService noticiaService) {
		this.noticiaService = noticiaService;
	}
	
	
}
