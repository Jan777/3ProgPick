package items;

import org.junit.Assert;

import raza.Humano;
import raza.Mago;

public class HechizosTests {
	public void MagoUtilizaEspectroPatronumReduceVidaAlaMitad(){
		Mago Harry = new Mago();
		Humano Enemigo = new Humano();
		Harry.agregarHechizo("Patronum", new ExpectroPatronum());
		int ptsSalud = Enemigo.getSalud();
		
		Harry.hechizar("Patronum", Enemigo);
		
		Assert.assertEquals(ptsSalud/2, Enemigo.obtenerNivelDeSalud());
		
	}
}
