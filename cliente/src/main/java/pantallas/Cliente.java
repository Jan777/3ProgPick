package pantallas;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import hilos.*;

public class Cliente extends JFrame {

	/**
	 * @author Matias Jimenez
	 */
	private static final long serialVersionUID = 3450984981898471246L;

	private JPanel contentPane;

	public static final String ENTRADA = "Entrada";
	public static final String LOGIN = "Login";

	public static final String MODIFICAR_DATOS = "ModificarDatos";

	
	private CardLayout cardLayout;
	public static ClienteLogica cliente;
	private static Cliente frame;

	public Entrada Entrada ;
	public Login Login ;

	public ModificarDatos ModificarDatos ;
	public String partida = "";
	public int minJ = 0, maxJ = 0;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Cliente();
					frame.setLocationRelativeTo(null);
					//frame.setResizable(false);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Cliente() {		

		Entrada = new Entrada();
		Login = new Login(this);

		ModificarDatos = new ModificarDatos();


		setTitle("jUEGO");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 700, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		cardLayout = new CardLayout();
		contentPane.setLayout(cardLayout);
		contentPane.add(Entrada, ENTRADA);
		contentPane.add(Login, LOGIN);
		contentPane.add(ModificarDatos, MODIFICAR_DATOS);
	}

	public static void irA(final String pantalla) {
	    EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                frame.cardLayout.show(frame.getContentPane(), pantalla);
            }
        });
	}
	

}
