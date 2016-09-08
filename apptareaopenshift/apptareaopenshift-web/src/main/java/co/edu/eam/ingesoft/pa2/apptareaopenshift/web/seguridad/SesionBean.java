package co.edu.eam.ingesoft.pa2.apptareaopenshift.web.seguridad;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import org.apache.log4j.Logger;
import org.omnifaces.util.Faces;
import org.omnifaces.util.Messages;

import co.edu.eam.ingesoft.pa2.apptareaopenshift.negocio.implementaciones.SeguridadEJB;
import co.edu.eam.ingesoft.pa2.apptareaopenshift.negocio.implementaciones.UsuarioEJB;
import co.edu.eam.ingesoft.pa2.apptareaopenshift.persistencia.modelo.entidades.Usuario;
import co.edu.eam.ingesoft.pa2.apptareaopenshift.persistencia.modelo.seguridad.Acceso;
import co.edu.eam.ingesoft.pa2.apptareaopenshift.persistencia.modelo.seguridad.Rol;

@Named("sesion")
@SessionScoped
public class SesionBean implements Serializable {

	private Logger logger= Logger.getLogger(SesionBean.class);
	
	private Usuario usuario;
	
	private String nombreUsuario;
	
	private String pass;
	
	@EJB
	private UsuarioEJB usuarioEJB;
	
	@EJB
	private SeguridadEJB seguridadEJB;
	
	private List<Acceso> accesos;
	
	private List<Rol> roles;
	
	public String login(){
		
		usuario = usuarioEJB.buscarUsuarioPorNameUser(nombreUsuario).get(0);
		
		pass = MD5Util.code(pass);
		
		if(usuario != null && pass.equals(usuario.getPassword())){
			roles = seguridadEJB.listarRolesUsuario(usuario);
			accesos = seguridadEJB.listarAccesosRol(roles);
/*			Messages.addFlashGlobalInfo("Inicio de sesión exitoso!!!");*/
			return "/paginas/inicio.jsf?faces-redirect=true";
		
		}else{
			usuario = null;
			roles = null;
			accesos = null;
			/*Messages.addFlashGlobalError("Usuario o password incorrecto!!!");*/
			return null;
		}
		
	}
	
	public String logOut(){
		Faces.getSession().invalidate();
		return"/login.jsf?faces-redirect=true";
	}
	
	/**
	 * Metodo que valida si hay sesion
	 * @return
	 */
	public boolean isLogged(){
		return usuario!=null;
	}
	
	
	
	public boolean mostrarMenusAdmin(){
		usuario = usuarioEJB.buscarUsuarioPorNameUser(nombreUsuario).get(0);
		roles = seguridadEJB.listarRolesUsuario(usuario);
		if(roles.get(0).getDescripcion().equals("Administrador")){
			return true;
		}else{
			return false;
		}
	}
	
	
	
	
	
	
	public Usuario getUsuario() {
		return usuario;
	}



	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}



	public String getNombreUsuario() {
		return nombreUsuario;
	}



	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}



	public String getPass() {
		return pass;
	}



	public void setPass(String pass) {
		this.pass = pass;
	}



	public List<Acceso> getAccesos() {
		return accesos;
	}



	public void setAccesos(List<Acceso> accesos) {
		this.accesos = accesos;
	}



	public List<Rol> getRoles() {
		return roles;
	}



	public void setRoles(List<Rol> roles) {
		this.roles = roles;
	}

	

	
	
}
