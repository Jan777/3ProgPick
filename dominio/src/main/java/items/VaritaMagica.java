package items;

import personaje.Personaje;
import personaje.PersonajeEquipado;

public class VaritaMagica extends PersonajeEquipado {

	public VaritaMagica(Personaje personajeDecorado) {
		super(personajeDecorado);
	}

	@Override
	public int obtenerPuntosDeAtaque() {
		return super.obtenerPuntosDeAtaque() + 20;
	}
}
