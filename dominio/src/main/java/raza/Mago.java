package raza;

import java.util.HashMap;
import java.util.Map;

import items.Hechizo;
import personaje.Personaje;

public class Mago extends Personaje {

	private Map<String, Hechizo> hechizos = new HashMap<String, Hechizo>();
	int cantidadDeAtaques;
	
	public void agregarHechizo(String conjuro, Hechizo hechizo) {
		this.hechizos.put(conjuro, hechizo);
	}
	
	public int getCantidadDeHechizos() {
		return this.hechizos.size();
	}

	public void hechizar(String conjuro, Personaje personaje) {
		this.hechizos.get(conjuro).afectar(personaje);
	}

	protected void despuesDeAtacar() {
		cantidadDeAtaques++;
	}
	
	@Override
	protected int calcularPuntosDeAtaque() {
		return 10 + cantidadDeAtaques;
	}

	@Override
	protected boolean puedeAtacar() {
		return energia >= calcularPuntosDeAtaque();
	}
	@Override
	public int obtenerPuntosDeDefensa() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int obtenerNivelDeSalud() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
