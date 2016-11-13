package peticiones;

import java.sql.SQLException;

import constantes.Mensaje;
import hilos.*;
import pojo.POJORegistrar;

public class PeticionRegistrar {

	private String respuesta;
	
	public PeticionRegistrar(POJORegistrar datosPeticion, ServerThread serverTh) throws SQLException {
		boolean resultado = serverTh.getServer().getConexionBD().agregarUsuario(datosPeticion.getNombre(), 
				datosPeticion.getPassword(), datosPeticion.getNick(),
				datosPeticion.getPregSecreta(), datosPeticion.getRespSecreta());
		if(resultado)
			respuesta = Mensaje.REGISTRAR_CORRECTO + "";
		else
			respuesta = Mensaje.REGISTRAR_INCORRECTO + "";
	}
	
	public String getRespuesta() {
		return this.respuesta;
	}
}
