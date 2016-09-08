/**
 * 
 */
package co.edu.eam.ingesoft.pa2.apptareaopenshift.negocio.interfaces;

import java.util.List;

import co.edu.eam.ingesoft.pa2.apptareaopenshift.persistencia.modelo.entidades.Facultad;


public interface FacultadRemoteEJB  extends InterfaceEJBGenerica<Facultad>{

	public List<Facultad>listarFacultad();
	
}
