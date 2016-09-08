package co.edu.eam.ingesoft.pa2.apptareaopenshift.web.seguridad;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import co.edu.eam.ingesoft.pa2.apptareaopenshift.persistencia.modelo.seguridad.Acceso;

@WebFilter(urlPatterns = "/paginas/*")
public class FiltroAcceso implements Filter {

	@Inject
	private SesionBean sesion;

	Logger logger = Logger.getLogger(FiltroAcceso.class);

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest httpreq = (HttpServletRequest) request;
		HttpServletResponse httpresp = (HttpServletResponse) resp;

		String urlcompleta = httpreq.getRequestURI().toString();
		String contextpath = httpreq.getContextPath();

		logger.info("url = " + urlcompleta + ",path =" + contextpath);
		String url = urlcompleta.substring(contextpath.length());

		logger.info("URL a filtrar=" + url);

		// si el usuario esta en sesion y no muestra la pagina de inicio
		// que todos tienen
		if (sesion.isLogged()) {
			// busca si tiene acceso a la pagina
			boolean exito = false;
			if (url.equals("/paginas/inicio.jsf")) {
				exito = true;
			} else {
				List<Acceso> accesos = sesion.getAccesos();
				for (Acceso a : accesos) {
					// si en la lista de accesos autorizados...
					if (a.getUrl().equals(url)) {
						exito = true;
					}
				}
			}
			//no esta en la lista, lo redirije hasta a la de inicio
			if(!exito){
				//
				httpresp.sendRedirect(httpreq.getContextPath()+"/paginas/inicio.jsf");
			}else{
				//continua la peticion
				chain.doFilter(request, resp);
			}
		}else{
			//no esta en sesion lo dirige al principio
			httpresp.sendRedirect(httpreq.getContextPath()+"/login.jsf");
		}

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
