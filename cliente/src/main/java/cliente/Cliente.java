package cliente;

import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import javax.swing.JOptionPane;
import com.google.gson.Gson;
import frames.*;
import juego.Juego;
import mensajeria.Comando;
import mensajeria.Paquete;
import mensajeria.PaquetePersonaje;
import mensajeria.PaqueteUsuario;

public class Cliente extends Thread {
	
	private Socket cliente;
	private String miIp;
	private ObjectInputStream entrada;
	private ObjectOutputStream salida;
	
	// Objeto gson
	private final Gson gson = new Gson();
	
	// Paquete usuario y paquete personaje
	private PaqueteUsuario paqueteUsuario;
	private PaquetePersonaje paquetePersonaje;
	
	// Acciones que realiza el usuario
	private int accion;

	public int getAccion() {
		return accion;
	}

	public void setAccion(int accion) {
		this.accion = accion;
	}
	
	//
	private Juego wome;

	public Cliente(String ip, int puerto) {
		try {
			cliente = new Socket(ip, puerto);
			miIp = cliente.getInetAddress().getHostAddress();
			entrada = new ObjectInputStream(cliente.getInputStream());
			salida = new ObjectOutputStream(cliente.getOutputStream());
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Fallo al iniciar la aplicaci�n. Revise la conexi�n con el servidor.");
			System.exit(1);
		}
	}

	public void run() {
		synchronized(this){
			try {
				
				// Creo el paquete que le voy a enviar al servidor
				paqueteUsuario = new PaqueteUsuario();

				while (!paqueteUsuario.isInicioSesion()) {
					
					// Muestro el men� principal
					new MenuPrincipal(this).setVisible(true);
					
					// Creo los paquetes que le voy a enviar al servidor
					paqueteUsuario = new PaqueteUsuario();
					paquetePersonaje = new PaquetePersonaje();
					
					// Espero a que el usuario seleccione alguna accion
					wait();
	
					switch (getAccion()) {
					
					case Comando.REGISTRO:
						paqueteUsuario.setComando(Comando.REGISTRO);
						break;
					case Comando.INICIOSESION:
						paqueteUsuario.setComando(Comando.INICIOSESION);
						break;
					case Comando.SALIR:
						paqueteUsuario.setIp(getMiIp());
						paqueteUsuario.setComando(Comando.SALIR);
						break;
					}
	
					// Le envio el paquete al servidor
					salida.writeObject(gson.toJson(paqueteUsuario));
	
					// Recibo el paquete desde el servidor
					String cadenaLeida = (String) entrada.readObject();
					Paquete paquete = gson.fromJson(cadenaLeida, Paquete.class);
					
					switch (paquete.getComando()) {
					
					case Comando.REGISTRO:
						if (paquete.getMensaje().equals(Paquete.msjExito)) {

							// Abro el menu para la creaci�n del personaje
							MenuCreacionPj menuCreacionPJ = new MenuCreacionPj(this, paquetePersonaje);
							menuCreacionPJ.setVisible(true);
							
							// Espero a que el usuario cree el personaje
							wait();
							
							// Le envio los datos al servidor
							paquetePersonaje.setComando(Comando.CREACIONPJ);
							salida.writeObject(gson.toJson(paquetePersonaje));									
							JOptionPane.showMessageDialog(null, "Registro exitoso.");
							
							// Recibo el paquete personaje con los datos (la id incluida)
							paquetePersonaje = (PaquetePersonaje) gson.fromJson((String) entrada.readObject(), PaquetePersonaje.class);
							
							// Indico que el usuario ya inicio sesion
							paqueteUsuario.setInicioSesion(true);
							
						} else {
							if (paquete.getMensaje().equals(Paquete.msjFracaso))
								JOptionPane.showMessageDialog(null, "No se pudo registrar.");

							// El usuario no pudo iniciar sesi�n
							paqueteUsuario.setInicioSesion(false);
						}
						break;
	
					case Comando.INICIOSESION:
						if (paquete.getMensaje().equals(Paquete.msjExito)) {
							// El usuario ya inicio sesi�n
							paqueteUsuario.setInicioSesion(true);
							
							// Recibo el paquete personaje con los datos
							paquetePersonaje = (PaquetePersonaje) gson.fromJson(cadenaLeida, PaquetePersonaje.class);
							
						} else {
							if (paquete.getMensaje().equals(Paquete.msjFracaso))
								JOptionPane.showMessageDialog(null, "No se pudo loguear");
								// El usuario no pudo iniciar sesi�n
								paqueteUsuario.setInicioSesion(false);
						}
						break;
	
					case Comando.SALIR:
						// El usuario no pudo iniciar sesi�n
						paqueteUsuario.setInicioSesion(false);
						salida.writeObject(gson.toJson(new Paquete(Comando.DESCONECTAR), Paquete.class));
						cliente.close();
						break;
	
					default:
						JOptionPane.showMessageDialog(null, "Error tratar");
						break;
					}
	
				}
				
				// Creo un paquete con el comando mostrar mapas
				paquetePersonaje.setComando(Comando.MOSTRARMAPAS);
				
				// Abro el menu de eleccion del mapa
				MenuMapas menuElegirMapa = new MenuMapas(this);
				menuElegirMapa.setVisible(true);
				
				// Espero a que el usuario elija el mapa
				wait();
				
				// Establezco el mapa en el paquete personaje
				paquetePersonaje.setIp(miIp);
				
				// Le envio el paquete con el mapa seleccionado
				salida.writeObject(gson.toJson(paquetePersonaje));
	
				// Instancio el juego y lo corro
				wome = new Juego("War Draft", 1024, 600, this, paquetePersonaje);
				wome.start();
	
			} catch (IOException | InterruptedException | ClassNotFoundException e) {
				JOptionPane.showMessageDialog(null, "Fallo la conexi�n con el servidor durante el inicio de sesi�n.");
				System.exit(1);
			}
		}

	}

	//main del juego
	public static void main(String args[]) throws UnknownHostException, IOException {
		//en el archivo config se coloca la ip del servidor
		Scanner sc = new Scanner(new File("config.txt"));
		Cliente cliente = new Cliente(sc.next(), 5000);
		//Cliente cliente = new Cliente("localhost", 5000);
		cliente.start();
	}

	public Socket getSocket() {
		return cliente;
	}

	public void setSocket(Socket cliente) {
		this.cliente = cliente;
	}

	public String getMiIp() {
		return miIp;
	}

	public void setMiIp(String miIp) {
		this.miIp = miIp;
	}

	public ObjectInputStream getEntrada() {
		return entrada;
	}

	public void setEntrada(ObjectInputStream entrada) {
		this.entrada = entrada;
	}

	public ObjectOutputStream getSalida() {
		return salida;
	}

	public void setSalida(ObjectOutputStream salida) {
		this.salida = salida;
	}
	
	public PaqueteUsuario getPaqueteUsuario(){
		return paqueteUsuario;
	}
	
	public PaquetePersonaje getPaquetePersonaje(){
		return paquetePersonaje;
	}
	
	public Juego getJuego(){
		return wome;
	}
}
