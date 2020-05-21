package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JList;

import entidad.Persona;
import negocio.PersonaNegocio;
import presentacion.vista.Agregar;
import presentacion.vista.Eliminar;
import presentacion.vista.Listar;
import presentacion.vista.Menu;
import presentacion.vista.Modificar;

public class Controlador implements ActionListener {

	private Menu menu;
	private Agregar pnlAgregar;
	private Eliminar pnlEliminar;
	private Modificar pnlModificar;
	private Listar pnlListar;
	private PersonaNegocio pNeg;
	private ArrayList<Persona> personasEnTabla;
	public static DefaultListModel<Persona> listModel;

	// Constructor
	public Controlador(Menu menu, PersonaNegocio personaNegocio)// , PersonaNegocio pNeg)
	{
		// Guardo todas las instancias que recibo en el constructor
		this.menu = menu;
		this.pNeg = personaNegocio;
		listModel = new DefaultListModel<Persona>();

		// Instancio los paneles
		this.pnlAgregar = new Agregar();
		this.pnlEliminar = new Eliminar();
		this.pnlModificar = new Modificar();
		this.pnlListar = new Listar();
		// Enlazo todos los eventos

		// Eventos menu del Frame principal llamado Ventana
		this.menu.getMenuEliminar().addActionListener(a -> EventoClickMenu_AbrirPanel_EliminarPersona(a));
		this.menu.getMenuAgregar().addActionListener(a -> EventoClickMenu_AbrirPanel_AgregarPersona(a));
		this.menu.getMenuModificar().addActionListener(a -> EventoClickMenu_AbrirPanel_ModificarPersona(a));
		this.menu.getMenuListar().addActionListener(a -> EventoClickMenu_AbrirPanel_Listar(a));

		// Eventos PanelAgregarPersonas
		this.pnlAgregar.getbtnAceptar().addActionListener(a -> EventoClickBoton_AgregarPesona_PanelAgregarPersonas(a));
		EventoAgregarValidarGetTxtDni();
		EventoAgregarValidarGetTxtNombre();
		EventoAgregarValidarGetTxtApellido();
		// Eventos PanelModificarPersonas
		this.pnlModificar.getbtnModificar()
				.addActionListener(s -> EventoClickBoton_ModificarPesona_PanelModificarPersonas(s));
		EventoGettxtNombreaddKeyListener();
		EventoGettxtApellidoaddKeyListener();
		EventoGettxtDniaddKeyListener();
		EventoGetJlisaddMouseListener();

		// Eventos PanelEliminarPersonas
		this.pnlEliminar.getBtnEliminar()
				.addActionListener(s -> EventoClickBoton_BorrarPesona_PanelEliminarPersonas(s));
	}

	private void EventoClickBoton_BorrarPesona_PanelEliminarPersonas(ActionEvent s) {
		boolean estado = false;
		Persona persona = new Persona();
		persona = this.pnlEliminar.getList().getSelectedValue();
		String mensaje;
		if (persona == null) {
			mensaje = "Seleccione una persona";
		} else {
			estado = pNeg.delete(persona);
			if (estado == true) {
				mensaje = "Persona eliminada con exito";
			} else {
				mensaje = "dni inexistente";
			}
		}

		this.pnlEliminar.mostrarMensaje(mensaje);
		pnlEliminar.setListModelClear(listModel);
		refrescarJlistEliminar();
	}

	private void EventoClickBoton_ModificarPesona_PanelModificarPersonas(ActionEvent s) {
		boolean estado = false;
		String mensaje;
		if (pnlModificar.devuelveApellido().length() == 0 || pnlModificar.devuelveNombre().length() == 0
				|| pnlModificar.devuelveDni().length() == 0) {
			mensaje = "Complete todos los campos";
		} else {
			Persona pMOD = new Persona();
			pMOD.setApellido(pnlModificar.devuelveApellido());
			pMOD.setNombre(pnlModificar.devuelveNombre());
			pMOD.setDni(pnlModificar.devuelveDni());
			String DniAux = pnlModificar.getDniAMod();

			estado = pNeg.update(pMOD, DniAux);
			if (estado == true) {
				mensaje = "Persona modificada con exito";
			} else {
				mensaje = "No se pudo modificar";
			}

			pnlModificar.setDni("");
			pnlModificar.setApellido("");
			pnlModificar.setNombre("");
			pnlModificar.setListModel(listModel);
			refrescarJlistModificar();

		}
		this.pnlModificar.mostrarMensaje(mensaje);
	}

	private void EventoClickBoton_AgregarPesona_PanelAgregarPersonas(ActionEvent a) {

		String nombre = this.pnlAgregar.gettxtNombre().getText();
		String apellido = this.pnlAgregar.gettxtApellido().getText();
		String dni = this.pnlAgregar.gettxtDni().getText();
		Persona nuevaPersona = new Persona(dni, nombre, apellido);
		String mensaje;
		try {
			boolean estado = pNeg.insert(nuevaPersona);
			if (estado == true) {
				mensaje = "Persona agregada con exito";
				this.pnlAgregar.gettxtNombre().setText("");
				this.pnlAgregar.gettxtApellido().setText("");
				this.pnlAgregar.gettxtDni().setText("");
			} else if (nombre.length() == 0 || apellido.length() == 0 || dni.length() == 0) {
				mensaje = "Persona no agregada, complete todos los campos";
			} else {
				mensaje = "DNI Repetido";
			}
		} catch (Exception ex) {
			mensaje = "Error";
		}

		this.pnlAgregar.mostrarMensaje(mensaje);
	}

	// EventoClickMenu abrir PanelAgregarPersonas
	public void EventoClickMenu_AbrirPanel_AgregarPersona(ActionEvent a) {
		menu.getContentPane().removeAll();
		menu.getContentPane().add(pnlAgregar);
		menu.getContentPane().repaint();
		menu.getContentPane().revalidate();
		this.pnlAgregar.gettxtNombre().setText("");
		this.pnlAgregar.gettxtApellido().setText("");
		this.pnlAgregar.gettxtDni().setText("");
	}

	public void EventoClickMenu_AbrirPanel_EliminarPersona(ActionEvent e) {
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
		for (Persona item : personasEnTabla) {
			listModel.addElement(item);
		}
		pnlEliminar.setListModel(listModel);
	}

	public void refrescarJlistModificar() {
		personasEnTabla = (ArrayList<Persona>) pNeg.readAll();
		listModel.clear();
		for (Persona item : personasEnTabla) {
			listModel.addElement(item);
			pnlModificar.setListModel(listModel);
		}
	}

	public void EventoClickMenu_AbrirPanel_ModificarPersona(ActionEvent a) {
		menu.getContentPane().removeAll();
		menu.getContentPane().add(pnlModificar);
		menu.getContentPane().repaint();
		menu.getContentPane().revalidate();
		pnlModificar.setListModel(listModel);
		pnlModificar.setDni("");
		pnlModificar.setApellido("");
		pnlModificar.setNombre("");
		refrescarJlistModificar();

	}

	public void EventoClickMenu_AbrirPanel_Listar(ActionEvent a) {
		menu.getContentPane().removeAll();
		menu.getContentPane().add(pnlListar);
		menu.getContentPane().repaint();
		menu.getContentPane().revalidate();

		personasEnTabla = (ArrayList<Persona>) pNeg.readAll();
		pnlListar.llenarTabla(personasEnTabla);
	}

	public void inicializar() {
		this.menu.setVisible(true);
		;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
	}

	private void EventoGettxtNombreaddKeyListener() {
		this.pnlModificar.GettxtNombre().addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char Validar = e.getKeyChar();
				if (!Character.isAlphabetic(Validar) && Validar != '\b') {
					pnlModificar.getToolkit().beep();
					e.consume();
					pnlModificar.MostarMensaje("Ingrese solamente letras");
				}
			}
		});
	}

	private void EventoGettxtApellidoaddKeyListener() {
		this.pnlModificar.GettxtApellido().addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char Validar = e.getKeyChar();
				if (!Character.isAlphabetic(Validar) && Validar != '\b') {
					pnlModificar.getToolkit().beep();
					e.consume();
					pnlModificar.MostarMensaje("Ingrese solamente letras");
				}
			}
		});
	}

	private void EventoGettxtDniaddKeyListener() {
		this.pnlModificar.GettxtDni().addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char Validar = e.getKeyChar();
				if (!Character.isDigit(Validar) && Validar != '\b') {
					pnlModificar.getToolkit().beep();
					e.consume();
					pnlModificar.MostarMensaje("Ingrese solamente numeros");
				}
			}
		});
	}

	private void EventoAgregarValidarGetTxtDni() {
		this.pnlAgregar.gettxtDni().addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char Validar = e.getKeyChar();
				if (!Character.isDigit(Validar) && Validar != '\b') {
					pnlModificar.getToolkit().beep();
					e.consume();
					pnlModificar.MostarMensaje("Ingrese solamente numeros");
				}
			}
		});
	}

	private void EventoAgregarValidarGetTxtNombre() {
		this.pnlAgregar.gettxtNombre().addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char Validar = e.getKeyChar();
				if (!Character.isAlphabetic(Validar) && Validar != '\b') {
					pnlModificar.getToolkit().beep();
					e.consume();
					pnlModificar.MostarMensaje("Ingrese solamente letras");
				}
			}
		});
	}

	private void EventoAgregarValidarGetTxtApellido() {
		this.pnlAgregar.gettxtApellido().addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char Validar = e.getKeyChar();
				if (!Character.isAlphabetic(Validar) && Validar != '\b') {
					pnlModificar.getToolkit().beep();
					e.consume();
					pnlModificar.MostarMensaje("Ingrese solamente letras");
				}
			}
		});
	}

	private void EventoGetJlisaddMouseListener() {
		this.pnlModificar.GetJlis().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Persona p = new Persona();
				JList<Persona> list = new JList<>();
				list = pnlModificar.GetJlis();
				p = list.getSelectedValue();
				pnlModificar.setNombre(p.getNombre());
				pnlModificar.setApellido(p.getApellido());
				pnlModificar.setDni(p.getDni());
				pnlModificar.setDniAMod(p.getDni());
			}
		});
	}
}
