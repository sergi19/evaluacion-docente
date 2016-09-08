package  co.edu.eam.ingesoft.pa2.apptareaopenshift.persistencia.modelo.seguridad;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Acceso")
@NamedQueries({
	@NamedQuery(name=Acceso.LISTAR_ACCESOS_POR_ROL, query="SELECT acc FROM AccesoRol acrol JOIN acrol.rol ro JOIN acrol.acceso acc WHERE acrol.rol IN ?1")
})
public class Acceso implements Serializable {

	public static final String LISTAR_ACCESOS_POR_ROL ="Acceso.listarPorRoles";
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "url")
	private String url;

	@Column(name = "nombre")
	private String nombre;

	/**
	 * constructor.
	 */
	public Acceso() {
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url
	 *            the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre
	 *            the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
