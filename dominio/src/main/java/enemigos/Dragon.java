package enemigos;

import java.util.ArrayList;
import java.util.Arrays;

import entidades.*;
import habilidades.EscupirFuego;
import habilidades.Habilidad;
import mapas.Mapa;

public class Dragon extends Enemigo
{
	public Dragon(String nombre, int nivel, int salud, int energia, int fuerza, int destreza,
				  int inteligencia, boolean esPasivo, int expBaseQueOtorga) {
		super(nombre, nivel, salud, energia, fuerza, destreza, inteligencia);
		this.estaVivo = true;
		this.habilidades = new ArrayList<Habilidad>(Arrays.asList(new EscupirFuego()));
	}
	
	public Dragon(String nombre, int nivel, int salud, int energia, int mana, int fuerza, int destreza,int inteligencia, boolean esPasivo, int expBaseQueOtorga,Mapa mapa){
		super(nombre, nivel, salud, energia, fuerza, destreza, inteligencia);
		this.habilidades = new ArrayList<Habilidad>(Arrays.asList(new EscupirFuego()));
		this.estaVivo = true;
		this.mapa = mapa;
	}
	
	public Dragon(String nombre, int nivel, int salud, int energia, int mana, int fuerza, int destreza,int inteligencia, boolean esPasivo, int expBaseQueOtorga,Mapa mapa,int posicionX, int posicionY) {
		super(nombre, nivel, salud, energia, fuerza, destreza, inteligencia);
		this.habilidades = new ArrayList<Habilidad>(Arrays.asList(new EscupirFuego()));
		this.estaVivo = true;
		this.mapa = mapa;
		this.posicionX = posicionX;
		this.posicionY = posicionY;
	}

	@Override
	public void despuesDeAtacar(Ente ente) {
		this.aumentarSalud(this.salud * 2);
	}

	@Override
	public void serAtacado(int daño) {
		this.restarSalud(daño);
	}
	
	@Override
	public int obtenerPuntosDeAtaque() {
		return calcularPuntosDeAtaque();
	}

	@Override
	public int obtenerPuntosDeDefensa() {
		return calcularPuntosDeDefensa();
	}

	@Override
	public int obtenerNivelDeSalud() {
		return this.salud;
	}

	@Override
	public int calcularPuntosDeAtaque() {
		return this.ataque + (this.destreza * 2);
	}

	@Override
	public int calcularPuntosDeDefensa() {
		return 0;
	}

	@Override
	public boolean puedeAtacar() {
		return true;
	}

//	@Override
//	public void serHechizado(Habilidad habilidad) {
//		
//	}
}
