package gson;

import org.junit.Assert;
import org.junit.Test;

import com.google.gson.Gson;

import entidades.Entidad;
import entidades.Jugador;
import enums.TipoEventoEnum;


public class GsonTests {

	@Test
	public void queConviertoUnObjectoaJson(){
		Gson gson = new Gson();
		Entidad jugador = new Jugador(TipoEventoEnum.LOGEARSE.ordinal(), "MATIAS", "MATIAS");
		String json = gson.toJson(jugador);
		System.out.println(json);
	}
	
	@Test
	public void queConvierteUnJsonAunObjecto(){
		Gson gson = new Gson();
		String json = "{\"nombreUsuario\":\"MATIAS\",\"password\":\"MATIAS\",\"partidas\":0,\"puntos\":0,\"enemigosEliminados\":0,\"tipo\":\"1\"}";
		Jugador jugador = gson.fromJson(json, Jugador.class);
		Assert.assertEquals("MATIAS", jugador.getNombreUsuario());
		Assert.assertEquals("MATIAS", jugador.getPassword());
		Assert.assertEquals(TipoEventoEnum.LOGEARSE, jugador.getTipo());
	}
}
