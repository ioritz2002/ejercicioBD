package modelo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import clases.Coche;
import clases.Propietario;

public class ImplementacionControladorBD implements ControladorDatos{

	private Connection conex;
	private PreparedStatement stmt;
	
	//Conexion
	private String url = "jdbc:mysql://localhost:3306/bdcoches?serverTimezone=Europe/Madrid&useSSL=false";
	private String usuario = "root";
	//private String usuario = "adminTemp";
	private String contraseña = "abcd*1234";
	
	//SQL
	final String INSERTpropietario = "INSERT INTO propietario(ID_PROPIETARIO, NOMBRE, FECHA_NAC) VALUES(?,?,?)";
	final String CONSULTARpropietarios = "SELECT * FROM propietario";
	final String MOSTRARpropietario = "SELECT * FROM propietario WHERE ID_PROPIETARIO = ?";
	final String DELETEpropietario = "DELETE FROM propietario WHERE ID_PROPIETARIO = ?";
	final String UPDATEpropietario = "UPDATE propietario SET NOMBRE = ?, FECHA_NAC = ? WHERE ID_PROPIETARIO = ?";
	
	public void openConnection() {
		try {
			conex = DriverManager.getConnection(url, usuario, contraseña);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void closeConnection() throws SQLException{
		if (conex != null) {
			conex.close();
		}
		if (stmt != null) {
			stmt.close();
		}
	}
	
	@Override
	public void altaPropietario(Propietario prop) {
		openConnection();
		try {
			stmt = conex.prepareStatement(INSERTpropietario);
			
			stmt.setString(1, prop.getIdentificador());
			stmt.setString(2, prop.getNombre());
			stmt.setDate(3, Date.valueOf(prop.getFechaNacimiento()));
			
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				closeConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public Propietario buscarPropietario(String codigo) {
		//Error
		Propietario propietario = null;
		ResultSet rs = null;
		
		openConnection();
		try {
			stmt = conex.prepareStatement(MOSTRARpropietario);
			rs = stmt.executeQuery();
			
			if (rs.next()) {
				propietario = new Propietario();
				propietario.setIdentificador(codigo);
				propietario.setNombre(rs.getString(2));
				propietario.setFechaNacimiento(rs.getDate(3).toLocalDate());
				System.out.println(propietario.getNombre());
				System.out.println(propietario.getFechaNacimiento());
				System.out.println(propietario.getIdentificador());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				closeConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return propietario;
	}

	@Override
	public void modificarPropietario(Propietario prop) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminarPropietario(Propietario prop) {
		openConnection();
		try {
			stmt = conex.prepareStatement(DELETEpropietario);
			
			stmt.setString(1, prop.getIdentificador());
			
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				closeConnection();
			} catch (SQLException e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
	}

	@Override
	public Map<String, Propietario> listarPropietarios() {
		Map<String, Propietario> propietarios = new HashMap<String, Propietario>();
		ResultSet rs = null;
		Propietario propietario = null;
		openConnection();
		try {
			stmt = conex.prepareStatement(CONSULTARpropietarios);
			rs = stmt.executeQuery();
			while (rs.next()) {
				propietario = new Propietario();
				propietario.setIdentificador(rs.getString(1));
				propietario.setNombre(rs.getString(2));
				propietario.setFechaNacimiento(rs.getDate(3).toLocalDate());
				propietarios.put(propietario.getIdentificador(), propietario);
			}			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
			try {
				if (rs != null) {
					rs.close();
				}
				closeConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		return propietarios;
	}

	@Override
	public void altaCoche(Coche coch) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Coche buscarCoche(String matricula) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void modificarCoche(Coche coch) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminarCoche(Coche coch) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Map<String, Coche> listarCoches() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Coche> listarCochesPropietario(Propietario prop) {
		// TODO Auto-generated method stub
		return null;
	}

}