/**
 * 
 */
package hellfoz.web;

import java.util.ResourceBundle;

import javax.faces.context.FacesContext;

/**
 * @author hevacho
 *
 */
public class UtilMessages {
	
	public static String getMessage(String key){
		
		FacesContext facesContext = FacesContext.getCurrentInstance();
	    ResourceBundle bundle = 
	        facesContext.getApplication().getResourceBundle(
	            facesContext, "msg");
	    
	    String aux = bundle.getString(key);
	    
	    return aux;
		
	}

}
