package mundo;

import recursos.Recursos;

public class TileArbusto extends Tile{
	public TileArbusto(int id) {
		super(Recursos.arbusto, id);
	}
	
	@Override
	public boolean esSolido() {
		return true;
	}
}
