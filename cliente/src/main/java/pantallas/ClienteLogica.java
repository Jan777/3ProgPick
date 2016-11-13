package pantallas;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

import pojo.POJORegistrar;
import pojo.POJOLogin;
import peticiones.CodigoPeticion;



import pantallas.Cliente;

public class ClienteLogica extends Thread {
	
	public static final int PUERTO_POR_DEFECTO = 5000;
	private Socket socket;
	private DataInputStream in;
	private DataOutputStream out;
	
	private static String respuestaServer;
	private boolean estaConectado = false;
	private String nombreUsuario;
	private String nombrePartida;
	private int indiceUsuario;
	private int indicePartida;
	private int tipoDeCuenta;
	private int tipoDeJugador;
	private int fila, columna;
	private Cliente cliente;
	private boolean estaEnPartida = false;
	
	public int getIndiceUsuario() {
		return indiceUsuario;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public int getTipoDeJugador() {
		return tipoDeJugador;
	}

	public int getFila() {
		return fila;
	}

	public int getColumna() {
		return columna;
	}

	public int getTipoDeCuenta() {
		return tipoDeCuenta;
	}

	public ClienteLogica(String host){	
		try {
			socket = new Socket(host, ClienteLogica.PUERTO_POR_DEFECTO);
			in = new DataInputStream(socket.getInputStream());
			out = new DataOutputStream(socket.getOutputStream());
			estaConectado = true;
			indiceUsuario = -1;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean estaConectado() {
		return estaConectado;
	}

	public String getNombre() {
		return this.nombreUsuario;
	}

	@Override
	public void run() {
		try {
			while(true) {
				if(in != null) {
					respuestaServer = in.readUTF();
					System.out.println("SERVER: " + respuestaServer);
					sleep(1000);
				}
			}
		} catch (Exception e) {
			try {
				in.close();
				out.close();
				socket.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			e.printStackTrace();
		}
	}

	public int registrarse(String nombre, String pass, String nick, String pregSec, String respSecre) {
		try {
			POJORegistrar reg = new POJORegistrar(nombre, pass, nick, pregSec, respSecre);
			System.out.println(reg.getDatosEnviable());
			out.writeUTF(reg.getDatosEnviable());
			Thread.sleep(2000);
			reg.setRespuesta(respuestaServer);
			System.out.println(reg.getRespuesta());
			int codigoRespuesta = Integer.parseInt(reg.getRespuesta());
			return CodigoPeticion.REGISTRAR_CORRECTO;			
		} catch (Exception e) {
			System.out.println("Error registro");
		}
		return CodigoPeticion.REGISTRAR_INCORRECTO;
	}
	
	public int loguearse(String nombre, String pass) {
		try {
			POJOLogin login = new POJOLogin(nombre, pass);
			
			out.writeUTF(login.getDatosEnviable());
			
			sleep(1000);	
			login.setRespuesta(respuestaServer);			
			int codigoRespuesta = Integer.parseInt(login.getRespuesta());
			//System.out.println(codigoRespuesta+" "+CodigoPeticion.LOGEO_CORRECTO);
			switch (codigoRespuesta) {
				case CodigoPeticion.LOGEO_CORRECTO_USUARIO:
					this.nombreUsuario = nombre;
					this.tipoDeCuenta = CodigoPeticion.LOGEO_CORRECTO_USUARIO;
					return CodigoPeticion.LOGEO_CORRECTO_USUARIO;
				default:
					break;
			}
			
		} catch (Exception e) {
			System.out.println("Error logueo");
		}
		return CodigoPeticion.LOGEO_INCORRECTO;
	}
}
