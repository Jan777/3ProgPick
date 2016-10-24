package personaje;


import org.junit.Assert;
import org.junit.Test;

import raza.Humano;
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
	
	@Test
	public void OrcoCurado(){
		Personaje Orco = new Orco();
		Orco.serCurado();
		Assert.assertEquals(100, Orco.getSalud());
	}
	
	public void MagoIncrementaAtaqueAlAtacar(){
		Personaje Mago = new Mago();
		Personaje Enemigo = new Orco();
		int ptsAtaque = Mago.obtenerPuntosDeAtaque();
		
		Mago.atacar(Enemigo);
		
		Assert.assertTrue(Mago.obtenerPuntosDeAtaque() > ptsAtaque);
		
	}
	
	public void HumanoIncrementaAtaqueAlAtacarEn10(){
		Personaje Humano = new Humano();
		Personaje Enemigo = new Mago();
		int ptsAtaque = Humano.obtenerPuntosDeAtaque();
		
		Humano.atacar(Enemigo);
		
		Assert.assertEquals(ptsAtaque+10, Humano.obtenerPuntosDeAtaque());
				
	}
	
}
