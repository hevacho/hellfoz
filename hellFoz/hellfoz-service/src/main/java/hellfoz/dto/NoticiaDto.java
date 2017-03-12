/**
 * 
 */
package hellfoz.dto;

import java.io.Serializable;

/**
 * @author hevacho
 *
 */
public class NoticiaDto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer idNoticia;
	private String titulo;
	private String texto;
	private String textoPeq;
	private String fecha;
	private ImagenDto fotoPeq;
	private ImagenDto fotoGrande;
	private String enlace;
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
	public String getFecha() {
		return fecha;
	}
	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(String fecha) {
		this.fecha = fecha;
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
	 * @return the fotoPeq
	 */
	public ImagenDto getFotoPeq() {
		return fotoPeq;
	}
	/**
	 * @param fotoPeq the fotoPeq to set
	 */
	public void setFotoPeq(ImagenDto fotoPeq) {
		this.fotoPeq = fotoPeq;
	}
	/**
	 * @return the fotoGrande
	 */
	public ImagenDto getFotoGrande() {
		return fotoGrande;
	}
	/**
	 * @param fotoGrande the fotoGrande to set
	 */
	public void setFotoGrande(ImagenDto fotoGrande) {
		this.fotoGrande = fotoGrande;
	}
	/**
	 * @return the textoPeq
	 */
	public String getTextoPeq() {
		return textoPeq;
	}
	/**
	 * @param textoPeq the textoPeq to set
	 */
	public void setTextoPeq(String textoPeq) {
		this.textoPeq = textoPeq;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("NoticiaDto [idNoticia=");
		builder.append(idNoticia);
		builder.append(", titulo=");
		builder.append(titulo);
		builder.append(", texto=");
		builder.append(texto);
		builder.append(", textoPeq=");
		builder.append(textoPeq);
		builder.append(", fecha=");
		builder.append(fecha);
		builder.append(", fotoPeq=");
		builder.append(fotoPeq);
		builder.append(", fotoGrande=");
		builder.append(fotoGrande);
		builder.append(", enlace=");
		builder.append(enlace);
		builder.append("]");
		return builder.toString();
	}
	
	
	

}
