package co.edu.eam.ingesoft.pa2.apptareaopenshift.negocio.implementaciones;

import java.io.Serializable;

import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import co.edu.eam.ingesoft.pa2.apptareaopenshift.negocio.interfaces.DocenteRemoteEJB;
import co.edu.eam.ingesoft.pa2.apptareaopenshift.negocio.interfaces.FacultadRemoteEJB;
import co.edu.eam.ingesoft.pa2.apptareaopenshift.negocio.interfaces.ProgramaRemoteEJB;
import co.edu.eam.ingesoft.pa2.apptareaopenshift.persistencia.modelo.entidades.Docente;
import co.edu.eam.ingesoft.pa2.apptareaopenshift.persistencia.modelo.entidades.Programa;

@LocalBean
@Stateless
@Remote(DocenteRemoteEJB.class)
public class DocenteEJB extends EJBGenerico<Docente> implements DocenteRemoteEJB{

	@Override
	public Class getClase() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void editar(Docente entidad) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Docente buscar(Object pk) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminar(Docente entidad) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void crear(Docente entidad) {
		// TODO Auto-generated method stub
		
	}

}
