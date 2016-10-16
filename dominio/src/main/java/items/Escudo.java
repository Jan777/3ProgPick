package items;

import personaje.Personaje;
import personaje.PersonajeEquipado;

public class Escudo extends PersonajeEquipado {

	public Escudo(Personaje personajeDecorado) {
		super(personajeDecorado);
	}
	
	@Override
	public int obtenerPuntosDeDefensa() {
		return super.obtenerPuntosDeDefensa() + 10;
	}

}
