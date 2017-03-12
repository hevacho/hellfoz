/**
 * 
 */
package hellfoz.web.validators;

import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import com.aeat.valida.Validador;

import org.primefaces.validate.ClientValidator;

/**
 * @author hevacho
 *
 */
@FacesValidator("custom.dniValidator")
public class DNIValidator implements Validator, ClientValidator {

	private Validador valAetc;
	
	public DNIValidator() {
		valAetc = new Validador();
	}
	
	@Override
	public Map<String, Object> getMetadata() {
		  return null;
	}

	
	@Override
	public String getValidatorId() {
		 return "custom.dniValidator";
	}

	
	@Override
	public void validate(FacesContext context, UIComponent component, Object value)
			throws ValidatorException {
		 if(value == null) {
	            return;
	        }
		
		int aux =  valAetc.checkNif(value.toString());
		
		if(aux<0){
			throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Validation Error", 
                    value + "no es un nif valido"));
		}
		
	}

}
