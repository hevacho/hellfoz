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
public class ElementoMenuDto implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	private String descripcion;
	private String ruta;
	
	//indica si tiene submenus
	private boolean tieneHijos;
	private List<ElementoSubMenuDto> elementosSubmenu;
	
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
	 * @return the ruta
	 */
	public String getRuta() {
		return ruta;
	}
	/**
	 * @param ruta the ruta to set
	 */
	public void setRuta(String ruta) {
		this.ruta = ruta;
	}
	/**
	 * @return the tieneHijos
	 */
	public boolean isTieneHijos() {
		return tieneHijos;
	}
	/**
	 * @param tieneHijos the tieneHijos to set
	 */
	public void setTieneHijos(boolean tieneHijos) {
		this.tieneHijos = tieneHijos;
	}
	/**
	 * @return the elementosSubmenu
	 */
	public List<ElementoSubMenuDto> getElementosSubmenu() {
		return elementosSubmenu;
	}
	/**
	 * @param elementosSubmenu the elementosSubmenu to set
	 */
	public void setElementosSubmenu(List<ElementoSubMenuDto> elementosSubmenu) {
		this.elementosSubmenu = elementosSubmenu;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ElementoMenuDto [descripcion=");
		builder.append(descripcion);
		builder.append(", ruta=");
		builder.append(ruta);
		builder.append(", tieneHijos=");
		builder.append(tieneHijos);
		builder.append(", elementosSubmenu=");
		builder.append(elementosSubmenu);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	
}
