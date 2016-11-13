package hechizos;
import entidades.Personaje;
import items.Hechizo;

public class Engorgio extends Hechizo {
	
	@Override
	public void afectar(Personaje personaje) {
		personaje.altura *= 2;
	}
}
