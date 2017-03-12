/**
 * 
 */
package hellfoz.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author hevacho
 *
 */
@Entity
@Table(name="PERSONA", schema="hellfoz")
public class Persona {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_PERSONA")
	private Integer idPersona;
	
	@Column(name="NIF", nullable=false)
	private String nif;
	
	@Column(name="EMAIL", nullable=false)
	private String email;
	
	@Column(name="NOMBRE", nullable=false)
	private String nombre;
	
	@Column(name="APELLIDOS", nullable=false)
	private String apellidos;
		
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="ID_PEDIDO")
	private Pedido pedido;
	
	@OneToOne(fetch=FetchType.LAZY, mappedBy="persona")
	private Entrada entrada;

	/**
	 * @return the idPersona
	 */
	public Integer getIdPersona() {
		return idPersona;
	}

	/**
	 * @param idPersona the idPersona to set
	 */
	public void setIdPersona(Integer idPersona) {
		this.idPersona = idPersona;
	}

	/**
	 * @return the nif
	 */
	public String getNif() {
		return nif;
	}

	/**
	 * @param nif the nif to set
	 */
	public void setNif(String nif) {
		this.nif = nif;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the pedido
	 */
	public Pedido getPedido() {
		return pedido;
	}

	/**
	 * @param pedido the pedido to set
	 */
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	
	/**
	 * @return the entrada
	 */
	public Entrada getEntrada() {
		return entrada;
	}

	/**
	 * @param entrada the entrada to set
	 */
	public void setEntrada(Entrada entrada) {
		this.entrada = entrada;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Persona [idPersona=");
		builder.append(idPersona);
		builder.append(", nif=");
		builder.append(nif);
		builder.append(", email=");
		builder.append(email);
		builder.append(", nombre=");
		builder.append(nombre);
		builder.append(", apellidos=");
		builder.append(apellidos);
		builder.append(", pedido=");
		builder.append(pedido);
		builder.append(", entrada=");
		builder.append(entrada);
		builder.append("]");
		return builder.toString();
	}
	
	

}
