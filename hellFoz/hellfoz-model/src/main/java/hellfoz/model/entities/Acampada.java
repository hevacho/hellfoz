/**
 * 
 */
package hellfoz.model.entities;

import java.io.Serializable;
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
@Table(name="ACAMPADA", schema="hellfoz")
public class Acampada implements Serializable {
	
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_ACAMPADA")
	private Integer idAcampada;
	
	@Column(name="NOMBRE", nullable=false, length=50)
	private String nombre;
	
	@Column(name="APELLIDO1", nullable=false, length=50)
	private String apellido1;
	
	@Column(name="APELLIDO2", nullable=false, length=50)
	private String apellido2;
	
	@Column(name="EMAIL", nullable=false, length=50)
	private String email;
	
	@Column(name="NUMERO_PERSONAS", nullable=false)
	private Integer numeroPersonas;
	
	@Column(name="FECHA_HORA_ENVIO")
	private Date fechaHoraEnvio;
	
	@Column(name="FECHA_HORA_ALTA")
	private Date fechaHoraAlta;

	/**
	 * @return the idAcampada
	 */
	public Integer getIdAcampada() {
		return idAcampada;
	}

	/**
	 * @param idAcampada the idAcampada to set
	 */
	public void setIdAcampada(Integer idAcampada) {
		this.idAcampada = idAcampada;
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
	 * @return the apellido1
	 */
	public String getApellido1() {
		return apellido1;
	}

	/**
	 * @param apellido1 the apellido1 to set
	 */
	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	/**
	 * @return the apellido2
	 */
	public String getApellido2() {
		return apellido2;
	}

	/**
	 * @param apellido2 the apellido2 to set
	 */
	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
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
	 * @return the fechaHoraEnvio
	 */
	public Date getFechaHoraEnvio() {
		return fechaHoraEnvio;
	}

	/**
	 * @param fechaHoraEnvio the fechaHoraEnvio to set
	 */
	public void setFechaHoraEnvio(Date fechaHoraEnvio) {
		this.fechaHoraEnvio = fechaHoraEnvio;
	}

	/**
	 * @return the fechaHoraAlta
	 */
	public Date getFechaHoraAlta() {
		return fechaHoraAlta;
	}

	/**
	 * @param fechaHoraAlta the fechaHoraAlta to set
	 */
	public void setFechaHoraAlta(Date fechaHoraAlta) {
		this.fechaHoraAlta = fechaHoraAlta;
	}

	/**
	 * @return the numeroPersonas
	 */
	public Integer getNumeroPersonas() {
		return numeroPersonas;
	}

	/**
	 * @param numeroPersonas the numeroPersonas to set
	 */
	public void setNumeroPersonas(Integer numeroPersonas) {
		this.numeroPersonas = numeroPersonas;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Acampada [idAcampada=");
		builder.append(idAcampada);
		builder.append(", nombre=");
		builder.append(nombre);
		builder.append(", apellido1=");
		builder.append(apellido1);
		builder.append(", apellido2=");
		builder.append(apellido2);
		builder.append(", email=");
		builder.append(email);
		builder.append(", numeroPersonas=");
		builder.append(numeroPersonas);
		builder.append(", fechaHoraEnvio=");
		builder.append(fechaHoraEnvio);
		builder.append(", fechaHoraAlta=");
		builder.append(fechaHoraAlta);
		builder.append("]");
		return builder.toString();
	}

	
	
	
	
}
