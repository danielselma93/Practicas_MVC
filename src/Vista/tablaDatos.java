package Vista;
import java.sql.ResultSet;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Modelo.BD;

public class tablaDatos {

	public JFrame frame;
	private JButton btnBorrar;
	private JButton btnContinuar;
	private JTable table;
	


	public tablaDatos() {
		
		initialize();
		mostrarTabla();
	}

	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
		
		table = new JTable();
	
		frame.getContentPane().add(table);
		
		btnContinuar = new JButton("New button");
		frame.getContentPane().add(btnContinuar);
		
		btnBorrar = new JButton("New button");
		frame.getContentPane().add(btnBorrar);
	}
	public void mostrarTabla (){
		
		DefaultTableModel modelo = new DefaultTableModel();
		ResultSet rs = null;
		BD bd = new BD ();
		rs=bd.rellenarDatosTabla();
		modelo.setColumnIdentifiers(new Object[]{"Nombre, Apellido, Edad"});
		try{
			while(rs.next()){
				modelo.addRow(new Object []{rs.getString("nombre"), rs.getString("apellido"), rs.getInt("edad")});
			}
			table.setModel(modelo);
		}catch(Exception e){
			
		}
	}

}
