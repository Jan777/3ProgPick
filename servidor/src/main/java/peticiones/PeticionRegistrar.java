package peticiones;

import java.sql.SQLException;

import hilos.*;

public class PeticionRegistrar {

	private String respuesta;
	
	public PeticionRegistrar(String[] datosPeticion, ServerThread serverTh) throws SQLException {
		String usuario = datosPeticion[1],
			   password = datosPeticion[2],
			   nick = datosPeticion[3],
			   pregSecreta = datosPeticion[4],
			   respSecreta = datosPeticion[5];
		boolean resultado = serverTh.getServer().getConexionBD().agregarUsuario(usuario, password, nick, pregSecreta, respSecreta);
		
		if(resultado)
			respuesta = CodigoPeticion.REGISTRAR_CORRECTO + "";
		else
			respuesta = CodigoPeticion.REGISTRAR_INCORRECTO + "";
	}
	
	public String getRespuesta() {
		return this.respuesta;
	}
}
