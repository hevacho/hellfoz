/**
 * 
 */
package hellfoz.model.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author hevacho
 *
 */
@Entity
@Table(name="PEDIDO", schema="hellfoz")
public class Pedido implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_PEDIDO")
	private Integer idPedido;
	
	@Column(name="FECHA_ALTA", nullable=false)
	private Date fechaAlta;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="ID_ESTADO")
	private Estado estado;
	
	@Column(name="JSON_PAYPAL", nullable=true, columnDefinition="MEDIUMTEXT")
	private String jsonPaypal;
	
	@Column(name="FECHA_ENVIO", nullable=true)
	private Date fechaEnvio;
	
	@Column(name="PRECIO_TOTAL", nullable=true, columnDefinition="DECIMAL(5,2)")
	private Double precioTotal;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="pedido")
	private List<Persona> personas;

	/**
	 * @return the idPedido
	 */
	public Integer getIdPedido() {
		return idPedido;
	}

	/**
	 * @param idPedido the idPedido to set
	 */
	public void setIdPedido(Integer idPedido) {
		this.idPedido = idPedido;
	}

	/**
	 * @return the fechaAlta
	 */
	public Date getFechaAlta() {
		return fechaAlta;
	}

	/**
	 * @param fechaAlta the fechaAlta to set
	 */
	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	/**
	 * @return the estado
	 */
	public Estado getEstado() {
		return estado;
	}

	/**
	 * @param estado the estado to set
	 */
	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	/**
	 * @return the jsonPaypal
	 */
	public String getJsonPaypal() {
		return jsonPaypal;
	}

	/**
	 * @param jsonPaypal the jsonPaypal to set
	 */
	public void setJsonPaypal(String jsonPaypal) {
		this.jsonPaypal = jsonPaypal;
	}

	/**
	 * @return the fechaEnvio
	 */
	public Date getFechaEnvio() {
		return fechaEnvio;
	}

	/**
	 * @param fechaEnvio the fechaEnvio to set
	 */
	public void setFechaEnvio(Date fechaEnvio) {
		this.fechaEnvio = fechaEnvio;
	}

	/**
	 * @return the personas
	 */
	public List<Persona> getPersonas() {
		return personas;
	}

	/**
	 * @param personas the personas to set
	 */
	public void setPersonas(List<Persona> personas) {
		this.personas = personas;
	}

	/**
	 * @return the precioTotal
	 */
	public Double getPrecioTotal() {
		return precioTotal;
	}

	/**
	 * @param precioTotal the precioTotal to set
	 */
	public void setPrecioTotal(Double precioTotal) {
		this.precioTotal = precioTotal;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Pedido [idPedido=");
		builder.append(idPedido);
		builder.append(", fechaAlta=");
		builder.append(fechaAlta);
		builder.append(", estado=");
		builder.append(estado);
		builder.append(", jsonPaypal=");
		builder.append(jsonPaypal);
		builder.append(", fechaEnvio=");
		builder.append(fechaEnvio);
		builder.append(", precioTotal=");
		builder.append(precioTotal);
		builder.append(", personas=");
		builder.append(personas);
		builder.append("]");
		return builder.toString();
	}

	

	
	
	
}
