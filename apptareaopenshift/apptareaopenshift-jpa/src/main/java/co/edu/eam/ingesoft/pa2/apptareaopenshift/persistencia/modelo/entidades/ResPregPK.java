package co.edu.eam.ingesoft.pa2.apptareaopenshift.persistencia.modelo.entidades;

import java.io.Serializable;

public class ResPregPK implements Serializable {

	
	private int idRespuesta;
	
	private PregEvalPK idPregEval;

	public ResPregPK(int idRespuesta, PregEvalPK idPregEval) {
		super();
		this.idRespuesta = idRespuesta;
		this.idPregEval = idPregEval;
	}
	
	public ResPregPK() {
		
	}

	public int getIdRespuesta() {
		return idRespuesta;
	}

	public void setIdRespuesta(int idRespuesta) {
		this.idRespuesta = idRespuesta;
	}

	public PregEvalPK getIdPregEval() {
		return idPregEval;
	}

	public void setIdPregEval(PregEvalPK idPregEval) {
		this.idPregEval = idPregEval;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idPregEval == null) ? 0 : idPregEval.hashCode());
		result = prime * result + idRespuesta;
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
		ResPregPK other = (ResPregPK) obj;
		if (idPregEval == null) {
			if (other.idPregEval != null)
				return false;
		} else if (!idPregEval.equals(other.idPregEval))
			return false;
		if (idRespuesta != other.idRespuesta)
			return false;
		return true;
	}
	
	
	
	
	
}
