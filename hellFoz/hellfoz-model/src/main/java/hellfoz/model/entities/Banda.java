/**
 * 
 */
package hellfoz.model.entities;

import java.io.Serializable;
import java.util.Arrays;

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
@Table(name="BANDA", schema="hellfoz")
public class Banda implements Serializable{
	
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_BANDA")
	private Integer idBanda;
	
	@Column(name="FOTO", columnDefinition="mediumblob", nullable=true)
	private byte[] foto;
	
	@Column(name="NOMBRE", length=100, nullable=false)
	private String nombre;
	
	@Column(name="TEXTO", columnDefinition="TEXT", nullable=false)
	private String texto;
	
	@Column(name="URL", nullable=true)
	private String url;
	
	@Column(name="ORDEN", nullable=true)
	private Integer orden;

	/**
	 * @return the idBanda
	 */
	public Integer getIdBanda() {
		return idBanda;
	}

	/**
	 * @param idBanda the idBanda to set
	 */
	public void setIdBanda(Integer idBanda) {
		this.idBanda = idBanda;
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

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * @return the orden
	 */
	public Integer getOrden() {
		return orden;
	}

	/**
	 * @param orden the orden to set
	 */
	public void setOrden(Integer orden) {
		this.orden = orden;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Banda [idBanda=");
		builder.append(idBanda);
		builder.append(", foto=");
		builder.append(Arrays.toString(foto));
		builder.append(", nombre=");
		builder.append(nombre);
		builder.append(", texto=");
		builder.append(texto);
		builder.append(", url=");
		builder.append(url);
		builder.append(", orden=");
		builder.append(orden);
		builder.append("]");
		return builder.toString();
	}
	
	
	

}
