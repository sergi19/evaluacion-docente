/**
 * 
 */
package co.edu.eam.ingesoft.pa2.apptareaopenshift.negocio.implementaciones;

import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import co.edu.eam.ingesoft.pa2.apptareaopenshift.negocio.interfaces.FacultadRemoteEJB;
import co.edu.eam.ingesoft.pa2.apptareaopenshift.persistencia.modelo.entidades.Facultad;


@LocalBean
@Stateless
@Remote(FacultadRemoteEJB.class)
public class FacultadEJB extends EJBGenerico<Facultad> implements FacultadRemoteEJB {

	@Override
	public List<Facultad> listarFacultad() {
		
		return dao.ejecutarNamedQuery(Facultad.LISTAR_FACULTADES);
	}

	@Override
	public Class getClase() {
		// TODO Auto-generated method stub
		return Facultad.class;
	}

	

}
