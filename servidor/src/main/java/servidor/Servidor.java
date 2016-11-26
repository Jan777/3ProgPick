package servidor;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import mensajeria.PaqueteMovimiento;
import mensajeria.PaquetePersonaje;

public class Servidor extends Thread {

	private static ArrayList<EscuchaCliente> clientesConectados = new ArrayList<>();
	private static Map<Integer, PaqueteMovimiento> ubicacionPersonajes = new HashMap<>();
	private static Map<Integer, PaquetePersonaje> personajesConectados = new HashMap<>();
	private static Thread server;
	private static ServerSocket serverSocket;
	private static Conector conexionDB;
	private static int PUERTO = 5000;
	public static JTextArea log;
	public static AtencionConexiones atencionConexiones = new AtencionConexiones();
	public static AtencionMovimientos atencionMovimientos = new AtencionMovimientos();;

	public static void main(String[] args) {
		cargarInterfaz();
	}

	// carga la pantalla principal del servidor, donde va a registrar todo
	private static void cargarInterfaz() {
		JFrame ventana = new JFrame("juego magico");
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setBounds(0, 0, 600, 600);
		JPanel contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		ventana.setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane spnlLog = new JScrollPane();
		spnlLog.setBounds(20, 47, 496, 300);

		contentPane.add(spnlLog);

		log = new JTextArea();
		log.setBounds(20, 224, 300, 300);
		spnlLog.setViewportView(log);

		JLabel lblEstadoDetenido = new JLabel("Estado: Detenido");
		lblEstadoDetenido.setForeground(Color.WHITE);
		lblEstadoDetenido.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEstadoDetenido.setBounds(30, 358, 188, 25);
		contentPane.add(lblEstadoDetenido);

		JComboBox cbFiltro = new JComboBox();
		cbFiltro.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cbFiltro.setModel(new DefaultComboBoxModel(new String[] { "TODO", "BUGS", "AVISO" }));
		cbFiltro.setBounds(340, 11, 113, 25);
		contentPane.add(cbFiltro);

		JLabel lblFiltro = new JLabel("Filtro: ");
		lblFiltro.setForeground(Color.WHITE);
		lblFiltro.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFiltro.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblFiltro.setBounds(187, 11, 143, 25);
		contentPane.add(lblFiltro);

		final JLabel lblIp = new JLabel("Puerto:");
		lblIp.setForeground(Color.WHITE);
		lblIp.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblIp.setBounds(10, 11, 76, 25);
		contentPane.add(lblIp);

		final JTextField txtPuerto = new JTextField();
		txtPuerto.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtPuerto.setText("5000");
		txtPuerto.setBounds(90, 11, 76, 25);
		contentPane.add(txtPuerto);
		txtPuerto.setColumns(10);

		// logica para los botones de iniciar y detener
		final JButton botonIniciar = new JButton("Iniciar Servidor");
		final JButton botonDetener = new JButton("Detener Servidor");
		botonIniciar.setBounds(231, 364, 285, 68);
		botonIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//setea el puerto igual al que ponemos en la pantalla
				PUERTO = Integer.parseInt(txtPuerto.getText());
				//inicia el servidor y genera hilos en escucha
				server = new Thread(new Servidor());
				server.start();
				botonIniciar.setEnabled(false);
				botonDetener.setEnabled(true);
			}
		});
		ventana.add(botonIniciar);

		//consigracion del boton que detiene el servidor
		botonDetener.setText("Detener");
		botonDetener.setBounds(231, 450, 285, 68);
		botonDetener.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					server.stop();
					for (EscuchaCliente cliente : clientesConectados) {
						cliente.getSalida().close();
						cliente.getEntrada().close();
						cliente.getSocket().close();
					}
					serverSocket.close();
					if (conexionDB != null)
						conexionDB.close();
					botonDetener.setEnabled(false);
					botonIniciar.setEnabled(true);
					log.setText("");
				} catch (IOException e1) {
					log.append("Fallo al intentar detener el servidor." + System.lineSeparator());
					e1.printStackTrace();
				}				
			}
		});
		botonDetener.setEnabled(false);
		ventana.add(botonDetener);

		// configura el comportamiento estandar al cerrar la ventana de java
		ventana.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		ventana.addWindowListener(new WindowAdapter() {
			// cuando se cierra la ventana del servidor cierra todas las
			// conecciones
			public void windowClosing(WindowEvent evt) {
				if (serverSocket != null) {
					try {
						server.stop();
						for (EscuchaCliente cliente : clientesConectados) {
							cliente.getSalida().close();
							cliente.getEntrada().close();
							cliente.getSocket().close();
						}
						serverSocket.close();
					} catch (IOException e) {
						log.append("Fallo al intentar detener el servidor." + System.lineSeparator());
						e.printStackTrace();
						System.exit(1);
					}
				}
				// cierra la conexion a la base de datos
				if (conexionDB != null)
					conexionDB.close();
				System.exit(0);
			}
		});

		ventana.setVisible(true);
	}

	public void run() {
		try {

			log.append("Iniciando el servidor..." + System.lineSeparator());
			serverSocket = new ServerSocket(PUERTO);
			log.append("Servidor esperando conexiones..." + System.lineSeparator());
			String ipRemota;
			conexionDB = new Conector();
			conexionDB.connect();
			atencionConexiones.start();
			atencionMovimientos.start();

			while (true) {
				Socket cliente = serverSocket.accept();
				ipRemota = cliente.getInetAddress().getHostAddress();
				log.append(ipRemota + " se ha conectado" + System.lineSeparator());

				ObjectOutputStream salida = new ObjectOutputStream(cliente.getOutputStream());
				ObjectInputStream entrada = new ObjectInputStream(cliente.getInputStream());

				EscuchaCliente atencion = new EscuchaCliente(ipRemota, cliente, entrada, salida);
				atencion.start();
				clientesConectados.add(atencion);
			}
		} catch (Exception e) {
			log.append("Fallo la conexión." + System.lineSeparator());
			e.printStackTrace();
		}
	}

	public static ArrayList<EscuchaCliente> getClientesConectados() {
		return clientesConectados;
	}

	public static Map<Integer, PaqueteMovimiento> getUbicacionPersonajes() {
		return ubicacionPersonajes;
	}

	public static Map<Integer, PaquetePersonaje> getPersonajesConectados() {
		return personajesConectados;
	}

	public static Conector getConector() {
		return conexionDB;
	}
}