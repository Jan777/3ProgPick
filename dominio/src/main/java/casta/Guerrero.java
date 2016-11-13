package casta;

import habilidades.Habilidad;

public class Guerrero extends Casta {

	@Override
	public void saludar() {
		System.out.println("Victoria o Muerte");
	}

	@Override
	public void guardarHabilidades(Habilidad habilidad) {
		if(this.habilidades != null)
			this.habilidades.add(habilidad);
	}	
}