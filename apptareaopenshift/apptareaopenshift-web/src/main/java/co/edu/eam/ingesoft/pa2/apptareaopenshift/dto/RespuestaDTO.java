package co.edu.eam.ingesoft.pa2.apptareaopenshift.dto;



public class RespuestaDTO {

	private Object obj;
	
	private String mensaje;
	
	private String codigo;

	public RespuestaDTO() {
		
	}

	public RespuestaDTO(Object obj) {
		super();
		this.obj = obj;
		mensaje = "Se ejecuto correctamente";
		codigo = "00";
	}

	public RespuestaDTO(Object obj, String mensaje, String codigo) {
		super();
		this.obj = obj;
		this.mensaje = mensaje;
		this.codigo = codigo;
	}

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	
	
	
	
}
