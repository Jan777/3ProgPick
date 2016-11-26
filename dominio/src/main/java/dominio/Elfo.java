package dominio;

import java.util.LinkedList;

public class Elfo extends Personaje{
	
	public Elfo(String nombre,Casta casta,int id){
		super(nombre,casta,id);
		energiaTope+=10;
		salud=saludTope;
		energia=energiaTope;
		nombreRaza="Elfo";
	}
	
	
	public Elfo(String nombre,int salud, int energia, int fuerza, int destreza, int inteligencia, Casta casta,int experiencia, int nivel, int idPersonaje) {
		super(nombre,salud, energia, fuerza, destreza, inteligencia, casta, experiencia, nivel,
				idPersonaje);
		nombreRaza="Elfo";
	}



	public boolean habilidadRaza1(Peleable atacado){ //golpelevel
		if(this.getEnergia()>10){
			this.setEnergia(this.getEnergia()-10);
			if(atacado.serAtacado(this.getFuerza()+this.getNivel()*10)!=0)
				return true;
		}
		return false;
	}
	
	public boolean habilidadRaza2(Peleable atacado){ //ataquebosque
		if(this.getEnergia()>10){
			this.setEnergia(this.getEnergia()-10);
			if(atacado.serAtacado( (int) (this.magia))!=0)
				return true;
		}
		return false;
	}

}
