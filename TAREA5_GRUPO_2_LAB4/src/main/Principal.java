package main;

import negocio.PersonaNegocio;
import negocioImpl.PersonaNegocioImpl;
import presentacion.controlador.Controlador;
import presentacion.vista.Menu;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		
		Menu menu = new Menu(); 
		PersonaNegocio negocio = new PersonaNegocioImpl();
		Controlador controlador = new Controlador(menu);
		controlador.inicializar();
		menu.setVisible(true);
	}

}
