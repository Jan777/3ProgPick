package hilos;

import java.io.ObjectOutputStream;

import pantallas.Servidor;

/**
 * 
 * @author Matias Jimenez
 *
 */
public class HiloConexionSalida extends Thread {

	private boolean conectado = true;
	private ObjectOutputStream bufferSalidaObj;
	private Servidor servidor;
	
	public HiloConexionSalida(ObjectOutputStream salida, Servidor servidor) {
		bufferSalidaObj = salida;
		this.setServidor(servidor);
	}
	
	@Override
	public void run() {
		try {
			while (this.conectado) {
				bufferSalidaObj.reset();
				bufferSalidaObj.writeObject("");
				Thread.sleep(12);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void desconectar() {
		conectado = false;
	}

	public Servidor getServidor() {
		return servidor;
	}

	public void setServidor(Servidor servidor) {
		this.servidor = servidor;
	}
}
