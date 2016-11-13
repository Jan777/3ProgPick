package items;

import casta.Casta;

public abstract class Item {

	protected String nombre;
	protected Casta casta;
	protected int nivelMinimo;
	
	public String getNombre() {
		return this.nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public Casta getCasta() {
		return this.casta;
	}
	
	public void setCasta(Casta casta) {
		this.casta = casta;
	}
	
	public int getNivelMinimo() {
		return this.nivelMinimo;
	}
	
	public void setNivelMinimo(int nivelMinimo) {
		this.nivelMinimo = nivelMinimo;
	}
	
	@Override
	public boolean equals(Object obj) {
		return this.nombre.equals(((Item)obj).nombre);
	}
}
