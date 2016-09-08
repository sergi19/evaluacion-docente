/**
 * 
 */
package co.edu.eam.ingesoft.pa2.apptareaopenshift.negocio.interfaces;

import java.util.List;

import co.edu.eam.ingesoft.pa2.apptareaopenshift.persistencia.modelo.entidades.Programa;

/**
 * @author Alejandro
 *
 */
public interface ProgramaRemoteEJB  extends InterfaceEJBGenerica<Programa>{

	public List<Programa> listarPrograma();
}
