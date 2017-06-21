package Vista;

import java.awt.Component;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

import Controller.ControladorExportarPDF;
import Modelo.BD;

public class OtraVentanaMas {

	public JFrame frame;
	private JList list;
	private JButton btnExportar;
	private JButton btnVolver;
	private JTextPane textArea;

	public OtraVentanaMas() {
		initialize();
	}

	
	private void initialize() {
		ControladorExportarPDF ce = new ControladorExportarPDF();
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
		DefaultListModel dlm = new DefaultListModel();
		ArrayList<Object> al;
		//for(int i=0;i<al.size();i++){
			//al.add(dlm);
			System.out.println("Bucle infinito idiota");
	//	}
				
		 list = new JList(dlm);
		scrollPane.setViewportView(list);

		
		 textArea = new JTextPane();
		 frame.getContentPane().add(textArea);
		
		 btnExportar = new JButton("Exportar");
		
		frame.getContentPane().add(btnExportar);
		btnExportar.setActionCommand("exportar");
		
		 btnVolver = new JButton("Volver");
		 
		frame.getContentPane().add(btnVolver);
		btnVolver.setActionCommand("volver");
	
		
	
		bd.rellenarDatosLista(list);
		ce.getTextArea(btnExportar, textArea);
		ce.backTo(btnVolver, frame);
		al=bd.rellenarDatosLista(list);
				
		
	}

}
