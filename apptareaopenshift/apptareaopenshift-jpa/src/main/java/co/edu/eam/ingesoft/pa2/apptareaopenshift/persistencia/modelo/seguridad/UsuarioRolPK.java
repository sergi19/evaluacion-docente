package  co.edu.eam.ingesoft.pa2.apptareaopenshift.persistencia.modelo.seguridad;

import java.io.Serializable;

public class UsuarioRolPK implements Serializable {

	private int usuario;

	private Long rol;

	public UsuarioRolPK() {
	}

	public UsuarioRolPK(int usuario, long rol) {
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

	public long getRol() {
		return rol;
	}

	public void setRol(long rol) {
		this.rol = rol;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((rol == null) ? 0 : rol.hashCode());
		result = prime * result + usuario;
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
		if (rol == null) {
			if (other.rol != null)
				return false;
		} else if (!rol.equals(other.rol))
			return false;
		if (usuario != other.usuario)
			return false;
		return true;
	}

	
	
}
