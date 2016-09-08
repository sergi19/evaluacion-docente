package co.edu.eam.ingesoft.pa2.apptareaopenshift.web.convertidores;

import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;

import co.edu.eam.ingesoft.pa2.apptareaopenshift.negocio.implementaciones.FacultadEJB;
import co.edu.eam.ingesoft.pa2.apptareaopenshift.persistencia.modelo.entidades.Facultad;

@Named
@FacesConverter(value="convertidorFacultad", forClass = Facultad.class)
public class ConvertidorFacultad implements Converter{

	@EJB
	private FacultadEJB facultadEJB;
	
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String string) {
		// TODO Auto-generated method stub
		if(string==null || string.trim().length()==0 || string.equals("Seleccione una opcion")){
			return null;
		}
		
		/*Integer idfacultad = Integer.valueOf(string);
		Facultad facultad = facultadEJB.buscar(idfacultad);
		return facultad;*/
		
		String idfacultad = string;
		Facultad facultad = facultadEJB.buscar(idfacultad);
		return facultad;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		// TODO Auto-generated method stub
		if(arg2 instanceof Facultad){
			Facultad f = (Facultad)arg2;
			return String.valueOf(f.getIdFacultad());
		}
		
		return null;
	}

}
