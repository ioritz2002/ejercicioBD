package modelo;

import java.util.Map;

import clases.Coche;
import clases.Propietario;

public interface ControladorDatos {
	public void altaPropietario(Propietario prop);
	public Propietario buscarPropietario(String codigo);
	public void modificarPropietario(Propietario prop);
	public void eliminarPropietario(Propietario prop);
	public Map<String, Propietario> listarPropietarios();
	public void altaCoche(Coche coch);
	public Coche buscarCoche(String matricula);
	public void modificarCoche(Coche coch);
	public void eliminarCoche(Coche coch);
	public Map<String, Coche> listarCoches();
	public Map<String, Coche> listarCochesPropietario(Propietario prop);
}
