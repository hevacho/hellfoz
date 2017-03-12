/**
 * 
 */
package hellfoz.dto;

import java.io.Serializable;

/**
 * @author hevacho
 *
 */
public class TarjetaDto implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	private String tipoTarjeta;
	private Integer cvv;
	private Integer anhoExpiracion;
	private Integer mesExpiracion;
	private String nombre;
	private String apellidos;
	private Long numero;
	/**
	 * @return the tipoTarjeta
	 */
	public String getTipoTarjeta() {
		return tipoTarjeta;
	}
	/**
	 * @param tipoTarjeta the tipoTarjeta to set
	 */
	public void setTipoTarjeta(String tipoTarjeta) {
		this.tipoTarjeta = tipoTarjeta;
	}
	/**
	 * @return the cvv
	 */
	public Integer getCvv() {
		return cvv;
	}
	/**
	 * @param cvv the cvv to set
	 */
	public void setCvv(Integer cvv) {
		this.cvv = cvv;
	}
	/**
	 * @return the anhoExpiracion
	 */
	public Integer getAnhoExpiracion() {
		return anhoExpiracion;
	}
	/**
	 * @param anhoExpiracion the anhoExpiracion to set
	 */
	public void setAnhoExpiracion(Integer anhoExpiracion) {
		this.anhoExpiracion = anhoExpiracion;
	}
	/**
	 * @return the mesExpiracion
	 */
	public Integer getMesExpiracion() {
		return mesExpiracion;
	}
	/**
	 * @param mesExpiracion the mesExpiracion to set
	 */
	public void setMesExpiracion(Integer mesExpiracion) {
		this.mesExpiracion = mesExpiracion;
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
	 * @return the apellidos
	 */
	public String getApellidos() {
		return apellidos;
	}
	/**
	 * @param apellidos the apellidos to set
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	/**
	 * @return the numero
	 */
	public Long getNumero() {
		return numero;
	}
	/**
	 * @param numero the numero to set
	 */
	public void setNumero(Long numero) {
		this.numero = numero;
	}
	
	
}
