package personaje;

import org.junit.Test;
import org.junit.Assert;

import raza.Humano;

public class NivelExperienciaTests {
	
	@Test
	public void queSubeExperienciaYnivel(){
		Personaje matias = new Humano("Soy Aragon");
		matias.subirExperencia(1);
		Assert.assertEquals(1, matias.getNivel());
	}
	
	@Test
	public void queSubeDosNiveles(){
		Personaje matias = new Humano("Soy Aragon");
		matias.subirExperencia(1);
		matias.subirExperencia(1);
		Assert.assertEquals(2, matias.getNivel()+1);
	}
	
	@Test
	public void queSubeTresNiveles(){
		Personaje matias = new Humano("Soy Aragon");
		matias.subirExperencia(1);
		matias.subirExperencia(1);
		matias.subirExperencia(2);
		Assert.assertEquals(3, matias.getNivel());
	}
	
	@Test
	public void queSubeCuatroNiveles(){
		Personaje matias = new Humano("Soy Aragon");
		matias.subirExperencia(1);
		matias.subirExperencia(1);
		matias.subirExperencia(2);
		matias.subirExperencia(3);
		Assert.assertEquals(4, matias.getNivel());
	}
	
	@Test
	public void queSubeCincoNiveles(){
		Personaje matias = new Humano("Soy Aragon");
		matias.subirExperencia(1);
		matias.subirExperencia(1);
		matias.subirExperencia(2);
		matias.subirExperencia(3);
		matias.subirExperencia(5);
		Assert.assertEquals(5, matias.getNivel());
	}
	
	@Test
	public void queSubeSeisNiveles(){
		Personaje matias = new Humano("Soy Aragon");
		matias.subirExperencia(1);
		matias.subirExperencia(1);
		matias.subirExperencia(2);
		matias.subirExperencia(3);
		matias.subirExperencia(5);
		matias.subirExperencia(8);
		Assert.assertEquals(6, matias.getNivel());
	}
}
