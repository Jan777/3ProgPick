package habilidades;

import casta.Explorador;
import entidades.Ente;

public class Curar extends Habilidad {

	public Curar() {
		this.casta = new Explorador();
		this.nivelRequerido = 5;
	}

	@Override
	public void EjecutarHabilidad(Ente lanzador, Ente objetivo) {
		objetivo.aumentarSalud(lanzador.getInteligencia() * 5);		
	}	
}
