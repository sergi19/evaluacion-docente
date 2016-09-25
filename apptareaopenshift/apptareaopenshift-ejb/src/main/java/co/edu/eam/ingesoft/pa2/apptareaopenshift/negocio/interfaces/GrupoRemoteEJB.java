package co.edu.eam.ingesoft.pa2.apptareaopenshift.negocio.interfaces;

import java.util.List;

import co.edu.eam.ingesoft.pa2.apptareaopenshift.persistencia.modelo.entidades.Facultad;
import co.edu.eam.ingesoft.pa2.apptareaopenshift.persistencia.modelo.entidades.Grupo;

public interface GrupoRemoteEJB extends InterfaceEJBGenerica<Grupo>{

	
	public List<Grupo> listarGrupos();
}
