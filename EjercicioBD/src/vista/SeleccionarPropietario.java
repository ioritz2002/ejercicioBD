package vista;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
		
		cargarPropietario(datos);
	}

	

	private void cargarPropietario(ControladorDatos datos) {
		propietarios = datos.listarPropietarios();
		for (Propietario p : propietarios.values()) {
			cmbxSelPropietario.addItem(p.getIdentificador() + " " + p.getNombre());
		}
		cmbxSelPropietario.setSelectedIndex(-1);
	}

	private void listarPropietario(ControladorDatos datos) {
		if (cmbxSelPropietario.getSelectedIndex() == -1) {
			JOptionPane.showMessageDialog(null, "Error, debe seleccionar un propietario", "Cuidado", JOptionPane.ERROR_MESSAGE);
		} else {
			String cadena = (String) cmbxSelPropietario.getSelectedItem();
			int pos = cadena.indexOf(" ");
			String id = cadena.substring(0, pos);
			
			VPropietario consulta = new VPropietario(this, propietarios.get(id), true, datos);
			consulta.setVisible(true);
		}
		
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btnConsulta)) {
			//Error
			listarPropietario(datos);
			
		}
	}

}