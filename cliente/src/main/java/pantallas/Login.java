package pantallas;

import java.awt.EventQueue;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import logica.Cliente;

import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;
import java.awt.event.ActionEvent;
import java.awt.Color;

@SuppressWarnings("serial")
public class Login extends JFrame {

	ImageIcon imagen;
	private Cliente cliente;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 500);
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(null);

		// text de usuario
		JLabel lusuario = new JLabel("USUARIO");
		lusuario.setForeground(Color.BLACK);
		lusuario.setHorizontalAlignment(SwingConstants.CENTER);
		lusuario.setBounds(140, 157, 63, 20);
		getContentPane().add(lusuario);
		final JTextPane tusuario = new JTextPane();
		tusuario.setBounds(201, 157, 170, 20);
		getContentPane().add(tusuario);
		tusuario.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_TAB) {
					tusuario.transferFocus();
					e.consume();
				}
			}
		});

		// text de password
		JLabel lpassword = new JLabel("PASSWORD");
		lpassword.setForeground(Color.BLACK);
		lpassword.setBounds(126, 203, 70, 20);
		getContentPane().add(lpassword);
		final JPasswordField tpassword = new JPasswordField();
		tpassword.setBounds(199, 203, 172, 20);
		getContentPane().add(tpassword);
		tpassword.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_TAB) {
					tpassword.transferFocus();
					e.consume();
				}
			}
		});

		// DATOS DEL SERVER
		JLabel lservidor = new JLabel("SERVIDOR");
		lservidor.setForeground(Color.BLACK);
		lservidor.setBounds(113, 249, 63, 20);
		getContentPane().add(lservidor);
		final JTextPane tservidor = new JTextPane();
		tservidor.setBounds(179, 249, 106, 20);
		getContentPane().add(tservidor);
		tservidor.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_TAB) {
					tservidor.transferFocus();
					e.consume();
				}
			}
		});
		JLabel lpuerto = new JLabel("PUERTO");
		lpuerto.setForeground(Color.BLACK);
		lpuerto.setBounds(290, 249, 49, 20);
		getContentPane().add(lpuerto);
		final JTextPane tpuerto = new JTextPane();
		tpuerto.setBounds(340, 249, 49, 20);
		getContentPane().add(tpuerto);
		tpuerto.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_TAB) {
					tpuerto.transferFocus();
					e.consume();
				}
			}
		});

		tusuario.setText("matias2016");
		tpassword.setText("matias2016");
		tservidor.setText("localhost");
		tpuerto.setText("21412");

		// logica del boton registrar
		JButton bregistrar = new JButton("Registrarse");
		bregistrar.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				if (tusuario.getText().length() > 0 && tservidor.getText().length() > 0 && tpuerto.getText().length() > 0 && tpassword.getPassword().length != 0) {
					cliente = new Cliente(tusuario.getText().toUpperCase(), tpassword.getText().toUpperCase(), tservidor.getText(), tpuerto.getText(), "REGISTRO");
					try {
						TimeUnit.MILLISECONDS.sleep(100);
						if (cliente.getJuego().getRegistro().equals("OK")) {
							JOptionPane.showMessageDialog(null, "Usuario creado");
							tusuario.setText("");
							tpassword.setText("");
							cliente.getJuego().salir();
						} else if (cliente.getJuego().getRegistro().equals("NO")) {
							JOptionPane.showMessageDialog(null, "El usuario ya existe");
							tusuario.setText("");
							tpassword.setText("");
							cliente.getJuego().salir();
						}else {
							//tusuario.setText("");
							//tpassword.setText("");
							//tservidor.setText("");
						}
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		bregistrar.setBounds(150, 301, 101, 23);
		bregistrar.setBorderPainted(false);
		getContentPane().add(bregistrar);

		// control login
		JButton blogin = new JButton("LOGIN");
		blogin.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				// validacion de usuario
				if (tusuario.getText().length() > 0 && tservidor.getText().length() > 0 && tpuerto.getText().length() > 0 && tpassword.getPassword().length != 0) {
					cliente = new Cliente(tusuario.getText().toUpperCase(), tpassword.getText().toUpperCase(), tservidor.getText(), tpuerto.getText(), "LOGIN");
					try {
						TimeUnit.MILLISECONDS.sleep(100);
						if (cliente.getJuego().getLogin().equals("OK")) {
							System.out.println("HAZ INGRESADO !!!");
						} else if (cliente.getJuego().getLogin().equals("NO")) {
							JOptionPane.showMessageDialog(null, "El usuario no existe, debe registrarse");
							tusuario.setText("");
							tpassword.setText("");
							cliente.getJuego().salir();
						} else if (cliente.getJuego().getLogin().equals("Y")) {
							JOptionPane.showMessageDialog(null, "El usuario ya se encuentra logueado");
							tusuario.setText("");
							tpassword.setText("");
						}
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
				} else {
					JOptionPane.showMessageDialog(null, "No puede haber campos en blanco");
				}
			}
		});
		blogin.setBounds(292, 301, 89, 23);
		blogin.setBorderPainted(false);
		getContentPane().add(blogin);

		// derechos
		JLabel derechos = new JLabel("Prohibido copiar este juego");
		derechos.setForeground(Color.WHITE);
		derechos.setBounds(200, 440, 200, 20);
		getContentPane().add(derechos);
	}

	private JFrame getLogin() {
		return this;
	}

}
