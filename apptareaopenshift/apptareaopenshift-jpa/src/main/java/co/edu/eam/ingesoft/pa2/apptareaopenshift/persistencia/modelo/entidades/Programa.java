/**
 * 
 */
package co.edu.eam.ingesoft.pa2.apptareaopenshift.persistencia.modelo.entidades;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * @author Alejandro
 *
 */
@Entity
@Table(name = "Programas")
@NamedQueries({
	@NamedQuery(name = Programa.LISTAR_PROGRAMAS, query = "SELECT p FROM Programa p")})
public class Programa implements Serializable {

	public static final String LISTAR_PROGRAMAS = "Programa.listarProgramas";
	@Id
	@Column(name = "idPrograma")
	private String idPrograma;
	
	@Column(name = "nombrePrograma")
	private String nombrePrograma;
	
	@ManyToOne
	@JoinColumn(name = "idFacultad")
	private Facultad idFacultad;

	// Constructor vacio
	public Programa() {
		super();
	}

	/**
	 * @param idPrograma
	 * @param nombrePrograma
	 * @param idFacultad
	 */
	public Programa(String idPrograma, String nombrePrograma, Facultad idFacultad) {
		super();
		this.idPrograma = idPrograma;
		this.nombrePrograma = nombrePrograma;
		this.idFacultad = idFacultad;
	}

	// Accesores y modificadores
	public String getIdPrograma() {
		return idPrograma;
	}

	public void setIdPrograma(String idPrograma) {
		this.idPrograma = idPrograma;
	}

	public String getNombrePrograma() {
		return nombrePrograma;
	}

	public void setNombrePrograma(String nombrePrograma) {
		this.nombrePrograma = nombrePrograma;
	}

	public Facultad getIdFacultad() {
		return idFacultad;
	}

	public void setIdFacultad(Facultad idFacultad) {
		this.idFacultad = idFacultad;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Programa) {
			Programa tmpPersona = (Programa) obj;
			if (this.nombrePrograma.equals(tmpPersona.nombrePrograma) && this.idPrograma.equals(tmpPersona.idPrograma)) {
				return true;
			} else {
				return false;
			}

		} else {
			return false;
		}
	}

}
