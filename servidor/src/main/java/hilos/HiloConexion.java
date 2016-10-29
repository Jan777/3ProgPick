package hilos;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

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
			while(this.conectado){
				Object obj = bufferEntradaObj.readObject();
				if(obj != null){
					String aux = (String)obj;
					String[] datos = new String[3];
					datos = aux.split(" ");
					switch (datos[0]) {
					case "REGISTRO":
						if(Servidor.getCon().insert("INSERT INTO Usuario VALUES('" + datos[1] + "', '" + datos[1] + "')") != 0){
							bufferSalidaObj.reset();
							bufferSalidaObj.writeObject("REGISTRO INSERTADO OK");
						}
						else{
							bufferSalidaObj.reset();
							bufferSalidaObj.writeObject("ERROR !!!");
						}
						break;
					case "SALIR":
						conectado = false;
						desconectar();
						break;
					default:
						break;
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
