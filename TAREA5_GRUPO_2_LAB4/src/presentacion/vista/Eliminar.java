package presentacion.vista;

import javax.swing.JPanel;

import entidad.Persona;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;

import com.mysql.cj.PerConnectionLRUFactory;

public class Eliminar extends JPanel {

	/**
	 * Create the panel.
	 */
	private JList<Persona> list;
	private JButton btnEliminar;
	private DefaultListModel<Persona> listModel;
	
	
	public Eliminar() {
		dibujarControles();
	}
	public void dibujarControles() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 272, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 215, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 1.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("Eliminar usuarios");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 3;
		gbc_lblNewLabel.gridy = 0;
		add(lblNewLabel, gbc_lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 3;
		gbc_scrollPane.gridy = 1;
		add(scrollPane, gbc_scrollPane);
		
		btnEliminar = new JButton("Eliminar");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridx = 3;
		gbc_btnNewButton.gridy = 2;
		add(btnEliminar, gbc_btnNewButton);	
		list = new JList<Persona>();		
		scrollPane.setViewportView(list);
	}


	public JList<Persona> getList() {
		return list;
	}


	public void setList(JList<Persona> list) {
		this.list = list;
	}


	public JButton getBtnEliminar() {
		return btnEliminar;
	}


	public void setBtnEliminar(JButton btnEliminar) {
		this.btnEliminar = btnEliminar;
	}


	public DefaultListModel<Persona> getListModel() {
		return listModel;
	}


	public void setListModel(DefaultListModel<Persona> listModel) {		
		this.list.setModel(listModel);
	}
	
	
	public void setListModelClear(DefaultListModel<Persona> listModel) {	
		listModel.clear();
		this.list.setModel(listModel);
	}
	
		
	public void mostrarMensaje(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje);		
	}

}
