package items;

import org.junit.Assert;
import org.junit.Test;

import personaje.Personaje;
import raza.Humano;


public class ItemsTests {
	@Test
	public void EquipoEscudoAumentaDefensaen10(){
		Personaje Humano = new Humano("Aragon");
		int ptsDefensa = Humano.obtenerPuntosDeDefensa();
		
		Humano = new Escudo(Humano);
		Assert.assertEquals(10, Humano.obtenerPuntosDeDefensa()-ptsDefensa);
			
	}
	@Test
	public void EquipoEspadaAumentaAtaqueen5(){
		Personaje Humano = new Humano("Aragon");
		int Ataque = Humano.obtenerPuntosDeAtaque();
		
		Humano = new Espada(Humano);
		Assert.assertEquals(5, Humano.obtenerPuntosDeAtaque()-Ataque);
			
	}
	@Test
	public void EquipoArcoAumentaAtaqueen15(){
		Personaje Humano = new Humano("Aragon");
		int Ataque = Humano.obtenerPuntosDeAtaque();
		
		Humano = new Arco(Humano);
		Assert.assertEquals(15, Humano.obtenerPuntosDeAtaque()-Ataque);
			
	}
	@Test
	public void EquipoFlechaAumentaAtaqueen5(){
		Personaje Humano = new Humano("Aragon");
		int Ataque = Humano.obtenerPuntosDeAtaque();
		
		Humano = new Flecha(Humano);
		Assert.assertEquals(5, Humano.obtenerPuntosDeAtaque()-Ataque);
			
	}
	
	@Test
	public void EquipoVaritaAumentaAtaqueen20(){
		Personaje Humano = new Humano("Aragon");
		int Ataque = Humano.obtenerPuntosDeAtaque();
		
		Humano = new VaritaMagica(Humano);
		Assert.assertEquals(20, Humano.obtenerPuntosDeAtaque()-Ataque);
			
	}
	
	
	/*
	 * Especificacion de Items
	 * -----------------------
	 * Escudo: aumenta 10 ptos de defensa
	 * Espada: aumenta 5 ptos de ataque
	 * Arco: aumenta 15 ptos de ataque
	 * Flecha: aumenta 5 ptos de ataque
	 * Varita: aumenta 20 ptos de ataque
	 */
}
