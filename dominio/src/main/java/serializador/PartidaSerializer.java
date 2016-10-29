package serializador;

import java.lang.reflect.Type;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import entidades.Partida;

/**
 * 
 * @author Matias Jimenez
 *
 */
public class PartidaSerializer implements JsonSerializer<Partida> {

	@Override
	public JsonElement serialize(Partida partida, Type type, JsonSerializationContext context) {
		JsonObject result = new JsonObject();
		result.add("nombre", new JsonPrimitive(partida.getNombre()));
		if(partida.getCantidadJugadores() > 0){
			//result.add("jugadores", new JsonPrimitive(partida.getJugadores()));
		}
		return result;
	}

}
