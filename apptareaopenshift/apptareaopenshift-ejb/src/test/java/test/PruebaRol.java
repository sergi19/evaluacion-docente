package test;

import java.util.List;

import javax.ejb.EJB;

import org.caferrer.testdata.junit.ArquillianUtil;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.EnterpriseArchive;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import co.edu.eam.ingesoft.pa2.apptareaopenshift.negocio.implementaciones.SeguridadEJB;
import co.edu.eam.ingesoft.pa2.apptareaopenshift.negocio.implementaciones.UsuarioEJB;
import co.edu.eam.ingesoft.pa2.apptareaopenshift.persistencia.modelo.entidades.Usuario;
import co.edu.eam.ingesoft.pa2.apptareaopenshift.persistencia.modelo.seguridad.Rol;



@RunWith(Arquillian.class)
public class PruebaRol {

	
	@EJB
	private SeguridadEJB seguridadEJB;
	
	@EJB
	private UsuarioEJB usuarioEJB;
	
	
	@Deployment
	public static EnterpriseArchive desplegar(){
		 
		EnterpriseArchive ear= ArquillianUtil.createDeployment("../apptareaopenshift-ear/target/apptareaopenshift-ear.ear");
		ear.addAsLibraries(ShrinkWrap.create(JavaArchive.class).addClass(PruebaRol.class));
		return ear;
	}
	
	
	@Test
	public void rolesTest(){
		Usuario u = usuarioEJB.buscarUsuarioPorNameUser("admin").get(0);
		List<Rol> listaRoles = seguridadEJB.listarRolesUsuario(u);
		Assert.assertEquals(1,listaRoles.size());
	}
	
}
