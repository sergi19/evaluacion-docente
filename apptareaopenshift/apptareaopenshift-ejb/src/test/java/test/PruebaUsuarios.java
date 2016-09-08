package test;


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
import co.edu.eam.ingesoft.pa2.apptareaopenshift.negocio.implementaciones.UsuarioEJB;
import co.edu.eam.ingesoft.pa2.apptareaopenshift.persistencia.modelo.entidades.Usuario;


@RunWith(Arquillian.class)
public class PruebaUsuarios {

	@EJB
    private UsuarioEJB usuarioEJB;
	
	@Deployment
	public static EnterpriseArchive desplegar(){
		EnterpriseArchive ear = ArquillianUtil.createDeployment("../apptareaopenshift-ear/target/apptareaopenshift-ear.ear");
		ear.addAsLibraries(ShrinkWrap.create(JavaArchive.class).addClass(PruebaUsuarios.class));
		return ear;
	}
	
	
	@Test
	public void crearUsuario(){
		Usuario usu = new Usuario();
		usu.setId(123452014);
		usu.setNombre("Camilo");
		usu.setApellido("Ferrer");
		usu.setUser("caferrerb");
		usu.setPassword("81dc9bdb52d04dc20036dbd8313ed055");
		
		usuarioEJB.crear(usu);
		
		Usuario usuario = usuarioEJB.buscar(1234);
		Assert.assertNotNull(usuario);		
	}
	
}
