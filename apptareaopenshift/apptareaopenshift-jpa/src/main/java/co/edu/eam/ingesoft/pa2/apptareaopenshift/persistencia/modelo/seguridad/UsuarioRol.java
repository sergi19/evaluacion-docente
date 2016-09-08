package  co.edu.eam.ingesoft.pa2.apptareaopenshift.persistencia.modelo.seguridad;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import co.edu.eam.ingesoft.pa2.apptareaopenshift.persistencia.modelo.entidades.Usuario;

@Entity
@Table(name="Usuariorol")
@IdClass(value= UsuarioRolPK.class)
public class UsuarioRol implements Serializable {

	@Id
	@ManyToOne
	private Usuario usuario;
	
	@Id
	@ManyToOne
	private Rol rol;

	public UsuarioRol() {
	}
	
	public UsuarioRol(Usuario usuario, Rol rol) {
		super();
		this.usuario = usuario;
		this.rol = rol;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}
	
	
	
	
	
}
