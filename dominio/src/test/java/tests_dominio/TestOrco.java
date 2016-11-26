package tests_dominio;

import org.junit.Assert;
import org.junit.Test;
import dominio.*;

public class TestOrco {

	@Test
	public void testGolpeDefensivo() {
		Humano h = new Humano("Pepe", new Guerrero(), 1);
		Orco o = new Orco("Pepe", new Guerrero(), 1);
		Assert.assertTrue(h.getSalud() == 55);
		if (o.habilidadRaza1(h))
			Assert.assertTrue(h.getSalud() == 45);
		else
			Assert.assertTrue(o.getSalud() == 55);
	}

	@Test
	public void testMordiscoDeVida() {
		Humano h = new Humano("Pepe", 100, 100, 55, 20, 30, new Hechicero(0.2, 0.3, 1.5), 0, 1, 1);
		Orco o = new Orco("Pepe", 100, 100, 80, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 1, 1);
		Assert.assertTrue(h.getSalud() == 100);
		o.setSalud(50);
		if (o.habilidadRaza2(h)) {
			Assert.assertTrue(h.getSalud() == 40);
			Assert.assertTrue(o.getSalud() == 100);
		} else {
			Assert.assertTrue(o.getSalud() == 50);
			Assert.assertTrue(h.getSalud() == 100);
		}
	}
}
