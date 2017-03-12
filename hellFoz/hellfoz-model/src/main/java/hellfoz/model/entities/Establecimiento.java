/**
 * 
 */
package hellfoz.model.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author hevacho
 *
 */

@Entity
@Table(name="ESTABLECIMIENTO", schema="hellfoz")
public class Establecimiento implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_ESTABLECIMIENTO")
	private Integer idEstablecimiento;
	
	@Column(name="NOMBRE", length=100, nullable=false)
	private String nombre;
	
	@Column(name="TEXTO",columnDefinition="text", nullable=false)
	private String texto;
	
	@Column(name="URL", length=100, nullable=true)
	private String url;
	
	@Column(name="GOOGLE_MAPS_URL", nullable=false)
	private String googleMapsUrl;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="ID_TIPO_ESTABLECIMIENTO")
	private TipoEstablecimiento tipoEstablecimiento;

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

	/**
	 * @return the tipoEstablecimiento
	 */
	public TipoEstablecimiento getTipoEstablecimiento() {
		return tipoEstablecimiento;
	}

	/**
	 * @param tipoEstablecimiento the tipoEstablecimiento to set
	 */
	public void setTipoEstablecimiento(TipoEstablecimiento tipoEstablecimiento) {
		this.tipoEstablecimiento = tipoEstablecimiento;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Establecimiento [idEstablecimiento=");
		builder.append(idEstablecimiento);
		builder.append(", nombre=");
		builder.append(nombre);
		builder.append(", texto=");
		builder.append(texto);
		builder.append(", url=");
		builder.append(url);
		builder.append(", googleMapsUrl=");
		builder.append(googleMapsUrl);
		builder.append(", tipoEstablecimiento=");
		builder.append(tipoEstablecimiento);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	
}
