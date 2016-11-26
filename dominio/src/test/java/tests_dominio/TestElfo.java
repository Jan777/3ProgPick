package tests_dominio;

import org.junit.Test;
import dominio.Elfo;
import dominio.Humano;
import org.junit.Assert;
import dominio.Asesino;

public class TestElfo {

	@Test
	public void testGolpeLevel() {
		Elfo e = new Elfo("Pepe", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 3, 1);
		Humano h = new Humano("Pepe", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 1, 1);

		Assert.assertTrue(h.getSalud() == 100);
		if (e.habilidadRaza1(h))
			Assert.assertTrue(h.getSalud() < 100);
		else
			Assert.assertTrue(h.getSalud() == 100);

	}

	@Test
	public void testAtaqueBosque() {
		Elfo e = new Elfo("Pepe", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 3, 1);
		Humano h = new Humano("Pepe", 100, 100, 25, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 1, 1);
		Assert.assertTrue(h.getSalud() == 100);
		if (e.habilidadRaza2(h))
			Assert.assertTrue(h.getSalud() < 100);
		else
			Assert.assertTrue(h.getSalud() == 100);
	}
}
