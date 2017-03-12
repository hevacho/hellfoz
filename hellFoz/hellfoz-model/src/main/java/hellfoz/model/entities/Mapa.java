/**
 * 
 */
package hellfoz.model.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author hevacho
 *
 */
@Entity
@Table(name="mapa", schema="hellfoz")
public class Mapa implements Serializable {

	
	private static final long serialVersionUID = -456851857472425310L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_MAPA")
	private Integer idMapa;

	@Column(name = "DESCRIPCION", length=100, nullable=false)
	private String descripcion;

	@Column(name="LATITUD", columnDefinition="Decimal(10,7)")
	private Double latitud;
	
	@Column(name="LONGITUD", columnDefinition="Decimal(10,7)")
	private Double longitud;
	
	@Column(name="ZOOM", nullable=false)
	private Integer zoom;
	
	@Column(name="CLAVE", nullable=false, length=50)
	private String clave;
	
	@OneToMany(fetch=FetchType.EAGER, mappedBy="mapa")
	private List<Marker> markers;

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
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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
	 * @return the clave
	 */
	public String getClave() {
		return clave;
	}

	/**
	 * @param clave the clave to set
	 */
	public void setClave(String clave) {
		this.clave = clave;
	}

	/**
	 * @return the markers
	 */
	public List<Marker> getMarkers() {
		return markers;
	}

	/**
	 * @param markers the markers to set
	 */
	public void setMarkers(List<Marker> markers) {
		this.markers = markers;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Mapa [idMapa=");
		builder.append(idMapa);
		builder.append(", descripcion=");
		builder.append(descripcion);
		builder.append(", latitud=");
		builder.append(latitud);
		builder.append(", longitud=");
		builder.append(longitud);
		builder.append(", zoom=");
		builder.append(zoom);
		builder.append(", clave=");
		builder.append(clave);
		builder.append(", markers=");
		builder.append(markers);
		builder.append("]");
		return builder.toString();
	}
	
	
	

}
