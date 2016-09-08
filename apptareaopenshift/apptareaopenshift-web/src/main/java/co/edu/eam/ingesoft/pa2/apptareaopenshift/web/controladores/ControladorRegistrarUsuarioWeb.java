package co.edu.eam.ingesoft.pa2.apptareaopenshift.web.controladores;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;


import javax.inject.Named;

import co.edu.eam.ingesoft.pa2.apptareaopenshift.negocio.implementaciones.FacultadEJB;
import co.edu.eam.ingesoft.pa2.apptareaopenshift.negocio.implementaciones.ProgramaEJB;
import co.edu.eam.ingesoft.pa2.apptareaopenshift.negocio.implementaciones.UsuarioEJB;
import co.edu.eam.ingesoft.pa2.apptareaopenshift.persistencia.modelo.entidades.Coordinador;
import co.edu.eam.ingesoft.pa2.apptareaopenshift.persistencia.modelo.entidades.Decano;
import co.edu.eam.ingesoft.pa2.apptareaopenshift.persistencia.modelo.entidades.Facultad;
import co.edu.eam.ingesoft.pa2.apptareaopenshift.persistencia.modelo.entidades.Programa;
import co.edu.eam.ingesoft.pa2.apptareaopenshift.web.interceptores.Secured;
import co.edu.eam.ingesoft.pa2.apptareaopenshift.web.seguridad.MD5Util;

@Named("usuarioWeb")
@javax.faces.view.ViewScoped
public class ControladorRegistrarUsuarioWeb implements Serializable{

	/**
	 * EJB de usuario
	 */
	@EJB
	private UsuarioEJB usuarioEJB;

	/**
	 * EJB Programa
	 */
	@EJB
	private ProgramaEJB programaEJB;

	/**
	 * EJB Facultad
	 */
	@EJB
	private FacultadEJB facultadEJB;

	/**
	 * Identificacion del usuario
	 */
	private int id;

	/**
	 * nombre del usuario
	 */
	private String nombre;

	/**
	 * apellido del usuario
	 */
	private String apellido;

	/**
	 * usuario del usuario
	 */
	private String user;

	/**
	 * contraseña del usuario
	 */
	private String password;
	
	
	private Facultad facultadSeleccionada;
	
	
	private Programa programaSeleccionado;

	/**
	 * El programa del coordinador
	 */
	private String idPrograma;

	/**
	 * La facultad del decano
	 */
	private String idFacultad;

	private String usuarioSeleccionado;

	private List<Programa> programa;
	private List<Facultad> facultad;
	
	
	/**
	 * crea un usuario
	 */
	@Secured
	public void crear() {
		if (nombre != null || id != 0 || apellido != null || user != null || password != null) {
			if (usuarioSeleccionado.equals("2")) {
				String contrasenia = MD5Util.code(password);
				Coordinador c = new Coordinador(nombre, apellido, user, 
						contrasenia, id, programaSeleccionado);
				usuarioEJB.crear(c);
				FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Coordinador fue registrado con exito",  null);
				FacesContext.getCurrentInstance().addMessage(null, message);
				System.out.println("Coordinador reado con exito");
			} else if (usuarioSeleccionado.equals("1")) {
				Decano d = new Decano(nombre, apellido, user, 
						password, id, facultadSeleccionada);
				usuarioEJB.crear(d);
				FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "El Decano fue registrado con exito",  null);
				FacesContext.getCurrentInstance().addMessage(null, message);	
				System.out.println("Decano creado con exito");
			}
		} else {

			System.out.println("llene campos");
		}

	}
	
	public boolean cargarFacultad(){
		if(usuarioSeleccionado.equals("1")){
			facultad = facultadEJB.listarFacultad();
			return true;
		}
		return false;
	}
	
	public boolean cargarPrograma(){
		if(usuarioSeleccionado.equals("2")){
			programa = programaEJB.listarPrograma();
			return true;
		}
		return false;
	}

	@PostConstruct
	public void inicializar() {
		usuarioSeleccionado = "0";
		programa = new LinkedList<>();
		facultad = new LinkedList<>();		
	}
	


	/**
	 * busca un usuario por su cedula
	 * 
	 * @return el usuario si lo encuentra, de lo contrario null
	 */
	public void buscar() {

	}

	public String getApellido() {
		return apellido;
	}

	public int getId() {
		return id;
	}

	public String getIdFacultad() {
		return idFacultad;
	}

	public String getIdPrograma() {
		return idPrograma;
	}

	public String getNombre() {
		return nombre;
	}

	public String getPassword() {
		return password;
	}

	public String getUser() {
		return user;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setIdFacultad(String idFacultad) {
		this.idFacultad = idFacultad;
	}

	public void setIdPrograma(String idPrograma) {
		this.idPrograma = idPrograma;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getUsuarioSeleccionado() {
		return usuarioSeleccionado;
	}

	public void setUsuarioSeleccionado(String usuarioSeleccionado) {
		this.usuarioSeleccionado = usuarioSeleccionado;
	}

	public List<Programa> getPrograma() {
		return programa;
	}

	public void setPrograma(List<Programa> programa) {
		this.programa = programa;
	}

	public List<Facultad> getFacultad() {
		return facultad;
	}

	public void setFacultad(List<Facultad> facultad) {
		this.facultad = facultad;
	}
	
	public Facultad getFacultadSeleccionada() {
		return facultadSeleccionada;
	}

	public void setFacultadSeleccionada(Facultad facultadSeleccionada) {
		this.facultadSeleccionada = facultadSeleccionada;
	}

	public Programa getProgramaSeleccionado() {
		return programaSeleccionado;
	}

	public void setProgramaSeleccionado(Programa programaSeleccionado) {
		this.programaSeleccionado = programaSeleccionado;
	}
	
	
	
}
