package pojo;

import peticiones.CodigoPeticion;
import peticiones.Peticion;

public class POJORegistrar {
	
	private String datosEnviable,
					respuesta;
	
	public POJORegistrar(String nombre, String password, String nick, String pregSecreta, String respSecreta) {
		this.datosEnviable = CodigoPeticion.REGISTRAR
							+ Peticion.CARACTER_SEPARACION
							+ nombre
							+ Peticion.CARACTER_SEPARACION
							+ password
							+ Peticion.CARACTER_SEPARACION
							+ nick
							+ Peticion.CARACTER_SEPARACION
							+ pregSecreta
							+ Peticion.CARACTER_SEPARACION
							+ respSecreta
							+ Peticion.CARACTER_SEPARACION;					
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