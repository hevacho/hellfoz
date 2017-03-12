/**
 * 
 */
package hellfoz.model.entities;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author hevacho
 *
 */
@Entity
@Table(name="FICHERO_VARIOS", schema="hellfoz")
public class FicheroVario implements Serializable{
	
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_FICHEROS_VARIOS")
	private Integer idFicheroVarios;
	
	@Column(name="DESCRIPCION", length=100, nullable=false)
	private String descripcion;
	
	@Column(name="FICHERO", columnDefinition="longblob", nullable=false)
	private byte[] fichero;
	
	@Column(name="MIME_TYPE", length=100, nullable=false)
	private String mimeType;
	
	@Column(name="NOMBRE_FICHERO", length=100, nullable=false)
	private String nombreFichero;
	
	@Column(name="CLAVE", length=100, nullable=false)
	private String clave;
	
	@Column(name="FECHA_DESDE")
	private Date fechaDesde;
	
	@Column(name="FECHA_HASTA")
	private Date fechaHasta;
	
	
	
	
	/**
	 * @return the idFicheroVarios
	 */
	public Integer getIdFicheroVarios() {
		return idFicheroVarios;
	}



	/**
	 * @param idFicheroVarios the idFicheroVarios to set
	 */
	public void setIdFicheroVarios(Integer idFicheroVarios) {
		this.idFicheroVarios = idFicheroVarios;
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
	 * @return the fichero
	 */
	public byte[] getFichero() {
		return fichero;
	}



	/**
	 * @param fichero the fichero to set
	 */
	public void setFichero(byte[] fichero) {
		this.fichero = fichero;
	}



	/**
	 * @return the mimeType
	 */
	public String getMimeType() {
		return mimeType;
	}



	/**
	 * @param mimeType the mimeType to set
	 */
	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}



	/**
	 * @return the nombreFichero
	 */
	public String getNombreFichero() {
		return nombreFichero;
	}



	/**
	 * @param nombreFichero the nombreFichero to set
	 */
	public void setNombreFichero(String nombreFichero) {
		this.nombreFichero = nombreFichero;
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
	 * @return the fechaDesde
	 */
	public Date getFechaDesde() {
		return fechaDesde;
	}



	/**
	 * @param fechaDesde the fechaDesde to set
	 */
	public void setFechaDesde(Date fechaDesde) {
		this.fechaDesde = fechaDesde;
	}



	/**
	 * @return the fechaHasta
	 */
	public Date getFechaHasta() {
		return fechaHasta;
	}



	/**
	 * @param fechaHasta the fechaHasta to set
	 */
	public void setFechaHasta(Date fechaHasta) {
		this.fechaHasta = fechaHasta;
	}



	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FicheroVario [idFicheroVarios=");
		builder.append(idFicheroVarios);
		builder.append(", descripcion=");
		builder.append(descripcion);
		builder.append(", fichero=");
		builder.append(Arrays.toString(fichero));
		builder.append(", mimeType=");
		builder.append(mimeType);
		builder.append(", nombreFichero=");
		builder.append(nombreFichero);
		builder.append(", clave=");
		builder.append(clave);
		builder.append(", fechaDesde=");
		builder.append(fechaDesde);
		builder.append(", fechaHasta=");
		builder.append(fechaHasta);
		builder.append("]");
		return builder.toString();
	}
	
	

}
