package entidades;

import java.util.List;

import habilidades.Habilidad;

public abstract class Enemigo extends Ente {

	protected List<Habilidad> habilidades;
	
	protected Enemigo (String nombre, int nivel, int salud, int energia, int fuerza,int destreza, int inteligencia) {
		super(nombre, nivel, salud, energia, fuerza, destreza, inteligencia);
	}

	@Override
	public void despuesDeMorir() {
	}
}