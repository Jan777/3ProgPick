package peticiones;

import constantes.Mensaje;
import hilos.*;
import pojo.POJOLogin;

public class PeticionLogeo{
	
	private String respuesta;
	private ServerThread serverTh;
	
	public PeticionLogeo(POJOLogin datosPeticion, ServerThread serverTh) {
		
		this.serverTh = serverTh;
		int codigoPeticion = existeUsuario(datosPeticion.getUser(), datosPeticion.getPass()); 

		switch (codigoPeticion) {
			case Mensaje.LOGEO_CORRECTO_USUARIO:
				UsuarioSocket aux2 = new UsuarioSocket(serverTh.getcSocket());
				int pos2 = this.serverTh.getServer().getListaSocketsUsuarios().indexOf(aux2);
				serverTh.getServer().getListaSocketsUsuarios().get(pos2).setNombre(datosPeticion.getUser());
				this.respuesta = Mensaje.LOGEO_CORRECTO_USUARIO + "";
				break;
			default:
				this.respuesta = Mensaje.LOGEO_INCORRECTO + "";
				break;
		}
	}

	private int existeUsuario(String usuario, String password) {
		return serverTh.getServer().getConexionBD().login(usuario, password);
	}

	public String getRespuesta() {
		return respuesta;
	}
}
