package alianza;

import java.util.LinkedList;
import java.util.List;

import interfaces.Atacable;
import personaje.Personaje;

public abstract class Alianza {

	protected List<Personaje> aliados = new LinkedList<Personaje>();
	
	public abstract void atacar(Alianza otro);
	public abstract Atacable obtenerProximaVictima();
	
	public Alianza(List<Personaje> aliados){
		this.aliados = aliados;
	}
	
	public int cantidadDeAliados(){
		return this.aliados.size();
	}
	
	public List<Personaje> getAliados(){
		return this.aliados;
	}
}
