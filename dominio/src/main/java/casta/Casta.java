package casta;

import java.util.ArrayList;

import habilidades.Habilidad;

public abstract class Casta {

	protected String nombre;
	protected String tipo;
	protected ArrayList<Habilidad> habilidades;
		
	public abstract void saludar();
	public abstract void guardarHabilidades(Habilidad habilidad);
	
	protected String getNombre() {
		return nombre;
	}

	protected void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Habilidad> getHabilidades() {
		return habilidades;
	}

	public void setHabilidades(ArrayList<Habilidad> habilidades) {
		this.habilidades = habilidades;
	}

	public Habilidad getHabilidad(int id) {
		for (Habilidad habilidad : this.habilidades) {
			if(habilidad.getId() == id) {
				return habilidad;
			}
		}
		return null;
	}
		
	public String getTipo() {
		return tipo;
	}

	protected void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Casta otro = (Casta) obj;
		if (nombre == null) {
			if (otro.nombre != null)
				return false;
		} else if (!nombre.equals(otro.nombre))
			return false;
		return true;
	}
}
