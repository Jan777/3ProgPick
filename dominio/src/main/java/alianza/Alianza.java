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
<<<<<<< HEAD
	public boolean isEmpty() {
		return this.cantidad == 0;
=======
	
	public boolean PoderAliarse(){
		if (this.cantidadDeAliados() >= 5) {
			return false;}
		else {
			return true;
		}
	}
	
	public void Aliarse(Personaje personaje){
		if (this.PoderAliarse()) {
			this.aliados.add(personaje);
		}
>>>>>>> 363192ccd9bf0746dc98322b7a413e8495c97636
	}
}
