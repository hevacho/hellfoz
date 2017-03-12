/**
 * 
 */
package hellfoz.web;

import hellfoz.dto.FicheroDto;
import hellfoz.dto.ParametroVarioDto;
import hellfoz.dto.PersonaEntradaDto;
import hellfoz.dto.TarjetaDto;
import hellfoz.service.EntradasService;
import hellfoz.service.VariosService;

import java.io.IOException;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;
import org.primefaces.event.FlowEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import utiles.Constants;

import com.paypal.base.rest.PayPalRESTException;

/**
 * @author hevacho
 *
 */

@ManagedBean(name="entradasWizardBean")
@ViewScoped
public class EntradasWizardBean implements Serializable{

	private static final Logger LOG = LoggerFactory.getLogger(EntradasWizardBean.class);
	
	private static final long serialVersionUID = 1L;
	
	
	@ManagedProperty("#{VariosServiceImpl}")
	private transient VariosService variosService;
	
	@ManagedProperty("#{EntradasServiceImpl}")
	private transient EntradasService entradasService;
	
	
	private int numeroEntradas;
	private List<PersonaEntradaDto> personasEntradas;
	private String precio;
	private Double precioEuros;
	private String precioTotal;
	private boolean skip;
	private Integer numeroPedidoSalvado;
	private TarjetaDto tarjeta;
	
	
	@PostConstruct
	public void init(){
		numeroEntradas = 1;
		precioTotal = "0 EUR";
		skip = false;
		personasEntradas = new LinkedList<PersonaEntradaDto>();
		tarjeta = new TarjetaDto();
		inicializaPrecio();
	
	}
	
	private void inicializaPrecio(){
		ParametroVarioDto param = variosService.obtenerParametroClaveNow(Constants.CLAVE_PARAMETRO_PRECIO_ENTRADAS);
		precio = param.getValor()+" Euros";
		precioEuros = Double.parseDouble(param.getValor());
	}
	
	public String onFlowProcess(FlowEvent event) {
        if(skip) {
            skip = false;   //reset in case user goes back
            return "confirm";
        }
        else {
        	
        	//paso uno reseteamos los datos
        	if(event.getNewStep().equals("entradas")){
        		personasEntradas = new LinkedList<PersonaEntradaDto>();
        	}
        	
        	
        	//paso para introducir los emails y la direccion
        	if(event.getNewStep().equals("direcciones")){
        		if(personasEntradas.isEmpty()){
	        		for (int i = 0; i < numeroEntradas; i++) {
	        			personasEntradas.add(new PersonaEntradaDto());
					}
        		}
        	}
        	
        	
        	if(event.getNewStep().endsWith("confirmacionDatos")){
        		//guardamos los datos de la compra
        		numeroPedidoSalvado = entradasService.salvarPedidoInicial(personasEntradas);
        		precioTotal = numeroEntradas * precioEuros + " Euros";
        	}
        	
        	
            return event.getNewStep();
        }
    }

	//realizamos el pago y guardamos el pago en la BD asi como la respuesta de paypal por si hiciera falta
	public void save() throws IOException{
		FacesContext facesContext = FacesContext.getCurrentInstance();
		try{
			
			//habria que validar los datos de la tarjeta
			
			entradasService.realizarPedidoPaypal(tarjeta, numeroPedidoSalvado);
			FicheroDto entradas = entradasService.generarEntradasPedido(numeroPedidoSalvado);
						
			facesContext.getExternalContext().getSessionMap().put(Constants.ENTRADAS, entradas);
			facesContext.getExternalContext().redirect("imprimirEntrada.xhtml");
			
			
		}catch (PayPalRESTException e){
			RequestContext.getCurrentInstance().execute(
					"PF('statusDialog').hide();");
			RequestContext
			.getCurrentInstance()
			.showMessageInDialog(
					new FacesMessage(
							FacesMessage.SEVERITY_ERROR,
							"Error",
							UtilMessages.getMessage("entradas.ko")));
			LOG.error("Error paypal",e);
			
		}
	}

	


	/**
	 * @return the skip
	 */
	public boolean isSkip() {
		return skip;
	}



	/**
	 * @param skip the skip to set
	 */
	public void setSkip(boolean skip) {
		this.skip = skip;
	}


	/**
	 * @return the numeroEntradas
	 */
	public int getNumeroEntradas() {
		return numeroEntradas;
	}


	/**
	 * @param numeroEntradas the numeroEntradas to set
	 */
	public void setNumeroEntradas(int numeroEntradas) {
		this.numeroEntradas = numeroEntradas;
	}


	/**
	 * @return the personasEntradas
	 */
	public List<PersonaEntradaDto> getPersonasEntradas() {
		return personasEntradas;
	}


	/**
	 * @param personasEntradas the personasEntradas to set
	 */
	public void setPersonasEntradas(List<PersonaEntradaDto> personasEntradas) {
		this.personasEntradas = personasEntradas;
	}


	/**
	 * @return the precio
	 */
	public String getPrecio() {
		return precio;
	}

	/**
	 * @param variosService the variosService to set
	 */
	public void setVariosService(VariosService variosService) {
		this.variosService = variosService;
	}

	/**
	 * @return the precioTotal
	 */
	public String getPrecioTotal() {
		return precioTotal;
	}

	/**
	 * @param entradasService the entradasService to set
	 */
	public void setEntradasService(EntradasService entradasService) {
		this.entradasService = entradasService;
	}

	/**
	 * @return the tarjeta
	 */
	public TarjetaDto getTarjeta() {
		return tarjeta;
	}

	/**
	 * @param tarjeta the tarjeta to set
	 */
	public void setTarjeta(TarjetaDto tarjeta) {
		this.tarjeta = tarjeta;
	}

	
	
	

}
