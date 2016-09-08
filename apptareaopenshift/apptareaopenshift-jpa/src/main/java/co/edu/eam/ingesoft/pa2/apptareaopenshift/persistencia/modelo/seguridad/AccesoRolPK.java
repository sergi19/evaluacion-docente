package  co.edu.eam.ingesoft.pa2.apptareaopenshift.persistencia.modelo.seguridad;

import java.io.Serializable;

public class AccesoRolPK implements Serializable {

	private int acceso;
	
	private int rol;

	public AccesoRolPK() {
	}

	public AccesoRolPK(int acceso, int rol) {
		super();
		this.acceso = acceso;
		this.rol = rol;
	}

	public int getAcceso() {
		return acceso;
	}

	public void setAcceso(int acceso) {
		this.acceso = acceso;
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
//		result = prime * result + ((acceso == null) ? 0 : acceso.hashCode());
//		result = prime * result + ((rol == null) ? 0 : rol.hashCode());
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
		AccesoRolPK other = (AccesoRolPK) obj;
		if (acceso != other.acceso)
			return false;
		if (rol != other.rol)
			return false;
//		if (acceso == null) {
//			if (other.acceso != null)
//				return false;
//		} else if (!acceso.equals(other.acceso))
//			return false;
//		if (rol == null) {
//			if (other.rol != null)
//				return false;
//		} else if (!rol.equals(other.rol))
//			return false;
		return true;
	}
	
}
