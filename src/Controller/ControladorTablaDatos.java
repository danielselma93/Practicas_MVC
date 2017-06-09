package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import Vista.OtraVentanaMas;
import Vista.PrimeraVentana;

public class ControladorTablaDatos {

	public ControladorTablaDatos() {
	
	}
	public void volverAntiguaVentana(JButton btnBorrar, JFrame frame){
		btnBorrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.dispose();
				PrimeraVentana window = new PrimeraVentana();
				window.frame.setVisible(true);
			}
		});
	}
	public void goToVentanaFinal (JButton btnContinuar, JFrame frame){
		btnContinuar.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent e) {
				
				frame.dispose();
				OtraVentanaMas window = new OtraVentanaMas();
				window.frame.setVisible(true);
			}
		});
		
	}
}
