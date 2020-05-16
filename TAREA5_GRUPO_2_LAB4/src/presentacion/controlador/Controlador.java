package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import entidad.Persona;
import negocio.PersonaNegocio;
import presentacion.vista.Agregar;
import presentacion.vista.Eliminar;
import presentacion.vista.Menu;
import presentacion.vista.Modificar;

public class Controlador  implements ActionListener {

	private Menu menu;
	private Agregar pnlIngreso;
	private Eliminar pnlEliminar;
	private Modificar pnlModificar; 
	private PersonaNegocio pNeg;
	private ArrayList<Persona> personasEnTabla;
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	}
	
	//Constructor
	public Controlador(Menu menu)//, PersonaNegocio pNeg)
	{
		//Guardo todas las instancias que recibo en el constructor
		this.menu = menu;
		this.pNeg = pNeg;
		
		//Instancio los paneles
		this.pnlAgregar = new PanelAgregarPersonas();
		this.pnlEliminarPersonas = new PanelEliminarPersonas();
		
		//Enlazo todos los eventos
		
		//Eventos menu del Frame principal llamado Ventana
		this.ventanaPrincipal.getMenuAgregar().addActionListener(a->EventoClickMenu_AbrirPanel_AgregarPersona(a));
		this.ventanaPrincipal.getMenuEliminar().addActionListener(a->EventoClickMenu_AbrirPanel_EliminarPersona(a));

		//Eventos PanelAgregarPersonas
		 this.pnlIngresoPersonas.getBtnAgregar().addActionListener(a->EventoClickBoton_AgregarPesona_PanelAgregarPersonas(a));
		 this.pnlIngresoPersonas.getBtnBorrar().addActionListener(s->EventoClickBoton_BorrarPesona_PanelAgregarPersonas(s));
			
		//Eventos PanelEliminarPersonas
		 this.pnlEliminarPersonas.getBtnEliminar().addActionListener(s->EventoClickBoton_BorrarPesona_PanelEliminarPersonas(s));
		 
		}
	
}
