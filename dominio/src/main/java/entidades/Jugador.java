package entidades;

import java.io.Serializable;

import enums.TipoEventoEnum;
import personaje.Personaje;

public class Jugador extends Entidad implements Serializable {

	/**
	 * @author Matias Jimenez
	 */
	private static final long serialVersionUID = -4299169000336852051L;
	private String nombreUsuario;
	private String password;
	private int partidas;
	private int puntos;
	private int enemigosEliminados;
	private Personaje personaje;
	
	public Jugador(int tipo, String usuario, String password){
		this.tipo = TipoEventoEnum.fromInteger(tipo);
		this.nombreUsuario = usuario;
		this.password = password;
	}
	
	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getPartidas() {
		return partidas;
	}

	public void setPartidas(int partidas) {
		this.partidas = partidas;
	}

	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

	public int getEnemigosEliminados() {
		return enemigosEliminados;
	}

	public void setEnemigosEliminados(int enemigosEliminados) {
		this.enemigosEliminados = enemigosEliminados;
	}

	public Personaje getPersonaje() {
		return personaje;
	}

	public void setPersonaje(Personaje personaje) {
		this.personaje = personaje;
	}
}
