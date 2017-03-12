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
public class EstablecimientosTotal implements Serializable {


	private static final long serialVersionUID = 764551984151111779L;
	List<EstablecimientoDto> hoteles;
	List<EstablecimientoDto> bares;
	List<EstablecimientoDto> supermercados;
	List<EstablecimientoDto> tiendas;
	/**
	 * @return the bares
	 */
	public List<EstablecimientoDto> getBares() {
		return bares;
	}
	/**
	 * @param bares the bares to set
	 */
	public void setBares(List<EstablecimientoDto> bares) {
		this.bares = bares;
	}
	/**
	 * @return the supermercados
	 */
	public List<EstablecimientoDto> getSupermercados() {
		return supermercados;
	}
	/**
	 * @param supermercados the supermercados to set
	 */
	public void setSupermercados(List<EstablecimientoDto> supermercados) {
		this.supermercados = supermercados;
	}
	/**
	 * @return the tiendas
	 */
	public List<EstablecimientoDto> getTiendas() {
		return tiendas;
	}
	/**
	 * @param tiendas the tiendas to set
	 */
	public void setTiendas(List<EstablecimientoDto> tiendas) {
		this.tiendas = tiendas;
	}
	
	
	/**
	 * @return the hoteles
	 */
	public List<EstablecimientoDto> getHoteles() {
		return hoteles;
	}
	/**
	 * @param hoteles the hoteles to set
	 */
	public void setHoteles(List<EstablecimientoDto> hoteles) {
		this.hoteles = hoteles;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("EstablecimientosTotal [hoteles=");
		builder.append(hoteles);
		builder.append(", bares=");
		builder.append(bares);
		builder.append(", supermercados=");
		builder.append(supermercados);
		builder.append(", tiendas=");
		builder.append(tiendas);
		builder.append("]");
		return builder.toString();
	}
	
	
}
