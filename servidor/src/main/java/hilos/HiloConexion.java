package hilos;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import com.google.gson.Gson;

import entidades.Entidad;
import entidades.Jugador;
import enums.TipoEventoEnum;
import pantallas.Servidor;

/**
 * 
 * @author Matias Jimenez
 *
 */
public class HiloConexion extends Thread implements Runnable {

	private Socket clienteSocket;
	private ObjectInputStream bufferEntradaObj;
	private ObjectOutputStream bufferSalidaObj;
	private HiloConexionSalida threadSalida;
	private Servidor servidor;
	private boolean conectado = true;
	
	public HiloConexion(Socket cliente, Servidor servidor) {
		this.clienteSocket = cliente;
		this.servidor = servidor;
		
		try {
			this.bufferEntradaObj = new ObjectInputStream(cliente.getInputStream());
			this.bufferSalidaObj = new ObjectOutputStream(cliente.getOutputStream());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		try {
			this.threadSalida = new HiloConexionSalida(bufferSalidaObj, servidor);
			this.threadSalida.start();
			Gson gson = new Gson();
			while(this.conectado) {
				Object obj = bufferEntradaObj.readObject();
				if(obj != null) {
					String json = (String)obj;
					if(json.length() > 0) {
						Entidad entidad = gson.fromJson(json, Jugador.class);	
						if(entidad.getTipo() == TipoEventoEnum.REGISTRAR_USUARIO) {
							if(Servidor.getCon().insert("INSERT INTO Usuario VALUES('" + ((Jugador)entidad).getNombreUsuario() + "', '" + ((Jugador)entidad).getPassword() + "')") != 0){
								bufferSalidaObj.reset();
								bufferSalidaObj.writeObject("REGISTRO OK");
							}
							else{
								bufferSalidaObj.reset();
								bufferSalidaObj.writeObject("ERROR");
							}
						} else if(entidad.getTipo() == TipoEventoEnum.LOGEARSE) {
							int i = 0;
							int encontro = 0;
							while (i < servidor.getUsuarios().size() && servidor.getUsuarios() != null && encontro == 0) {
								if (((Jugador)entidad).getNombreUsuario().equals(servidor.getUsuarios().get(i))) {
									encontro = 1;
								}
								i++;
							}
							if (encontro == 0) {
								if (Servidor.getCon().query("SELECT 1 FROM Usuario WHERE Usuario ='" + ((Jugador)entidad).getNombreUsuario() + "' and Password ='" + ((Jugador)entidad).getPassword() + "'") != null) {
									bufferSalidaObj.reset();
									bufferSalidaObj.writeObject("LOGIN OK");
									servidor.getUsuarios().add(((Jugador)entidad).getNombreUsuario());
								} else {
									bufferSalidaObj.reset();
									bufferSalidaObj.writeObject("LOGIN NO");
								}
							} else {
								bufferSalidaObj.reset();
								bufferSalidaObj.writeObject("LOGUEADO");
							}
						}
						else if(entidad.getTipo() == TipoEventoEnum.SALIR) {
							conectado = false;
							desconectar();
						}
						else {
							
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void desconectar() {
		try {
			threadSalida.desconectar();
			bufferSalidaObj.close();
			bufferEntradaObj.close();
			clienteSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
