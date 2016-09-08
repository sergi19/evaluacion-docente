package co.edu.eam.ingesoft.pa2.apptareaopenshift.negocio.implementaciones;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.xml.ws.BindingProvider;

import co.edu.eam.ingesoft.pa2.apptareaopenshift.persistencia.modelo.entidades.Asignatura;
import co.edu.eam.ingesoft.pa2.apptareaopenshift.persistencia.modelo.entidades.Facultad;
import co.edu.eam.ingesoft.pa2.apptareaopenshift.persistencia.modelo.entidades.Programa;
import co.edu.eam.ingesoft.pa2.serviciosAcademicos.Curso;
import co.edu.eam.ingesoft.pa2.serviciosAcademicos.Estudiante;
import co.edu.eam.ingesoft.pa2.serviciosAcademicos.ServiciosAcademicos;
import co.edu.eam.ingesoft.pa2.serviciosAcademicos.ServiciosEducativosService;

@LocalBean
@Stateless
public class WebServicesEJB implements Serializable{
	
	@EJB
	private ProgramaEJB programaEJB;
	
	@EJB
	private FacultadEJB facultadEJB;
	
	@EJB
	private AsignaturaEJB asignaturaEJB;

	
	public boolean buscarEstudiante(String codigo, String cedula){
		
		ServiciosEducativosService cliente = new ServiciosEducativosService();
        ServiciosAcademicos servicio = cliente.getServiciosAcademicos();

        BindingProvider bp = (BindingProvider) servicio;
        bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY,
                "http://174.142.65.144:28080/eamweb/serviciosAcademicos");

        Estudiante e = servicio.consultaEstudiante(codigo, cedula);
        
        if(e != null){
        	return true;
        }else{
        	return false;
        }
		
	}
	
	
	public boolean listarCursosEstudiante(String codigo, String cedula){
		ServiciosEducativosService cliente = new ServiciosEducativosService();
        ServiciosAcademicos servicio = cliente.getServiciosAcademicos(); 

        BindingProvider bp = (BindingProvider) servicio;
        bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY,
                "http://174.142.65.144:28080/eamweb/serviciosAcademicos");
        List<Curso> lista = servicio.consultarCursosEstudiante(codigo, cedula);
        if(!(lista.isEmpty())){
        	for (int i = 0; i < lista.size(); i++) {
        		Facultad fac = facultadEJB.buscar(lista.get(i).getAsignatura().getPrograma().getFacultad().getCodigo());
        		Programa pro = programaEJB.buscar(lista.get(i).getAsignatura().getPrograma().getCodigo());
        		Asignatura a = asignaturaEJB.buscar(lista.get(i).getAsignatura().getCodigo()); 
        		if(fac==null){
        			Facultad f = new Facultad(lista.get(i).getAsignatura().getPrograma().getFacultad().getCodigo(),
        					lista.get(i).getAsignatura().getPrograma().getFacultad().getNombre());
        			facultadEJB.crear(f);
        		}
        		
        		if(pro==null){
        			Programa p = new Programa();
        			p.setIdPrograma(lista.get(i).getAsignatura().getPrograma().getCodigo());
        			p.setNombrePrograma(lista.get(i).getAsignatura().getPrograma().getNombre());
        			p.setIdFacultad(fac);
        			programaEJB.crear(p);
        		}
        		
        		if(a==null){
        			Asignatura asig = new Asignatura();
        			asig.setIdAsignatura(lista.get(i).getAsignatura().getCodigo());
        			asig.setNombreAsignatura(lista.get(i).getAsignatura().getNombre());
        			asig.setIdPrograma(pro);
        			asignaturaEJB.crear(asig);
        		}
        	
        	}
        	return true;
		
        }else{
        	return false;
        }
	
	}	
	
}

