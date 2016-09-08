/**
 * 
 */
package co.edu.eam.ingesoft.pa2.apptareaopenshift.persistencia.modelo.entidades;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * @author Alejandro
 *
 */
@Entity
@Table(name = "Facultades")
@NamedQueries({
	@NamedQuery(name = Facultad.LISTAR_FACULTADES, query = "SELECT f FROM Facultad f")})
public class Facultad implements Serializable {
	
	public static final String LISTAR_FACULTADES = "Facultad.listarFacultades";
	
	@Id
	@Column(name = "idFacultad")
	public String idFacultad;
	
	@Column(name = "nombre")
	public String nombre;

	// Constructor vacio
	public Facultad() {
		super();
	}

	// Constructor
	public Facultad(String idFacultad, String nombre) {
		super();
		this.idFacultad = idFacultad;
		this.nombre = nombre;
	}

	// Accesores y modificadores
	public String getIdFacultad() {
		return idFacultad;
	}

	public void setIdFacultad(String idFacultad) {
		this.idFacultad = idFacultad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Facultad) {
			Facultad tmpPersona = (Facultad) obj;
			if (this.nombre.equals(tmpPersona.nombre) && this.idFacultad.equals(tmpPersona.idFacultad)) {
				return true;
			} else {
				return false;
			}

		} else {
			return false;
		}
	}

}
