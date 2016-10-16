package personaje;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import interfaces.Atacable;

public abstract class Alianza {

	protected List<Personaje> Alianza = new LinkedList<Personaje>();
	
	public abstract void atacar(Alianza otro);
	public abstract Atacable obtenerProximaVictima();
	
	public final void depurarAlianza() {
		Iterator<Personaje> iter = Alianza.iterator();
		while(iter.hasNext()){
		    if(!iter.next().estaVivo()) iter.remove();
		}
	}
}