package pojo;

import constantes.Mensaje;

public class POJOLogin extends POJOMensaje {

	private String user, pass;

	public POJOLogin(String usuario, String contrasenia) {
		this.user = usuario;
		this.pass = contrasenia;
		this.codigo = Mensaje.LOGEO;
	}
	
	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
}
