package co.edu.eam.ingesoft.pa2.apptareaopenshift.persistencia.modelo.seguridad;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@NamedQueries({
		@NamedQuery(name = Rol.LISTA_ROLES_POR_USUARIOS, query = "SELECT ur.rol FROM UsuarioRol ur WHERE ur.usuario = ?1") })
public class Rol implements Serializable {

	public static final String LISTA_ROLES_POR_USUARIOS = "Rol.listar";

	@Id
	@SequenceGenerator(name = "rol_seq", sequenceName = "rol_seq", allocationSize = 1)
	private Long idRol;

	private String descripcion;

	public Rol(Long idRol, String descripcion) {
		super();
		this.idRol = idRol;
		this.descripcion = descripcion;
	}

	// Constructor vacio
	public Rol() {
		super();
	}

	// Accesores y modificadores
	public Long getIdRol() {
		return idRol;
	}

	public void setIdRol(Long idRol) {
		this.idRol = idRol;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
