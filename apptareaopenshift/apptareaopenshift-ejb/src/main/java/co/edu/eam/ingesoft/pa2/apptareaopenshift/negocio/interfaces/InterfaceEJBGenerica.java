package co.edu.eam.ingesoft.pa2.apptareaopenshift.negocio.interfaces;


public interface InterfaceEJBGenerica<T> {

	
	public void editar(T entidad);

	
	public T buscar(Object pk);

	
	public void eliminar(T entidad);


	public void crear(T entidad);
}
