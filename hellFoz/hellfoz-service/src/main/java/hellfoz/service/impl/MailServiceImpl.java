/**
 * 
 */
package hellfoz.service.impl;

import hellfoz.dto.FicheroDto;
import hellfoz.model.entities.Acampada;
import hellfoz.service.MailService;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.activation.FileDataSource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.mail.util.ByteArrayDataSource;

import org.apache.commons.collections.map.HashedMap;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import utiles.Configuracion;

/**
 * @author hevacho
 *
 */
@Service("MailServiceImpl")
@Transactional(propagation=Propagation.SUPPORTS, isolation=Isolation.READ_COMMITTED)
public class MailServiceImpl implements MailService {
	
	private static final Logger LOG = LoggerFactory.getLogger(MailServiceImpl.class);
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	@Autowired
	private VelocityEngine velocityEngine;
	
	@Autowired
	private Configuracion configuracion;
	
	
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED, isolation=Isolation.READ_COMMITTED)
	public void enviarEmailAcampada(Acampada acampada) throws MessagingException{
		
		Map<String,String> clavesVelocity = new HashMap<String, String>(10);
		clavesVelocity.put("nombre", acampada.getNombre());
		clavesVelocity.put("apellido1", acampada.getApellido1());
		clavesVelocity.put("apellido2", acampada.getApellido2());
		
		String nombreTemplate ="acampadaEmail.vm";
		
		Map<String, ByteArrayDataSource> filesInline = new HashMap<String, ByteArrayDataSource>(2);
		try {
			
			InputStream io = this.getClass().getClassLoader().getResourceAsStream("hellfozCorreos.png");
			ByteArrayDataSource data = new ByteArrayDataSource(io, "image/png");
			filesInline.put("hellfozFoto", data);
		} catch (IOException e) {
			LOG.error("Error leyendo el fichero para hellfozFoto (hellfozCorreos.png)");
		}
		
		try{
			InputStream io2 = this.getClass().getClassLoader().getResourceAsStream("valhallaMetal.png");
			ByteArrayDataSource data2 = new ByteArrayDataSource(io2, "image/png");
			filesInline.put("valhallaFoto", data2);
		}catch(IOException e){
			LOG.error("Error leyendo el fichero para hellfozFoto (valhallaMetal.png)");
		}
		
		Map<String, ByteArrayDataSource> filesAttach = null;
		
		String to = acampada.getEmail();
		
		String from = configuracion.getMailFrom();
		
		String subject = "Mensaje Zona Acampada HellFoz";
		
		String[] cc = null;
		
		String [] bcc = null;
		
		
		enviarEmailHtml(clavesVelocity, nombreTemplate, filesInline, filesAttach, to, from, subject, cc, bcc);
	}
	
	@Override
	public void enviarEmailEntradas(String to, String[] cc, FicheroDto entradas) throws MessagingException{
		
		
		Map<String,String> clavesVelocity = new HashMap<String, String>(10);
				
		String nombreTemplate ="entradasEmail.vm";
		
		Map<String, ByteArrayDataSource> filesInline = new HashMap<String, ByteArrayDataSource>(2);
		try {
			
			InputStream io = this.getClass().getClassLoader().getResourceAsStream("hellfozCorreos.png");
			ByteArrayDataSource data = new ByteArrayDataSource(io, "image/png");
			filesInline.put("hellfozFoto", data);
		} catch (IOException e) {
			LOG.error("Error leyendo el fichero para hellfozFoto (hellfozCorreos.png)");
		}
		
		try{
			InputStream io2 = this.getClass().getClassLoader().getResourceAsStream("valhallaMetal.png");
			ByteArrayDataSource data2 = new ByteArrayDataSource(io2, "image/png");
			filesInline.put("valhallaFoto", data2);
		}catch(IOException e){
			LOG.error("Error leyendo el fichero para hellfozFoto (valhallaMetal.png)");
		}
		
		ByteArrayDataSource entradasDS = new ByteArrayDataSource(entradas.getFichero(), entradas.getMimeType());
		
		Map<String, ByteArrayDataSource> filesAttach = new HashMap<String, ByteArrayDataSource>();
		filesAttach.put("entradas.pdf", entradasDS);
		
		String from = configuracion.getMailFrom();
		
		String subject = "Entradas HellFoz";
		
		
		String [] bcc = null;
		
		
		enviarEmailHtml(clavesVelocity, nombreTemplate, filesInline, filesAttach, to, from, subject, cc, bcc);
		
		
	}
	
private void enviarEmailHtml(Map<String,String> clavesVelocity,String nombreTemplate, Map<String, ByteArrayDataSource> filesInline, Map<String, ByteArrayDataSource> filesAttach, String to, String from, String subject, String[] cc, String[] bcc) throws MessagingException{
		
		final MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		final MimeMessageHelper mailMessage = new MimeMessageHelper(mimeMessage, true);
		Template template = velocityEngine.getTemplate("./"+nombreTemplate);
		StringWriter stringWriter = new StringWriter();
	    
		VelocityContext velocityContext = new VelocityContext();
	    //rellenamos las claves
		if(clavesVelocity!=null && !clavesVelocity.isEmpty()){
			Set<String> keySet = clavesVelocity.keySet();
			
			for (String key : keySet) {
				velocityContext.put(key, clavesVelocity.get(key));
			} 
		}
		
		template.merge(velocityContext, stringWriter);
		
		//ponemos el texto
		mailMessage.setText(stringWriter.toString(),true);
		
		//adjuntamos en linea
		if(filesInline!=null && !filesInline.isEmpty()){
			Set<String> keySet = filesInline.keySet();
			for (String key : keySet) {
				mailMessage.addInline(key, filesInline.get(key));
			}
		}
		
		//adjuntamos en attachment
		if(filesAttach!=null && !filesAttach.isEmpty()){
			Set<String> keySet = filesAttach.keySet();
			for (String key : keySet) {
				mailMessage.addAttachment(key, filesAttach.get(key));
			}
		}
		
		mailMessage.setTo(to);
        mailMessage.setFrom(from);
        
        if(cc!=null && cc.length>0){
        	mailMessage.setCc(cc);
        }
        
        if(bcc!=null && bcc.length>0){
        	mailMessage.setBcc(bcc);
        }
        
        
        mailMessage.setSubject(subject);
        
        
        javaMailSender.send(mimeMessage);
		
		
	}
	
	@Override
	public void pruebaMail(){
		
		System.out.println("hola");
		
		try{
		final MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		final MimeMessageHelper mailMessage = new MimeMessageHelper(mimeMessage, true);
		
		 Template template = velocityEngine.getTemplate("./acampadaEmail.vm");

	        VelocityContext velocityContext = new VelocityContext();
	        velocityContext.put("firstName", "Yashwant");
	        velocityContext.put("lastName", "Chavan");
	        velocityContext.put("location", "Pune");
	        
	        
	        
	        StringWriter stringWriter = new StringWriter();
	        
	        template.merge(velocityContext, stringWriter);
	        
	        mailMessage.setText(stringWriter.toString(),true);
		
		
		
		InputStream io = this.getClass().getClassLoader().getResourceAsStream("autentia.gif");
		ByteArrayDataSource data = new ByteArrayDataSource(io, "image/gif");
		
		//con esto adjuntamos
				
	mailMessage.addAttachment("id002", data);
	mailMessage.addAttachment("id003", data);
	mailMessage.addAttachment("id004", data);
		
		// con esto mostramos en linea tiene que coincidir con el correo html el cid
		mailMessage.addInline("id002", data);
				
		mailMessage.setTo("hevacho@gmail.com");
        mailMessage.setFrom("hevachoProyectos@gmail.com");
        mailMessage.setSubject("Lorem ipsum");
        
       
        
        
        
        
        javaMailSender.send(mimeMessage);
		}catch (Exception e){
			e.printStackTrace();
		}
		
		System.out.println("hola");
		
	}
	
	

}
