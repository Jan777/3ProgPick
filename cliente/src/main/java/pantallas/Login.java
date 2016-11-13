package pantallas;

import javax.swing.JPanel;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.SwingConstants;

import constantes.Mensaje;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JPanel {
	/**
	 * @author Matias Jimenez
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtLoginUsuario;
	private JPasswordField txtLoginPassword;
	private JTextField txtRegistrarseNick;
	private JTextField txtRegistrarseUsuario;
	private JPasswordField txtRegistrarsePassword;
	private JTextField txtRegistrarsePregSec;
	private JTextField txtRegistrarseResp;
	private JTextField txtRecuperarUsuario;
	private JTextField txtRecuperarPregSec;
	private JTextField txtRecuperarRespuesta;

	/**
	 * Create the panel.
	 * @param zrCliente 
	 */
	public Login(final Cliente zrCliente) {
		setLayout(null);
		setBounds(0, 0, 700, 600);
		
		JPanel pnlTitulo = new JPanel();
		pnlTitulo.setLayout(null);
		pnlTitulo.setBackground(Color.WHITE);
		pnlTitulo.setBounds(0, 0, 483, 123);
		add(pnlTitulo);
		
		JLabel lblWordDraft = new JLabel("War Draft");
		//label.setIcon(new ImageIcon(ZRLogin.class.getResource("")));
		lblWordDraft.setHorizontalAlignment(SwingConstants.LEFT);
		lblWordDraft.setFont(new Font("Tahoma", Font.PLAIN, 99));
		lblWordDraft.setBackground(Color.RED);
		lblWordDraft.setBounds(0, 0, 700, 125);
		pnlTitulo.add(lblWordDraft);
		
		JLabel label_13 = new JLabel("");
		label_13.setBounds(0, 121, 700, 477);
		pnlTitulo.add(label_13);
		
		JPanel pnlLogin = new JPanel();
		pnlLogin.setLayout(null);
		pnlLogin.setBounds(0, 0, 700, 600);
		add(pnlLogin);
		
		JLabel label_1 = new JLabel("Entrar");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(Color.BLACK);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_1.setBounds(10, 130, 173, 29);
		pnlLogin.add(label_1);
		
		JLabel label_2 = new JLabel("Usuario");
		label_2.setForeground(Color.BLACK);
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_2.setBackground(Color.BLACK);
		label_2.setBounds(20, 170, 46, 14);
		pnlLogin.add(label_2);
		
		txtLoginUsuario = new JTextField();
		txtLoginUsuario.setColumns(10);
		txtLoginUsuario.setBounds(20, 195, 177, 20);
		pnlLogin.add(txtLoginUsuario);
		
		JLabel label_3 = new JLabel("Contrase\u00F1a");
		label_3.setForeground(Color.BLACK);
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_3.setBackground(Color.BLACK);
		label_3.setBounds(20, 226, 130, 14);
		pnlLogin.add(label_3);
		
		txtLoginPassword = new JPasswordField();
		txtLoginPassword.setBounds(20, 251, 177, 20);
		pnlLogin.add(txtLoginPassword);
		
		JButton btnLoginEntrar = new JButton("Entrar");
		btnLoginEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String usuario = txtLoginUsuario.getText(),
					password = txtLoginPassword.getText().toString();
				System.out.println("User y pass: " + usuario + " " + password);
				if( Cliente.cliente.loguearse(usuario, password) != Mensaje.LOGEO_INCORRECTO ) {
					JOptionPane.showMessageDialog(null, "Te has logueado correctamente.");
				}
				else {
					JOptionPane.showMessageDialog(null, "Ha fallado el login");
				}
			}
		});
		btnLoginEntrar.setBounds(20, 282, 177, 37);
		pnlLogin.add(btnLoginEntrar);
		
		JButton btnLoginSalir = new JButton("Salir");
		btnLoginSalir.setBounds(20, 330, 177, 37);
		pnlLogin.add(btnLoginSalir);
		
		JButton btnLoginOlvidoContra = new JButton("Olvido su contrasenia?");
		
		btnLoginOlvidoContra.setBounds(20, 378, 177, 20);
		pnlLogin.add(btnLoginOlvidoContra);
		
		final JPanel pnlRecContra = new JPanel();
		pnlRecContra.setVisible(false);
		pnlRecContra.setLayout(null);
		pnlRecContra.setBounds(222, 181, 253, 186);
		pnlLogin.add(pnlRecContra);
		
		JLabel label_10 = new JLabel("Usuario");
		label_10.setForeground(Color.BLACK);
		label_10.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_10.setBackground(Color.BLACK);
		label_10.setBounds(10, 11, 46, 14);
		pnlRecContra.add(label_10);
		
		txtRecuperarUsuario = new JTextField();
		txtRecuperarUsuario.setColumns(10);
		txtRecuperarUsuario.setBounds(11, 26, 172, 20);
		pnlRecContra.add(txtRecuperarUsuario);
		
		JButton btnRecuperarGo = new JButton(">");
		btnRecuperarGo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnRecuperarGo.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnRecuperarGo.setBounds(193, 26, 55, 23);
		pnlRecContra.add(btnRecuperarGo);
		
		JLabel label_11 = new JLabel("Pregunta Secreta");
		label_11.setForeground(Color.BLACK);
		label_11.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_11.setBackground(Color.BLACK);
		label_11.setBounds(11, 47, 139, 20);
		pnlRecContra.add(label_11);
		
		txtRecuperarPregSec = new JTextField();
		txtRecuperarPregSec.setEnabled(false);
		txtRecuperarPregSec.setColumns(10);
		txtRecuperarPregSec.setBounds(12, 68, 171, 20);
		pnlRecContra.add(txtRecuperarPregSec);
		
		JLabel label_12 = new JLabel("Respuesta");
		label_12.setForeground(Color.BLACK);
		label_12.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_12.setBackground(Color.BLACK);
		label_12.setBounds(11, 89, 122, 20);
		pnlRecContra.add(label_12);
		
		txtRecuperarRespuesta = new JTextField();
		txtRecuperarRespuesta.setColumns(10);
		txtRecuperarRespuesta.setBounds(12, 112, 171, 20);
		pnlRecContra.add(txtRecuperarRespuesta);
		
		JButton btnRecuperarContra = new JButton("Recuperar contrase\u00F1a");
		btnRecuperarContra.setBounds(11, 137, 171, 38);
		pnlRecContra.add(btnRecuperarContra);
		
		JButton button = new JButton("X");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pnlRecContra.setVisible(false);
			}
		});
		button.setFont(new Font("Tahoma", Font.BOLD, 20));
		button.setBounds(193, 60, 55, 23);
		pnlRecContra.add(button);
		
		JLabel lblRegistrarse = new JLabel("Registrarse");
		lblRegistrarse.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistrarse.setForeground(Color.BLACK);
		lblRegistrarse.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblRegistrarse.setBounds(523, 130, 103, 29);
		pnlLogin.add(lblRegistrarse);
		
		JLabel label_5 = new JLabel("Nick");
		label_5.setForeground(Color.BLACK);
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_5.setBounds(501, 155, 147, 14);
		pnlLogin.add(label_5);
		
		txtRegistrarseNick = new JTextField();
		txtRegistrarseNick.setColumns(10);
		txtRegistrarseNick.setBounds(501, 180, 147, 20);
		pnlLogin.add(txtRegistrarseNick);
		
		JLabel label_6 = new JLabel("Usuario");
		label_6.setForeground(Color.BLACK);
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_6.setBounds(501, 211, 147, 14);
		pnlLogin.add(label_6);
		
		txtRegistrarseUsuario = new JTextField();
		txtRegistrarseUsuario.setColumns(10);
		txtRegistrarseUsuario.setBounds(501, 236, 147, 20);
		pnlLogin.add(txtRegistrarseUsuario);
		
		JLabel label_7 = new JLabel("Contrase\u00F1a");
		label_7.setForeground(Color.BLACK);
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_7.setBounds(501, 267, 147, 14);
		pnlLogin.add(label_7);
		
		txtRegistrarsePassword = new JPasswordField();
		txtRegistrarsePassword.setBounds(500, 292, 148, 20);
		pnlLogin.add(txtRegistrarsePassword);
		
		JLabel label_8 = new JLabel("Pregunta Secreta");
		label_8.setForeground(Color.BLACK);
		label_8.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_8.setBounds(500, 323, 148, 14);
		pnlLogin.add(label_8);
		
		txtRegistrarsePregSec = new JTextField();
		txtRegistrarsePregSec.setColumns(10);
		txtRegistrarsePregSec.setBounds(500, 348, 148, 20);
		pnlLogin.add(txtRegistrarsePregSec);
		
		JLabel label_9 = new JLabel("Respuesta");
		label_9.setForeground(Color.BLACK);
		label_9.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_9.setBounds(500, 379, 148, 14);
		pnlLogin.add(label_9);
		
		txtRegistrarseResp = new JTextField();
		txtRegistrarseResp.setColumns(10);
		txtRegistrarseResp.setBounds(500, 404, 148, 20);
		pnlLogin.add(txtRegistrarseResp);
		
		JButton btnCrearUsuario = new JButton("Crear Usuario");
		btnCrearUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String usuarioR = txtRegistrarseUsuario.getText(),
					   passwordR = txtRegistrarsePassword.getText().toString(),
					   nickR = txtRegistrarseNick.getText(),
					   pregR = txtRegistrarsePregSec.getText(),
					   respR = txtRegistrarseResp.getText();
				Cliente.cliente.registrarse(usuarioR, passwordR, nickR, pregR, respR);
				JOptionPane.showMessageDialog(null, "El usuario se ha creado correctamente.");
			}
		});
		btnCrearUsuario.setBounds(501, 454, 147, 37);
		pnlLogin.add(btnCrearUsuario);
		
		btnLoginOlvidoContra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pnlRecContra.setVisible(true);
			}
		});
	}
}
