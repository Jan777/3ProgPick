package pantallas;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import pantallas.ClienteLogica;

public class Entrada extends JPanel {
	/**
	 * @author Matias Jimenez
	 */
	private static final long serialVersionUID = -619989603551295346L;
	private JTextField txtIp;

	public Entrada() {
		setLayout(null);
		//setBounds(0, 0, ResolucionPantalla.pAncho, ResolucionPantalla.pLargo);
		
		final JButton btnEntrarAlJuego = new JButton("Entrar al juego");
		btnEntrarAlJuego.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				irALoggin();
			}			
		});
		btnEntrarAlJuego.setVisible(false);
		btnEntrarAlJuego.setForeground(Color.BLACK);
		btnEntrarAlJuego.setBackground(Color.WHITE);
		btnEntrarAlJuego.setBounds(209, 122, 148, 30);
		add(btnEntrarAlJuego);
		
		final JLabel lblEstado = new JLabel("Desconectado");
		lblEstado.setForeground(Color.RED);
		lblEstado.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEstado.setBounds(70, 122, 134, 30);
		add(lblEstado);
		
		JLabel lblIp = new JLabel("IP:");
		lblIp.setForeground(Color.BLACK);
		lblIp.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblIp.setBounds(10, 23, 50, 30);
		add(lblIp);
		
		txtIp = new JTextField();
		txtIp.setText("Localhost");
		txtIp.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtIp.setColumns(10);
		txtIp.setBounds(70, 23, 249, 30);
		add(txtIp);
		
		JButton btnProbarConexion = new JButton("Probar conexi\u00F3n");
		btnProbarConexion.addActionListener(new ActionListener() {
			//Probar conexion
			public void actionPerformed(ActionEvent arg0) {
				Cliente.cliente = new ClienteLogica(txtIp.getText());
				Cliente.cliente.start();
				if (Cliente.cliente.estaConectado()) {
					lblEstado.setText("Conectado");
					btnEntrarAlJuego.setVisible(true);
				}
			}
		});
		btnProbarConexion.setForeground(Color.BLACK);
		btnProbarConexion.setBackground(Color.WHITE);
		btnProbarConexion.setBounds(130, 64, 156, 30);
		add(btnProbarConexion);
		
		JLabel lblFondo = new JLabel("");
		//lblFondo.setIcon(new ImageIcon(ZREntrada.class.getResource("")));
		lblFondo.setBounds(0, 0, 700, 600);
		add(lblFondo);

	}
	
	private void irALoggin() {
		Cliente.irA(Cliente.LOGIN);
	}
}
