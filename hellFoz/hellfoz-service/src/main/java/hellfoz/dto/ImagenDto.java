/**
 * 
 */
package hellfoz.dto;

import java.io.Serializable;

/**
 * @author hevacho
 *
 */
public class ImagenDto implements Serializable {

	
	private static final long serialVersionUID = 3247729226795246680L;
	private int idImagen;
	private byte[] foto;
	private String descripcion;
	
	/**
	 * @return the idImagenInicio
	 */
	public int getIdImagen() {
		return idImagen;
	}
	/**
	 * @param idImagenInicio the idImagenInicio to set
	 */
	public void setIdImagen(int idImagenInicio) {
		this.idImagen = idImagenInicio;
	}
	/**
	 * @return the foto
	 */
	public byte[] getFoto() {
		return foto;
	}
	/**
	 * @param foto the foto to set
	 */
	public void setFoto(byte[] foto) {
		this.foto = foto;
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
	
	
	
}
