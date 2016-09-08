package  co.edu.eam.ingesoft.pa2.apptareaopenshift.persistencia.modelo.seguridad;

import java.io.Serializable;

public class UsuarioRolPK implements Serializable {

	private int usuario;

	private int rol;

	public UsuarioRolPK() {
	}

	public UsuarioRolPK(int usuario, int rol) {
		super();
		this.usuario = usuario;
		this.rol = rol;
	}

	public int getUsuario() {
		return usuario;
	}

	public void setUsuario(int usuario) {
		this.usuario = usuario;
	}

	public int getRol() {
		return rol;
	}

	public void setRol(int rol) {
		this.rol = rol;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + rol;
		result = prime * result + usuario;
//		result = prime * result + ((rol == null) ? 0 : rol.hashCode());
//		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UsuarioRolPK other = (UsuarioRolPK) obj;
		if (rol != other.rol)
			return false;
		if (usuario != other.usuario)
			return false;
//		if (rol == null) {
//			if (other.rol != null)
//				return false;
//		} else if (!rol.equals(other.rol))
//			return false;
//		if (usuario == null) {
//			if (other.usuario != null)
//				return false;
//		} else if (!usuario.equals(other.usuario))
//			return false;
		return true;
	}
	
}
