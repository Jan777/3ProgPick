package personaje;

public class PersonajeEquipado extends Personaje {

	Personaje personajeDecorado;
	
	public PersonajeEquipado(Personaje personajeDecorado) {
		super("");
		this.personajeDecorado = personajeDecorado;
	}

	@Override
	protected boolean puedeAtacar() {
		return this.personajeDecorado.puedeAtacar();
	}

	@Override
	public int obtenerPuntosDeAtaque() {
		return this.personajeDecorado.obtenerPuntosDeAtaque();
	}
	
	@Override
	protected int calcularPuntosDeAtaque() {
		return this.personajeDecorado.calcularPuntosDeAtaque();
	}

	@Override
	public int obtenerPuntosDeDefensa() {
		return this.personajeDecorado.obtenerPuntosDeDefensa();
	}

	@Override
	public int obtenerNivelDeSalud() {
		return this.personajeDecorado.obtenerNivelDeSalud();
	}
}

