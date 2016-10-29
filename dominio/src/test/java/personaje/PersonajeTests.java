package personaje;


import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;

import org.junit.Test;

import raza.Humano;
import raza.Mago;
import raza.Orco;
import alianza.AlianzaDeHumanos;


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
	
	
	@Test
	public void MagoIncrementaAtaqueAlAtacar(){
		Personaje Mago = new Mago();
		Personaje Enemigo = new Orco();
		int ptsAtaque = Mago.obtenerPuntosDeAtaque();
		
		Mago.atacar(Enemigo);
		
		Assert.assertTrue(Mago.obtenerPuntosDeAtaque() > ptsAtaque);
		
	}
	
	@Test
	public void HumanoIncrementaAtaqueAlAtacarEnDiez(){
		Personaje Humano = new Humano();
		Personaje Enemigo = new Mago();
		int ptsAtaque = Humano.obtenerPuntosDeAtaque();
		
		Humano.atacar(Enemigo);
		
		Assert.assertEquals(ptsAtaque+10, Humano.obtenerPuntosDeAtaque());
				
	}
	
	@Test
	public void AlSerAtacadoSaludDismunuyeSegunPtsAtaqueRival(){
		Personaje Humano = new Humano();
		Personaje Enemigo = new Humano();
		int ptsAtaque = Enemigo.obtenerPuntosDeAtaque();
		
		Enemigo.atacar(Humano);
		
		Assert.assertEquals(Humano.getSalud()+ptsAtaque, Humano.saludmax);
	}
	
	@Test
	public void MagoAlSubirDeNivelAdquiereHechizo(){
		Mago Mago = new Mago();
		int cantHechizos = Mago.getCantidadDeHechizos();
		Mago.SubirNivel();
		
		Assert.assertTrue(Mago.getCantidadDeHechizos() > cantHechizos);	
	}
	
	@Test
	public void OrcoAlAtacarMagoSaludDisminuyeEn10(){
		Orco Orco = new Orco();
		Mago Enemigo = new Mago();
		int ptsSalud = Enemigo.getSalud();
		
		Orco.atacar(Enemigo);
		
		Assert.assertEquals(10, ptsSalud-Enemigo.getSalud());
		
	}
	
	@Test
	public void NoPoderAliarseSiAlianzaSupera5(){
		List<Personaje> aliados = new LinkedList<Personaje>();
		for (int i = 0; i < 5; i++) {
			aliados.add(new Humano());
		}
		
		AlianzaDeHumanos Alianza = new AlianzaDeHumanos(aliados);
		Assert.assertFalse(Alianza.PoderAliarse());
	}
	
	
	
}
