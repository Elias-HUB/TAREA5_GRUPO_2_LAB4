package presentacion.vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Menu extends JFrame {

	private JPanel contentPane;

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


		/*
		JMenuItem MnAgregar = new JMenuItem("Agregar");
		MnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Agregar panelAg = new Agregar();
				contentPane.removeAll(); 
				contentPane.add(panelAg);
				contentPane.repaint();
				contentPane.revalidate();
			}
		});
		mnNewMenu.add(MnAgregar);
		
		JMenuItem MnModificar = new JMenuItem("Modificar");
		MnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.removeAll(); 
				Modificar panelMod = new Modificar();
				contentPane.add(panelMod);
				contentPane.repaint();
				contentPane.revalidate();
			}
		});
		mnNewMenu.add(MnModificar);
		
		JMenuItem MnEliminar = new JMenuItem("Eliminar");
		MnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.removeAll(); 
				Eliminar panelElim = new Eliminar();
				contentPane.add(panelElim);
				contentPane.repaint();
				contentPane.revalidate();
			}
		});
		mnNewMenu.add(MnEliminar);
		
		JMenuItem MnListar = new JMenuItem("Listar");
		mnNewMenu.add(MnListar);
		contentPane = new JPanel();
		contentPane.removeAll(); 
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		*/


}
