package items;

import personaje.Personaje;
import personaje.PersonajeEquipado;

public class Flecha extends PersonajeEquipado {

	public Flecha(Personaje personajeDecorado) {
		super(personajeDecorado);
	}

	@Override
	public int obtenerPuntosDeAtaque() {
		return super.obtenerPuntosDeAtaque() + 5;
	}
}
