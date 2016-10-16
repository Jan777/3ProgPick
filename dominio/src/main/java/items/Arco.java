package items;

import personaje.Personaje;
import personaje.PersonajeEquipado;

public class Arco extends PersonajeEquipado {

	public Arco(Personaje personajeDecorado) {
		super(personajeDecorado);
	}

	@Override
	public int obtenerPuntosDeAtaque() {
		return super.obtenerPuntosDeAtaque() + 15;
	}
}
