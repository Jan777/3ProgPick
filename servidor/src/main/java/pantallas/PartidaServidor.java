package pantallas;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

import java.util.ArrayList;
import entidades.Jugador;
import raza.NPC;

public class PartidaServidor extends JPanel implements ActionListener {

	/**
	 * @author Matias Jimenez
	 */
	private static final long serialVersionUID = -4763615905127246856L;
	private boolean jugando = false;
	private static ArrayList<Jugador> jugadores;
	private static ArrayList<NPC> enemigos;
	private Servidor servidor;
	
	public PartidaServidor(Servidor servidor){
		this.jugadores = new ArrayList<Jugador>();
		this.enemigos = new ArrayList<NPC>();
		this.servidor = servidor;
		jugando = true;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
	}
}
