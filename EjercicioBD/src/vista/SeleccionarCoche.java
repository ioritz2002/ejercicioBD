package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;

public class SeleccionarCoche extends JDialog {
	private JButton btnConsulta;


	/**
	 * Create the dialog.
	 */
	public SeleccionarCoche() {
		setBounds(100, 100, 863, 446);
		getContentPane().setLayout(null);
		
		JLabel lblSeleccioneCoche = new JLabel("Seleccione un coche");
		lblSeleccioneCoche.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSeleccioneCoche.setBounds(56, 54, 248, 90);
		getContentPane().add(lblSeleccioneCoche);
		
		JComboBox cmbxSelCoche = new JComboBox();
		cmbxSelCoche.setBounds(267, 75, 340, 52);
		getContentPane().add(cmbxSelCoche);
		
		btnConsulta = new JButton("CONSULTAR");
		btnConsulta.setBounds(251, 247, 296, 52);
		getContentPane().add(btnConsulta);
	}
}
