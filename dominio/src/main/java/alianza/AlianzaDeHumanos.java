package alianza;

import java.util.ArrayList;
import interfaces.Atacable;
import personaje.Personaje;
import raza.Humano;

public class AlianzaDeHumanos extends Alianza {

	public AlianzaDeHumanos(int cantidad) {
		super(cantidad);
		this.aliados = new ArrayList<Personaje>();
		for (int i = 0; i < cantidad; i++) {
			this.aliados.add(new Humano());
		}
	}

	@Override
	public void atacar(Alianza otro) {
		Atacable victima = otro.obtenerProximaVictima();
		for (Personaje atacante : aliados) {
			atacante.atacar(victima);
		}
	}
	
	@Override
	public Atacable obtenerProximaVictima() {
		if(this.aliados.isEmpty())
			throw new RuntimeException("No existe alianza");
		return this.aliados.get(0);
	}
	
	public boolean aliarse(Humano personaje){
		return this.aliados.add(personaje);
	}
	
	public void salirDeLaAlianza(Humano personaje){
		this.aliados.remove(personaje);
	}
}
