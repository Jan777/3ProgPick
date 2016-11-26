package dominio;

import java.util.Random;

public class Asesino extends Casta {

	private double probabilidadDeRobo = 0.2;

	public Asesino(double prob_crit, double evasion, double da�o_crit) {
		super(prob_crit, evasion, da�o_crit);
		this.nombreCasta = "Asesino";
	}

	public Asesino() {
		super();
		this.nombreCasta = "Asesino";
	}

	// Golpe Critico
	public boolean habilidad1(Personaje caster, Peleable atacado) {
		if (caster.getEnergia() > 10) {
			caster.setEnergia(caster.getEnergia() - 10);
			if (atacado.serAtacado((int) (caster.ataque * caster.getCasta().getDa�oCritico())) != 0)
				return true;
		}
		return false;
	}

	// Aumentar Evasion
	public boolean habilidad2(Personaje caster, Peleable atacado) {
		if (caster.getEnergia() > 10) {
			caster.setEnergia(caster.getEnergia() - 10);
			if (this.getProbabilidadEvitarDa�o() + 0.15 < 0.5)
				this.probabilidadEvitarDa�o += 0.15;
			else
				this.probabilidadEvitarDa�o = 0.5;
			return true;
		}
		return false;
	}

	@Override
	public boolean habilidad3(Personaje caster, Peleable atacado) {
		return false;
	}
}
