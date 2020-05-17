package presentacion.vista;

import javax.swing.JPanel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import entidad.Persona;

import java.awt.BorderLayout;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import java.awt.GridLayout;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.FlowLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.SwingConstants;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Modificar extends JPanel {
	
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtDni;
	private JList<Persona> list;
	private DefaultListModel<Persona> listModel;
	private JButton btnModificar;
	private JScrollPane scrollPane;
	private MouseListener Click; 
	private String DniAMod; 
	
	public Modificar() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{1, 0, 0, 51, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("Seleccione la persona que desea modificar");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel.anchor = GridBagConstraints.NORTH;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		add(lblNewLabel, gbc_lblNewLabel);
		
		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 2;
		add(scrollPane, gbc_scrollPane);
		
		list = new JList<Persona>();
		list.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				Persona p= new Persona();
				p= list.getSelectedValue();
				txtNombre.setText(p.getNombre());
				txtApellido.setText(p.getApellido());
				txtDni.setText(p.getDni());
				DniAMod=p.getDni();
			}
		});
		scrollPane.setViewportView(list);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.anchor = GridBagConstraints.NORTH;
		gbc_panel.insets = new Insets(0, 0, 0, 5);
		gbc_panel.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 3;
		add(panel, gbc_panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		txtNombre = new JTextField();
		txtNombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char Validar = e.getKeyChar();
				if(!Character.isAlphabetic(Validar)) {
				getToolkit().beep();
				e.consume();
				JOptionPane.showMessageDialog(getRootPane(), "Ingrese solamente letras");
			}
			}
		});
		panel.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char Validar = e.getKeyChar();
				if(!Character.isAlphabetic(Validar) && Validar!= '\b') {
				getToolkit().beep();
				e.consume();
				JOptionPane.showMessageDialog(getRootPane(), "Ingrese solamente letras");
				}
			}
		});
		panel.add(txtApellido);
		txtApellido.setColumns(10);
		
		txtDni = new JTextField();
		txtDni.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char Validar = e.getKeyChar();
				if(!Character.isDigit(Validar)&& Validar!= '\b') {
				getToolkit().beep();
				e.consume();
				JOptionPane.showMessageDialog(getRootPane(), "Ingrese solamente numeros");
			}
			}
		});
		panel.add(txtDni);
		txtDni.setColumns(10);
		
		btnModificar = new JButton("Modificar");
		panel.add(btnModificar);

	}


	public JList<Persona> getList() {
		return list;
	}

	public void setList(JList<Persona> list) {
		this.list = list;
	}

	public JButton getbtnModificar() {
		return btnModificar;
	}

	public void setbtnModificar(JButton btnModificar) {
		this.btnModificar = btnModificar;
	}

	public DefaultListModel<Persona> getListModel() {
		return listModel;
	}
	public void setListModel(DefaultListModel<Persona> listModelo) {		
		this.list.setModel(listModelo);
	}
	
	public void mostrarMensaje(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje);		
	}

	public String devuelveApellido()
	{
		return txtApellido.getText();
	}
	
	public void setApellido(String ap)
	{
		txtApellido.setText(ap);
	}
	
	public String devuelveNombre()
	{
		return txtNombre.getText();
	}
	
	public void setNombre(String no)
	{
		txtNombre.setText(no);
	}
	
	public String devuelveDni()
	{
		return txtDni.getText();
	}
	
	public void setDni(String dni)
	{
		txtDni.setText(dni);
	}
	public String getDniAMod()
	{
		return DniAMod;
	}
	
	public MouseListener DevuelveClick()
	{
		return Click;
	}

}
