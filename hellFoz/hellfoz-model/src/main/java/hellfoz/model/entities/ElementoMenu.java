/**
 * 
 */
package hellfoz.model.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author hevacho
 *
 */
@Entity
@Table(name="ELEMENTO_MENU", schema="hellfoz")
public class ElementoMenu implements Serializable {
	
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_ELEMENTO_MENU")
	private Integer idElementoMenu;
	
	@Column(name="DESCRIPCION", length=100, nullable=false)
	private String descripcion;
	
	@Column(name="ACTIVO", nullable=false)
	private Boolean activo;
	
	@Column(name="ORDEN", nullable=false)
	private Integer orden;
	
	@Column(name="DIRECCION", length=50, nullable=true)
	private String direccion;
	
	@OneToMany(fetch=FetchType.EAGER, mappedBy="elementoMenu")
	private List<ElementoSubmenu> elementosSubmenu;

	/**
	 * @return the idElementoMenu
	 */
	public Integer getIdElementoMenu() {
		return idElementoMenu;
	}

	/**
	 * @param idElementoMenu the idElementoMenu to set
	 */
	public void setIdElementoMenu(Integer idElementoMenu) {
		this.idElementoMenu = idElementoMenu;
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
	 * @return the elementosSubmenu
	 */
	public List<ElementoSubmenu> getElementosSubmenu() {
		return elementosSubmenu;
	}

	/**
	 * @param elementosSubmenu the elementosSubmenu to set
	 */
	public void setElementosSubmenu(List<ElementoSubmenu> elementosSubmenu) {
		this.elementosSubmenu = elementosSubmenu;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ElementoMenu [idElementoMenu=");
		builder.append(idElementoMenu);
		builder.append(", descripcion=");
		builder.append(descripcion);
		builder.append(", activo=");
		builder.append(activo);
		builder.append(", orden=");
		builder.append(orden);
		builder.append(", direccion=");
		builder.append(direccion);
		builder.append(", elementosSubmenu=");
		builder.append(elementosSubmenu);
		builder.append("]");
		return builder.toString();
	}
	
	
	

}
