package co.edu.eam.ingesoft.pa2.apptareaopenshift.web.interceptores;

import java.io.Serializable;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import org.apache.log4j.Logger;

import co.edu.eam.ingesoft.pa2.apptareaopenshift.negocio.excepciones.ExcepcionNegocio;
import co.edu.eam.ingesoft.pa2.apptareaopenshift.web.seguridad.SesionBean;

@Interceptor
@Secured
public class SecurityInterceptor implements Serializable {

	private static Logger log = Logger.getLogger(ExceptionLoggerInterceptor.class);

	@Inject
	private SesionBean sesion;

	@AroundInvoke
	public Object mostrarExcepcion(InvocationContext invocationContext) throws Exception {

		// verificar que el metodo que se invoca este anotado
		if (invocationContext.getMethod().isAnnotationPresent(Secured.class)) {
			if (sesion.isLogged()) {
				Object res = invocationContext.proceed();
				return res;
			} else {
				throw new ExcepcionNegocio("Autorizado!!!");
			}
		}else{
			Object res = invocationContext.proceed();
			return res;
		}
	}
	
	
	
}
