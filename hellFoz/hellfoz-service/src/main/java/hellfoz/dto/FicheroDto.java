/**
 * 
 */
package hellfoz.dto;

import java.io.Serializable;
import java.util.Arrays;

/**
 * @author hevacho
 *
 */
public class FicheroDto implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idFicheroVarios;
	private String descripcion;
	private byte[] fichero;
	private String mimeType;
	private String nombreFichero;
	private String clave;
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
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FicheroDto [idFicheroVarios=");
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
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
