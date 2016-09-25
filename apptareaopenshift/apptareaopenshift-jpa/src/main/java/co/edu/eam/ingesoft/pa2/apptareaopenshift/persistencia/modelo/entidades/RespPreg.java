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
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Alejandro
 *
 */
@Entity
@Table(name = "RespuestasPreg")
@IdClass(value=ResPregPK.class)
public class RespPreg implements Serializable {


	@Id
	@ManyToOne
	@JoinColumn(name = "idRespuesta")
	private Respuesta idRespuesta;

	@Id
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="idPregunta",referencedColumnName="idPregunta"),
		@JoinColumn(name="idEvaluacion",referencedColumnName="idEvaluacion")
	})
	private PregEval idPregEval;
	
	@Column(name = "calificacion")
	private double calificacion;

	// Constructor vacio
	public RespPreg() {
		super();
	}

	// Constructor
	public RespPreg(Respuesta idRespuesta, double calificacion) {
		super();
		this.idRespuesta = idRespuesta;
		this.calificacion = calificacion;
	}

	// Accesores y modificadores

	public Respuesta getIdRespuesta() {
		return idRespuesta;
	}

	public void setIdRespuesta(Respuesta idRespuesta) {
		this.idRespuesta = idRespuesta;
	}

	public double getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(double calificacion) {
		this.calificacion = calificacion;
	}
}
