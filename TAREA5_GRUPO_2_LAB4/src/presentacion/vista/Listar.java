package presentacion.vista;

import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

import entidad.Persona;

import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JTable;
import javax.swing.BoxLayout;

public class Listar extends JPanel {
	
	private JTable tablaPersonas;
	private DefaultTableModel modelPersonas;
	private String[] nombreColumnas = {"Nombre", "Apellido","Dni"};
	
	
	/**
	 * Create the panel.
	 */
	public Listar() {
		super();
		initialize();
		
	}
	private void initialize() 
	{
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		JScrollPane spPersonas = new JScrollPane();
		panel.add(spPersonas);
		
		modelPersonas = new DefaultTableModel(null,nombreColumnas);
		tablaPersonas = new JTable(modelPersonas);
		spPersonas.setViewportView(tablaPersonas);
	}
	
	
	public DefaultTableModel getModelPersonas() 
	{
		return modelPersonas;
	}
	
	public JTable getTablaPersonas()
	{
		return tablaPersonas;
	}

	public String[] getNombreColumnas() 
	{
		return nombreColumnas;
	}
	
	
	public void llenarTabla(List<Persona> personasEnTabla) {
		this.getModelPersonas().setRowCount(0); //Para vaciar la tabla
		this.getModelPersonas().setColumnCount(0);
		this.getModelPersonas().setColumnIdentifiers(this.getNombreColumnas());

		for (Persona p : personasEnTabla)
		{
			String Nombre = p.getNombre();
			String Apellido = p.getApellido();
			String Dni = p.getDni();
			Object[] fila = {Nombre, Apellido, Dni};
			this.getModelPersonas().addRow(fila);
		}
		
	}
}
