package itemsTipo;

import items.Item;

public abstract class ItemDefensa extends Item {
	
	protected int defensa;

	public int getDefensa() {
		return defensa;
	}

	public void setDefensa(int defensa) {
		this.defensa = defensa;
	}
}