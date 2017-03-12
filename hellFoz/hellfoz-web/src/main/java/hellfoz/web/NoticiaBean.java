/**
 * 
 */
package hellfoz.web;

import hellfoz.dto.NoticiaDto;
import hellfoz.dto.NoticiasPagina;
import hellfoz.service.NoticiaService;

import java.io.IOException;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import utiles.Constants;

/**
 * Clase para manejar la pagina de noticias
 * @author hevacho
 *
 */
@ManagedBean(name="noticiaBean")
@ViewScoped
public class NoticiaBean implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@ManagedProperty("#{NoticiaServiceImpl}")
	private transient NoticiaService noticiaService;

	private int numeroPagina;
	private int numeroNoticiasPorPagina;
	private NoticiasPagina noticiasPagina;
	
	@PostConstruct
	public void init(){
		this.numeroPagina = 1;
		this.numeroNoticiasPorPagina = 4; 
		
		//intentamos recuperar la pagina por si vuelve de una noticia en concreto
		FacesContext fc = FacesContext.getCurrentInstance();
		Integer numeroPagina = (Integer) fc.getExternalContext().getSessionMap().get(Constants.NUMERO_PAGINA);
		fc.getExternalContext().getSessionMap().remove(Constants.NUMERO_PAGINA);
		
		if(numeroPagina!=null){
			this.numeroPagina = numeroPagina;
		}
		
		cargarNoticias(this.numeroPagina-1);
		
	}
	
	
	/**
	 * Metodo que carga las noticias pasando como parametro el primer elemento
	 * @param primera
	 */
	private void cargarNoticias(int primera){
		noticiasPagina = noticiaService.obtenerNoticias(primera, numeroNoticiasPorPagina);
		FacesContext context = FacesContext.getCurrentInstance();
		
		//cargamos las noticias y las identificaremos por peq + el id de la foto
		if(noticiasPagina!=null && noticiasPagina.getNoticias()!=null){
			for (NoticiaDto noticia : noticiasPagina.getNoticias()) {
				if(noticia.getFotoPeq()!=null){
					context.getExternalContext().getSessionMap().put("peq"+noticia.getFotoPeq().getIdImagen(), noticia.getFotoPeq());
				}
				
			}
			
		}
	}
	
	/**
	 * Metodo para cargar la pagina anterior con las noticias
	 */
	public void anterior(){
		numeroPagina--;
		cargarNoticias((numeroPagina-1)*numeroNoticiasPorPagina);
	}
	
	/**
	 * Metodo para cargar la siguiente pagina con las noticias
	 */
	public void siguiente(){
		cargarNoticias(numeroPagina*numeroNoticiasPorPagina);
		numeroPagina++;
		
	}
	
	/**
	 * Metodo que verifica si existen siguientes
	 * @return
	 */
	public boolean haySiguiente(){
		if(noticiasPagina!=null && noticiasPagina.getNoticias()!=null && !noticiasPagina.getNoticias().isEmpty()){
			return numeroPagina*numeroNoticiasPorPagina<noticiasPagina.getTotal();
		}
		return false;
	}
	
	public boolean hayAnterior(){
		return numeroPagina>1;
	}
	
	public void leerMas(Integer idNoticia){
		FacesContext facesContext = FacesContext.getCurrentInstance();
		try {
			facesContext.getExternalContext().redirect("noticia.xhtml");
			facesContext.getExternalContext().getSessionMap().put(Constants.NUMERO_PAGINA, numeroPagina);
			facesContext.getExternalContext().getSessionMap().put(Constants.ID_NOTICIA, idNoticia);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * @return the noticiaService
	 */
	public NoticiaService getNoticiaService() {
		return noticiaService;
	}

	/**
	 * @param noticiaService the noticiaService to set
	 */
	public void setNoticiaService(NoticiaService noticiaService) {
		this.noticiaService = noticiaService;
	}

	/**
	 * @return the noticiasPagina
	 */
	public NoticiasPagina getNoticiasPagina() {
		return noticiasPagina;
	}

	/**
	 * @param noticiasPagina the noticiasPagina to set
	 */
	public void setNoticiasPagina(NoticiasPagina noticiasPagina) {
		this.noticiasPagina = noticiasPagina;
	}
	
	
	
	

	
}
