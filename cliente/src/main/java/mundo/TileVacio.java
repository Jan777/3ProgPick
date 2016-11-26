package mundo;

import recursos.Recursos;

public class TileVacio  extends Tile{
	public TileVacio(int id) {
		super(Recursos.vacio, id);
	}
	
	@Override
	public boolean esSolido() {
		return true;
	}
}
