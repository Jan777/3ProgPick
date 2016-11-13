package raza;

import entidades.Personaje;
//import habilidades.Habilidad;

public class Humano extends Personaje {

	public Humano(String nombre) {
		super(nombre);
	}
	
	@Override
	public boolean puedeAtacar() {
		return this.energia > (10 + this.calcularPuntosDeAtaque());
	}

	@Override
	public void subirEstadisticas(int nivel) {
		// TODO Auto-generated method stub
		
	}

//	@Override
//	public void serHechizado(Habilidad habilidad) {
//		// TODO Auto-generated method stub
//	}
}
