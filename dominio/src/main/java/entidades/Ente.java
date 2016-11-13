package entidades;

import enums.Orientacion;
//import habilidades.Habilidad;
import interfaces.Atacable;
import mapas.Mapa;

public abstract class Ente implements Atacable {

	//Atributos principales
	protected String nombre;
	protected int nivel;
	
	//Estadisticas
	protected int fuerza;
	protected int destreza;
	protected int inteligencia;
	protected int salud;
	protected int energia;
	public int altura;

	//Ataque y defensa
	protected int ataque;
	protected int defensa;
	
	//Ubicacion en el mapa de una Entidad
	protected int posicionX;
	protected int posicionY;
	protected Mapa mapa;
	protected Orientacion orientacion;
	
	// Atributo que guarda la distacia a recorrer entre el punto donde
	// se encuentra el jugador y el punto clickeado por el mouse 
	protected double distancia;
	
	protected boolean estaVivo;
		
	public Ente() {
		
	}
	
	public Ente(String nombre) {
		this.nombre = nombre;
		this.estaVivo = true;
		this.fuerza = this.destreza = this.inteligencia = 10;
		this.salud = this.energia = 100;
		this.ataque = 10;
		this.defensa = 0;
		this.nivel = 1;
		this.posicionX = this.posicionY = 0;
	}
	
	protected Ente (String nombre, int nivel, int salud, int energia, int fuerza, int destreza, int inteligencia)
	{
		this.nombre = nombre;
		this.nivel = nivel;
		this.salud = salud;
		this.energia = energia;
		this.fuerza = fuerza;
		this.destreza = destreza;
		this.inteligencia = inteligencia;
	}
	
	public abstract void despuesDeMorir();
	public abstract int calcularPuntosDeAtaque();
	public abstract int calcularPuntosDeDefensa();
	
	@Override
	public boolean estaVivo() {
		return this.salud > 0;
	}
	
	public void moverse(int posicionX, int posicionY){
		this.posicionX = posicionX;
		this.posicionY = posicionY;
		// Falta calcular hacia donde se mueve segun la posicion
		//this.setOrientacion(Orientacion.ESTE);
	}
	
	public void restarSalud(int salud) {
		this.salud -= salud;
		if(this.salud <= 0) {
			this.salud = 0;
			this.estaVivo = false;
			this.despuesDeMorir();
		}
	}
	
	public void aumentarFuerza(int fuerza) {
		this.fuerza += this.fuerza;
	}

	public void aumentarInteligencia(int inteligencia) {
		this.inteligencia += inteligencia;
	}


	public void aumentarSalud(int salud) {
		this.salud += this.salud;
	}
	
	public Orientacion getOrientacion() {
		return orientacion;
	}

	public void setOrientacion(Orientacion orientacion) {
		this.orientacion = orientacion;
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
	
	public int getNivel() {
		return this.nivel;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public int getPosicionX() {
		return posicionX;
	}

	public void setPosicionX(int posicionX) {
		this.posicionX = posicionX;
	}

	public int getPosicionY() {
		return posicionY;
	}

	public void setPosicionY(int posicionY) {
		this.posicionY = posicionY;
	}
	
	public int getInteligencia() {
		return inteligencia;
	}
	
	public void setInteligencia(int inteligencia) {
		this.inteligencia = inteligencia;
	}
	
	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}
	
	public boolean getEstaVivo() {
		return this.estaVivo;
	}
	
	public void setEstaVivo(boolean estaVivo) {
		this.estaVivo = estaVivo;
	}
}
