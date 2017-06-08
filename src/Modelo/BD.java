package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


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
	public ResultSet rellenarDatosTabla(){
		
		String consulta= "SELECT * FROM usuario";
		Connection cn = Conectar();
		ResultSet rs=null;
		PreparedStatement ps=null;
		try{
			 ps = cn.prepareStatement(consulta);
			 rs = ps.executeQuery();
		
		}catch(SQLException e){
			
		}
		return rs;
	}
}