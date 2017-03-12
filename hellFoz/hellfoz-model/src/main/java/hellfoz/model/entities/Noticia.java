/**
 * 
 */
package hellfoz.model.entities;

import java.io.Serializable;
import java.util.Arrays;
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
@Table(name="NOTICIA", schema="hellfoz")
public class Noticia implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_NOTICIA")
	private Integer idNoticia;
	
	@Column(name="TITULO", length=100, nullable=false)
	private String titulo;
	
	@Lob
	@Column(name="TEXTO", columnDefinition="TEXT", nullable=false)
	private String texto;
	
	@Column(name="FECHA", nullable=false)
	private Date fecha;
	
	@Column(name="FOTO_PEQ", columnDefinition="blob", nullable=true)
	private byte[] fotoPeq;
	
	@Column(name="FOTO_GRANDE", columnDefinition="longblob", nullable=true)
	private byte[] fotoGrande;
	
	@Column(name="ENLACE", nullable=true)
	private String enlace;
	
	@Column(name="INTRO", length=150, nullable=false)
	private String intro;
	

	/**
	 * @return the idNoticia
	 */
	public Integer getIdNoticia() {
		return idNoticia;
	}

	/**
	 * @param idNoticia the idNoticia to set
	 */
	public void setIdNoticia(Integer idNoticia) {
		this.idNoticia = idNoticia;
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

	/**
	 * @return the fecha
	 */
	public Date getFecha() {
		return fecha;
	}

	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	/**
	 * @return the fotoPeq
	 */
	public byte[] getFotoPeq() {
		return fotoPeq;
	}

	/**
	 * @param fotoPeq the fotoPeq to set
	 */
	public void setFotoPeq(byte[] fotoPeq) {
		this.fotoPeq = fotoPeq;
	}

	/**
	 * @return the fotoGrande
	 */
	public byte[] getFotoGrande() {
		return fotoGrande;
	}

	/**
	 * @param fotoGrande the fotoGrande to set
	 */
	public void setFotoGrande(byte[] fotoGrande) {
		this.fotoGrande = fotoGrande;
	}

	/**
	 * @return the enlace
	 */
	public String getEnlace() {
		return enlace;
	}

	/**
	 * @param enlace the enlace to set
	 */
	public void setEnlace(String enlace) {
		this.enlace = enlace;
	}

	/**
	 * @return the intro
	 */
	public String getIntro() {
		return intro;
	}

	/**
	 * @param intro the intro to set
	 */
	public void setIntro(String intro) {
		this.intro = intro;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Noticia [idNoticia=");
		builder.append(idNoticia);
		builder.append(", titulo=");
		builder.append(titulo);
		builder.append(", texto=");
		builder.append(texto);
		builder.append(", intro=");
		builder.append(intro);
		builder.append(", fecha=");
		builder.append(fecha);
		builder.append(", fotoPeq=");
		builder.append(Arrays.toString(fotoPeq));
		builder.append(", fotoGrande=");
		builder.append(Arrays.toString(fotoGrande));
		builder.append(", enlace=");
		builder.append(enlace);
		builder.append("]");
		return builder.toString();
	}

	

	
	
	
}
