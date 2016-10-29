package gson;

import org.junit.Test;
import com.google.gson.GsonBuilder;

import entidades.Usuario;
import enums.TipoEventoEnum;
import serializador.UsuarioSerializer;


public class GsonTests {

	@Test
	public void unSimpleTestParaProbarGson(){
		Usuario jugador = new Usuario(TipoEventoEnum.LOGEARSE.ordinal(), "MATIAS", "MATIAS");
		com.google.gson.Gson gson = new GsonBuilder().registerTypeAdapter(Usuario.class, new UsuarioSerializer()).create();
		String json = gson.toJson(jugador);
		System.out.println(json);
	}
}
