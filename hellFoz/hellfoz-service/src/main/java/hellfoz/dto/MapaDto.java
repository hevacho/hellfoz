/**
 * 
 */
package hellfoz.dto;

import java.io.Serializable;
import java.util.List;

/**
 * @author hevacho
 *
 */
public class MapaDto implements Serializable {

	
	private static final long serialVersionUID = -9014375844797276743L;
	
	private Integer idMapa;
	private Double longitud;
	private Double latitud;
	private Integer zoom;
	private List<MarkerDto> markers;
	/**
	 * @return the idMapa
	 */
	public Integer getIdMapa() {
		return idMapa;
	}
	/**
	 * @param idMapa the idMapa to set
	 */
	public void setIdMapa(Integer idMapa) {
		this.idMapa = idMapa;
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
	 * @return the zoom
	 */
	public Integer getZoom() {
		return zoom;
	}
	/**
	 * @param zoom the zoom to set
	 */
	public void setZoom(Integer zoom) {
		this.zoom = zoom;
	}
	/**
	 * @return the markers
	 */
	public List<MarkerDto> getMarkers() {
		return markers;
	}
	/**
	 * @param markers the markers to set
	 */
	public void setMarkers(List<MarkerDto> markers) {
		this.markers = markers;
	}
	
	
	public String getCoordenadas(){
		return latitud+" , "+longitud;
		
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MapaDto [idMapa=");
		builder.append(idMapa);
		builder.append(", longitud=");
		builder.append(longitud);
		builder.append(", latitud=");
		builder.append(latitud);
		builder.append(", zoom=");
		builder.append(zoom);
		builder.append(", markers=");
		builder.append(markers);
		builder.append("]");
		return builder.toString();
	}
	
	
}
