package test;

import javax.ejb.EJB;

import org.caferrer.testdata.junit.ArquillianUtil;
import org.caferrer.testdata.junit.TestDataUtil;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.EnterpriseArchive;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import co.edu.eam.ingesoft.pa2.apptareaopenshift.negocio.implementaciones.AsignaturaEJB;
import co.edu.eam.ingesoft.pa2.apptareaopenshift.negocio.implementaciones.FacultadEJB;
import co.edu.eam.ingesoft.pa2.apptareaopenshift.negocio.implementaciones.ProgramaEJB;
import co.edu.eam.ingesoft.pa2.apptareaopenshift.negocio.implementaciones.WebServicesEJB;
import co.edu.eam.ingesoft.pa2.apptareaopenshift.persistencia.modelo.entidades.Asignatura;
import co.edu.eam.ingesoft.pa2.apptareaopenshift.persistencia.modelo.entidades.Facultad;
import co.edu.eam.ingesoft.pa2.apptareaopenshift.persistencia.modelo.entidades.Programa;

@RunWith(Arquillian.class)
public class PruebaAsignatura {
	
	@EJB
	private WebServicesEJB webServicesEJB;
	

	@Deployment
	public static EnterpriseArchive desplegar(){
		 
		EnterpriseArchive ear= ArquillianUtil.createDeployment("../apptareaopenshift-ear/target/apptareaopenshift-ear.ear");
		ear.addAsLibraries(ShrinkWrap.create(JavaArchive.class).addClass(PruebaAsignatura.class));
		return ear;
		
	}
	
	@Test
	public void buscar(){
		Assert.assertTrue(webServicesEJB.buscarEstudiante("123", "123"));
	}
	
	@Test
	public void crearAsignatura(){
		boolean metodo = webServicesEJB.listarCursosEstudiante("123", "123");	
		Assert.assertTrue(metodo);
	}
	
	
}
