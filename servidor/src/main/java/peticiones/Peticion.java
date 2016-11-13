package peticiones;

import java.sql.SQLException;

import com.google.gson.Gson;

import constantes.Mensaje;
import hilos.ServerThread;
import pojo.*;

public class Peticion {
	
	public static final String CARACTER_SEPARACION = ";";
	public static final int PETICION_GRUPAL = 10000;
	public static final int PETICION_INDIVIDUAL = 20000;
	
	private int codPeticion;
	private String respuesta;
	
	public Peticion (Gson gson, String peticion, ServerThread serverTh) throws SQLException {
		POJOMensaje mje = gson.fromJson(peticion, POJOMensaje.class);
		this.codPeticion = mje.getCodigo();
		this.respuesta = "";
		switch (this.codPeticion) {
			case Mensaje.LOGEO:
				PeticionLogeo petLog = new PeticionLogeo(gson.fromJson(peticion, POJOLogin.class), serverTh);
				this.respuesta = petLog.getRespuesta();
				break;
			case Mensaje.REGISTRAR:
				PeticionRegistrar petReg = new PeticionRegistrar(gson.fromJson(peticion, POJORegistrar.class), serverTh);
				this.respuesta = petReg.getRespuesta();
				break;
			default:
				break;
		}
	}	

	public String getRespuesta() {
		return respuesta;
	}
}
