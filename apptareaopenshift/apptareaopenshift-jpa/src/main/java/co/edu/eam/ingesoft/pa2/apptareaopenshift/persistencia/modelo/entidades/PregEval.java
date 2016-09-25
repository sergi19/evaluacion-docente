/**
 * 
 */
package co.edu.eam.ingesoft.pa2.apptareaopenshift.persistencia.modelo.entidades;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "PreguntasEval")
@IdClass(value=PregEvalPK.class)
public class PregEval implements Serializable {
	

	@Id
	@ManyToOne
	@JoinColumn(name = "idPregunta")
	private Pregunta idPregunta;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "idEvaluacion")
	private Evaluacion idEvaluacion;

	// Constructor vacio
	public PregEval() {
		super();
	}

	// Constructor
	public PregEval(Pregunta idPregunta, Evaluacion idEvaluacion) {
		super();
		this.idPregunta = idPregunta;
		this.idEvaluacion = idEvaluacion;
	}

	// Accesores y modificadores
	public Pregunta getIdPregunta() {
		return idPregunta;
	}

	public void setIdPregunta(Pregunta idPregunta) {
		this.idPregunta = idPregunta;
	}

	public Evaluacion getIdEvaluacion() {
		return idEvaluacion;
	}

	public void setIdEvaluacion(Evaluacion idEvaluacion) {
		this.idEvaluacion = idEvaluacion;
	}

}
