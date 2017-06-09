package Vista;
import java.sql.ResultSet;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Modelo.BD;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import Controller.ControladorTablaDatos;
public class tablaDatos {

	public JFrame frame;
	private JButton btnBorrar;
	private JButton btnContinuar;
	private JTable table;
	private JScrollPane scrollPane;
	


	public tablaDatos() {
		
		initialize();
		mostrarTabla();
	}

	
	private void initialize() {
		ControladorTablaDatos ctd = new ControladorTablaDatos();
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
		
		scrollPane = new JScrollPane();
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		btnContinuar = new JButton("Continuar");
		btnContinuar.setActionCommand("continuar");
		frame.getContentPane().add(btnContinuar);
		
		btnBorrar = new JButton("Volver");
		btnBorrar.setActionCommand("volver");
		frame.getContentPane().add(btnBorrar);
		ctd.volverAntiguaVentana(btnBorrar, frame);
		ctd.goToVentanaFinal(btnContinuar, frame);
	}
	public void mostrarTabla (){
		
		DefaultTableModel modelo = new DefaultTableModel();
		ResultSet rs = null;
		BD bd = new BD ();
		table=bd.rellenarDatosTabla(table, modelo);
		
	
			
	}

}
