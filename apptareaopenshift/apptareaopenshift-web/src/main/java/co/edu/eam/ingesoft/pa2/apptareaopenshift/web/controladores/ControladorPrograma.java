package co.edu.eam.ingesoft.pa2.apptareaopenshift.web.controladores;

import co.edu.eam.ingesoft.pa2.apptareaopenshift.negocio.implementaciones.FacultadEJB;
import co.edu.eam.ingesoft.pa2.apptareaopenshift.negocio.implementaciones.ProgramaEJB;
import co.edu.eam.ingesoft.pa2.apptareaopenshift.persistencia.modelo.entidades.Facultad;
import co.edu.eam.ingesoft.pa2.apptareaopenshift.persistencia.modelo.entidades.Programa;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named("programasWeb")
@ViewScoped
public class ControladorPrograma implements Serializable {

	@EJB
	private ProgramaEJB programaEJB;

	@EJB
	private FacultadEJB facultadEJB;

	private String id;

	private String nombre;

	private Facultad facultad;

	private List<Facultad> facultades;

	@PostConstruct
	public void inicializar() {
		facultades = facultadEJB.listarFacultad();
	}

	public void crear() {
		Programa p = new Programa(id, nombre, facultad);
		programaEJB.crear(p);
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Programa registrado con exito", null);
		FacesContext.getCurrentInstance().addMessage(null, message);
		System.out.println("id: " + id + " " + "nombre: " + nombre + " " + "Facultad: " + facultad);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Facultad getFacultad() {
		return facultad;
	}

	public List<Facultad> getFacultades() {
		return facultades;
	}

	public void setFacultades(List<Facultad> facultades) {
		this.facultades = facultades;
	}

	public void setFacultad(Facultad facultad) {
		this.facultad = facultad;
	}

}
