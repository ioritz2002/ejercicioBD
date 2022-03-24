package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import clases.Coche;
import clases.Propietario;
import modelo.ControladorDatos;

import javax.swing.JComboBox;

public class VCoche extends JDialog implements ActionListener{

	private JTextField txtMatricula;
	private JButton btnBaja;
	private JButton btnModificacion;
	private JButton btnAlta;
	private JLabel lblEdad;
	private JLabel lblMarca;
	private JLabel lblModelo;
	private JLabel lblPrecio;
	private JLabel lblNewLabel_1;
	private JComboBox cmbxPropietario;
	private JTextField txtEdad;
	private JTextField txtMarca;
	private JTextField txtModelo;
	private JTextField txtPrecio;
	private ControladorDatos datos;
	private Map<String, Propietario> propietarios;


	/**
	 * Create the dialog.
	 * @param b 
	 * @param vPrincipal 
	 * @param datos 
	 */
	public VCoche(VPrincipal vPrincipal, boolean modal, ControladorDatos datos) {
		super(vPrincipal);
		this.setModal(modal);
		this.datos = datos;
		setBounds(100, 100, 752, 568);
		getContentPane().setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Matricula");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblNewLabel.setBounds(54, 24, 139, 63);
			getContentPane().add(lblNewLabel);
		}
		
		txtMatricula = new JTextField();
		txtMatricula.setBounds(164, 44, 222, 26);
		getContentPane().add(txtMatricula);
		txtMatricula.setColumns(10);
		
		btnAlta = new JButton("Alta");
		btnAlta.setBounds(480, 93, 165, 41);
		getContentPane().add(btnAlta);
		
		btnModificacion = new JButton("Modificacion");
		btnModificacion.setBounds(480, 177, 165, 41);
		getContentPane().add(btnModificacion);
		
		btnBaja = new JButton("Baja");
		btnBaja.setBounds(480, 278, 165, 41);
		getContentPane().add(btnBaja);
		
		btnModificacion.setEnabled(false);
		btnBaja.setEnabled(false);
		
		lblEdad = new JLabel("Edad");
		lblEdad.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEdad.setBounds(54, 81, 139, 63);
		getContentPane().add(lblEdad);
		
		lblMarca = new JLabel("marca");
		lblMarca.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMarca.setBounds(54, 155, 139, 63);
		getContentPane().add(lblMarca);
		
		lblModelo = new JLabel("Modelo");
		lblModelo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblModelo.setBounds(54, 221, 139, 63);
		getContentPane().add(lblModelo);
		
		lblPrecio = new JLabel("Precio");
		lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPrecio.setBounds(54, 291, 139, 63);
		getContentPane().add(lblPrecio);
		
		lblNewLabel_1 = new JLabel("Propietario:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(43, 413, 173, 56);
		getContentPane().add(lblNewLabel_1);
		
		cmbxPropietario = new JComboBox();
		cmbxPropietario.setBounds(265, 412, 209, 41);
		getContentPane().add(cmbxPropietario);
		
		txtEdad = new JTextField();
		txtEdad.setColumns(10);
		txtEdad.setBounds(164, 98, 222, 26);
		getContentPane().add(txtEdad);
		
		txtMarca = new JTextField();
		txtMarca.setColumns(10);
		txtMarca.setBounds(164, 178, 222, 26);
		getContentPane().add(txtMarca);
		
		txtModelo = new JTextField();
		txtModelo.setColumns(10);
		txtModelo.setBounds(164, 244, 222, 26);
		getContentPane().add(txtModelo);
		
		txtPrecio = new JTextField();
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(164, 314, 222, 26);
		getContentPane().add(txtPrecio);
		
		cargarComboPropietarios(datos);
	}
	
	public VCoche(SeleccionarCoche seleccionarCoche, Coche coche, boolean modal, ControladorDatos datos) {
		super(seleccionarCoche);
		this.setModal(modal);
		this.datos = datos;
		setBounds(100, 100, 752, 568);
		getContentPane().setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Matricula");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblNewLabel.setBounds(54, 24, 139, 63);
			getContentPane().add(lblNewLabel);
		}
		
		txtMatricula = new JTextField();
		txtMatricula.setBounds(164, 44, 222, 26);
		getContentPane().add(txtMatricula);
		txtMatricula.setColumns(10);
		
		btnAlta = new JButton("Alta");
		btnAlta.setBounds(480, 93, 165, 41);
		getContentPane().add(btnAlta);
		btnAlta.setEnabled(false);
		
		btnModificacion = new JButton("Modificacion");
		btnModificacion.setBounds(480, 177, 165, 41);
		getContentPane().add(btnModificacion);
		
		btnBaja = new JButton("Baja");
		btnBaja.setBounds(480, 278, 165, 41);
		getContentPane().add(btnBaja);
		
		lblEdad = new JLabel("Edad");
		lblEdad.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEdad.setBounds(54, 81, 139, 63);
		getContentPane().add(lblEdad);
		
		lblMarca = new JLabel("marca");
		lblMarca.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMarca.setBounds(54, 155, 139, 63);
		getContentPane().add(lblMarca);
		
		lblModelo = new JLabel("Modelo");
		lblModelo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblModelo.setBounds(54, 221, 139, 63);
		getContentPane().add(lblModelo);
		
		lblPrecio = new JLabel("Precio");
		lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPrecio.setBounds(54, 291, 139, 63);
		getContentPane().add(lblPrecio);
		
		lblNewLabel_1 = new JLabel("Propietario:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(43, 413, 173, 56);
		getContentPane().add(lblNewLabel_1);
		
		cmbxPropietario = new JComboBox();
		cmbxPropietario.setBounds(265, 412, 209, 41);
		getContentPane().add(cmbxPropietario);
		
		txtEdad = new JTextField();
		txtEdad.setColumns(10);
		txtEdad.setBounds(164, 98, 222, 26);
		getContentPane().add(txtEdad);
		
		txtMarca = new JTextField();
		txtMarca.setColumns(10);
		txtMarca.setBounds(164, 178, 222, 26);
		getContentPane().add(txtMarca);
		
		txtModelo = new JTextField();
		txtModelo.setColumns(10);
		txtModelo.setBounds(164, 244, 222, 26);
		getContentPane().add(txtModelo);
		
		txtPrecio = new JTextField();
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(164, 314, 222, 26);
		getContentPane().add(txtPrecio);
		
		cargarComboPropietarios(datos);
	}
	
	private void cargarComboPropietarios(ControladorDatos datos) {
		propietarios = datos.listarPropietarios();
		
		for (Propietario p : propietarios.values()) {
			cmbxPropietario.addItem(p.getIdentificador() + " " + p.getNombre());
		}
		
		cmbxPropietario.setSelectedIndex(-1);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btnAlta)) {
			Coche coche = new Coche();
			coche.setMatricula(txtMatricula.getText());
			coche.setMarca(txtMarca.getText());
			coche.setModelo(txtModelo.getText());
			coche.setEdad(Integer.parseInt(txtEdad.getText()));
			coche.setPrecio(Double.parseDouble(txtPrecio.getText()));
			
			datos.altaCoche(coche);
		}
	}
}
