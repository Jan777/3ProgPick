package peticiones;

public class CodigoPeticion {
	
	// Conexion: 1000
	public static final int CONEXION_CON_SERVIDOR = 1000;

	// Usuario: 0-99
	public static final int LOGEO = 1;
	public static final int LOGEO_CORRECTO_ADMIN = 9;
	public static final int LOGEO_CORRECTO_USUARIO = 0;
	public static final int LOGEO_INCORRECTO = 13;
	public static final int REGISTRAR = 15;
	public static final int REGISTRAR_INCORRECTO = 16;
	public static final int REGISTRAR_CORRECTO = 17;
		
	public static final int CREAR_PARTIDA = 110;	
	public static final int CREAR_PARTIDA_CORRECTO = 111;
	public static final int CREAR_PARTIDA_INCORRECTO = 112;
	
	public static final int UNIRSE_PARTIDA = 120;

	// Partida: 200-299
	public static final int EMPEZAR_PARTIDA = 200;
	public static final int EMPEZAR_PARTIDA_CORRECTO = 201;
	public static final int EMPEZAR_PARTIDA_INCORRECTO = 202;
	
	public static final int AGREGAR_JUGADOR = 210;
	public static final int AGREGAR_JUGADOR_CORRECTO = 211;
	public static final int AGREGAR_JUGADOR_INCORRECTO = 212;
	
	public static final int MOVIMIENTO = 220;
	public static final int MOVIMIENTO_CORRECTO = 221;
	public static final int MOVIMIENTO_INCORRECTO = 222;
	
	public static final int MOVER_JUGADORES = 230;
	public static final int MOVER_JUGADORES_CORRECTO = 231;
	public static final int MOVER_JUGADORES_INCORRECTO = 232;

}
