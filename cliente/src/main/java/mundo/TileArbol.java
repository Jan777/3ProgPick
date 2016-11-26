package mundo;

import recursos.Recursos;

public class TileArbol extends Tile {
	
	public TileArbol(int id) {
		super(Recursos.arbol, id);
	}
	
	@Override
	public boolean esSolido() {
		return true;
	}
}