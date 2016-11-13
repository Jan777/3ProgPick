package items;

import casta.Casta;
import casta.Guerrero;
import itemsTipo.ItemAtaque;

public class Espada extends ItemAtaque {

	public Espada(Casta casta) {
		this.setCasta(casta);
		this.setNombre("Espada");
		this.setAtaque(10);
		this.setPuntosDeEnergiaPorAtaque(20);
		this.setCasta(new Guerrero());
		this.setNivelMinimo(1);
	}
}
