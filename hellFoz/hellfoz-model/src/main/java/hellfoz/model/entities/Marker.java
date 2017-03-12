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
@Table(name="marker", schema="hellfoz")
public class Marker implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_MARKER")
	private Integer idMarker;
	
	@Column(name="TEXTO", length=100)
	private String texto;
	
	@Column(name="LATITUD", columnDefinition="Decimal(10,7)")
	private Double latitud;
	
	@Column(name="LONGITUD", columnDefinition="Decimal(10,7)")
	private Double longitud;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="ID_MAPA")
	private Mapa mapa;

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
	 * @return the mapa
	 */
	public Mapa getMapa() {
		return mapa;
	}

	/**
	 * @param mapa the mapa to set
	 */
	public void setMapa(Mapa mapa) {
		this.mapa = mapa;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Marker [idMarker=");
		builder.append(idMarker);
		builder.append(", texto=");
		builder.append(texto);
		builder.append(", latitud=");
		builder.append(latitud);
		builder.append(", longitud=");
		builder.append(longitud);
		builder.append(", mapa=");
		builder.append(mapa);
		builder.append("]");
		return builder.toString();
	}
	
	

}
