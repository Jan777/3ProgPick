package personaje;

import java.awt.Graphics2D;

import interfaces.Atacable;

public abstract class Personaje implements Atacable {
	
	protected double x;
	protected double y;
	
	protected double dx;
	protected double dy;
	
	protected int antX;
	protected int antY;
	
	protected int velocidad;
	
	//protected Mapa mapa; 
	
	// Atributo que guarda la distacia a recorrer entre el punto donde
	// se encuentra el jugador y el punto clickeado por el mouse 
	protected double distancia; 
	
	//para subir de nivel reviso el fibonacci correspondiente al nivel
	protected int energia = 100;
	public int salud = 100;
	protected int SALUD_MAX = 100;
	protected int experiencia = 0;
	protected int nivel = 0;
	public int altura = 0;
	protected String nombre;	
	
	// Constructor que recibe como referencia el objeto mapa para obtener posiciones 
	// validas o invalidas del mapa (colisiones contra obejetos, etc). ver despues 
//	public Personaje(String nombre, Mapa mapa){
//		this.nombre = nombre;
//      this.mapa = mapa;
//	}
	
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
	
	// falta (ver despues)
	public boolean colision(){
		return false;
	}
	
	// Metodo que mueve la pantalla en base al movimiento del jugador
//	private void moverMapa(){
//		mapa.setX((int) ((Juego.ANCHO / 2) - x));
//		mapa.setY((int) ((Juego.LARGO / 2) - y));
//	}
	
	public void update(){
		x += dx;
		y += dy;		
		detenerJugador();
	}
	
	private double distanciaEntrePuntos(double x, double y){
		return Math.sqrt(x * x + y * y);
	}
	
	/*  Metodo que recibe la posicion x e y del mouse al cliackearlo
	 *  calcula la distancia en tres los puntos A, B y mueve al jugador hasta dicha posición.
	 *  El jugador se detiene luego de recorrer la distacia calculada. 
	 */ 
	public void moverJugador(int x, int y){
		
		if(x != this.x || y != this.y){
			antX = (int) this.x;
			antY = (int) this.y;
			distancia = distanciaEntrePuntos(x - this.x, y - this.y);
			dx = ((x - this.x) / distancia) * velocidad;
			dy = ((y - this.y) / distancia) * velocidad;
		}
	}
	
	private void detenerJugador(){
		double dist = (int) distanciaEntrePuntos(x - antX, y - antY);	
		if(dist >= distancia){
			dx = 0;
			dy = 0;
		}
	}
	
	// Metodo que se encarga de dibujar al jugador en pantalla
	public void draw(Graphics2D g){
	
	}
	
	
}