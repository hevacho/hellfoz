/**
 * 
 */
package hellfoz.model.entities;

import java.io.Serializable;

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
@Table(name="TIPO_ESTABLECIMIENTO", schema="hellfoz")
public class TipoEstablecimiento implements Serializable{

	private static final long serialVersionUID = 7077594036104744511L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_TIPO_ESTABLECIMIENTO")
	private Integer idTipoEstablecimiento;
	
	@Column(name="DESCRIPCION",length=100, nullable=false)
	private String descricpion;

	/**
	 * @return the idTipoEstablecimiento
	 */
	public Integer getIdTipoEstablecimiento() {
		return idTipoEstablecimiento;
	}

	/**
	 * @param idTipoEstablecimiento the idTipoEstablecimiento to set
	 */
	public void setIdTipoEstablecimiento(Integer idTipoEstablecimiento) {
		this.idTipoEstablecimiento = idTipoEstablecimiento;
	}

	/**
	 * @return the descricpion
	 */
	public String getDescricpion() {
		return descricpion;
	}

	/**
	 * @param descricpion the descricpion to set
	 */
	public void setDescricpion(String descricpion) {
		this.descricpion = descricpion;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TipoEstablecimiento [idTipoEstablecimiento=");
		builder.append(idTipoEstablecimiento);
		builder.append(", descricpion=");
		builder.append(descricpion);
		builder.append("]");
		return builder.toString();
	}

	
	
	
}
