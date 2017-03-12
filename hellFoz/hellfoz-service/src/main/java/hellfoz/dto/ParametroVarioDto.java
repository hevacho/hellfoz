/**
 * 
 */
package hellfoz.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * @author hevacho
 *
 */
public class ParametroVarioDto implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	
	private Integer idParametrosVarios;
	private String descripcion;
	private String valor;
	private String clave;
	private Date fechaDesde;
	private Date fechaHasta;
	/**
	 * @return the idParametrosVarios
	 */
	public Integer getIdParametrosVarios() {
		return idParametrosVarios;
	}
	/**
	 * @param idParametrosVarios the idParametrosVarios to set
	 */
	public void setIdParametrosVarios(Integer idParametrosVarios) {
		this.idParametrosVarios = idParametrosVarios;
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
	 * @return the valor
	 */
	public String getValor() {
		return valor;
	}
	/**
	 * @param valor the valor to set
	 */
	public void setValor(String valor) {
		this.valor = valor;
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
		builder.append("ParametroVarioDto [idParametrosVarios=");
		builder.append(idParametrosVarios);
		builder.append(", descripcion=");
		builder.append(descripcion);
		builder.append(", valor=");
		builder.append(valor);
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
