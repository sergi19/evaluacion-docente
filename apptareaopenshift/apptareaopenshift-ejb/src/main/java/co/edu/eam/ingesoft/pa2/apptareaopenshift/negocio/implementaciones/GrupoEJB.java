package co.edu.eam.ingesoft.pa2.apptareaopenshift.negocio.implementaciones;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import co.edu.eam.ingesoft.pa2.apptareaopenshift.negocio.interfaces.GrupoRemoteEJB;
import co.edu.eam.ingesoft.pa2.apptareaopenshift.persistencia.modelo.entidades.Grupo;

@LocalBean
@Stateless
@Remote(GrupoRemoteEJB.class)
public class GrupoEJB extends EJBGenerico<Grupo> implements GrupoRemoteEJB{


	@Override
	public List<Grupo> listarGrupos() {
		return dao.ejecutarNamedQuery(Grupo.LISTAR_GRUPOS);
	}

	@Override
	public Class getClase() {
		// TODO Auto-generated method stub
		return Grupo.class;
	}

}
