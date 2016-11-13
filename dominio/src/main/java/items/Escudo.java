package items;

import casta.Guerrero;
import itemsTipo.ItemDefensa;

public class Escudo extends ItemDefensa {

	public Escudo() {
		this.setNombre("Escudo");
		this.setDefensa(defensa);
		
		this.setCasta(new Guerrero());
		this.setNivelMinimo(1);
	}
}
