/**
 * 
 */
package co.edu.eam.ingesoft.pa2.apptareaopenshift.negocio.implementaciones;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import co.edu.eam.ingesoft.pa2.apptareaopenshift.negocio.excepciones.ExcepcionNegocio;
import co.edu.eam.ingesoft.pa2.apptareaopenshift.negocio.interfaces.ProgramaRemoteEJB;
import co.edu.eam.ingesoft.pa2.apptareaopenshift.persistencia.modelo.entidades.Programa;
import co.edu.eam.ingesoft.pa2.apptareaopenshift.persistencia.modelo.entidades.Usuario;


@LocalBean
@Stateless
@Remote(ProgramaRemoteEJB.class)
public class ProgramaEJB extends EJBGenerico<Programa> implements ProgramaRemoteEJB{

	@Override
	public List<Programa> listarPrograma() {
		return dao.ejecutarNamedQuery(Programa.LISTAR_PROGRAMAS);
	}
	
	public void crear(Programa pro) throws ExcepcionNegocio {
		if (buscar(pro.getIdPrograma()) != null) {
			throw new ExcepcionNegocio("El programa ya se encuentra registrado");
		} else {
			dao.crear(pro);
		}
	}
	
	public Programa buscar(Object pk) {
		return dao.buscar(pk);
	}

	@Override
	public Class getClase() {
		// TODO Auto-generated method stub
		return Programa.class;
	}

}
