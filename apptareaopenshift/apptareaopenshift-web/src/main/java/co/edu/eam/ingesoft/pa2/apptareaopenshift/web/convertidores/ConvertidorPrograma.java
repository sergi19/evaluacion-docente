package co.edu.eam.ingesoft.pa2.apptareaopenshift.web.convertidores;

import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;

import co.edu.eam.ingesoft.pa2.apptareaopenshift.negocio.implementaciones.ProgramaEJB;
import co.edu.eam.ingesoft.pa2.apptareaopenshift.persistencia.modelo.entidades.Facultad;
import co.edu.eam.ingesoft.pa2.apptareaopenshift.persistencia.modelo.entidades.Programa;

@Named
@FacesConverter(value="convertidorPrograma", forClass=Programa.class)
public class ConvertidorPrograma implements Converter{

	@EJB
	private ProgramaEJB programaEJB;
	
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String string) {
		// TODO Auto-generated method stub
		if(string==null || string.trim().length()==0 || string.equals("Seleccione una opcion")){
			return null;
		}
		
		String idprograma = string;
		Programa programa = programaEJB.buscar(idprograma);
		return programa;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		// TODO Auto-generated method stub
		if(arg2 instanceof Programa){
			Programa p = (Programa)arg2;
			return String.valueOf(p.getIdPrograma());
		}	
		return null;
	}

}
