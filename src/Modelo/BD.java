package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class BD {

	private Connection connexio;
	
	
	public BD() {
	}
	public Connection Conectar(){
		Connection cn = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection("jdbc:mysql://localhost/deprueba","root","");
		}catch(Exception e){
			e.printStackTrace();
		}
		 return cn;
	}
	public Connection getConnexio() {
		return connexio;
	}
	public void setConnexio(Connection connexio) {
		this.connexio = connexio;
	}
	public void InsertarDatos (String nombre, String apellido, int edad){
		
		Connection cn = Conectar();
		try{
			
		PreparedStatement pat = cn.prepareStatement("INSERT INTO usuario (nombre, apellido, edad) VALUES (?, ?, ?)");
		pat.setString(1, nombre);
		pat.setString(2, apellido);
		pat.setInt(3, edad);
		pat.execute();
		  if(pat.executeUpdate()==1){
		       System.out.println("fila insertada correctamente");
		     }

		}catch(SQLException ex){
			
		}
		}
	public JTable rellenarDatosTabla(JTable table, DefaultTableModel modelo){
		
		String consulta= "SELECT * FROM usuario";
		Connection cn = Conectar();
		ResultSet rs=null;
		PreparedStatement ps=null;
		modelo.setColumnIdentifiers(new Object[]{"Nombre, Apellido, Edad"});
		try{
			 ps = cn.prepareStatement(consulta);
			 rs = ps.executeQuery();
			 while(rs.next()){
					modelo.addRow(new Object []{rs.getString("nombre"), rs.getString("apellido"), rs.getInt("edad")});
		
		}
			 }catch(SQLException e){
				 table.setModel(modelo);
				
		}
		return table;	
	}
	public ArrayList<Object> rellenarDatosLista(JList list){
		ArrayList<Object> al = new ArrayList<Object>();
		DefaultListModel dlm = new DefaultListModel();
		String consulta="SELECT nombre,apellido,edad FROM usuario";
		Connection cn = Conectar();
		ResultSet rs=null;
		PreparedStatement ps = null;
		try {
			ps = cn.prepareStatement(consulta);
			rs= ps.executeQuery();
			while (rs.next()){
			String nombre = rs.getString("nombre");
			String apellido = rs.getString("apellido");
			int edad = rs.getInt("edad");
			al.add(new Object []{ rs.getString("nombre"),
			 rs.getString("apellido"),
			  rs.getInt("edad")});
			}
			list.setModel(dlm);
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
		return al;
		
	}
}