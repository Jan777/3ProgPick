package hilos;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.sql.SQLException;

import peticiones.Peticion;

public class ServerThread extends Thread {
	
	private Socket cSocket;
	private Server server;
	private DataInputStream in;
	private DataOutputStream out;	
	
	public Server getServer() {
		return server;
	}

	public Socket getcSocket() {
		return cSocket;
	}

	public ServerThread(Socket socket, Server server) {
		this.server = server;
		this.cSocket = socket;
	}

	@Override
	public void run() {
		try {
	
			in = new DataInputStream(cSocket.getInputStream());
			out = new DataOutputStream(cSocket.getOutputStream());
			
			while(true) {	
				String entrada = in.readUTF();
				System.out.println("CLIENTE: " + entrada);
				Peticion peticion = new Peticion(entrada, this);
				String pojoRespuesta = peticion.getRespuesta();
				int tipoRespuesta = 0; 
				if(tipoRespuesta != -1) {
					for (UsuarioSocket socket : this.getServer().getListaSocketsUsuarios()) {
						(new DataOutputStream(socket.getS().getOutputStream())).writeUTF(pojoRespuesta);
					}
				} else {					
					out.writeUTF(pojoRespuesta);
				}				
			}
		} catch (IOException e) {
			server.getListaSocketsUsuarios().remove(cSocket);
			try {
				in.close();
				out.close();
				cSocket.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
