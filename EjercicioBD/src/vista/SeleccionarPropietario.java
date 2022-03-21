package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.Propietario;
import modelo.ControladorDatos;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;

public class SeleccionarPropietario extends JDialog implements ActionListener {

	private JButton btnConsulta;
	private JComboBox cmbxSelPropietario;
	private ControladorDatos datos;
	Map<String, Propietario> propietarios;

	/**
	 * Create the dialog.
	 * 
	 * @param datos
	 * @param b
	 * @param vPrincipal
	 */
	public SeleccionarPropietario(VPrincipal vPrincipal, boolean b, ControladorDatos datos) {
		super(vPrincipal);
		this.setModal(b);
		this.datos = datos;
		setBounds(100, 100, 863, 446);
		getContentPane().setLayout(null);

		JLabel lblSeleccioneCoche = new JLabel("Seleccione un propietario");
		lblSeleccioneCoche.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSeleccioneCoche.setBounds(56, 54, 248, 90);
		getContentPane().add(lblSeleccioneCoche);
		
		cmbxSelPropietario = new JComboBox();
		cmbxSelPropietario.setBounds(267, 75, 340, 52);
		getContentPane().add(cmbxSelPropietario);

		btnConsulta = new JButton("CONSULTAR");
		btnConsulta.addActionListener(this);
		btnConsulta.setBounds(251, 247, 296, 52);
		getContentPane().add(btnConsulta);
		
		propietarios = datos.listarPropietarios();
		for (Propietario p : propietarios.values()) {
			cmbxSelPropietario.addItem(p.getIdentificador());
		}
		cmbxSelPropietario.setSelectedIndex(-1);
	}

	

	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btnConsulta)) {
			//Error
			Propietario propietario = datos.buscarPropietario("");
			VPropietario consulta = new VPropietario(this, propietario, true, datos);
			consulta.setVisible(true);
			
		}
	}

}