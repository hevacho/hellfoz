/**
 * 
 */
package hellfoz.dto;

import java.io.Serializable;

/**
 * @author hevacho
 *
 */
public class MarkerDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer idMarker;
	private Double latitud;
	private Double longitud;
	private String texto;
	/**
	 * @return the idMarker
	 */
	public Integer getIdMarker() {
		return idMarker;
	}
	/**
	 * @param idMarker the idMarker to set
	 */
	public void setIdMarker(Integer idMarker) {
		this.idMarker = idMarker;
	}
	/**
	 * @return the latitud
	 */
	public Double getLatitud() {
		return latitud;
	}
	/**
	 * @param latitud the latitud to set
	 */
	public void setLatitud(Double latitud) {
		this.latitud = latitud;
	}
	/**
	 * @return the longitud
	 */
	public Double getLongitud() {
		return longitud;
	}
	/**
	 * @param longitud the longitud to set
	 */
	public void setLongitud(Double longitud) {
		this.longitud = longitud;
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
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MarkerDto [idMarker=");
		builder.append(idMarker);
		builder.append(", latitud=");
		builder.append(latitud);
		builder.append(", longitud=");
		builder.append(longitud);
		builder.append(", texto=");
		builder.append(texto);
		builder.append("]");
		return builder.toString();
	}
	
	
}
