package frames;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import cliente.*;
import mensajeria.Comando;
import recursos.CargadorImagen;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MenuPrincipal extends JFrame {
	
	public MenuPrincipal(final Cliente cliente) {

		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// En caso de cerrar la ventana
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				synchronized (cliente) {
					cliente.setAccion(Comando.SALIR);
					cliente.notify();
				}
				dispose();
			}
		});

		setLayout(null);
		setBounds(0, 0, 550, 450);

		JPanel pnlTitulo = new JPanel();
		pnlTitulo.setLayout(null);
		pnlTitulo.setBackground(Color.WHITE);
		pnlTitulo.setBounds(0, 0, 700, 125);
		add(pnlTitulo);

		JLabel lblWordDraft = new JLabel("War Draft");
		// label.setIcon(new ImageIcon(ZRLogin.class.getResource("")));
		lblWordDraft.setHorizontalAlignment(SwingConstants.LEFT);
		lblWordDraft.setFont(new Font("Tahoma", Font.PLAIN, 99));
		lblWordDraft.setBackground(Color.RED);
		lblWordDraft.setBounds(0, 0, 700, 125);
		pnlTitulo.add(lblWordDraft);

		JPanel pnlLogin = new JPanel();
		pnlLogin.setLayout(null);
		pnlLogin.setBounds(0, 0, 550, 450);
		add(pnlLogin);

		JLabel label_1 = new JLabel("Entrar");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(Color.BLACK);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_1.setBounds(10, 130, 173, 29);
		pnlLogin.add(label_1);

		JLabel login = new JLabel("Usuario");
		login.setForeground(Color.BLACK);
		login.setFont(new Font("Tahoma", Font.PLAIN, 14));
		login.setBackground(Color.BLACK);
		login.setBounds(20, 170, 46, 14);
		pnlLogin.add(login);

		final JTextField txtLoginUsuario = new JTextField();
		txtLoginUsuario.setColumns(10);
		txtLoginUsuario.setBounds(20, 195, 177, 20);
		pnlLogin.add(txtLoginUsuario);

		JLabel clave = new JLabel("Contraseña");
		clave.setForeground(Color.BLACK);
		clave.setFont(new Font("Tahoma", Font.PLAIN, 14));
		clave.setBackground(Color.BLACK);
		clave.setBounds(20, 226, 130, 14);
		pnlLogin.add(clave);

		final JPasswordField txtLoginPassword = new JPasswordField();
		txtLoginPassword.setBounds(20, 251, 177, 20);
		pnlLogin.add(txtLoginPassword);

		JButton btnIniciarSesion = new JButton("Iniciar Sesion");
		btnIniciarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				synchronized (cliente) {
					cliente.setAccion(Comando.INICIOSESION);
					cliente.getPaqueteUsuario().setUsername(txtLoginUsuario.getText());
					cliente.getPaqueteUsuario().setPassword(txtLoginPassword.getText());
					cliente.notify();
					dispose();
				}
			}
		});
		btnIniciarSesion.setBounds(20, 282, 177, 37);
		pnlLogin.add(btnIniciarSesion);

		JButton btnLoginSalir = new JButton("Salir");
		btnLoginSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				synchronized (cliente) {
					cliente.setAccion(Comando.SALIR);
				}
				dispose();
			}
		});

		btnLoginSalir.setBounds(20, 330, 177, 37);
		pnlLogin.add(btnLoginSalir);

		final JPanel pnlRecContra = new JPanel();
		pnlRecContra.setVisible(false);
		pnlRecContra.setLayout(null);
		pnlRecContra.setBounds(100, 101, 100, 186);
		pnlLogin.add(pnlRecContra);

		JLabel text_Usuario = new JLabel("Usuario");
		text_Usuario.setForeground(Color.BLACK);
		text_Usuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		text_Usuario.setBackground(Color.BLACK);
		text_Usuario.setBounds(10, 11, 46, 14);
		pnlRecContra.add(text_Usuario);

		JLabel lblRegistrarse = new JLabel("Registrarse");
		lblRegistrarse.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistrarse.setForeground(Color.BLACK);
		lblRegistrarse.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblRegistrarse.setBounds(323, 130, 103, 29);
		pnlLogin.add(lblRegistrarse);

		JLabel label_6 = new JLabel("Usuario");
		label_6.setForeground(Color.BLACK);
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_6.setBounds(301, 170, 147, 14);
		pnlLogin.add(label_6);

		final JTextField txtUsuario = new JTextField();
		txtUsuario.setColumns(10);
		txtUsuario.setBounds(301, 195, 147, 20);
		pnlLogin.add(txtUsuario);

		JLabel labe_Password = new JLabel("Contraseña");
		labe_Password.setForeground(Color.BLACK);
		labe_Password.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labe_Password.setBounds(301, 226, 147, 14);
		pnlLogin.add(labe_Password);

		final JPasswordField pwPassword = new JPasswordField();
		pwPassword.setBounds(300, 251, 148, 20);
		pnlLogin.add(pwPassword);

		JButton btnRegistrar = new JButton("Registrarse");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				synchronized (cliente) {
					cliente.getPaqueteUsuario().setUsername(txtUsuario.getText());
					cliente.getPaqueteUsuario().setPassword(pwPassword.getText());
					cliente.setAccion(Comando.REGISTRO);
					cliente.notify();
					dispose();
				}
			}
		});
		btnRegistrar.setBounds(301, 282, 147, 37);
		pnlLogin.add(btnRegistrar);		
	}
}
