package habilidades;

import entidades.Ente;

public class EscupirFuego extends Habilidad {
	
	@Override
	public void EjecutarHabilidad(Ente lanzador, Ente objetivo) {
		objetivo.restarSalud(lanzador.getInteligencia() * 10);
	}
}
