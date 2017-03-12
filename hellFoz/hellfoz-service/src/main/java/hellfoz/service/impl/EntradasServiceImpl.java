/**
 * 
 */
package hellfoz.service.impl;

import hellfoz.dto.EntradaJasperDto;
import hellfoz.dto.FicheroDto;
import hellfoz.dto.PedidoJasperDto;
import hellfoz.dto.PersonaEntradaDto;
import hellfoz.dto.TarjetaDto;
import hellfoz.model.dao.EntradaDao;
import hellfoz.model.dao.ParametroVarioDao;
import hellfoz.model.dao.PedidoDao;
import hellfoz.model.dao.PersonaDao;
import hellfoz.model.entities.Entrada;
import hellfoz.model.entities.Estado;
import hellfoz.model.entities.ParametroVario;
import hellfoz.model.entities.Pedido;
import hellfoz.model.entities.Persona;
import hellfoz.service.EntradasService;
import hellfoz.service.MailService;

import java.io.ByteArrayOutputStream;
import java.net.URL;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.mail.MessagingException;

import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;

import org.jfree.util.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import utiles.Constants;

import com.paypal.api.payments.Amount;
import com.paypal.api.payments.CreditCard;
import com.paypal.api.payments.FundingInstrument;
import com.paypal.api.payments.Payer;
import com.paypal.api.payments.Payment;
import com.paypal.api.payments.Transaction;
import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.PayPalRESTException;

/**
 * @author hevacho
 *
 */
@Service("EntradasServiceImpl")
@Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.READ_COMMITTED)
public class EntradasServiceImpl implements EntradasService {

	private static final Logger LOG = LoggerFactory
			.getLogger(EntradasServiceImpl.class);

	@Autowired
	private ParametroVarioDao parametroVarioDao;

	@Autowired
	private PedidoDao pedidoDao;

	@Autowired
	private PersonaDao personaDao;

	@Autowired
	private EntradaDao entradaDao;

	@Autowired
	private MailService mailService;

	private static final DecimalFormat df = new DecimalFormat("#.00");
	private static final DateFormat daf = new SimpleDateFormat("yyyy-MM-dd");

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Integer salvarPedidoInicial(List<PersonaEntradaDto> personasEntradas) {

		// recuperamos el valor de BD por si han inyectado algo
		ParametroVario paramBD = parametroVarioDao
				.findByClaveAndTimeNow(Constants.CLAVE_PARAMETRO_PRECIO_ENTRADAS);
		Double precioEntrada = Double.parseDouble(paramBD.getValor());

		// creamos el pedido
		Pedido ped = new Pedido();
		ped.setFechaAlta(new Date());
		Estado estado = new Estado();
		estado.setIdEstado(1);
		ped.setEstado(estado);
		ped.setPrecioTotal(precioEntrada * personasEntradas.size());
		ped = pedidoDao.create(ped);

		for (PersonaEntradaDto personaEntradaDto : personasEntradas) {

			Persona pers = new Persona();
			pers.setEmail(personaEntradaDto.getEmail());
			pers.setNombre(personaEntradaDto.getNombre());
			pers.setApellidos(personaEntradaDto.getApellidos());
			pers.setNif(personaEntradaDto.getNif());
			pers.setPedido(ped);
			pers = personaDao.create(pers);

			Entrada entrada = new Entrada();
			entrada.setNumero(java.util.UUID.randomUUID().toString());
			entrada.setPersona(pers);
			entradaDao.create(entrada);
		}

		return ped.getIdPedido();
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void realizarPedidoPaypal(TarjetaDto tarjeta, Integer numeroPedido)
			throws PayPalRESTException {

		// recuperamos el valor de BD por si han inyectado algo
		ParametroVario paramBD = parametroVarioDao
				.findByClaveAndTimeNow(Constants.CLAVE_PARAMETRO_PRECIO_ENTRADAS);
		Double precioEntrada = Double.parseDouble(paramBD.getValor());

		Pedido pedBD = pedidoDao.findById(Pedido.class, numeroPedido);

		// Tarjeta de credito
		CreditCard creditCard = new CreditCard();
		creditCard.setBillingAddress(null);
		creditCard.setCvv2(tarjeta.getCvv());
		creditCard.setExpireMonth(tarjeta.getMesExpiracion());
		creditCard.setExpireYear(tarjeta.getAnhoExpiracion());
		creditCard.setFirstName(tarjeta.getNombre());
		creditCard.setLastName(tarjeta.getApellidos());
		creditCard.setNumber(tarjeta.getNumero().toString());
		creditCard.setType(tarjeta.getTipoTarjeta());

		// Total de pedido
		Amount amount = new Amount();
		amount.setCurrency("EUR");
		amount.setTotal(df.format(pedBD.getPrecioTotal()).replace(',', '.'));
		// No ponemos detalles amount.setDetails(details);

		// ###Transaction
		Transaction transaction = new Transaction();
		transaction.setAmount(amount);
		transaction.setDescription("Numero de pedido:" + pedBD.getIdPedido());

		// The Payment creation API requires a list of
		// Transaction; add the created `Transaction`
		// to a List
		List<Transaction> transactions = new ArrayList<Transaction>();
		transactions.add(transaction);
		FundingInstrument fundingInstrument = new FundingInstrument();
		fundingInstrument.setCreditCard(creditCard);

		List<FundingInstrument> fundingInstrumentList = new ArrayList<FundingInstrument>();
		fundingInstrumentList.add(fundingInstrument);

		// ###Payer
		Payer payer = new Payer();
		payer.setFundingInstruments(fundingInstrumentList);
		payer.setPaymentMethod("credit_card");

		// ###Payment
		Payment payment = new Payment();
		payment.setIntent("sale");
		payment.setPayer(payer);
		payment.setTransactions(transactions);

		// ###AccessToken
		String accessToken = GenerateAccessToken.getAccessToken();

		// ### Api Context
		APIContext apiContext = new APIContext(accessToken);
		Payment createdPayment = payment.create(apiContext);

		pedBD.setJsonPaypal(createdPayment.getLastResponse());
		Estado estado = new Estado();
		estado.setIdEstado(2);
		pedBD.setEstado(estado);

		pedidoDao.update(pedBD);
	}

	@Override
	public FicheroDto generarEntradasPedido(Integer numeroPedido) {

		try {

			Pedido pedBD = pedidoDao.findById(Pedido.class, numeroPedido);

			List<PedidoJasperDto> pedidos = new ArrayList<PedidoJasperDto>();
			PedidoJasperDto pedido = new PedidoJasperDto();
			pedido.setnPedido(pedBD.getIdPedido());
			pedido.setFecha(daf.format(pedBD.getFechaAlta()));
			pedido.setPrecioTotal(df.format(pedBD.getPrecioTotal()) + " €");

			for (Persona persona : pedBD.getPersonas()) {
				EntradaJasperDto entrada = new EntradaJasperDto();
				entrada.setId(persona.getEntrada().getIdEntrada());
				entrada.setNombre(persona.getNombre().toUpperCase());
				entrada.setApellidos(persona.getApellidos().toUpperCase());
				entrada.setNif(persona.getNif().toUpperCase());
				entrada.setCodigo(persona.getEntrada().getNumero());
				pedido.addEntrada(entrada);
			}

			pedidos.add(pedido);

			// informe jasper
			URL aux = this.getClass().getClassLoader()
					.getResource("reporteMaestroDS.jasper");
			JasperPrint jasperPrint = JasperFillManager.fillReport(
					aux.getFile(), new HashMap(),
					new JRBeanCollectionDataSource(pedidos));

			ByteArrayOutputStream baos = new ByteArrayOutputStream();

			JRPdfExporter docPdfExporter = new JRPdfExporter();
			docPdfExporter
					.setExporterInput(new SimpleExporterInput(jasperPrint));
			docPdfExporter
					.setExporterOutput(new SimpleOutputStreamExporterOutput(
							baos));
			docPdfExporter.exportReport();

			Thread.sleep(5000);

			FicheroDto ficheroDto = new FicheroDto();
			ficheroDto.setClave("Entrada");
			ficheroDto.setDescripcion("Entrada festival");
			ficheroDto.setFichero(baos.toByteArray());
			ficheroDto.setMimeType("application/pdf");
			ficheroDto.setNombreFichero("Entradas.pdf");

			return ficheroDto;

		} catch (Exception e) {
			LOG.error("Error obteniendo entradas", e);
		}

		return null;
	}

	@Override
	public List<Integer> idsPedidosEstadoPagoCompletado() {

		return pedidoDao
				.idsPedidosByEstado(Constants.ID_ESTADO_ACEPTADO_PAYPAL);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void enviarEntradasCorreo(Integer idPedido) {

		try {
			FicheroDto entradas = generarEntradasPedido(idPedido);

			List<String> emails = personaDao.getEmailsFromIdPedido(idPedido);

			if (emails != null) {
				String to = null;
				String[] cc = new String[emails.size() - 1];

				int i = 0;

				for (String email : emails) {
					if (to == null) {
						to = email;
					} else {
						cc[i++] = email;
					}
				}

				mailService.enviarEmailEntradas(to, cc, entradas);
			}
			
			Pedido ped = pedidoDao.findById(Pedido.class, idPedido);
			ped.setFechaEnvio(new Date());
			Estado estadoNuevo = new Estado();
			estadoNuevo.setIdEstado(Constants.ID_ESTADO_EMAIL_ENVIADO);
			ped.setEstado(estadoNuevo);
			pedidoDao.update(ped);
			
			
		} catch (MessagingException e) {
			Log.error("Error enviando pedido :"+idPedido, e);
		}

	}

}
