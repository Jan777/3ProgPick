package serializador;

import java.lang.reflect.Type;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import entidades.Usuario;

/**
 * 
 * @author Matias Jimenez
 *
 */

public class UsuarioSerializer implements JsonSerializer<Usuario> {

	@Override
	public JsonElement serialize(Usuario usuario, Type type, JsonSerializationContext context) {
		JsonObject result = new JsonObject();
		result.add("tipo", new JsonPrimitive(usuario.getTipo().getValue()));
		result.add("nombreUsuario", new JsonPrimitive(usuario.getNombreUsuario()));
		result.add("password", new JsonPrimitive(usuario.getPassword()));
		return result;
	}	
}
