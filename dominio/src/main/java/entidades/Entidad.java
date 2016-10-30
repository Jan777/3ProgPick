package entidades;

import enums.TipoEventoEnum;

public abstract class Entidad {

	public TipoEventoEnum tipo;

	public TipoEventoEnum getTipo() {
		return tipo;
	}

	public void setTipo(TipoEventoEnum tipo) {
		this.tipo = tipo;
	}
}
