package dominio;

public class Hechicero extends Casta {

	public Hechicero(double prob_crit, double evasion, double da�o_crit) {
		super(prob_crit, evasion, da�o_crit);
		this.nombreCasta="Hechicero";
	}

	public Hechicero()
	{
		super();
		this.nombreCasta="Hechicero";
	}

	//ataca
	public boolean habilidad1(Personaje caster, Peleable atacado) {
		if (caster.getEnergia() > 10) {
			caster.setEnergia(caster.getEnergia() - 10);
			if (atacado.serAtacado((int) (caster.calcularPuntosDeMagia() * 1.5)) != 0)
				return true;
		}
		return false;
	}

	//se cura
	public boolean habilidad2(Personaje caster, Peleable aliado) {
		if (caster.getEnergia() > 10) {
			caster.setEnergia(caster.getEnergia() - 10);
			if (aliado instanceof Personaje) {
				((Personaje) aliado).serCurado(caster.calcularPuntosDeMagia());
				return true;
			}
		}
		return false;
	}

	//roba energia y se cura
	public boolean habilidad3(Personaje caster, Peleable atacado) 
	{
		if (caster.getEnergia() > 10) {
			caster.setEnergia(caster.getEnergia() - 10);
			if (atacado instanceof Personaje) {
				int energia_robada = ((Personaje) atacado).serDesernegizado(caster.calcularPuntosDeMagia());
				int salud_robada = ((Personaje) atacado).serRobadoSalud(caster.calcularPuntosDeMagia() / 2);
				caster.serEnergizado(energia_robada);
				caster.serCurado(salud_robada);
				return true;
			}

		}
		return false;
	}

}
