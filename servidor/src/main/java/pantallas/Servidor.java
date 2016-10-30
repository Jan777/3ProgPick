package pantallas;

import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.sql.SQLException;
import java.io.*;
import java.net.InetAddress;
import java.util.ArrayList;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import db.DBConnection;
import hilos.HiloConexion;

import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JScrollPane;
import java.awt.Color;

/**
 * 
 * @author Matias Jimenez
 *
 */

@SuppressWarnings("serial")
public class Servidor extends JFrame {

	private ServerSocket serverSocket;
	private boolean escuchando;
	private JPanel contentPane;
	private JTextArea textArea;
	private JButton btnIniciarServidor;
	private JButton btnIniciarServidor_2;
	private JTextField textField;
	private static int ANCHO_PANTALLA = 500;
	private static int ALTO_PANTALLA = 500;
	private static DBConnection conn;
	private int inicio = 0;
	private int salir = 0;
	private ArrayList<String> usuarios = new ArrayList<String>();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Servidor frame = new Servidor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void loopServer() {
		try {
			printGUI("*****Inicio servidor*****");
			int port = Integer.parseInt(textField.getText());
			printGUI("Intentando abrir socket servidor, en el puerto " + port + "...\n");

			// Creo socket servidor en el puerto indicado
			serverSocket = new ServerSocket(port);
			escuchando = true;
			printGUI("***Socket creado***\nIP server: " + InetAddress.getLocalHost().getHostAddress() + " - Puerto: " + serverSocket.getLocalPort());
			while (escuchando) {

				//printGUI("Esperando conexión de cliente...");
				Socket clientSocket = serverSocket.accept();
				printGUI("\n***Conectado con cliente, IP: " + clientSocket.getInetAddress());

				Runnable threadConexion = new HiloConexion(clientSocket, this);
				Thread hilo = new Thread(threadConexion);
				hilo.start();
			}
			System.out.println("Aca ya no esta escuchando...");
		} catch (Exception e) {
			e.printStackTrace();
			printGUI("ERROR: " + e.toString());
		}
	}

	public void printGUI(final String msj) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				textArea.append(msj + "\n");
			}
		});
	}

	private void cerrarSockets() {
		try {
			if (serverSocket != null && !serverSocket.isClosed()) {
				Thread.currentThread().interrupt();
				serverSocket.close();
			}
		} catch (SocketException s){

		} catch (IOException e1) {
			e1.printStackTrace();
		} 
	}
	
	private void cerrarServer() {
		try {
			salir = 1;
			escuchando = false;
			cerrarSockets();
			conn.Close();
			System.exit(ABORT);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Servidor() throws SQLException {
		conn = DBConnection.getInstance();
		setTitle("SERVIDOR");
		setDefaultCloseOperation(0);
		setResizable(false);
		setBounds(100, 100, 600, 477);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		btnIniciarServidor = new JButton("Iniciar");
		btnIniciarServidor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Thread serverThread = new Thread() {
					public void run() {
						loopServer();
						btnIniciarServidor.setEnabled(false);
					}
				};
				serverThread.start();
			}
		});
		btnIniciarServidor.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnIniciarServidor.setBounds(198, 386, 87, 45);
		contentPane.add(btnIniciarServidor);

		btnIniciarServidor_2 = new JButton("Salir");
		btnIniciarServidor_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cerrarServer();
			}
		});
		btnIniciarServidor_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnIniciarServidor_2.setBounds(487, 386, 87, 45);
		contentPane.add(btnIniciarServidor_2);

		JLabel lblPuerto = new JLabel("Puerto:");
		lblPuerto.setForeground(Color.WHITE);
		lblPuerto.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPuerto.setBounds(41, 396, 58, 26);
		contentPane.add(lblPuerto);
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField.setText("21412");
		textField.setBounds(109, 396, 69, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 575, 350);
		contentPane.add(scrollPane);
		textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 16));
		scrollPane.setViewportView(textArea);

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				cerrarServer();
			}
		});
	}

	public ArrayList<String> getUsuarios() {
		return usuarios;
	}

	public int getSalir() {
		return salir;
	}
	
	public int getInicio() {
		return inicio;
	}

	public static int getANCHO_PANTALLA() {
		return ANCHO_PANTALLA;
	}

	public static void setANCHO_PANTALLA(int aNCHO_PANTALLA) {
		ANCHO_PANTALLA = aNCHO_PANTALLA;
	}

	public static int getALTO_PANTALLA() {
		return ALTO_PANTALLA;
	}

	public static void setALTO_PANTALLA(int aLTO_PANTALLA) {
		ALTO_PANTALLA = aLTO_PANTALLA;
	}

	public static DBConnection getCon() {
		return conn;
	}

	public static void setCon(DBConnection con) {
		Servidor.conn = con;
	}
}
