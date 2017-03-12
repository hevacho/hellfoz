/**
 * 
 */
package hellfoz.dto;

import java.io.Serializable;

/**
 * @author hevacho
 *
 */
public class BandaDto implements Serializable {

	
	private static final long serialVersionUID = 1L;
	private Integer idBanda;
	private ImagenDto foto;
	private String nombre;
	private String texto;
	private String url;
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
	/**
	 * @return the foto
	 */
	public ImagenDto getFoto() {
		return foto;
	}
	/**
	 * @param foto the foto to set
	 */
	public void setFoto(ImagenDto foto) {
		this.foto = foto;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BandaDto [idBanda=");
		builder.append(idBanda);
		builder.append(", foto=");
		builder.append(foto);
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
