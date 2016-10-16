package items;

import personaje.Personaje;
import personaje.PersonajeEquipado;

public class Espada extends PersonajeEquipado {

	public Espada(Personaje personajeDecorado) {
		super(personajeDecorado);
	}
	
	@Override
	public int obtenerPuntosDeAtaque() {
		return super.obtenerPuntosDeAtaque() + 5;
	}

}
