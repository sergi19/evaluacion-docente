/**
 * 
 */
package co.edu.eam.ingesoft.pa2.apptareaopenshift.persistencia.modelo.entidades;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author Alejandro
 *
 */
@Entity
@Table(name = "SuperAdmin")
public class SuperAdmin extends Usuario implements Serializable {

	// Constructor
	public SuperAdmin(String nombre, String apellido, String user, String password, int idUsuario) {
		super(idUsuario, nombre, apellido, user, password);

	}

	public SuperAdmin() {
		super();
	}
	// Metodos accesores

}
