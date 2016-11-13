package pojo;

import peticiones.CodigoPeticion;

public class POJORegistrar {
	
	private String datosEnviable,
					respuesta;
	
	public POJORegistrar(String nombre, String password, String nick, String pregSecreta, String respSecreta) {
		this.datosEnviable = CodigoPeticion.REGISTRAR
							+ ";"
							+ nombre
							+ ";"
							+ password
							+ ";"
							+ nick
							+ ";"
							+ pregSecreta
							+ ";"
							+ respSecreta
							+ ";";					
	}
	
	public String getDatosEnviable() {
		return this.datosEnviable;
	}
	
	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}
	
	public String getRespuesta() {
		return this.respuesta;
	}
}