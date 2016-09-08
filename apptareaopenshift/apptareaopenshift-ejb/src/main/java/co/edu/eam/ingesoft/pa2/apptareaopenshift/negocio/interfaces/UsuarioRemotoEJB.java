package co.edu.eam.ingesoft.pa2.apptareaopenshift.negocio.interfaces;

import java.util.List;

import co.edu.eam.ingesoft.pa2.apptareaopenshift.persistencia.modelo.entidades.Programa;
import co.edu.eam.ingesoft.pa2.apptareaopenshift.persistencia.modelo.entidades.Usuario;

public interface UsuarioRemotoEJB extends InterfaceEJBGenerica<Usuario>{

	public List<Usuario> buscarUsuarioPorNameUser(String nombreUsuario);
}
