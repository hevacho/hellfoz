/**
 * 
 */
package hellfoz.dto;

import java.io.Serializable;

/**
 * @author hevacho
 *
 */
public class EstablecimientoDto implements Serializable {

	
	private static final long serialVersionUID = -1279899468300584438L;
	private Integer idEstablecimiento;
	private String nombre;
	private String texto;
	private String url;
	private String googleMapsUrl;
	/**
	 * @return the idEstablecimiento
	 */
	public Integer getIdEstablecimiento() {
		return idEstablecimiento;
	}
	/**
	 * @param idEstablecimiento the idEstablecimiento to set
	 */
	public void setIdEstablecimiento(Integer idEstablecimiento) {
		this.idEstablecimiento = idEstablecimiento;
	}
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
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
	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * @return the googleMapsUrl
	 */
	public String getGoogleMapsUrl() {
		return googleMapsUrl;
	}
	/**
	 * @param googleMapsUrl the googleMapsUrl to set
	 */
	public void setGoogleMapsUrl(String googleMapsUrl) {
		this.googleMapsUrl = googleMapsUrl;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("EstablecimientoDto [idEstablecimiento=");
		builder.append(idEstablecimiento);
		builder.append(", nombre=");
		builder.append(nombre);
		builder.append(", texto=");
		builder.append(texto);
		builder.append(", url=");
		builder.append(url);
		builder.append(", googleMapsUrl=");
		builder.append(googleMapsUrl);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
