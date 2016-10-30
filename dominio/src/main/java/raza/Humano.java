package raza;

import personaje.Personaje;

public class Humano extends Personaje {
	int cantidadDeAtaques;
	
	public Humano(String nombre) {
		super(nombre);
	}

	protected void despuesDeAtacar() {
		cantidadDeAtaques++;
	}
	
	@Override
	protected int calcularPuntosDeAtaque() {
		return 10 + (cantidadDeAtaques *10);
	}

	@Override
	protected boolean puedeAtacar() {
		return energia >= calcularPuntosDeAtaque();
	}

	@Override
	public int obtenerPuntosDeDefensa() {
		return 0;
	}

	@Override
	public int obtenerNivelDeSalud() {
		return this.salud;
	}
}
