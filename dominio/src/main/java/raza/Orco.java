package raza;

import personaje.Personaje;

public class Orco extends Personaje {

	public Orco(String nombre) {
		super(nombre);
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

	@Override
	protected int calcularPuntosDeAtaque() {
		// TODO Auto-generated method stub
		return 10;
	}
}
