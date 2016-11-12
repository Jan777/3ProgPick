package peticiones;

import java.sql.SQLException;

import hilos.ServerThread;

public class Peticion {
	
	public static final String CARACTER_SEPARACION = ";";
	public static final int PETICION_GRUPAL = 10000;
	public static final int PETICION_INDIVIDUAL = 20000;
	public static final int CARACTERES_PETICION_GI_F = 5;
	public static final int CARACTERES_PETICION_GI_I = 0;
	
	private String[] datosPeticion;
	private int codPeticion;
	private String respuesta;
	
	public Peticion (String peticion, ServerThread serverTh) throws SQLException {
		this.datosPeticion = peticion.split(CARACTER_SEPARACION);	
		this.codPeticion = Integer.parseInt(datosPeticion[0]);
		this.respuesta = "";
		
		switch (this.codPeticion) {
		case CodigoPeticion.LOGEO:
			PeticionLogeo petLog = new PeticionLogeo(datosPeticion, serverTh);
			this.respuesta = petLog.getRespuesta();
			break;
		
		case CodigoPeticion.REGISTRAR:
			PeticionRegistrar petReg = new PeticionRegistrar(datosPeticion, serverTh);
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
