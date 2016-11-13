package itemsTipo;

import items.Item;

public abstract class ItemAtaque extends Item {
	
	protected int ataque;
	protected int puntosDeEnergiaPorAtaque;
	
	public int getAtaque() {
		return ataque;
	}
	
	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}
	
	public int getPuntosDeEnergiaPorAtaque() {
		return puntosDeEnergiaPorAtaque;
	}
	
	public void setPuntosDeEnergiaPorAtaque(int puntosDeEnergiaPorAtaque) {
		this.puntosDeEnergiaPorAtaque = puntosDeEnergiaPorAtaque;
	}
}