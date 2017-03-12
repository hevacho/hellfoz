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
@Table(name="ESTADO", schema="hellfoz")
public class Estado implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_ESTADO")
	private Integer idEstado;
	
	@Column(name="DESCRIPCION", nullable=false)
	private String descripcion;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="estado")
	private List<Pedido> pedidos;

	/**
	 * @return the idEstado
	 */
	public Integer getIdEstado() {
		return idEstado;
	}

	/**
	 * @param idEstado the idEstado to set
	 */
	public void setIdEstado(Integer idEstado) {
		this.idEstado = idEstado;
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
	 * @return the pedidos
	 */
	public List<Pedido> getPedidos() {
		return pedidos;
	}

	/**
	 * @param pedidos the pedidos to set
	 */
	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Estado [idEstado=");
		builder.append(idEstado);
		builder.append(", descripcion=");
		builder.append(descripcion);
		builder.append(", pedidos=");
		builder.append(pedidos);
		builder.append("]");
		return builder.toString();
	}
	
	
}
