package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextPane;

import Vista.tablaDatos;


public class ControladorExportarPDF {
public String contenidoText="";
public void getTextArea(JButton btnExportar, JTextPane textArea){
	btnExportar.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent arg0) {
		 		contenidoText=textArea.getText();
		 		exportarPDF(contenidoText);
		 	}
		 });
	
}
public void exportarPDF(String contenidoText){
	String fichero = "exportacion.txt";
	File f = new File(fichero);
	try{
		BufferedWriter bw = new BufferedWriter(new FileWriter(fichero));
		bw.write(contenidoText);
		bw.close();
	}catch(Exception e){
		
	}
}
public void backTo (JButton btnVolver, JFrame frame){
	btnVolver.addActionListener(new ActionListener() {
	 	public void actionPerformed(ActionEvent e) {
			frame.dispose();
			tablaDatos window = new tablaDatos();
			window.frame.setVisible(true);
	 	}
	 });
	
}
}
