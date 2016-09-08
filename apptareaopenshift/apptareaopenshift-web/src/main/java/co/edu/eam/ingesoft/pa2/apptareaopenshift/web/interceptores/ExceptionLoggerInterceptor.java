package co.edu.eam.ingesoft.pa2.apptareaopenshift.web.interceptores;

import java.io.Serializable;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import org.apache.log4j.Logger;
import org.omnifaces.util.Faces;
import org.omnifaces.util.Messages;

import co.edu.eam.ingesoft.pa2.apptareaopenshift.negocio.excepciones.ExcepcionNegocio;;

@Interceptor
@ExceptionLogger
public class ExceptionLoggerInterceptor implements Serializable {

	private static Logger log = Logger.getLogger(ExceptionLoggerInterceptor.class);
	
	@AroundInvoke
	public Object mostrarExcepcion(InvocationContext invocationContext) throws Exception{
		log.info("Ingresando al metodo" + invocationContext.getMethod().getName());
		try {
			return invocationContext.proceed();
		} catch (ExcepcionNegocio e) {
			Messages.addFlashGlobalError(e.getMessage());
			log.error(e.getMessage(), e);
		} catch(Exception exc) {
			log.error(exc.getMessage(),exc);
			Faces.getApplication().getNavigationHandler().
			handleNavigation(Faces.getContext(),null, "/error.jsf?faces-redirect=true");
		}
		log.info("Saliendo del metodo" + invocationContext.getMethod().getName());
		return null;
		
	}
	
}
