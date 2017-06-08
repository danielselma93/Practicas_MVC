package Vista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Controller.PrincipalControlador;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Modelo.BD;

public class PrimeraVentana implements ActionListener {

	public JFrame frame;

	private JTextField textNombre;
	private JTextField textApellido;
	private JTextField textEdad;
	private JButton btnEnviar;
	private JButton btnSiguiente;

	public PrimeraVentana() {
		initialize();
	}


	private void initialize() {
		PrincipalControlador pc = new PrincipalControlador();
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
		
		JLabel lblNewLabel = new JLabel("nombre");
		frame.getContentPane().add(lblNewLabel);
		
		textNombre = new JTextField();
		frame.getContentPane().add(textNombre);
		textNombre.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		frame.getContentPane().add(lblNewLabel_1);
		
		textApellido = new JTextField();
		frame.getContentPane().add(textApellido);
		textApellido.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		frame.getContentPane().add(lblNewLabel_2);
		
		textEdad = new JTextField();
		frame.getContentPane().add(textEdad);
		textEdad.setColumns(10);
		
		 btnEnviar = new JButton("Enviar");
		frame.getContentPane().add(btnEnviar);
		btnEnviar.setActionCommand("enviar");
		btnEnviar.addActionListener(this);
		
		
		
		btnSiguiente = new JButton("siguiente");
		frame.getContentPane().add(btnSiguiente);
		btnSiguiente.setActionCommand("siguiente");
		btnSiguiente.addActionListener(this);
		
		pc.goToNuevaVentana(btnSiguiente, frame);
		
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
		if (arg0.getActionCommand().equals("enviar")){
			BD bd= new BD ();
			String nombre=textNombre.getText();
			String apellido=textApellido.getText();
			int edad=Integer.parseInt(textEdad.getText());	
			bd.InsertarDatos(nombre, apellido, edad);
		}
		
		}
	}


