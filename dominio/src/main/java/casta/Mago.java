package casta;

import java.util.HashMap;
import java.util.Map;

import entidades.Personaje;
import habilidades.Habilidad;
import items.Hechizo;

public class Mago extends Casta {

	private Map<String, Hechizo> hechizos = new HashMap<String, Hechizo>();
	int cantidadDeAtaques;
	
	public int getCantidadDeHechizos() {
		return this.hechizos.size();
	}
	
	public void agregarHechizo(String conjuro, Hechizo hechizo) {
		this.hechizos.put(conjuro, hechizo);
	}
	
	public void hechizar(String conjuro, Personaje personaje) {
		this.hechizos.get(conjuro).afectar(personaje);
	}

	protected void despuesDeAtacar() {
		cantidadDeAtaques++;
	}

	@Override
	public void saludar() {
		System.out.println("Soy un mago!");
	}

	@Override
	public void guardarHabilidades(Habilidad habilidad) {
		if(this.habilidades != null)
			this.habilidades.add(habilidad);
	}
}
