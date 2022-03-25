package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.Coche;
import modelo.ControladorDatos;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.JComboBox;

public class SeleccionarCoche extends JDialog implements ActionListener{
	private JButton btnConsulta;
	private JComboBox cmbxSelCoche;
	private ControladorDatos datos;
	private Map<String, Coche> coches;


	/**
	 * Create the dialog.
	 * @param datos 
	 * @param b 
	 * @param vPrincipal 
	 */
	public SeleccionarCoche(VPrincipal vPrincipal, boolean b, ControladorDatos datos) {
		super(vPrincipal);
		this.setModal(b);
		this.datos = datos;
		setBounds(100, 100, 863, 446);
		getContentPane().setLayout(null);
		
		JLabel lblSeleccioneCoche = new JLabel("Seleccione un coche");
		lblSeleccioneCoche.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSeleccioneCoche.setBounds(56, 54, 248, 90);
		getContentPane().add(lblSeleccioneCoche);
		
		cmbxSelCoche = new JComboBox();
		cmbxSelCoche.setBounds(267, 75, 340, 52);
		getContentPane().add(cmbxSelCoche);
		
		btnConsulta = new JButton("CONSULTAR");
		btnConsulta.setBounds(251, 247, 296, 52);
		getContentPane().add(btnConsulta);
		btnConsulta.addActionListener(this);
		
		cargarCoches(datos);
	}

	
	private void cargarCoches(ControladorDatos datos) {
		coches = datos.listarCoches();
		
		for (Coche c : coches.values()) {
			cmbxSelCoche.addItem(c.getMatricula() + " " + c.getMarca());
		}
		cmbxSelCoche.setSelectedIndex(-1);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btnConsulta)) {
			if (cmbxSelCoche.getSelectedIndex() == -1) {
				JOptionPane.showMessageDialog(null,"No se ha seleccionado ninguna opcion", "Error", JOptionPane.ERROR_MESSAGE);
			} else {
				String coche = (String) cmbxSelCoche.getSelectedItem();
				String matricula = coche.substring(0, coche.indexOf(" "));
				
				VCoche consulta = new VCoche(this, coches.get(matricula), true, datos);
				consulta.setVisible(true);
				this.dispose();
			}
			
			
		}
	}
	
	
}
