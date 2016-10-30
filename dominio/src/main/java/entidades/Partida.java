package entidades;

import java.io.Serializable;
import java.util.ArrayList;

public class Partida extends Entidad implements Serializable {

	/**
	 * @author Matias Jimenez
	 */
	private static final long serialVersionUID = -7960889180717670695L;

	private String nombre;
	private ArrayList<Jugador> jugadores;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public ArrayList<Jugador> getJugadores() {
		return jugadores;
	}
	public void setJugadores(ArrayList<Jugador> jugadores) {
		this.jugadores = jugadores;
	}
	
	public int getCantidadJugadores(){
		return this.jugadores.size();
	}
	
	public void agregarJugador(Jugador jugador){
		this.jugadores.add(jugador);
	}
}
