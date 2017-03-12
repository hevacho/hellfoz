/**
 * 
 */
package hellfoz.dto;

import java.io.Serializable;

/**
 * @author hevacho
 *
 */
public class EventoDto implements Serializable {
	
	
	private static final long serialVersionUID = -3594197047504670512L;
	private Integer idEvento;
	private String ciudad;
	private String fechaEvento;
	private String titulo;
	private String texto;
	/**
	 * @return the idEvento
	 */
	public Integer getIdEvento() {
		return idEvento;
	}
	/**
	 * @param idEvento the idEvento to set
	 */
	public void setIdEvento(Integer idEvento) {
		this.idEvento = idEvento;
	}
	/**
	 * @return the ciudad
	 */
	public String getCiudad() {
		return ciudad;
	}
	/**
	 * @param ciudad the ciudad to set
	 */
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	/**
	 * @return the fechaEvento
	 */
	public String getFechaEvento() {
		return fechaEvento;
	}
	/**
	 * @param fechaEvento the fechaEvento to set
	 */
	public void setFechaEvento(String fechaEvento) {
		this.fechaEvento = fechaEvento;
	}
	/**
	 * @return the titulo
	 */
	public String getTitulo() {
		return titulo;
	}
	/**
	 * @param titulo the titulo to set
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	/**
	 * @return the texto
	 */
	public String getTexto() {
		return texto;
	}
	/**
	 * @param texto the texto to set
	 */
	public void setTexto(String texto) {
		this.texto = texto;
	}
	
	
	

}
