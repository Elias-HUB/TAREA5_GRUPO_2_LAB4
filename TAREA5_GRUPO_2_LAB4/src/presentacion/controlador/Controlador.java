package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;

import entidad.Persona;
import negocio.PersonaNegocio;
import presentacion.vista.Agregar;
import presentacion.vista.Eliminar;
import presentacion.vista.Listar;
import presentacion.vista.Menu;
import presentacion.vista.Modificar;
import negocio.*;

public class Controlador  implements ActionListener {

	private Menu menu;
	private Agregar pnlAgregar;
	private Eliminar pnlEliminar;
	private Modificar pnlModificar; 
	private Listar pnlListar;
	private PersonaNegocio pNeg;
	private ArrayList<Persona> personasEnTabla;
	public static DefaultListModel<Persona> listModel;
	
	
	//Constructor
	public Controlador(Menu menu, PersonaNegocio personaNegocio)//, PersonaNegocio pNeg)
	{
		//Guardo todas las instancias que recibo en el constructor
		this.menu = menu;
		this.pNeg = personaNegocio;
		listModel = new DefaultListModel<Persona>();
		
		//Instancio los paneles
		this.pnlAgregar = new Agregar();
		this.pnlEliminar = new Eliminar();
		this.pnlModificar = new Modificar();
		this.pnlListar = new Listar(); 
		//Enlazo todos los eventos
		
		//Eventos menu del Frame principal llamado Ventana
		this.menu.getMenuEliminar().addActionListener(a->EventoClickMenu_AbrirPanel_EliminarPersona(a));
		this.menu.getMenuAgregar().addActionListener(a->EventoClickMenu_AbrirPanel_AgregarPersona(a));		
		this.menu.getMenuModificar().addActionListener(a->EventoClickMenu_AbrirPanel_ModificarPersona(a));
		this.menu.getMenuListar().addActionListener(a->EventoClickMenu_AbrirPanel_Listar(a));
	
		
		
		//Eventos PanelAgregarPersonas
		this.pnlAgregar.getbtnAceptar().addActionListener(a->EventoClickBoton_AgregarPesona_PanelAgregarPersonas(a));
		
		//Eventos PanelModificarPersonas
		this.pnlModificar.getbtnModificar().addActionListener(s->EventoClickBoton_ModificarPesona_PanelModificarPersonas(s));
		
		//Eventos PanelEliminarPersonas
		this.pnlEliminar.getBtnEliminar().addActionListener(s->EventoClickBoton_BorrarPesona_PanelEliminarPersonas(s));		
		
		//Eventos PanelLista
		//this.pnlEliminarPersonas.getBtnEliminar().addActionListener(s->EventoClickBoton_BorrarPesona_PanelEliminarPersonas(s));
		}
	
	private void EventoClickBoton_BorrarPesona_PanelEliminarPersonas(ActionEvent s) {
		boolean estado=false;
		//int filasSeleccionadas = this.pnlEliminar.getList().getSelectedIndex();
		Persona persona = new Persona();
		persona = this.pnlEliminar.getList().getSelectedValue();
		String mensaje;
		if(persona==null)
		{
			mensaje="Seleccione una persona";
		}
		else 
			{
				estado = pNeg.delete(persona);
				if(estado==true)
				{
					mensaje="Persona eliminada con exito";	
				}
				else
				{
					 mensaje="dni inexistente";
				}
			}
		
		this.pnlEliminar.mostrarMensaje(mensaje);
		pnlEliminar.setListModelClear(listModel);
		refrescarJlistEliminar();
	}

	private void EventoClickBoton_ModificarPesona_PanelModificarPersonas(ActionEvent s) 
	{
		boolean estado= false; 
		Persona pMOD = new Persona();
		pMOD.setApellido(pnlModificar.devuelveApellido());
		pMOD.setNombre(pnlModificar.devuelveNombre());
		pMOD.setDni(pnlModificar.devuelveDni());
		String DniAux = pnlModificar.getDniAMod();
		String mensaje; 
		estado = pNeg.update(pMOD,DniAux);
		if(estado==true)
		{
			mensaje="Persona modificada con exito";	
	}
		else
		{
			 mensaje="No se pudo modificar";
		}
		this.pnlModificar.mostrarMensaje(mensaje);
		pnlModificar.setDni("");
		pnlModificar.setApellido("");
		pnlModificar.setNombre("");
		pnlModificar.setListModel(listModel);
		refrescarJlistModificar();
		
	}
	
	private void EventoClickBoton_AgregarPesona_PanelAgregarPersonas(ActionEvent a) {
		
		String nombre = this.pnlAgregar.gettxtNombre().getText();
		String apellido = this.pnlAgregar.gettxtApellido().getText();
		String dni = this.pnlAgregar.gettxtDni().getText();
		Persona nuevaPersona = new Persona(dni,nombre,apellido);
		String mensaje="";
		if(nombre.length() != 0 && apellido.length() != 0 && dni.length() != 0)
		{
			boolean estado = pNeg.insert(nuevaPersona);
			
			if(estado==true)
			{
				mensaje="Persona agregada con exito";
				this.pnlAgregar.gettxtNombre().setText("");
				this.pnlAgregar.gettxtApellido().setText("");
				this.pnlAgregar.gettxtDni().setText("");
			}
		}
		
		else
			
			mensaje="Persona no agregada, complete todos los campos";
		
		this.pnlAgregar.mostrarMensaje(mensaje);		
	}
	
		//EventoClickMenu abrir PanelAgregarPersonas
	public void  EventoClickMenu_AbrirPanel_AgregarPersona(ActionEvent a)
	{		
		menu.getContentPane().removeAll();
		menu.getContentPane().add(pnlAgregar);
		menu.getContentPane().repaint();
		menu.getContentPane().revalidate();
		this.pnlAgregar.gettxtNombre().setText("");
		this.pnlAgregar.gettxtApellido().setText("");
		this.pnlAgregar.gettxtDni().setText("");
	}
	
	public void EventoClickMenu_AbrirPanel_EliminarPersona(ActionEvent e)
	{
		menu.getContentPane().removeAll();
		menu.getContentPane().add(pnlEliminar);
		menu.getContentPane().repaint();
		menu.getContentPane().revalidate();	
		pnlEliminar.setListModelClear(listModel);
		refrescarJlistEliminar();		
	}
	
	public void refrescarJlistEliminar() {		
		personasEnTabla = (ArrayList<Persona>) pNeg.readAll();
		listModel.clear();
		for (Persona item: personasEnTabla)
			{
				listModel.addElement(item);		
			}
		pnlEliminar.setListModel(listModel);
	}
	
	
	public void refrescarJlistModificar() {		
		personasEnTabla = (ArrayList<Persona>) pNeg.readAll();
		listModel.clear();
		for (Persona item: personasEnTabla)
		{
			listModel.addElement(item);		
			pnlModificar.setListModel(listModel);
		}
	}
		
	public void EventoClickMenu_AbrirPanel_ModificarPersona(ActionEvent a)
	{
		menu.getContentPane().removeAll();
		menu.getContentPane().add(pnlModificar);
		menu.getContentPane().repaint();
		menu.getContentPane().revalidate();	
		pnlModificar.setListModel(listModel);
		refrescarJlistModificar();
		Persona per = new Persona();
		if(pnlModificar.getList().getSelectedValue() != null)
		{
			per = this.pnlModificar.getList().getSelectedValue();
			pnlModificar.setNombre(per.getNombre());
			pnlModificar.setApellido(per.getApellido());
			pnlModificar.setDni(per.getDni());
			pnlModificar.update(null);
		}
		
	}
	
	public void EventoClickMenu_AbrirPanel_Listar(ActionEvent a)
	{	
		menu.getContentPane().removeAll();
		menu.getContentPane().add(pnlListar);
		menu.getContentPane().repaint();
		menu.getContentPane().revalidate();
		
		personasEnTabla = (ArrayList<Persona>) pNeg.readAll();
		pnlListar.llenarTabla(personasEnTabla);
	}
	
	public void inicializar()
	{
		this.menu.setVisible(true);;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
