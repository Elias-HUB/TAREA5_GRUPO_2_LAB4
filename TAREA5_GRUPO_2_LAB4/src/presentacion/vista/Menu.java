package presentacion.vista;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.FlowLayout;

public class Menu extends JFrame {

	private JMenuBar MenuBar;
	private JMenu MnPersonas;
	private JMenuItem MnAgregar;
	private JMenuItem MnModificar;
	private JMenuItem MnEliminar;
	private JMenuItem MnListar;
	
	public Menu() {
		
		setResizable(false);
		setTitle("Programa");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 516, 347);
		
		MenuBar = new JMenuBar();
		setJMenuBar(MenuBar);
		
		MnPersonas = new JMenu("Persona");
		MenuBar.add(MnPersonas);
		
		MnAgregar = new JMenuItem("Agregar");
		MnPersonas.add(MnAgregar);
		
		MnModificar = new JMenuItem("Modificar");
		MnPersonas.add(MnModificar);
		
		MnEliminar = new JMenuItem("Eliminar");
		MnPersonas.add(MnEliminar);
		
		MnListar = new JMenuItem("Listar");
		MnPersonas.add(MnListar);
		getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
	}
	
	
	public JMenu getMnPersonas() {
		return MnPersonas;
	}

	public void setMnPersonas(JMenu mnPersonas) {
		this.MnPersonas = mnPersonas;
	}

	
	public JMenuItem getMenuAgregar() {
		return MnAgregar;
	}

	public void setMenuAgregar(JMenuItem menuAgregar) {
		this.MnAgregar = menuAgregar;
	}
	
	
	public JMenuItem getMenuModificar() {
		return MnModificar;
	}

	public void setMenuModificar(JMenuItem menuModificar) {
		this.MnModificar = menuModificar;
	}
	
		
	public JMenuItem getMenuEliminar() {
		return MnEliminar;
	}

	public void setMenuEliminar(JMenuItem menuEliminar) {
		this.MnEliminar = menuEliminar;
	}
	
	public JMenuItem getMenuListar() {
		return MnListar;
	}

	public void setMenuListar(JMenuItem menuListar) {
		this.MnListar = menuListar;
	}
}
