package items;
import personaje.Personaje;

public class ExpectroPatronum extends Hechizo{
	
	@Override
	public void afectar(Personaje personaje){
		personaje.salud /= 2;
	}
}
