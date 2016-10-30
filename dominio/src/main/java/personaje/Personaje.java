package personaje;

import interfaces.Atacable;

public abstract class Personaje implements Atacable {
	
	//para subir de nivel reviso el fibonacci correspondiente al nivel
	protected int energia = 100;
	public int salud = 100;
	protected int SALUD_MAX = 100;
	protected int experiencia = 0;
	protected int nivel = 0;
	public int altura = 0;
	protected String nombre;	
	
	public Personaje(String nombre){
		this.nombre = nombre;
	}
	
	public final void atacar(Atacable atacado) {
		if (puedeAtacar()) {
			atacado.serAtacado(calcularPuntosDeAtaque());
			energia -= calcularPuntosDeAtaque();
			despuesDeAtacar();
		}
	}
	
	public void SubirNivel(){
	}

	protected void despuesDeAtacar() { 
		
	}
	
	protected abstract boolean puedeAtacar();
	protected abstract int calcularPuntosDeAtaque();
	public abstract int obtenerPuntosDeDefensa();
	public abstract int obtenerNivelDeSalud();
	
	public boolean estaVivo() {
		return this.salud > 0;
	}
	
	@Override
	public void serAtacado(int daño) {
		this.salud -= daño;
	}

	public void serCurado() {
		this.salud = 100;
	}

	public void serEnergizado() {
		this.energia = 100;
	}
	
	public int getSalud() {
		return this.salud;
	}

	public int obtenerPuntosDeAtaque() {
		return calcularPuntosDeAtaque();
	}
	
	public int obtenerAtaqueSegunNivel(int nivel){
		switch (nivel) {
		case 1:
			return 5;
		case 2:
			return 10;
		default:
			return 0;
		}
	}

	public void subirExperencia(int i) {
		this.experiencia += (i - this.experiencia);
		calcularNivel();
	}

	private void calcularNivel() {
		for (int i = 1; i <= 100; i++) {
			if(this.experiencia <= fibonacciDe(i)){
				this.nivel = i;
				break;
			}
		}
	}

	public int getNivel() {
		return this.nivel;
	}

	public String getNombre() {
		return this.nombre;
	}
	
	public static int fibonacciDe(int n) {
		if (n == 0) throw new RuntimeException("No se puede calcular el Fibonacci de cero");
		if (n>=3) return fibonacciDe(n - 1) + fibonacciDe(n - 2);
		return 1;
	}
}