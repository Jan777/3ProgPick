package pantallas;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class ModificarDatos extends JPanel {
	/**
	 * @author Matias Jimenez
	 */
	private static final long serialVersionUID = 1L;
	private JPasswordField txtNuevaPassword;

	/**
	 * Create the panel.
	 */
	public ModificarDatos() {
		//setBounds(0, 0, ResolucionPantalla.pAncho, ResolucionPantalla.pLargo);
		setLayout(null);
		
		JLabel label = new JLabel("Configuracion");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Tahoma", Font.BOLD, 30));
		label.setBounds(10, 11, 371, 51);
		add(label);
		
		JLabel label_1 = new JLabel("Nick");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_1.setBounds(10, 163, 252, 28);
		add(label_1);
		
		JTextArea txtNick = new JTextArea();
		txtNick.setBounds(10, 198, 252, 22);
		add(txtNick);
		
		JLabel label_2 = new JLabel("Usuario");
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_2.setBounds(10, 231, 252, 28);
		add(label_2);
		
		JTextArea txtUsuario = new JTextArea();
		txtUsuario.setBounds(10, 266, 252, 22);
		add(txtUsuario);
		
		JLabel label_3 = new JLabel("Nueva Contrasenia");
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_3.setBounds(10, 299, 252, 28);
		add(label_3);
		
		txtNuevaPassword = new JPasswordField();
		txtNuevaPassword.setBounds(10, 334, 252, 22);
		add(txtNuevaPassword);
		
		JLabel label_4 = new JLabel("Pregunta secreta");
		label_4.setForeground(Color.WHITE);
		label_4.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_4.setBounds(10, 367, 252, 28);
		add(label_4);
		
		JTextArea txtPregSec = new JTextArea();
		txtPregSec.setBounds(10, 402, 252, 22);
		add(txtPregSec);
		
		JLabel label_5 = new JLabel("Respuesta secreta");
		label_5.setForeground(Color.WHITE);
		label_5.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_5.setBounds(10, 435, 252, 28);
		add(label_5);
		
		JTextArea txtRespSec = new JTextArea();
		txtRespSec.setBounds(10, 470, 252, 22);
		add(txtRespSec);
		
		JButton btnGuardarCambios = new JButton("Guardar Cambios");
		btnGuardarCambios.setBounds(10, 657, 244, 51);
		add(btnGuardarCambios);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setBounds(264, 657, 244, 51);
		add(btnSalir);
		
		JLabel label_6 = new JLabel("bg");
		//label_6.setIcon(new ImageIcon(ZRModificarDatos.class.getResource("")));
		label_6.setBounds(0, 0, 998, 719);
		add(label_6);
	}

}
