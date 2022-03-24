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
	//private String usuario = "root";
	private String usuario = "adminTemp";
	private String contraseña = "abcd*1234";
	
	//SQL
	private final String INSERTpropietario = "INSERT INTO propietario(ID_PROPIETARIO, NOMBRE, FECHA_NAC) VALUES(?,?,?)";
	private final String CONSULTARpropietarios = "SELECT * FROM propietario";
	private final String MOSTRARpropietario = "SELECT * FROM propietario WHERE ID_PROPIETARIO = ?";
	private final String DELETEpropietario = "DELETE FROM propietario WHERE ID_PROPIETARIO = ?";
	private final String UPDATEpropietario = "UPDATE propietario SET NOMBRE = ?, FECHA_NAC = ? WHERE ID_PROPIETARIO = ?";
	private final String INSERTcoche = "INSERT INTO coches(MATRICULA, MARCA, MODELO, EDAD, PRECIO, ID_PROPIETARIO) VALUES(?,?,?,?,?,?)";
	private final String SELECTcoches = "SELECT * FROM coches";
	
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
		openConnection();
		try {
			stmt = conex.prepareStatement(UPDATEpropietario);
			
			stmt.setString(1, prop.getNombre());
			stmt.setDate(2, Date.valueOf(prop.getFechaNacimiento()));
			stmt.setString(3, prop.getIdentificador());
			
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
		
		openConnection();
		try {
			
			stmt = conex.prepareStatement(INSERTcoche);
			
			stmt.setString(1, coch.getMatricula());
			stmt.setString(2, coch.getMarca());
			stmt.setString(3, coch.getModelo());
			stmt.setInt(4, coch.getEdad());
			stmt.setDouble(5, coch.getPrecio());
			stmt.setString(6, coch.getIdPropietario());
			
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
		ResultSet rs = null;
		Coche coche = null;
		Map<String, Coche> coches = new HashMap<String, Coche>();
		openConnection();
		try {
			stmt = conex.prepareStatement(SELECTcoches);
			rs = stmt.executeQuery();
			
			while (rs.next()) {
				coche = new Coche();
				coche.setMatricula(rs.getString(1));
				coche.setMarca(rs.getString(2));
				coche.setModelo(rs.getString(3));
				coche.setEdad(rs.getInt(4));
				coche.setPrecio(rs.getDouble(5));
				coche.setIdPropietario(rs.getString(6));
				coches.put(coche.getMatricula(), coche);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if (rs != null) {
					rs.close();
				}
				closeConnection();
			} catch (SQLException e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		
		return coches;
	}

	@Override
	public Map<String, Coche> listarCochesPropietario(Propietario prop) {
		// TODO Auto-generated method stub
		return null;
	}

}