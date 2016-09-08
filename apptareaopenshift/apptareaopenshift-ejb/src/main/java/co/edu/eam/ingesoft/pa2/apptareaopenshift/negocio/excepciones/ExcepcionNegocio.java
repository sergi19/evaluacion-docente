package co.edu.eam.ingesoft.pa2.apptareaopenshift.negocio.excepciones;

import javax.ejb.ApplicationException;

@ApplicationException
public class ExcepcionNegocio extends RuntimeException {

	public ExcepcionNegocio(String mensaje) {
		super(mensaje);
	}

}
