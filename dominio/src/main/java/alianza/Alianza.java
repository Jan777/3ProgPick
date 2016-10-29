package alianza;

import java.util.List;
import interfaces.Atacable;
import personaje.Personaje;

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
}
