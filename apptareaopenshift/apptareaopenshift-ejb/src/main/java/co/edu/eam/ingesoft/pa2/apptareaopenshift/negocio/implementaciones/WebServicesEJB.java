package co.edu.eam.ingesoft.pa2.apptareaopenshift.negocio.implementaciones;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.xml.ws.BindingProvider;

import co.edu.eam.ingesoft.pa2.apptareaopenshift.persistencia.modelo.entidades.Asignatura;
import co.edu.eam.ingesoft.pa2.apptareaopenshift.persistencia.modelo.entidades.Docente;
import co.edu.eam.ingesoft.pa2.apptareaopenshift.persistencia.modelo.entidades.Facultad;
import co.edu.eam.ingesoft.pa2.apptareaopenshift.persistencia.modelo.entidades.Grupo;
import co.edu.eam.ingesoft.pa2.apptareaopenshift.persistencia.modelo.entidades.Programa;
import co.edu.eam.ingesoft.pa2.serviciosAcademicos.Curso;
import co.edu.eam.ingesoft.pa2.serviciosAcademicos.Estudiante;
import co.edu.eam.ingesoft.pa2.serviciosAcademicos.ServiciosAcademicos;
import co.edu.eam.ingesoft.pa2.serviciosAcademicos.ServiciosEducativosService;

@LocalBean
@Stateless
public class WebServicesEJB implements Serializable {

	@EJB
	private ProgramaEJB programaEJB;

	@EJB
	private FacultadEJB facultadEJB;

	@EJB
	private AsignaturaEJB asignaturaEJB;

	@EJB
	private GrupoEJB grupoEJB;
	
	@EJB
	private DocenteEJB docenteEJB;

	public boolean buscarEstudiante(String codigo, String cedula) {

		ServiciosEducativosService cliente = new ServiciosEducativosService();
		ServiciosAcademicos servicio = cliente.getServiciosAcademicos();

		BindingProvider bp = (BindingProvider) servicio;
		bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY,
				"http://174.142.65.144:28080/eamweb/serviciosAcademicos");

		Estudiante e = servicio.consultaEstudiante(codigo, cedula);

		if (e != null) {
			return true;
		} else {
			return false;
		}

	}

	public boolean listarCursosEstudiante(String codigo, String cedula) {
		ServiciosEducativosService cliente = new ServiciosEducativosService();
		ServiciosAcademicos servicio = cliente.getServiciosAcademicos();

		BindingProvider bp = (BindingProvider) servicio;
		bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY,
				"http://174.142.65.144:28080/eamweb/serviciosAcademicos");
		List<Curso> lista = servicio.consultarCursosEstudiante(codigo, cedula);
		if (!(lista.isEmpty())) {
			for (int i = 0; i < lista.size(); i++) {
				Facultad fac = facultadEJB.buscar(lista.get(i).getAsignatura().getPrograma().getFacultad().getCodigo());
				Programa pro = programaEJB.buscar(lista.get(i).getAsignatura().getPrograma().getCodigo());
				Asignatura a = asignaturaEJB.buscar(lista.get(i).getAsignatura().getCodigo());
				if (fac == null) {
					Facultad f = new Facultad(lista.get(i).getAsignatura().getPrograma().getFacultad().getCodigo(),
							lista.get(i).getAsignatura().getPrograma().getFacultad().getNombre());
					facultadEJB.crear(f);
				}

				if (pro == null) {
					Programa p = new Programa();
					p.setIdPrograma(lista.get(i).getAsignatura().getPrograma().getCodigo());
					p.setNombrePrograma(lista.get(i).getAsignatura().getPrograma().getNombre());
					p.setIdFacultad(fac);
					programaEJB.crear(p);
				}

				if (a == null) {
					Asignatura asig = new Asignatura();
					asig.setIdAsignatura(lista.get(i).getAsignatura().getCodigo());
					asig.setNombreAsignatura(lista.get(i).getAsignatura().getNombre());
					asig.setIdPrograma(pro);
					asignaturaEJB.crear(asig);
				}

			}
			return true;

		} else {
			return false;
		}

	}

	public List<Grupo> crearGrupos(String codigo, String cedula) {

		ServiciosEducativosService cliente = new ServiciosEducativosService();
		ServiciosAcademicos servicio = cliente.getServiciosAcademicos();

		BindingProvider bp = (BindingProvider) servicio;
		bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY,
				"http://174.142.65.144:28080/eamweb/serviciosAcademicos");
		List<Curso> lista = servicio.consultarCursosEstudiante(codigo, cedula);
		List<Grupo> listaGrupos = new ArrayList<>();

		for (int i = 0; i < lista.size(); i++) {

			Grupo gru = grupoEJB.buscar(lista.get(i).getId());
			Facultad fac = facultadEJB.buscar(lista.get(i).getAsignatura().getPrograma().getFacultad().getCodigo());
			Programa pro = programaEJB.buscar(lista.get(i).getAsignatura().getPrograma().getCodigo());
			Asignatura a = asignaturaEJB.buscar(lista.get(i).getAsignatura().getCodigo());
			Docente d = docenteEJB.buscar(lista.get(i).getDocente().getDocumentoidentificacion());
			if (fac == null) {
				Facultad f = new Facultad(lista.get(i).getAsignatura().getPrograma().getFacultad().getCodigo(),
				lista.get(i).getAsignatura().getPrograma().getFacultad().getNombre());
				facultadEJB.crear(f);
			}

			if (pro == null) {
				Programa p = new Programa();
				p.setIdPrograma(lista.get(i).getAsignatura().getPrograma().getCodigo());
				p.setNombrePrograma(lista.get(i).getAsignatura().getPrograma().getNombre());
				p.setIdFacultad(fac);
				programaEJB.crear(p);
			}

			if (a == null) {
				Asignatura asig = new Asignatura();
				asig.setIdAsignatura(lista.get(i).getAsignatura().getCodigo());
				asig.setNombreAsignatura(lista.get(i).getAsignatura().getNombre());
				asig.setIdPrograma(pro);
				asignaturaEJB.crear(asig);
			}
			
			if(d ==null){
				Docente doc = new Docente();
				doc.setId(lista.get(i).getDocente().getDocumentoidentificacion());
				doc.setNombre(lista.get(i).getDocente().getNombre());
				doc.setApellido(lista.get(i).getDocente().getApellido());
				doc.setIdPrograma(pro);
				docenteEJB.crear(doc);
			}
			
			if (gru == null) {
				Calendar calendario = GregorianCalendar.getInstance();
				Date fecha = calendario.getTime();
				Grupo grup = new Grupo();
				grup.setIdGrupo(lista.get(i).getId());
				grup.setIdAsignatura(a);
				grup.setIdDocente(d);
				grup.setAnio(fecha);
				grup.setPeriodo(2);
				grup.setGrupo(lista.get(i).getGrupo().toString());
				listaGrupos.add(grup);
				grupoEJB.crear(grup);
			}else{
				listaGrupos.add(gru);
			}
			
		}
		return listaGrupos;

	}

}
