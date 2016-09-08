/**
 * 
 */
package co.edu.eam.ingesoft.pa2.apptareaopenshift.web.validadores;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.inject.Named;


@Named
@FacesValidator(value = "campos")
public class Campos implements Validator {

	@Override
	public void validate(FacesContext arg0, UIComponent arg1, Object value) throws ValidatorException {
		
		if (value instanceof Integer) {
			int valor = (Integer) value;
			if (!(String.valueOf(valor).matches("[0-9]*"))) {
				throw new ValidatorException(
						new FacesMessage(FacesMessage.SEVERITY_WARN, "Ha ingresado letras o simbolos en este campo", null));
			}

		} else if (value instanceof String) {
			throw new ValidatorException(
					new FacesMessage(FacesMessage.SEVERITY_WARN, "Ha ingresado letras o simbolos en este campo", null));
		}
	}

}
