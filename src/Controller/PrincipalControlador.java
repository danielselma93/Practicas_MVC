package Controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

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
}
