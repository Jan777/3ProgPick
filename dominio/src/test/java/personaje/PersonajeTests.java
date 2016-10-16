package personaje;

import org.junit.Assert;
import org.junit.Test;

import raza.Mago;
import raza.Orco;

public class PersonajeTests {

	@Test
	public void queUnEnemigoSufreDaño(){
		
		Personaje mago = new Mago();
		Personaje enemigo = new Orco();
		Assert.assertEquals(100, enemigo.obtenerNivelDeSalud());
		
		mago.atacar(enemigo);
		Assert.assertTrue(enemigo.obtenerNivelDeSalud() < 100);
	}
}
