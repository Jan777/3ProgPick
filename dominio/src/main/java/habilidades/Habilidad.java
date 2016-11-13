package habilidades;

import casta.Casta;
import entidades.Ente;

/**
 * 
 * @author Matias Jimenez
 *
 */
public abstract class Habilidad {
	
	public static final String CURAR = "Curar";
	public static final String CONGELAR = "Congelar";
	public static final String ESPADACHIN = "Espadachin";

	protected int id;
	protected Casta casta;
	protected int nivelRequerido;
	
	public abstract void EjecutarHabilidad(Ente lanzador, Ente objetivo);
	
	public int getId() {
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public Casta getCasta() {
		return casta;
	}
	
	public void setCasta(Casta casta) {
		this.casta = casta;
	}
	
	public int getNivelRequerido() {
		return nivelRequerido;
	}
	
	public void setNivelRequerido(int nivelRequerido) {
		this.nivelRequerido = nivelRequerido;
	}
}
