package hilos;

import java.net.Socket;

public class UsuarioSocket {
	private Socket socket;
	private String nombre;
	
	
	public Socket getS() {
		return socket;
	}

	public UsuarioSocket(Socket s) {
		this.socket = s;	
		this.nombre = "Desconocido";
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String n) {
		this.nombre = n;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UsuarioSocket other = (UsuarioSocket) obj;
		if (socket == null) {
			if (other.socket != null)
				return false;
		} else if (!socket.equals(other.socket))
			return false;
		return true;
	}	
	
	@Override
	public String toString() {
		return this.nombre;
	}
}
