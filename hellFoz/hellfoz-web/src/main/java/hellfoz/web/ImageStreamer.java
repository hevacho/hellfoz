/**
 * 
 */
package hellfoz.web;

import hellfoz.dto.ImagenDto;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.Serializable;

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
public class ImageStreamer implements Serializable {

	private static final long serialVersionUID = 1L;

	public StreamedContent getImage() throws IOException {
		FacesContext context = FacesContext.getCurrentInstance();

		if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
			// So, we're rendering the HTML. Return a stub StreamedContent so
			// that it will generate right URL.
			return new DefaultStreamedContent();

		} else {

			// So, browser is requesting the image. Return a real
			// StreamedContent with the image bytes.
			String imageId = context.getExternalContext()
					.getRequestParameterMap().get("id");
			if(context.getExternalContext().getSessionMap().get(imageId) !=null){
				// buscar imagen
				ImagenDto imagen = (ImagenDto) context.getExternalContext()
						.getSessionMap().get(imageId);
				byte[] bytes = imagen.getFoto();
	
				context.getExternalContext().getSessionMap().remove(imageId);
				
				FacesContext.getCurrentInstance().getExternalContext().setResponseContentLength(bytes.length);
				
				return new DefaultStreamedContent(new ByteArrayInputStream(bytes));
			}else{
				return new DefaultStreamedContent();
			}

		}
	}
}
