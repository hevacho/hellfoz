/**
 * 
 */
package hellfoz.model.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

/**
 * @author hevacho
 *
 */
@Entity
@Table(name="EVENTO", schema="hellfoz")
public class Evento {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_EVENTO")
	private Integer idEvento;
	
	@Column(name="CIUDAD", length=100, nullable=false)
	private String ciudad;
	
	@Column(name="FECHA_EVENTO", nullable=false)
	private Date fechaEvento;
	
	@Column(name="TITULO", nullable=false)
	private String titulo;
	
	@Lob
	@Column(columnDefinition="TEXT")
	private String texto;
	

	/**
	 * @return the idEvento
	 */
	public Integer getIdEvento() {
		return idEvento;
	}

	/**
	 * @param idEvento the idEvento to set
	 */
	public void setIdEvento(Integer idEvento) {
		this.idEvento = idEvento;
	}

	/**
	 * @return the ciudad
	 */
	public String getCiudad() {
		return ciudad;
	}

	/**
	 * @param ciudad the ciudad to set
	 */
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	/**
	 * @return the fechaEvento
	 */
	public Date getFechaEvento() {
		return fechaEvento;
	}

	/**
	 * @param fechaEvento the fechaEvento to set
	 */
	public void setFechaEvento(Date fechaEvento) {
		this.fechaEvento = fechaEvento;
	}

	/**
	 * @return the titulo
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * @param titulo the titulo to set
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	/**
	 * @return the texto
	 */
	public String getTexto() {
		return texto;
	}

	/**
	 * @param texto the texto to set
	 */
	public void setTexto(String texto) {
		this.texto = texto;
	}

	

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Evento [idEvento=");
		builder.append(idEvento);
		builder.append(", ciudad=");
		builder.append(ciudad);
		builder.append(", fechaEvento=");
		builder.append(fechaEvento);
		builder.append(", titulo=");
		builder.append(titulo);
		builder.append(", texto=");
		builder.append(texto);
		builder.append("]");
		return builder.toString();
	}
	
	

}
