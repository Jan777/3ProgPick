package pojo;

import peticiones.CodigoPeticion;

public class POJOLogin {

	private String datosEnviable, respuesta;
	
	public POJOLogin(String usuario, String contrasenia) {
		datosEnviable = CodigoPeticion.LOGEO
				+ ";"
				+ usuario
				+ ";"
				+ contrasenia
				+ ";";
		//this.respuesta = "--.--";
	}

	public String getDatosEnviable() {
		return datosEnviable;
	}

	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}

	public String getRespuesta() {
		return respuesta;
	}
}
