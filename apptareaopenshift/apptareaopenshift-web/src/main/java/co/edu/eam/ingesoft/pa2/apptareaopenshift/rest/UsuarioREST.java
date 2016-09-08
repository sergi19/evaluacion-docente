package co.edu.eam.ingesoft.pa2.apptareaopenshift.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import co.edu.eam.ingesoft.pa2.apptareaopenshift.dto.RespuestaDTO;
import co.edu.eam.ingesoft.pa2.apptareaopenshift.negocio.implementaciones.UsuarioEJB;
import co.edu.eam.ingesoft.pa2.apptareaopenshift.persistencia.modelo.entidades.Decano;
import co.edu.eam.ingesoft.pa2.apptareaopenshift.persistencia.modelo.entidades.Usuario;

@Path("/usuario")
public class UsuarioREST {

	@EJB
	private UsuarioEJB usuarioEJB;
	
	public UsuarioREST(){
		
	}
	
	@GET
	@Path("/buscarusuario")
	@Produces(MediaType.APPLICATION_JSON)
	public RespuestaDTO buscarUsuario(@QueryParam(value="ced")int cedula){
		Usuario u = usuarioEJB.buscar(cedula);
		return new RespuestaDTO(u);
	}
	
	@PUT
	@Path("/crear")	
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public RespuestaDTO crear(Usuario u){
		if(usuarioEJB.buscar(u.getId())==null){
			usuarioEJB.crear(u);
			return new RespuestaDTO(true);
		}else{
			return new RespuestaDTO(false, "El usuario ya existe", "-1");
		}
	}
	
	
	
	
	
	
	
}
