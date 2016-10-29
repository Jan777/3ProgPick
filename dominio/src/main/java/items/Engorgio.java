package items;
import personaje.Personaje;

public class Engorgio extends Hechizo{
	
	@Override
	public void afectar(Personaje personaje){
		personaje.altura *= 2;
	}
}
