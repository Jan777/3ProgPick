package recursos;

import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Recursos {

	private static int ANCHO; // Ancho del frame a obtener
	private static int ALTO; // Alto del frame a obtener

	public static Map<String, LinkedList<BufferedImage[]>> personaje = new HashMap<>();

	// Inicio Personajes
	public static LinkedList<BufferedImage[]> humano = new LinkedList<>();
	private static BufferedImage[] humanoIzq;
	private static BufferedImage[] humanoArribaIzq;
	private static BufferedImage[] humanoArriba;
	private static BufferedImage[] humanoArribaDer;
	private static BufferedImage[] humanoDer;
	private static BufferedImage[] humanoAbajoDer;
	private static BufferedImage[] humanoAbajo;
	private static BufferedImage[] humanoAbajoIzq;

	public static LinkedList<BufferedImage[]> orco = new LinkedList<>();
	private static BufferedImage[] orcoIzq;
	private static BufferedImage[] orcoArribaIzq;
	private static BufferedImage[] orcoArriba;
	private static BufferedImage[] orcoArribaDer;
	private static BufferedImage[] orcoDer;
	private static BufferedImage[] orcoAbajoDer;
	private static BufferedImage[] orcoAbajo;
	private static BufferedImage[] orcoAbajoIzq;

	public static LinkedList<BufferedImage[]> elfo = new LinkedList<>();
	private static BufferedImage[] elfoIzq;
	private static BufferedImage[] elfoArribaIzq;
	private static BufferedImage[] elfoArriba;
	private static BufferedImage[] elfoArribaDer;
	private static BufferedImage[] elfoDer;
	private static BufferedImage[] elfoAbajoDer;
	private static BufferedImage[] elfoAbajo;
	private static BufferedImage[] elfoAbajoIzq;
	// Fin Personajes

	// Entorno
	public static BufferedImage cesped;
	public static BufferedImage roca;
	public static BufferedImage agua;
	public static BufferedImage arena;
	public static BufferedImage mundo1;
	public static BufferedImage mundo2;
	public static BufferedImage mundo3;
	public static BufferedImage marco;
	public static BufferedImage botonMenu;
	public static BufferedImage arbol;
	public static BufferedImage palmera;
	public static BufferedImage arbusto;
	public static BufferedImage tierra;
	public static BufferedImage vacio;
	// Fin Entorno

	// Batalla
	public static BufferedImage barraComandos;
	public static BufferedImage estadoPersonaje;
	public static BufferedImage barraSalud;
	public static BufferedImage barraEnergia;
	public static BufferedImage barraExperiencia;
	public static BufferedImage habilidad1;
	public static BufferedImage habilidad2;
	public static BufferedImage habilidad3;
	// Fin Batalla

	// Se cargan todos los recursos del juego una sola vez al inicio

	public static void cargar() {

		ANCHO = 256;
		ALTO = 256;
		// Inicio humano

		SpriteSheet spritehumano = new SpriteSheet(CargadorImagen.cargarImagen("/recursos/humano.png"));

		humanoIzq = new BufferedImage[4];
		humanoArribaIzq = new BufferedImage[4];
		humanoArriba = new BufferedImage[4];
		humanoArribaDer = new BufferedImage[4];
		humanoDer = new BufferedImage[4];
		humanoAbajoDer = new BufferedImage[4];
		humanoAbajo = new BufferedImage[4];
		humanoAbajoIzq = new BufferedImage[4];

		for (int i = 0; i < 4; i++) {
			humanoIzq[i] = spritehumano.getTile(ANCHO * i, 0, ANCHO, ALTO);
		}

		for (int i = 0; i < 4; i++) {
			humanoArribaIzq[i] = spritehumano.getTile(ANCHO * i, ALTO, ANCHO, ALTO);
		}

		for (int i = 0; i < 4; i++) {
			humanoArriba[i] = spritehumano.getTile(ANCHO * i, ALTO * 2, ANCHO, ALTO);
		}

		for (int i = 0; i < 4; i++) {
			humanoArribaDer[i] = spritehumano.getTile(ANCHO * i, ALTO * 3, ANCHO, ALTO);
		}

		for (int i = 0; i < 4; i++) {
			humanoDer[i] = spritehumano.getTile(ANCHO * i, ALTO * 4, ANCHO, ALTO);
		}

		for (int i = 0; i < 4; i++) {
			humanoAbajoDer[i] = spritehumano.getTile(ANCHO * i, ALTO * 5, ANCHO, ALTO);
		}

		for (int i = 0; i < 4; i++) {
			humanoAbajo[i] = spritehumano.getTile(ANCHO * i, ALTO * 6, ANCHO, ALTO);
		}

		for (int i = 0; i < 4; i++) {
			humanoAbajoIzq[i] = spritehumano.getTile(ANCHO * i, ALTO * 7, ANCHO, ALTO);
		}

		humano.add(humanoIzq);
		humano.add(humanoArribaIzq);
		humano.add(humanoArriba);
		humano.add(humanoArribaDer);
		humano.add(humanoDer);
		humano.add(humanoAbajoDer);
		humano.add(humanoAbajo);
		humano.add(humanoAbajoIzq);
		// Fin humano

		// Inicio orco
		SpriteSheet spriteorco = new SpriteSheet(CargadorImagen.cargarImagen("/recursos/orco.png"));

		orcoIzq = new BufferedImage[4];
		orcoArribaIzq = new BufferedImage[4];
		orcoArriba = new BufferedImage[4];
		orcoArribaDer = new BufferedImage[4];
		orcoDer = new BufferedImage[4];
		orcoAbajoDer = new BufferedImage[4];
		orcoAbajo = new BufferedImage[4];
		orcoAbajoIzq = new BufferedImage[4];

		for (int i = 0; i < 4; i++) {
			orcoIzq[i] = spriteorco.getTile(ANCHO * i, 0, ANCHO, ALTO);
		}

		for (int i = 0; i < 4; i++) {
			orcoArribaIzq[i] = spriteorco.getTile(ANCHO * i, ALTO, ANCHO, ALTO);
		}

		for (int i = 0; i < 4; i++) {
			orcoArriba[i] = spriteorco.getTile(ANCHO * i, ALTO * 2, ANCHO, ALTO);
		}

		for (int i = 0; i < 4; i++) {
			orcoArribaDer[i] = spriteorco.getTile(ANCHO * i, ALTO * 3, ANCHO, ALTO);
		}

		for (int i = 0; i < 4; i++) {
			orcoDer[i] = spriteorco.getTile(ANCHO * i, ALTO * 4, ANCHO, ALTO);
		}

		for (int i = 0; i < 4; i++) {
			orcoAbajoDer[i] = spriteorco.getTile(ANCHO * i, ALTO * 5, ANCHO, ALTO);
		}

		for (int i = 0; i < 4; i++) {
			orcoAbajo[i] = spriteorco.getTile(ANCHO * i, ALTO * 6, ANCHO, ALTO);
		}

		for (int i = 0; i < 4; i++) {
			orcoAbajoIzq[i] = spriteorco.getTile(ANCHO * i, ALTO * 7, ANCHO, ALTO);
		}

		orco.add(orcoIzq);
		orco.add(orcoArribaIzq);
		orco.add(orcoArriba);
		orco.add(orcoArribaDer);
		orco.add(orcoDer);
		orco.add(orcoAbajoDer);
		orco.add(orcoAbajo);
		orco.add(orcoAbajoIzq);

		// Fin orco

		// Inicio elfo
		SpriteSheet spriteElfo = new SpriteSheet(CargadorImagen.cargarImagen("/recursos/elfo.png"));

		elfoIzq = new BufferedImage[4];
		elfoArribaIzq = new BufferedImage[4];
		elfoArriba = new BufferedImage[4];
		elfoArribaDer = new BufferedImage[4];
		elfoDer = new BufferedImage[4];
		elfoAbajoDer = new BufferedImage[4];
		elfoAbajo = new BufferedImage[4];
		elfoAbajoIzq = new BufferedImage[4];

		for (int i = 0; i < 4; i++) {
			elfoIzq[i] = spriteElfo.getTile(ANCHO * i, 0, ANCHO, ALTO);
		}

		for (int i = 0; i < 4; i++) {
			elfoArribaIzq[i] = spriteElfo.getTile(ANCHO * i, ALTO, ANCHO, ALTO);
		}

		for (int i = 0; i < 4; i++) {
			elfoArriba[i] = spriteElfo.getTile(ANCHO * i, ALTO * 2, ANCHO, ALTO);
		}

		for (int i = 0; i < 4; i++) {
			elfoArribaDer[i] = spriteElfo.getTile(ANCHO * i, ALTO * 3, ANCHO, ALTO);
		}

		for (int i = 0; i < 4; i++) {
			elfoDer[i] = spriteElfo.getTile(ANCHO * i, ALTO * 4, ANCHO, ALTO);
		}

		for (int i = 0; i < 4; i++) {
			elfoAbajoDer[i] = spriteElfo.getTile(ANCHO * i, ALTO * 5, ANCHO, ALTO);
		}

		for (int i = 0; i < 4; i++) {
			elfoAbajo[i] = spriteElfo.getTile(ANCHO * i, ALTO * 6, ANCHO, ALTO);
		}

		for (int i = 0; i < 4; i++) {
			elfoAbajoIzq[i] = spriteElfo.getTile(ANCHO * i, ALTO * 7, ANCHO, ALTO);
		}

		elfo.add(elfoIzq);
		elfo.add(elfoArribaIzq);
		elfo.add(elfoArriba);
		elfo.add(elfoArribaDer);
		elfo.add(elfoDer);
		elfo.add(elfoAbajoDer);
		elfo.add(elfoAbajo);
		elfo.add(elfoAbajoIzq);
		// Fin elfo

		// Agrego los pj al hash
		personaje.put("Humano", humano);
		personaje.put("Orco", orco);
		personaje.put("Elfo", elfo);

		// Inicio Entorno
		cesped = CargadorImagen.cargarImagen("/recursos/pasto.png");
		roca = CargadorImagen.cargarImagen("/recursos/concreto.png");
		tierra = CargadorImagen.cargarImagen("/recursos/tierra.png");		
		mundo1 = CargadorImagen.cargarImagen("/recursos/mundo1.jpg");
		mundo2 = CargadorImagen.cargarImagen("/recursos/mundo2.jpg");
		mundo3 = CargadorImagen.cargarImagen("/recursos/mundo3.jpg");
		agua = CargadorImagen.cargarImagen("/recursos/agua.png");
		arena = CargadorImagen.cargarImagen("/recursos/arena.png");
		arbol = CargadorImagen.cargarImagen("/recursos/arbol.png");
		palmera = CargadorImagen.cargarImagen("/recursos/palmera.png");
		arbusto = CargadorImagen.cargarImagen("/recursos/arbusto.png");
		vacio = null;
		botonMenu=CargadorImagen.cargarImagen("/recursos/botonMenu.jpg");
		// Fin Entorno

		// Inicio Batalla
		barraComandos = CargadorImagen.cargarImagen("/recursos/BarraComandos.png");
		estadoPersonaje = CargadorImagen.cargarImagen("/recursos/EstadoPersonaje.png");
		barraSalud = CargadorImagen.cargarImagen("/recursos/BarraDeSalud.png");
		barraEnergia = CargadorImagen.cargarImagen("/recursos/BarraDeEnergia.png");
		barraExperiencia = CargadorImagen.cargarImagen("/recursos/BarraDeExperiencia.png");
		habilidad1 = CargadorImagen.cargarImagen("/recursos/espada.jpg");
		habilidad2 = CargadorImagen.cargarImagen("/recursos/escudo.jpg");
		//habilidad3 = CargadorImagen.cargarImagen("/habilidad3.png");
		// Fin Batalla
	}
}
