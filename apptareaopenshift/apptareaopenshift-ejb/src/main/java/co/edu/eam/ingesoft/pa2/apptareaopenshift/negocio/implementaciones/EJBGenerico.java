package co.edu.eam.ingesoft.pa2.apptareaopenshift.negocio.implementaciones;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import co.edu.eam.ingesoft.pa2.apptareaopenshift.persistencia.modelo.dao.DAOGenerico;

public abstract class EJBGenerico<T> {

	@PersistenceContext
	private EntityManager em;
	
	protected DAOGenerico dao;
	
	
	
	@PostConstruct
	public void inicializar(){
		dao=new DAOGenerico(em, getClase());
	}
	
	public void editar(T entidad){
		dao.editar(entidad);
	}
	
	/**
	 * 
	 * @param pk
	 * @return
	 */
	public T buscar(Object pk){
		return dao.buscar(pk);
	}
	
	public void eliminar(T entidad){
		dao.borrar(entidad);
	}
	
	public void crear(T entidad) {
		dao.crear(entidad);
	}
	
	public abstract Class getClase();
	
}
