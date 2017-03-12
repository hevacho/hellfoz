/**
 * 
 */
package hellfoz.dto;

import java.io.Serializable;
import java.util.List;

/**
 * @author hevacho
 *
 */
public class NoticiasPagina implements Serializable {
	
	
	private static final long serialVersionUID = 7357863000089961813L;
	
	List<NoticiaDto> noticias;
	int total;
	/**
	 * @return the noticias
	 */
	public List<NoticiaDto> getNoticias() {
		return noticias;
	}
	/**
	 * @param noticias the noticias to set
	 */
	public void setNoticias(List<NoticiaDto> noticias) {
		this.noticias = noticias;
	}
	/**
	 * @return the total
	 */
	public int getTotal() {
		return total;
	}
	/**
	 * @param total the total to set
	 */
	public void setTotal(int total) {
		this.total = total;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("NoticiasPagina [noticias=");
		builder.append(noticias);
		builder.append(", total=");
		builder.append(total);
		builder.append("]");
		return builder.toString();
	}

	
}
