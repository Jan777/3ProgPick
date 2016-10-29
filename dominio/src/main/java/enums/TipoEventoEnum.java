package enums;

import com.google.gson.annotations.SerializedName;

/**
 * 
 * @author Matias Jimenez
 *
 */

public enum TipoEventoEnum {
	@SerializedName("0")
	REGISTRAR_USUARIO (0), // Obj de Usuario 
	@SerializedName("1")
	LOGEARSE (1),			// Obj de Usuario
	@SerializedName("2")
	DESLOGUEARSE (2),		// Obj de Usuario
	@SerializedName("3")
	CAMBIAR_PASSWORD (3),	// Obj de Usuario
	@SerializedName("4")
	CREAR_PARTIDA (4),		// Obj Partida
	@SerializedName("5")
	INICIAR_PARTIDA (5),	// Obj Partida	
	@SerializedName("6")
	ATACAR (6),				
	@SerializedName("7")
	AVANZAR (7),
	@SerializedName("8")
	RETROCEDER (8),
	@SerializedName("9")
	SALIR (9),				// nada
	@SerializedName("10")
	GUARDAR_ESTADISTICAS (10),	// Obj Estadisticas
	@SerializedName("11")
	BUSCAR_ESTADISTICAS (11),	// Obj Estadisticas
	@SerializedName("12")
	JUGADOR (12); // Obj Jugador
	
	private final int value;
	
    public int getValue() {
        return value;
    }

    private TipoEventoEnum(int value) {
        this.value = value;
    }
    
    public static TipoEventoEnum fromInteger(int e) {
        switch(e) {
        case 0:
            return TipoEventoEnum.REGISTRAR_USUARIO;
        case 1:
            return TipoEventoEnum.LOGEARSE;
        }
        return null;
    }
}
