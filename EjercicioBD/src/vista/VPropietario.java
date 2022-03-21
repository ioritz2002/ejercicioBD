package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.Propietario;
import modelo.ControladorDatos;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.JTextField;

public class VPropietario extends JDialog implements ActionListener {
	private JTextField txtId;
	private JTextField txtNombre;
	private JTextField txtFechaNacimiento;
	private JButton btnBaja;
	private JButton btnModificacion;
	private JButton btnAlta;
	private ControladorDatos datos;
	private Propietario propietario;

	/**
	 * Create the dialog.
	 * 
	 * @param b
	 * @param vPrincipal
	 * @param seleccionarPropietario
	 * @param datos
	 */
	public VPropietario(VPrincipal vPrincipal, boolean b, ControladorDatos datos) {
		super(vPrincipal);
		this.setModal(b);
		this.datos = datos;
		setBounds(100, 100, 752, 568);
		getContentPane().setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("ID");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblNewLabel.setBounds(68, 83, 139, 63);
			getContentPane().add(lblNewLabel);
		}

		txtId = new JTextField();
		txtId.setBounds(164, 103, 222, 26);
		getContentPane().add(txtId);
		txtId.setColumns(10);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNombre.setBounds(54, 170, 139, 63);
		getContentPane().add(lblNombre);

		JLabel lblFechaNacimiento = new JLabel("Fecha nacimiento");
		lblFechaNacimiento.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblFechaNacimiento.setBounds(54, 244, 139, 63);
		getContentPane().add(lblFechaNacimiento);

		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(164, 184, 222, 26);
		getContentPane().add(txtNombre);

		txtFechaNacimiento = new JTextField();
		txtFechaNacimiento.setColumns(10);
		txtFechaNacimiento.setBounds(203, 264, 222, 26);
		getContentPane().add(txtFechaNacimiento);

		btnAlta = new JButton("Alta");
		btnAlta.setBounds(480, 93, 165, 41);
		getContentPane().add(btnAlta);

		btnModificacion = new JButton("Modificacion");
		btnModificacion.setBounds(480, 177, 165, 41);
		getContentPane().add(btnModificacion);
		btnModificacion.setEnabled(false);

		btnBaja = new JButton("Baja");
		btnBaja.setBounds(480, 257, 165, 41);
		getContentPane().add(btnBaja);
		btnBaja.setEnabled(false);

		btnAlta.addActionListener(this);
		btnModificacion.addActionListener(this);
		btnBaja.addActionListener(this);

	}

	public VPropietario(SeleccionarPropietario seleccionarPropietario, Propietario propietario, boolean b, ControladorDatos datos) {
		super(seleccionarPropietario);
		this.setModal(b);
		this.datos = datos;
		this.propietario = propietario;
		setBounds(100, 100, 752, 568);
		getContentPane().setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("ID");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblNewLabel.setBounds(68, 83, 139, 63);
			getContentPane().add(lblNewLabel);
		}

		txtId = new JTextField();
		txtId.setBounds(164, 103, 222, 26);
		getContentPane().add(txtId);
		txtId.setColumns(10);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNombre.setBounds(54, 170, 139, 63);
		getContentPane().add(lblNombre);

		JLabel lblFechaNacimiento = new JLabel("Fecha nacimiento");
		lblFechaNacimiento.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblFechaNacimiento.setBounds(54, 244, 139, 63);
		getContentPane().add(lblFechaNacimiento);

		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(164, 184, 222, 26);
		getContentPane().add(txtNombre);

		txtFechaNacimiento = new JTextField();
		txtFechaNacimiento.setColumns(10);
		txtFechaNacimiento.setBounds(203, 264, 222, 26);
		getContentPane().add(txtFechaNacimiento);

		btnAlta = new JButton("Alta");
		btnAlta.setBounds(480, 93, 165, 41);
		getContentPane().add(btnAlta);
		btnAlta.setEnabled(false);

		btnModificacion = new JButton("Modificacion");
		btnModificacion.setBounds(480, 177, 165, 41);
		getContentPane().add(btnModificacion);

		btnBaja = new JButton("Baja");
		btnBaja.setBounds(480, 257, 165, 41);
		getContentPane().add(btnBaja);

		btnAlta.addActionListener(this);
		btnModificacion.addActionListener(this);
		btnBaja.addActionListener(this);

		mostrarDatos();
	}

	private void mostrarDatos() {
		txtId.setText(propietario.getIdentificador());
		txtNombre.setText(propietario.getNombre());
		txtFechaNacimiento.setText(String.valueOf(propietario.getFechaNacimiento()));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btnAlta)) {
			Propietario prop = new Propietario();

			prop.setIdentificador(txtId.getText());
			prop.setNombre(txtNombre.getText());
			prop.setFechaNacimiento(LocalDate.parse(txtFechaNacimiento.getText()));

			datos.altaPropietario(prop);
			limpiar();
		}

	}

	private void limpiar() {
		txtId.setText("");
		txtNombre.setText("");
		txtFechaNacimiento.setText("");
	}

}
