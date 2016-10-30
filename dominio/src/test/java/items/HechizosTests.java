package items;

import org.junit.Assert;
import org.junit.Test;


import raza.Humano;
import raza.Mago;

public class HechizosTests {
	
	@Test
	public void MagoUtilizaEspectroPatronumReduceVidaAlaMitad(){
		Mago Harry = new Mago("Harry Potter");
		Humano Enemigo = new Humano("Aragon");
		Harry.agregarHechizo("Patronum", new ExpectroPatronum());
		int ptsSalud = Enemigo.getSalud();
		
		Harry.hechizar("Patronum", Enemigo);
		
		Assert.assertEquals(ptsSalud/2, Enemigo.obtenerNivelDeSalud());
		
	}
}
