package co.edu.eam.ingesoft.pa2.apptareaopenshift.negocio.implementaciones;


import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import co.edu.eam.ingesoft.pa2.apptareaopenshift.negocio.excepciones.ExcepcionNegocio;
import co.edu.eam.ingesoft.pa2.apptareaopenshift.negocio.interfaces.UsuarioRemotoEJB;
import co.edu.eam.ingesoft.pa2.apptareaopenshift.persistencia.modelo.entidades.Usuario;

@LocalBean
@Stateless
@Remote(UsuarioRemotoEJB.class)
public class UsuarioEJB extends EJBGenerico<Usuario> implements UsuarioRemotoEJB {

	@Override
	public Class getClase() {
		// TODO Auto-generated method stub
		return Usuario.class;
	}

	public void crear(Usuario usuario) throws ExcepcionNegocio {
		if (buscar(usuario.getId()) != null) {
			throw new ExcepcionNegocio("El usuario ya se encuentra registrado");
		} else {
			dao.crear(usuario);
		}
	}

	public Usuario buscar(Object pk) {
		return dao.buscar(pk);
	}

	@Override
	public List<Usuario> buscarUsuarioPorNameUser(String nombreUsuario) {
		return dao.ejecutarNamedQuery(Usuario.BUSCAR_USUARIO_POR_USER, nombreUsuario);
	}
}
