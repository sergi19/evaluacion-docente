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

import co.edu.eam.ingesoft.pa2.apptareaopenshift.negocio.implementaciones.FacultadEJB;
import co.edu.eam.ingesoft.pa2.apptareaopenshift.negocio.implementaciones.ProgramaEJB;
import co.edu.eam.ingesoft.pa2.apptareaopenshift.persistencia.modelo.entidades.Facultad;
import co.edu.eam.ingesoft.pa2.apptareaopenshift.persistencia.modelo.entidades.Programa;

@RunWith(Arquillian.class)
public class PruebaProgramas {

		@EJB
		private ProgramaEJB programaEJB;
		@EJB
		private FacultadEJB facultadEJB;
		
		@Deployment
		public static EnterpriseArchive desplegar(){
			 
			EnterpriseArchive ear= ArquillianUtil.createDeployment("../apptareaopenshift-ear/target/apptareaopenshift-ear.ear");
			ear.addAsLibraries(ShrinkWrap.create(JavaArchive.class).addClass(PruebaProgramas.class));
			return ear;
			
		}
		
		@Test
		public void testCrearPrograma(){
			System.out.println("se entra al metodo");
			Programa p = new Programa();
			
		    p.setIdPrograma("5");
		    p.setNombrePrograma("probando");
		    Facultad fa = facultadEJB.buscar("1");
		    p.setIdFacultad(fa);
			programaEJB.crear(p);
			
			Programa pre = programaEJB.buscar(p.getIdPrograma());
			Assert.assertEquals("probando", pre.getNombrePrograma());
		}
		
		@AfterClass
		public static void finPrueba(){
			System.out.println("saliendo");
			TestDataUtil.ejecutarSQL("sqltest/Prueba-del.sql");
		
		}
	
	
}
