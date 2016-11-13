package alianza;

import java.util.List;

import entidades.Personaje;
import interfaces.Atacable;

public abstract class Alianza {

	protected int cantidad;
	protected List<Personaje> aliados;
	
	public abstract void atacar(Alianza otro);
	public abstract Atacable obtenerProximaVictima();
	
	public Alianza(int cantidad){
		this.cantidad = cantidad;
	}
	
	public int size(){
		return this.cantidad;
	}
	
	public List<Personaje> getAliados(){
		return this.aliados;
	}
	public boolean isEmpty() {
		return this.cantidad == 0;
	}
	
	public boolean PoderAliarse(){
		if (this.cantidad >= 5) {
			return false;}
		else {
			return true;
		}
	}
	
	public void Aliarse(Personaje personaje){
		if (this.PoderAliarse()) {
			this.aliados.add(personaje);
		}
	}
}
