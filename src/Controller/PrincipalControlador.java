package Controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import Modelo.BD;
import Vista.tablaDatos;

public class PrincipalControlador {

	
	public PrincipalControlador(){
		
	}
	public void goToNuevaVentana (JButton btnSiguiente, JFrame frame){
		btnSiguiente.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				
				
				frame.dispose();
				tablaDatos window = new tablaDatos();
				window.frame.setVisible(true);
		
			}
		});
			
			
			}
	public void insercionDatos(JButton btnEnviar, JTextField textNombre, JTextField textApellido, JTextField textEdad){
		btnEnviar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				BD bd= new BD ();
				String nombre=textNombre.getText();
				String apellido=textApellido.getText();
				int edad=Integer.parseInt(textEdad.getText());	
				bd.InsertarDatos(nombre, apellido, edad);
			}
		});
			
	}
}
