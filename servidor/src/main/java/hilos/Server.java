package hilos;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JTextArea;
import javax.swing.JTextField;

import db.ConexionBD;

public class Server {
	public static int PUERTO_POR_DEFECTO = 5000;
	private ArrayList<UsuarioSocket> listaSocketsUsuarios;
	private ConexionBD conexionBD;
	private JTextArea txtLog;

	public JTextArea getTxtLog() {
		return txtLog;
	}

	public ArrayList<UsuarioSocket> getListaSocketsUsuarios() {
		return listaSocketsUsuarios;
	}
	
	public ConexionBD getConexionBD() {
		return conexionBD;
	}

	public Server(JTextField txtPuerto, JTextArea txtLog) throws SQLException {
		this.txtLog = txtLog;
		PUERTO_POR_DEFECTO = Integer.parseInt(txtPuerto.getText());
		//conexionBD = new ConexionBD(txtLog);
		conexionBD = new ConexionBD();

		listaSocketsUsuarios = new ArrayList<UsuarioSocket>();

		try {

			ServerSocket svSocket = new ServerSocket(PUERTO_POR_DEFECTO);
			// Escuchar a clientes de forma constante
			while(true) {
				System.out.println("Escuchando en el puerto: " + PUERTO_POR_DEFECTO);
				escribirLog("Escuchando en el puerto: " + PUERTO_POR_DEFECTO);
				// Aceptar la conexión
				Socket cSocket = svSocket.accept();
				escribirLog("Se conectó: " + cSocket.getInetAddress());
				UsuarioSocket aux = new UsuarioSocket(cSocket);
				listaSocketsUsuarios.add(aux);

				ServerThread sThread = new ServerThread(cSocket, this);
				sThread.start();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void mostrarUsuariosConectados() {
		escribirLog("-------------------Usuarios------------------------");
		escribirLog("Lista de usuarios conectados:");
		for (int i = 0; i < this.listaSocketsUsuarios.size(); i++) {
			escribirLog((i+1)+": "+listaSocketsUsuarios.get(i));
		}
		escribirLog("---------------------------------------------------");
	}
	
	public void escribirLog (String cadena) {
		this.txtLog.append(cadena+"\n");
	}
}
