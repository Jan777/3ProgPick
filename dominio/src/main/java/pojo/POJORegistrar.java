package pojo;

import constantes.Mensaje;

public class POJORegistrar extends POJOMensaje {

	private String nombre, password, nick, pregSecreta, respSecreta;
	
	
	public POJORegistrar(String nombre, String password, String nick, String pregSecreta, String respSecreta) {			
		this.nombre = nombre;
		this.password = password;
		this.nick = nick;
		this.pregSecreta = pregSecreta;
		this.respSecreta = respSecreta;
		this.codigo = Mensaje.REGISTRAR;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getPregSecreta() {
		return pregSecreta;
	}

	public void setPregSecreta(String pregSecreta) {
		this.pregSecreta = pregSecreta;
	}

	public String getRespSecreta() {
		return respSecreta;
	}

	public void setRespSecreta(String respSecreta) {
		this.respSecreta = respSecreta;
	}
}