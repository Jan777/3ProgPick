package pantallas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;


import hilos.*;
import javax.swing.JTextArea;

public class Servidor extends JFrame {
	/**
	 * @author Matias Jimenez
	 */
	private static final long serialVersionUID = 1517929693110427533L;
	private Server server;
	private JPanel contentPane;
	private boolean estaFuncionando = false;
	private JLabel lblEstadoDetenido;
	private JLabel lblFiltro;
	private JComboBox cbFiltro;
	private JButton btnPrenderYDeternerServidor;
	
	private static JTextField txtPuerto;
	private static JTextArea txtLog;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Servidor frame = new Servidor();
					frame.setLocationRelativeTo(null);
					frame.setResizable(false);	
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static void iniciar() {
		(new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					new Server(txtPuerto, txtLog);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		})).start();
	}
	
	public Servidor() {
		setTitle("juego magico");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 700, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
//		JLabel lblBannerArriba = new JLabel("New label");
//		//lblBannerArriba.setIcon(new ImageIcon(ZRSevidor.class.getResource("")));
//		lblBannerArriba.setBounds(0, 0, 1008, 68);
//		contentPane.add(lblBannerArriba);
		
		JScrollPane spnlLog = new JScrollPane();
		spnlLog.setBounds(20, 47, 496, 300);
		
		contentPane.add(spnlLog);
		
		txtLog = new JTextArea();
		txtLog.setBounds(20, 224, 300, 300);
		spnlLog.setViewportView(txtLog);
		
		
		lblEstadoDetenido = new JLabel("Estado: Detenido");
		lblEstadoDetenido.setForeground(Color.WHITE);
		lblEstadoDetenido.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEstadoDetenido.setBounds(30, 358, 188, 25);
		contentPane.add(lblEstadoDetenido);
		
		
		cbFiltro = new JComboBox();
		cbFiltro.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cbFiltro.setModel(new DefaultComboBoxModel(new String[] {"TODO", "BUGS", "AVISO"}));
		cbFiltro.setBounds(340, 11, 113, 25);
		contentPane.add(cbFiltro);
		
		lblFiltro = new JLabel("Filtro: ");
		lblFiltro.setForeground(Color.WHITE);
		lblFiltro.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFiltro.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblFiltro.setBounds(187, 11, 143, 25);
		contentPane.add(lblFiltro);
		
		JLabel lblIp = new JLabel("Puerto:");
		lblIp.setForeground(Color.WHITE);
		lblIp.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblIp.setBounds(10, 11, 76, 25);
		contentPane.add(lblIp);
		
		txtPuerto = new JTextField();
		txtPuerto.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtPuerto.setText("5000");
		txtPuerto.setBounds(90, 11, 76, 25);
		contentPane.add(txtPuerto);
		txtPuerto.setColumns(10);
		
		btnPrenderYDeternerServidor = new JButton("Prender Servidor");
		btnPrenderYDeternerServidor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
						iniciar();
						lblEstadoDetenido.setText("Estado: Encendido");
			}
		});
		btnPrenderYDeternerServidor.setBounds(231, 364, 285, 68);
		contentPane.add(btnPrenderYDeternerServidor);
		
		JLabel lblBG = new JLabel("New label");
		//lblBG.setIcon(new ImageIcon(ZRSevidor.class.getResource("")));
		lblBG.setBounds(350, 57, 231, 49);
		contentPane.add(lblBG);
	}
}
