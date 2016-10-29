package entidades;

import java.io.Serializable;
import java.util.ArrayList;

public class Partida extends Entidad implements Serializable {

	/**
	 * @author Matias Jimenez
	 */
	private static final long serialVersionUID = -7960889180717670695L;

	private String nombre;
	private ArrayList<Usuario> jugadores;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public ArrayList<Usuario> getJugadores() {
		return jugadores;
	}
	public void setJugadores(ArrayList<Usuario> jugadores) {
		this.jugadores = jugadores;
	}
	
	public int getCantidadJugadores(){
		return this.jugadores.size();
	}
	
	public void agregarJugador(Usuario jugador){
		this.jugadores.add(jugador);
	}
}
