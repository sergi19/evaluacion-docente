package co.edu.eam.ingesoft.pa2.apptareaopenshift.negocio.interfaces;

import java.util.List;

import co.edu.eam.ingesoft.pa2.apptareaopenshift.persistencia.modelo.entidades.Pregunta;

public interface PreguntaRemoteEJB extends InterfaceEJBGenerica<Pregunta>{

	public List<Pregunta> listarPreguntas();
}
