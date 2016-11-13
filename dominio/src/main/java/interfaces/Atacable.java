package interfaces;

import entidades.Ente;

public interface Atacable {

	public abstract boolean estaVivo();
	public abstract boolean puedeAtacar();
	public abstract void serAtacado(int daño);
	public abstract void despuesDeAtacar(Ente ente);
	
	public abstract int obtenerPuntosDeAtaque();
	public abstract int obtenerPuntosDeDefensa();
	public abstract int obtenerNivelDeSalud();
	
}