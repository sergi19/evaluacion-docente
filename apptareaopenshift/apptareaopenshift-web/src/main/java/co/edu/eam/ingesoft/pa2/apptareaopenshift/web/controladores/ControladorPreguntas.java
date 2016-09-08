package co.edu.eam.ingesoft.pa2.apptareaopenshift.web.controladores;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import org.omnifaces.cdi.ViewScoped;

import co.edu.eam.ingesoft.pa2.apptareaopenshift.negocio.implementaciones.PreguntaEJB;
import co.edu.eam.ingesoft.pa2.apptareaopenshift.persistencia.modelo.entidades.Pregunta;

@Named("preguntaWeb")
@ViewScoped
public class ControladorPreguntas implements Serializable{

	@EJB
	private PreguntaEJB preguntaEJB;
	
	private int id;
	
	private String texto;
	
	private double valor;
	
	public void crear(){
		if(valor<101){
			Pregunta p = new Pregunta(id, texto, valor);
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Pregunta registrada con exito",  null);
			FacesContext.getCurrentInstance().addMessage(null, message);
			preguntaEJB.crear(p);
		}else{
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El valor debe ser menor a 100",  null);
			FacesContext.getCurrentInstance().addMessage(null, message);    
		}
		
	}

	public PreguntaEJB getPreguntaEJB() {
		return preguntaEJB;
	}

	public void setPreguntaEJB(PreguntaEJB preguntaEJB) {
		this.preguntaEJB = preguntaEJB;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
