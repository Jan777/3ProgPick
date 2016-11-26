package mundo;

import recursos.Recursos;

public class TilePalmeras extends Tile{
	public TilePalmeras(int id) {
		super(Recursos.palmera, id);
	}
	
	@Override
	public boolean esSolido() {
		return true;
	}
}
