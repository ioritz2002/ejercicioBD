package controlador;

import modelo.ControladorDatos;
import modelo.ImplementacionControladorBD;
import vista.VPrincipal;

public class Main {

	public static void main(String[] args) {
		ControladorDatos datos = new ImplementacionControladorBD();
		
		VPrincipal principal = new VPrincipal(datos);
		principal.setVisible(true);
	}

}
