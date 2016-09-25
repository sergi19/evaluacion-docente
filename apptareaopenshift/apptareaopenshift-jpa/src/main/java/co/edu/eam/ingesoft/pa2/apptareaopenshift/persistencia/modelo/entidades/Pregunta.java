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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * @author Alejandro
 *
 */
@Entity
@Table(name = "Preguntas")
@NamedQueries({ @NamedQuery(name = Pregunta.LISTAR_PREGUNTAS, query = "SELECT p FROM Pregunta p")})
public class Pregunta implements Serializable {

	public static final String LISTAR_PREGUNTAS = "Pregunta.listarPreguntas";
	
	@Id
	@Column(name = "idPregunta")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPregunta;

	@Column(name = "texto")
	private String texto;

	@Column(name = "valor")
	private double valor;

	// Constructor vacio
	public Pregunta() {
		super();
	}

	// Constructor
	public Pregunta(int idPregunta, String texto, double valor) {
		super();
		this.idPregunta = idPregunta;
		this.texto = texto;
		this.valor = valor;
	}

	// Accesores y modificadores
	public int getIdPregunta() {
		return idPregunta;
	}

	public void setIdPregunta(int idPregunta) {
		this.idPregunta = idPregunta;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

}
