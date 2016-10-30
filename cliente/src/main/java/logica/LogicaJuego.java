package logica;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.concurrent.TimeUnit;
import javax.swing.JOptionPane;

import com.google.gson.Gson;

import entidades.Jugador;
import enums.TipoEventoEnum;

public class LogicaJuego {


	private Socket miSocket;
	protected boolean conectado;

	protected ObjectOutputStream bufferSalidaObj;
	protected ObjectInputStream bufferEntradaObj;


	protected String login = "ERR";
	protected String registro = "ERR";
	private String usuario;
	protected String tipo;

	public LogicaJuego() {
		
	}

	public void conexion(String ip, int port, String usuario, String password, String accion) {

		try {
			// Creo socket para conectarme con el server
			miSocket = new Socket(ip, port);
			conectado = true;
			// Creo stream de entrada y salida para objetos
			bufferSalidaObj = new ObjectOutputStream(miSocket.getOutputStream());
			bufferEntradaObj = new ObjectInputStream(miSocket.getInputStream());
			if (accion.equals("LOGIN")) {
				login(usuario, password);
			} else {
				registro(usuario, password);
			}
			while (conectado) {
				Object obj = bufferEntradaObj.readObject();
				if(obj != null) {
					String aux = (String) obj;
					String[] datos = new String[2];
					datos = aux.split(" ");
					if (datos[0].equals("REGISTRO")) {
						if (datos[1].equals("NO")) {
							conectado = false;
						}
						this.registro = datos[1];
					}
				}
				Thread.sleep(4);
			}
		} catch (UnknownHostException e) {
			this.login = "ERR";
			JOptionPane.showMessageDialog(null, "Ip incorrecta");
		} catch (IOException e) {
			this.login = "ERR";
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public String getTipo() {
		return tipo;
	}

	
	public String getRegistro() {
		return registro;
	}

	

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getLogin() {
		return this.login;
	}

	

	public void setConectado(boolean conectado) {
		this.conectado = conectado;
	}

	public void inicio() {
		try {
			tipo = "";
			bufferSalidaObj.reset();
			bufferSalidaObj.writeObject("INICIO");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}






	public void login(String usuario, String password) {
		try {
			this.usuario = usuario;
			tipo = "LOGIN";
			String aux = "LOGIN " + usuario + " " + password;
			bufferSalidaObj.reset();
			bufferSalidaObj.writeObject(aux);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void registro(String usuario, String password) {
		try {
		Gson gson = new Gson();
		Jugador jugador = new Jugador(TipoEventoEnum.REGISTRAR_USUARIO.ordinal(), usuario, password);
		bufferSalidaObj.reset();
		bufferSalidaObj.writeObject(gson.toJson(jugador));			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}






	

	public void salir() {
		try {
			bufferSalidaObj.reset();
			bufferSalidaObj.writeObject("SALIR " + usuario);
			TimeUnit.MILLISECONDS.sleep(3);
			bufferSalidaObj.close();
			bufferEntradaObj.close();
			miSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
