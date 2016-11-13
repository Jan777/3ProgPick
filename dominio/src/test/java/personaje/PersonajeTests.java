package personaje;

import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;

import org.junit.Test;

import raza.Humano;
import raza.Orco;
import alianza.AlianzaDeHumanos;
import casta.Guerrero;
import casta.Mago;
import enemigos.Dragon;
import entidades.Enemigo;
import entidades.Personaje;
import items.Espada;

public class PersonajeTests {

//	@Test
//	public void queUnEnemigoSufreDaño(){
//		
//		Personaje mago = new Mago("Harry Potter");
//		Personaje enemigo = new Orco("Orco");
//		Assert.assertEquals(100, enemigo.obtenerNivelDeSalud());
//		
//		mago.atacar(enemigo);
//		Assert.assertTrue(enemigo.obtenerNivelDeSalud() < 100);
//	}
//	
//	@Test
//	public void OrcoCurado(){
//		Personaje Orco = new Orco("Orco");
//		Orco.serCurado();
//		Assert.assertEquals(100, Orco.getSalud());
//	}
//	
//	
//	@Test
//	public void MagoIncrementaAtaqueAlAtacar(){
//		Personaje Mago = new Mago("Harry Potter");
//		Personaje Enemigo = new Orco("Orco");
//		int ptsAtaque = Mago.obtenerPuntosDeAtaque();
//		
//		Mago.atacar(Enemigo);
//		
//		Assert.assertTrue(Mago.obtenerPuntosDeAtaque() > ptsAtaque);
//		
//	}
//	
//	@Test
//	public void HumanoIncrementaAtaqueAlAtacarEnDiez(){
//		Personaje Humano = new Humano("Aragon");
//		Personaje Enemigo = new Mago("Harry Potter");
//		int ptsAtaque = Humano.obtenerPuntosDeAtaque();
//		
//		Humano.atacar(Enemigo);
//		
//		Assert.assertEquals(ptsAtaque+10, Humano.obtenerPuntosDeAtaque());
//				
//	}
//	
//	@Test
//	public void AlSerAtacadoSaludDismunuyeSegunPtsAtaqueRival(){
//		Personaje Humano = new Humano("Aragon");
//		Personaje Enemigo = new Humano("Aragon");
//		int ptsAtaque = Enemigo.obtenerPuntosDeAtaque();
//		
//		Enemigo.atacar(Humano);
//		
//		Assert.assertEquals(Humano.getSalud()+ptsAtaque, Humano.SALUD_MAX);
//	}
//	
//	@Test
//	public void MagoAlSubirDeNivelAdquiereHechizo(){
//		Mago Mago = new Mago("Harry Potter");
//		int cantHechizos = Mago.getCantidadDeHechizos();
//		Mago.SubirNivel();
//		
//		Assert.assertTrue(Mago.getCantidadDeHechizos() > cantHechizos);	
//	}
//	
//	@Test
//	public void OrcoAlAtacarMagoSaludDisminuyeEn10(){
//		Orco Orco = new Orco("Orco");
//		Mago Enemigo = new Mago("Harry Potter");
//		int ptsSalud = Enemigo.getSalud();
//		
//		Orco.atacar(Enemigo);
//		
//		Assert.assertEquals(10, ptsSalud-Enemigo.getSalud());
//		
//	}
//	
//	@Test
//	public void NoPoderAliarseSiAlianzaSupera5(){
//		List<Personaje> aliados = new LinkedList<Personaje>();
//		for (int i = 0; i < 5; i++) {
//			aliados.add(new Humano("Aragon"));
//		}
//		
//		AlianzaDeHumanos Alianza = new AlianzaDeHumanos(aliados);
//		Assert.assertFalse(Alianza.PoderAliarse());
//	}
	
	@Test
	public void queAtacoUnaVezYRestoDiezDeSaludAlEnemigo() {
		Personaje mati = new Humano("Matias");
		mati.setCasta(new Guerrero());
		Assert.assertEquals(0, mati.getExperiencia());
		mati.equiparObjectoAtaque(new Espada(mati.getCasta()));
		
		Enemigo drago = new Dragon("Dragoncito", 1, 100, 100, 100, 100, 100, false, 0);
		mati.atacar(drago);
		Assert.assertEquals(90, drago.getSalud());
	}
}
