package frames;

import dominio.*;
import mensajeria.Comando;
import mensajeria.Paquete;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cliente.Cliente;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.concurrent.Semaphore;
import java.awt.event.ActionEvent;
import javax.swing.JLayeredPane;

public class MenuMapas extends JFrame {

	private JPanel contentPane;

	public MenuMapas(final Cliente cliente) {
		setTitle("Elegir Mapa");
		setBounds(100, 100, 450, 300);

		// En caso de cerrar
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

		// Panel
		setTitle("War Draft - Elegir Mapa");
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);

		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 444, 271);
		contentPane.add(layeredPane);

		// Mapa 1
		JLabel lblAubenor = new JLabel("Mundo 1");
		lblAubenor.setBounds(191, 72, 66, 23);
		layeredPane.add(lblAubenor, new Integer(2));
		lblAubenor.setForeground(Color.BLACK);
		lblAubenor.setFont(new Font("Tahoma", Font.PLAIN, 15));

		// Mapa 2
		JLabel lblEodrim = new JLabel("Mundo 2");
		lblEodrim.setBounds(191, 129, 66, 23);
		layeredPane.add(lblEodrim, new Integer(2));
		lblEodrim.setForeground(Color.BLACK);
		lblEodrim.setFont(new Font("Tahoma", Font.PLAIN, 15));

		// Mapa 3
		JLabel lblAris = new JLabel("Mundo 3");
		lblAris.setBounds(191, 192, 66, 23);
		layeredPane.add(lblAris, new Integer(2));
		lblAris.setForeground(Color.BLACK);
		lblAris.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JButton btnAubenor = new JButton("");
		btnAubenor.setBounds(148, 72, 143, 23);
		layeredPane.add(btnAubenor, new Integer(1));
		btnAubenor.setFocusable(false);
		// btnAubenor.setIcon(new
		// ImageIcon(MenuMapas.class.getResource("/frames/BotonMenu.png")));

		JButton btnEodrim = new JButton("");
		btnEodrim.setBounds(148, 192, 143, 23);
		layeredPane.add(btnEodrim, new Integer(1));
		btnEodrim.setFocusable(false);
		btnEodrim.setEnabled(false);
		// btnEodrim.setIcon(new
		// ImageIcon(MenuMapas.class.getResource("/frames/BotonMenu.png")));
		btnEodrim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				synchronized (cliente) {
					cliente.getPaquetePersonaje().setMapa(3);
					cliente.notify();
				}
				dispose();
			}
		});

		btnEodrim.setEnabled(true);

		JButton btnAris = new JButton("");
		btnAris.setBounds(148, 130, 143, 23);
		layeredPane.add(btnAris, new Integer(1));
		btnAris.setFocusable(false);
		// btnAris.setIcon(new
		// ImageIcon(MenuMapas.class.getResource("/frames/BotonMenu.png")));
		btnAris.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				synchronized (cliente) {
					cliente.getPaquetePersonaje().setMapa(2);
					cliente.notify();
				}
				dispose();
			}
		});

		btnAris.setEnabled(true);

		JLabel lblBackground = new JLabel("");
		lblBackground.setBounds(0, 0, 444, 271);
		layeredPane.add(lblBackground, new Integer(0));
		lblBackground.setIcon(new ImageIcon(MenuMapas.class.getResource("/frames/fondo.jpg")));
		btnAubenor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				synchronized (cliente) {
					cliente.getPaquetePersonaje().setMapa(1);
					cliente.notify();
				}
				dispose();
			}
		});
	}
}
