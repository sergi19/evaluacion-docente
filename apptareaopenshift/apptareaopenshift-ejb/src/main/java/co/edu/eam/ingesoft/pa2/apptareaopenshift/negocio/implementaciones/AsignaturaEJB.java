package co.edu.eam.ingesoft.pa2.apptareaopenshift.negocio.implementaciones;

import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import co.edu.eam.ingesoft.pa2.apptareaopenshift.negocio.excepciones.ExcepcionNegocio;
import co.edu.eam.ingesoft.pa2.apptareaopenshift.negocio.interfaces.AsignaturaRemoteEJB;
import co.edu.eam.ingesoft.pa2.apptareaopenshift.negocio.interfaces.FacultadRemoteEJB;
import co.edu.eam.ingesoft.pa2.apptareaopenshift.persistencia.modelo.entidades.Asignatura;

@LocalBean
@Stateless
@Remote(AsignaturaRemoteEJB.class)
public class AsignaturaEJB extends EJBGenerico<Asignatura> implements AsignaturaRemoteEJB{

	
	public void crear(Asignatura a) throws ExcepcionNegocio {
		if (buscar(a.getIdAsignatura()) != null) {
			throw new ExcepcionNegocio("El programa ya se encuentra registrado");
		} else {
			dao.crear(a);
		}
	}
	
	public Asignatura buscar(Object pk) {
		return dao.buscar(pk);
	}
	
	@Override
	public Class getClase() {
		// TODO Auto-generated method stub
		return Asignatura.class;
	}

}
