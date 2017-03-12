/**
 * 
 */
package hellfoz.web;

import hellfoz.dto.FicheroDto;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

/**
 * @author hevacho
 *
 */

@ManagedBean
@SessionScoped
public class FicheroStreamer {
	
	public StreamedContent getContent() throws IOException {
		FacesContext context = FacesContext.getCurrentInstance();

		if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
			// So, we're rendering the HTML. Return a stub StreamedContent so
			// that it will generate right URL.
			return new DefaultStreamedContent();

		} else {

			
			// buscar imagen
			FicheroDto fichero = (FicheroDto) context.getExternalContext()
					.getSessionMap().get("fichero");
			
			context.getExternalContext().getSessionMap().remove("fichero");
			return new DefaultStreamedContent(new ByteArrayInputStream(fichero.getFichero()), fichero.getMimeType());

		}
	}
	

}
