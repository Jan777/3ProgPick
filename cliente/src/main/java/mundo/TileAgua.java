package mundo;

import recursos.Recursos;

public class TileAgua extends Tile {
	
	public TileAgua(int id) {
		super(Recursos.agua, id);
	}
	
	@Override
	public boolean esSolido() {
		return true;
	}
}