/**
 * 
 */
package hellfoz.web;

import hellfoz.dto.FicheroDto;
import hellfoz.service.VariosService;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 * @author hevacho
 *
 */
@ManagedBean(name = "horariosBean")
@ViewScoped
public class HorariosBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManagedProperty("#{VariosServiceImpl}")
	private transient VariosService variosService;

	/**
	 * fichero para sacar por la vista
	 */
	private FicheroDto horario;

	@PostConstruct
	public void init() {

		// buscamos el horario y lo metemos en session para poder renderizarlo
		horario = variosService.obtenerHorarioGrupos();

		if (horario != null) {
			FacesContext context = FacesContext.getCurrentInstance();
			context.getExternalContext().getSessionMap()
					.put("fichero", horario);
		}

	}

	/**
	 * @param variosService
	 *            the variosService to set
	 */
	public void setVariosService(VariosService variosService) {
		this.variosService = variosService;
	}

	/**
	 * @return the horario
	 */
	public FicheroDto getHorario() {
		return horario;
	}

	/**
	 * @param horario
	 *            the horario to set
	 */
	public void setHorario(FicheroDto horario) {
		this.horario = horario;
	}

}
