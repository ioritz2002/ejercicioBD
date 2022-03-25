package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.ControladorDatos;

import javax.swing.JButton;

public class VPrincipal extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JButton btnAltapropietario;
	private JButton btnAltaCoche;
	private JButton btnConsultacoche;
	private JButton btnConsultapropietario;
	private ControladorDatos datos;
	
	/**
	 * Create the frame.
	 * @param datos 
	 */
	public VPrincipal(ControladorDatos datos) {
		this.datos = datos;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 739, 378);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnAltaCoche = new JButton("Alta Coche");
		btnAltaCoche.setBounds(48, 11, 201, 79);
		contentPane.add(btnAltaCoche);
		
		btnConsultacoche = new JButton("ConsultaCoche");
		btnConsultacoche.setBounds(48, 158, 201, 79);
		contentPane.add(btnConsultacoche);
		
		btnAltaCoche.addActionListener(this);
		btnConsultacoche.addActionListener(this);
		
		btnConsultapropietario = new JButton("ConsultaPropietario");
		btnConsultapropietario.setBounds(396, 158, 201, 79);
		contentPane.add(btnConsultapropietario);
		
		btnAltapropietario = new JButton("AltaPropietario");
		btnAltapropietario.setBounds(396, 11, 201, 79);
		contentPane.add(btnAltapropietario);
		
		btnConsultapropietario.addActionListener(this);
		btnAltapropietario.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btnAltaCoche)) {
			VCoche alta = new VCoche(this, true, datos);
			alta.setVisible(true);
		}
		if (e.getSource().equals(btnAltapropietario)) {
			VPropietario alta = new VPropietario(this, true, datos);
			alta.setVisible(true);
		}
		if (e.getSource().equals(btnConsultacoche)) {
			SeleccionarCoche selCoch = new SeleccionarCoche(this, true, datos);
			selCoch.setVisible(true);
		}
		if (e.getSource().equals(btnConsultapropietario)) {
			SeleccionarPropietario selProp = new SeleccionarPropietario(this, true, datos);
			selProp.setVisible(true);
		}
	}
}