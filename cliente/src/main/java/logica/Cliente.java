package logica;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Cliente extends JFrame {

	public static LogicaJuego juego;
	private String usuario;
	private String password;
	private String ip;
	private int puerto;
	private String accion;

	public Cliente(String usuario, String password, String ip,String puerto,String accion) {
		this.usuario = usuario;
		this.password = password;
		this.ip = ip;
		this.puerto = Integer.parseInt(puerto);
		this.accion = accion;
		conectar();
	}

	private void conectar() {
		// La conexión con el server se hace en otro thread
		Thread conexionThread = new Thread() {
			public void run() {
				juego = new LogicaJuego();
				juego.conexion(ip, puerto, usuario, password, accion);
			}
		};
		conexionThread.start();
	}

	public LogicaJuego getJuego() {
		return juego;
	}

	public String getUsuario() {
		return usuario;
	}

	public String getPassword() {
		return password;
	}

}
