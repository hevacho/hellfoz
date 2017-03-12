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
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author hevacho
 *
 */
@Entity
@Table(name="ENTRADA", schema="hellfoz")
public class Entrada implements Serializable {
	

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_ENTRADA")
	private Integer idEntrada;
	
	@Column(name="NUMERO", nullable=false)
	private String numero;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ID_PERSONA")
	private Persona persona;

	/**
	 * @return the idEntrada
	 */
	public Integer getIdEntrada() {
		return idEntrada;
	}

	/**
	 * @param idEntrada the idEntrada to set
	 */
	public void setIdEntrada(Integer idEntrada) {
		this.idEntrada = idEntrada;
	}

	/**
	 * @return the numero
	 */
	public String getNumero() {
		return numero;
	}

	/**
	 * @param numero the numero to set
	 */
	public void setNumero(String numero) {
		this.numero = numero;
	}

	/**
	 * @return the persona
	 */
	public Persona getPersona() {
		return persona;
	}

	/**
	 * @param persona the persona to set
	 */
	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Entrada [idEntrada=");
		builder.append(idEntrada);
		builder.append(", numero=");
		builder.append(numero);
		builder.append(", persona=");
		builder.append(persona);
		builder.append("]");
		return builder.toString();
	}
	
	
	 
	 

}
