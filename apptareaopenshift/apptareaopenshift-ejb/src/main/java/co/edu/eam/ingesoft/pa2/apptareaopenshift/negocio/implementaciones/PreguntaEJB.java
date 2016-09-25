package co.edu.eam.ingesoft.pa2.apptareaopenshift.negocio.implementaciones;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import co.edu.eam.ingesoft.pa2.apptareaopenshift.negocio.interfaces.PreguntaRemoteEJB;
import co.edu.eam.ingesoft.pa2.apptareaopenshift.persistencia.modelo.entidades.Pregunta;

@LocalBean
@Stateless
public class PreguntaEJB extends EJBGenerico<Pregunta> implements PreguntaRemoteEJB{
	@Override
	public Class getClase() {
		// TODO Auto-generated method stub
		return Pregunta.class;
	}

	@Override
	public List<Pregunta> listarPreguntas() {
		return dao.ejecutarNamedQuery(Pregunta.LISTAR_PREGUNTAS);
	}

	
}
