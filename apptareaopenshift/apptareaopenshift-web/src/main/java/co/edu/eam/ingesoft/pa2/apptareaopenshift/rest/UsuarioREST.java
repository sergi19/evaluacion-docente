package co.edu.eam.ingesoft.pa2.apptareaopenshift.rest;

import java.awt.Cursor;
import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import co.edu.eam.ingesoft.pa2.apptareaopenshift.dto.RespuestaDTO;
import co.edu.eam.ingesoft.pa2.apptareaopenshift.negocio.implementaciones.PreguntaEJB;
import co.edu.eam.ingesoft.pa2.apptareaopenshift.negocio.implementaciones.UsuarioEJB;
import co.edu.eam.ingesoft.pa2.apptareaopenshift.negocio.implementaciones.WebServicesEJB;
import co.edu.eam.ingesoft.pa2.apptareaopenshift.persistencia.modelo.entidades.Decano;
import co.edu.eam.ingesoft.pa2.apptareaopenshift.persistencia.modelo.entidades.Grupo;
import co.edu.eam.ingesoft.pa2.apptareaopenshift.persistencia.modelo.entidades.Pregunta;
import co.edu.eam.ingesoft.pa2.apptareaopenshift.persistencia.modelo.entidades.Usuario;
import co.edu.eam.ingesoft.pa2.serviciosAcademicos.Curso;

@Path("/usuario")
public class UsuarioREST {

	@EJB
	private UsuarioEJB usuarioEJB;
	
	@EJB
	private PreguntaEJB preguntaEJB;
	
	@EJB
	private WebServicesEJB webServices;
	
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
	
	@POST
	@Path("/loginusuario")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public RespuestaDTO login(@FormParam(value="cod")String codigo, 
							  @FormParam(value="ced")String cedula){
		
		boolean usuario = webServices.buscarEstudiante(codigo, cedula);
		if(usuario==true){
			return new RespuestaDTO(true);
		}else{
			return new RespuestaDTO(false, "Acceso denegado", "-1");
		}
		
	}
	
	
	@GET
	@Path("/listarpreguntas")
	@Produces(MediaType.APPLICATION_JSON)
	public RespuestaDTO listarPreguntas(){
		
		List<Pregunta> listaPreguntas = preguntaEJB.listarPreguntas();
		if(!(listaPreguntas.isEmpty())){
			return new RespuestaDTO(listaPreguntas);
		}else{
			return new RespuestaDTO(false, "No hay preguntas", "-1");
		}
		
	}
	
	@POST
	@Path("/listacursos")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public RespuestaDTO listarGrupos(@FormParam(value="cod")String codigo, 
			  						 @FormParam(value="ced")String cedula){
		
		List<Grupo> lista = webServices.crearGrupos(codigo, cedula);
		if(!(lista.isEmpty())){
			return new RespuestaDTO(lista);
		}else{
			return new RespuestaDTO(false, "No hay cursos", "-1");
		}
		
	}
	
	
	
	
}
