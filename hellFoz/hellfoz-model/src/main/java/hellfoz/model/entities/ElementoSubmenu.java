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
import javax.persistence.Table;

/**
 * @author hevacho
 *
 */
@Entity
@Table(name="ELEMENTO_SUBMENU", schema="hellfoz")
public class ElementoSubmenu {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_ELEMENTO_SUBMENU")
	private Integer idElementoSubmenu;
	
	@Column(name="DESCRIPCION", nullable=false, length=50)
	private String descripcion;
	
	@Column(name="DIRECCION", nullable=false, length=50)
	private String direccion;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="ID_ELEMENTO_MENU")
	private ElementoMenu elementoMenu;
	
	@Column(name="ACTIVO", nullable=false)
	private Boolean activo;

	/**
	 * @return the idElementoSubmenu
	 */
	public Integer getIdElementoSubmenu() {
		return idElementoSubmenu;
	}

	/**
	 * @param idElementoSubmenu the idElementoSubmenu to set
	 */
	public void setIdElementoSubmenu(Integer idElementoSubmenu) {
		this.idElementoSubmenu = idElementoSubmenu;
	}

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
	 * @return the direccion
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * @param direccion the direccion to set
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	/**
	 * @return the elementoMenu
	 */
	public ElementoMenu getElementoMenu() {
		return elementoMenu;
	}

	/**
	 * @param elementoMenu the elementoMenu to set
	 */
	public void setElementoMenu(ElementoMenu elementoMenu) {
		this.elementoMenu = elementoMenu;
	}

	
	/**
	 * @return the activo
	 */
	public Boolean getActivo() {
		return activo;
	}

	/**
	 * @param activo the activo to set
	 */
	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ElementoSubmenu [idElementoSubmenu=");
		builder.append(idElementoSubmenu);
		builder.append(", descripcion=");
		builder.append(descripcion);
		builder.append(", direccion=");
		builder.append(direccion);
		builder.append(", elementoMenu=");
		builder.append(elementoMenu);
		builder.append(", activo=");
		builder.append(activo);
		builder.append("]");
		return builder.toString();
	}
	
	

}
