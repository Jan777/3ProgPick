package dominio;

import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

import dominio.Asesino;

public abstract class Personaje implements Peleable,Serializable {

	protected int salud;
	protected int energia;
	protected int defensa;// depende de la destreza y de los items
	protected int ataque;// depende de la fuerza y de los items
	protected int magia;// depende de la inteligencia y de los items

	protected String nombre;// hay que agregarlo a todos los constructores
	protected String nombreRaza;
	
	protected int x;
	protected int y;

	protected int saludTope;
	protected int energiaTope;

	protected int fuerza;
	protected int destreza;
	protected int inteligencia;
	protected Casta casta;

	protected int experiencia;
	protected int nivel;

	protected int idPersonaje;
	protected int itemManos = 0;
	public static int tablaDeNiveles[];

	public static void cargarTablaNivel() {
		Personaje.tablaDeNiveles = new int[101];
		Personaje.tablaDeNiveles[0] = 0;
		Personaje.tablaDeNiveles[1] = 0;
		for (int i = 2; i < 101; i++)
			Personaje.tablaDeNiveles[i] = Personaje.tablaDeNiveles[i - 1] + 50;
	}	
	
	public Personaje(){
		this.setCasta(new Asesino(0.2, 0.3, 1.5));
	}

	public Personaje(String nombre, Casta casta, int id) {
		this.nombre = nombre;
		this.casta = casta;
		this.idPersonaje = id;
		x = 0;
		y = 0;
		experiencia = 0;
		nivel = 1;
		fuerza = 10;
		inteligencia = 10;
		destreza = 10;
		if (casta instanceof Guerrero)
			fuerza += 5;
		if (casta instanceof Hechicero)
			inteligencia += 5;
		if (casta instanceof Asesino)
			destreza += 5;

		saludTope = 100;
		energiaTope = 100;

		ataque = this.calcularPuntosDeAtaque();
		defensa = this.calcularPuntosDeDefensa();
		magia = this.calcularPuntosDeMagia();

	}

	public Personaje(String nombre, int salud, int energia, int fuerza, int destreza, int inteligencia, Casta casta,
			int experiencia, int nivel,
			int idPersonaje) {

		this.nombre = nombre;
		this.salud = salud;
		this.energia = energia;
		this.fuerza = fuerza;
		this.destreza = destreza;
		this.inteligencia = inteligencia;
		this.casta = casta;
		this.experiencia = experiencia;
		this.nivel = nivel;
		this.saludTope = this.salud;
		this.energiaTope = this.energia;
		this.idPersonaje = idPersonaje;
		this.defensa = this.calcularPuntosDeDefensa();
		this.ataque = this.calcularPuntosDeAtaque();
		this.magia = this.calcularPuntosDeMagia();
	}	

	public String getNombreRaza() {
		return nombreRaza;
	}

	public void setNombreRaza(String nombreRaza) {
		this.nombreRaza = nombreRaza;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getAtaque() {
		return ataque;
	}

	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}

	public int getMagia() {
		return magia;
	}

	public void setMagia(int magia) {
		this.magia = magia;
	}

	public int getPosicion_x() {
		return x;
	}

	public void setPosicion_x(int posicion_x) {
		this.x = posicion_x;
	}

	public int getPosicion_y() {
		return y;
	}

	public void setPosicion_y(int posicion_y) {
		this.y = posicion_y;
	}

	public int getSalud() {
		return salud;
	}

	public void setSalud(int salud) {
		this.salud = salud;
	}

	public int getEnergia() {
		return energia;
	}

	public void setEnergia(int energia) {
		this.energia = energia;
	}

	public int getFuerza() {
		return fuerza;
	}

	public void setFuerza(int fuerza) {
		this.fuerza = fuerza;
	}

	public int getDestreza() {
		return destreza;
	}

	public void setDestreza(int destreza) {
		this.destreza = destreza;
	}

	public int getInteligencia() {
		return inteligencia;
	}

	public void setInteligencia(int inteligencia) {
		this.inteligencia = inteligencia;
	}

	public Casta getCasta() {
		return casta;
	}

	public void setCasta(Casta casta) {
		this.casta = casta;
	}

	public int getExperiencia() {
		return experiencia;
	}

	public void setExperiencia(int experiencia) {
		this.experiencia = experiencia;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public int getIdPersonaje() {
		return idPersonaje;
	}

	public void setIdPersonaje(int idPersonaje) {
		this.idPersonaje = idPersonaje;
	}

	public int getDefensa() {
		return defensa;
	}

	public void setDefensa(int defensa) {
		this.defensa = defensa;
	}

	public int getSaludTope() {
		return saludTope;
	}

	public void setSaludTope(int saludTope) {
		this.saludTope = saludTope;
	}

	public int getEnergiaTope() {
		return energiaTope;
	}

	public void setEnergiaTope(int energiaTope) {
		this.energiaTope = energiaTope;
	}

	public int atacar(Peleable atacado) {
		Random rnd = new Random();
		if (salud == 0)
			return 0;
		if (atacado.getSalud() > 0) {
			if (rnd.nextDouble() <= this.casta.getProbabilidadGolpeCritico() + this.destreza / 1000) {
				System.out.println("GOLPE CRITICO!");
				return atacado.serAtacado(this.golpe_critico());
			} else {
				return atacado.serAtacado(this.ataque);
			}
		}
		return 0;
	}

	public int golpe_critico() {
		return (int) (this.ataque * this.getCasta().getDa�oCritico());
	}

	public void despuesDeTurno() {

	}

	public boolean puedeAtacar() {
		return true;
	}

	public int calcularPuntosDeAtaque() {
		return (int) (this.getFuerza() * 1.5);
	}

	public int calcularPuntosDeDefensa() {
		return (int) (this.getDestreza());
	}

	public int calcularPuntosDeMagia() {
		return (int) (this.getInteligencia() * 1.5);
	}

	public void restablecerSalud() {
		this.salud = this.saludTope;
	}

	public void restablecerEnergia() {
		this.energia = this.energiaTope;
	}

	public void modificarAtributos() {
		this.ataque = this.calcularPuntosDeAtaque();
		this.defensa = this.calcularPuntosDeDefensa();
		this.magia = this.calcularPuntosDeMagia();

	}

	public boolean estaVivo() {
		return salud > 0;
	}

	public int serAtacado(int da�o) {
		Random rnd = new Random();
		if (rnd.nextDouble() >= this.getCasta().getProbabilidadEvitarDa�o()) {
			da�o -= this.defensa;
			if (da�o > 0) {
				if (salud <= da�o) {
					da�o = salud;
					salud = 0;
				} else {
					salud -= da�o;
					return da�o;
				}
			}
			return 0;
		}
		System.out.println("GOLPE EVADIDO!");
		return 0;
	}

	public int serRobadoSalud(int da�o) {
		da�o -= this.defensa;
		if (da�o <= 0)
			return 0;
		if ((salud - da�o) >= 0)
			salud -= da�o;
		else {
			da�o = salud;// le queda menos salud que el da�o inflingido
			salud = 0;
		}
		return da�o;
	}

	public int serDesernegizado(int da�o) {
		da�o -= this.defensa;
		if (da�o <= 0)
			return 0;
		if ((energia - da�o) >= 0)
			energia -= da�o;
		else {
			da�o = energia;// le queda menos energia que el da�o inflingido
			energia = 0;
		}
		return da�o;
	}

	public void serCurado(int salud) {
		if ((this.salud + salud) <= this.saludTope)
			this.salud += salud;
		else
			this.salud = this.saludTope;

	}

	public void serEnergizado(int energia) {
		if ((this.energia + energia) <= this.energiaTope)
			this.energia += energia;
		else
			this.energia = this.energiaTope;
	}

	public void AsignarPuntosSkills(int fuerza, int destreza, int inteligencia) {
		if (this.fuerza + fuerza <= 200)
			this.fuerza += fuerza;
		if (this.destreza + destreza <= 200)
			this.destreza += destreza;
		if (this.inteligencia + inteligencia <= 200)
			this.inteligencia += inteligencia;
		this.modificarAtributos();
	}

	public void subirNivel() {

		int acumuladorExperiencia = 0;
		if (this.nivel == 100) {
			System.out.println("Ya ha alcanzado el maximo nivel!");
			return;
		}
		while (this.nivel != 100 && (this.experiencia >= Personaje.tablaDeNiveles[this.nivel+1] + acumuladorExperiencia)) {
			acumuladorExperiencia += Personaje.tablaDeNiveles[this.nivel+1];
			this.nivel++;
			this.modificarAtributos();
			this.saludTope += 25;
			this.energiaTope += 20;
		}
		this.experiencia -= acumuladorExperiencia;
	}

	public void ganarExperiencia(int exp) {
		this.experiencia += exp;

		if (experiencia >= Personaje.tablaDeNiveles[this.nivel])
			this.subirNivel();
	}

	public int otorgarExp() {
		return this.nivel * 40;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	public double distanciaCon(Personaje p) {
		return Math.sqrt(Math.pow(this.x - p.x, 2) + Math.pow(this.y - p.y, 2));
	}

	public boolean habilidadCasta1(Peleable atacado) {
		return this.getCasta().habilidad1(this, atacado);
	}

	public boolean habilidadCasta2(Peleable atacado) {
		return this.getCasta().habilidad2(this, atacado);
	}

	public boolean habilidadCasta3(Peleable atacado) {
		return this.getCasta().habilidad3(this, atacado);
	}

	public abstract boolean habilidadRaza1(Peleable atacado);

	public abstract boolean habilidadRaza2(Peleable atacado);

	public int elegirOpcion() {
		String aux = "";
		aux += "1-Atacar\n";
		if (this.getCasta() instanceof Guerrero)
			aux += "2-Golpe Doble\n3-Aumentar Defensa\n4-Ignorar Defensa\n";
		if (this.getCasta() instanceof Hechicero)
			aux += "2-Bola de Fuego\n3-Curar\n4-Robar Energia y Salud\n";
		if (this.getCasta() instanceof Asesino)
			aux += "2-Golpe Critico\n3-Aumentar Evasion\n4-Robar\n";

		if (this instanceof Humano)
			aux += "5-Incentivar\n6-Golpe Fatal\n";
		if (this instanceof Elfo)
			aux += "5-Golpe Level\n6-Ataque Bosque\n";
		if (this instanceof Orco)
			aux += "5-Super Golpe\n6-Mordisco de Vida\n";
		System.out.println(aux);
		Scanner sc = new Scanner(System.in);
		return sc.nextInt();

	}
/*
	public LinkedList<Personaje> armarBatallonPjs() {
		LinkedList<Personaje> batallon_amigo = new LinkedList();
		batallon_amigo.add(this);
		if (this.getClan() != null) {
			Iterator<Personaje> it = this.getClan().getAliados().iterator();
			Personaje aux;
			while (it.hasNext()) {
				aux = it.next();
				if (aux != this && aux.distanciaCon(this) <= 10)
					batallon_amigo.add(aux);
			}

		}
		return batallon_amigo;

	}
	*/
}
