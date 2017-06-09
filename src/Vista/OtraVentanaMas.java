package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Component;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import Modelo.BD;

public class OtraVentanaMas {

	public JFrame frame;
	private JList list;
	private JButton btnExportar;
	private JButton btnVolver;

	public OtraVentanaMas() {
		initialize();
	}

	
	private void initialize() {
		BD bd = new BD();
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
		
		JLabel lblHolaPutoAmo = new JLabel("HOLA PUTO AMO");
		lblHolaPutoAmo.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblHolaPutoAmo.setFont(new Font("MoolBoran", Font.PLAIN, 25));
		frame.getContentPane().add(lblHolaPutoAmo);
		
		JScrollPane scrollPane = new JScrollPane();
		frame.getContentPane().add(scrollPane);
		
		 list = new JList();
		scrollPane.setViewportView(list);
		
		 btnExportar = new JButton("Exportar");
		frame.getContentPane().add(btnExportar);
		btnExportar.setActionCommand("exportar");
		
		 btnVolver = new JButton("Volver");
		frame.getContentPane().add(btnVolver);
		btnVolver.setActionCommand("volver");
		bd.rellenarDatosLista(list);
	}

}
