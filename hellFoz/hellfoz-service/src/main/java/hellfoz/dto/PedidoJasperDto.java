/**
 * 
 */
package hellfoz.dto;

import java.util.ArrayList;
import java.util.List;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 * @author hevacho
 *
 */
public class PedidoJasperDto {

	private int nPedido;
	private String fecha;
	private String precioTotal;
	private List entradas = new ArrayList();

	public PedidoJasperDto() {
	}

	public void addEntrada(EntradaJasperDto materia) {
		this.entradas.add(materia);
	}

	public JRDataSource getEntradasDS() {
		return new JRBeanCollectionDataSource(entradas);
	}

	/**
	 * @return the entradas
	 */
	public List getEntradas() {
		return entradas;
	}

	/**
	 * @param entradas
	 *            the entradas to set
	 */
	public void setEntradas(List entradas) {
		this.entradas = entradas;
	}

	/**
	 * @return the nPedido
	 */
	public int getnPedido() {
		return nPedido;
	}

	/**
	 * @param nPedido
	 *            the nPedido to set
	 */
	public void setnPedido(int nPedido) {
		this.nPedido = nPedido;
	}

	/**
	 * @return the fecha
	 */
	public String getFecha() {
		return fecha;
	}

	/**
	 * @param fecha
	 *            the fecha to set
	 */
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	/**
	 * @return the precioTotal
	 */
	public String getPrecioTotal() {
		return precioTotal;
	}

	/**
	 * @param precioTotal
	 *            the precioTotal to set
	 */
	public void setPrecioTotal(String precioTotal) {
		this.precioTotal = precioTotal;
	}
}
