package entidades;

import casta.Casta;
import interfaces.Atacable;
import itemsTipo.ItemAtaque;
import itemsTipo.ItemDefensa;

public abstract class Personaje extends Ente implements Atacable {
		
	public static final int EXPERIENCIA_LIMITE = 100;
	
	protected int experiencia = 1; // la actual
	protected int victorias;
	protected int derrotas;
	protected Casta casta;
	
	// Por el momento equipa un item de ataque y defensa, pero deberia poder tener una lista de items.
	protected ItemAtaque objectoAtaque;
	protected ItemDefensa objectoDefensa;
	
	public Personaje(String nombre){
		super(nombre);
	}	
	
	public abstract void subirEstadisticas(int nivel);
	
	@Override
	public int obtenerPuntosDeAtaque() {
		return this.ataque + calcularPuntosDeAtaque();
	}
	
	@Override
	public int obtenerPuntosDeDefensa() {
		return this.defensa + calcularPuntosDeDefensa();
	}
	
	@Override
	public int obtenerNivelDeSalud() {
		return this.salud;
	}
	
	@Override
	public void serAtacado(int daño) {
		this.salud -= daño;
		if(this.salud <= 0) {
			this.estaVivo = false;
		}
	}
	
	@Override
	public void despuesDeAtacar(Ente ente) {
		
	}
	
	@Override
	public void despuesDeMorir() {
		
	}
	
	@Override
	public int calcularPuntosDeAtaque(){
		// Deberia ver que Items de ataque tiene y volver la sumatoria
		if(this.objectoAtaque != null)
			return objectoAtaque.getAtaque();
		return 0;
	}
	
	@Override
	public int calcularPuntosDeDefensa() {
		// Deberia ver que Items de defensa tiene y volver la sumatoria
		return 0;
	}
	
	public final void atacar(Atacable atacado) {
		if (puedeAtacar()) {
			atacado.serAtacado(calcularPuntosDeAtaque());
			this.energia -= calcularPuntosDeAtaque();
			if(!atacado.estaVivo())
				this.aumentarExperiencia(Personaje.FibonacciDe(this.experiencia));
			despuesDeAtacar();
		}
	}	
	
	public void subirNivel() {
		this.nivel = this.nivel + 1;
	}
	
	public void subirExperiencia(int experiencia) {
		this.experiencia += experiencia;
		if(this.experiencia >= Personaje.EXPERIENCIA_LIMITE){
			this.subirNivel();
			this.experiencia = 0;
		}
	}	
	
	public void aumentarExperiencia(int experiencia) {
		this.experiencia += experiencia;
	}
	
	public void equiparObjectoDefensa(ItemDefensa objDefensa) {
		if(objDefensa.getCasta().equals(this.getCasta()) && objDefensa.getNivelMinimo() <= this.getNivel()) {
			this.objectoDefensa = objDefensa;
			this.setDefensa(objDefensa.getDefensa()+this.getDefensa());
		}
		else {
			System.out.println("No podes usar esta arma gil!!!");
		}
	}
	
	public void equiparObjectoAtaque(ItemAtaque objAtaque){
		if(objAtaque.getCasta().equals(this.getCasta()) && objAtaque.getNivelMinimo() <= this.getNivel()){
			this.objectoAtaque = objAtaque;
			this.setAtaque(objectoAtaque.getAtaque() + this.getAtaque());
		}
		else {
			System.out.println("No se puede equipar el arma!!");
		}
	}
	
	public void mostrarDatos(){
		System.out.println("Nombre: " + super.getNombre());
		System.out.println("Nivel: " + super.getNivel());
	}
	
	public static int FibonacciDe(int n) {
		if (n == 0) throw new RuntimeException("No se puede calcular el Fibonacci de cero");
		if (n >= 3) return FibonacciDe(n - 1) + FibonacciDe(n - 2);
		return 1;
	}

	protected void despuesDeAtacar() { 	
		
	}
	
	public Casta getCasta() {
		return casta;
	}

	public void setCasta(Casta casta) {
		this.casta = casta;
	}
	
	public int getAtaque() {
		return ataque;
	}

	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}

	public int getDefensa() {
		return defensa;
	}

	public void setDefensa(int defensa) {
		this.defensa = defensa;
	}
	
	public int getExperiencia() {
		return this.experiencia;
	}

	public void setExperiencia(int experiencia) {
		this.experiencia = experiencia;
	}
}