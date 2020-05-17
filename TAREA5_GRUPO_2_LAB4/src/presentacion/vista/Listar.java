package presentacion.vista;

import javax.swing.JPanel;
import javax.swing.JList;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.ListSelectionModel;

public class Listar extends JPanel {

	/**
	 * Create the panel.
	 */
	public Listar() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JList ListaPersonas = new JList();
		ListaPersonas.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		ListaPersonas.setValueIsAdjusting(true);
		ListaPersonas.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		GridBagConstraints gbc_ListaPersonas = new GridBagConstraints();
		gbc_ListaPersonas.gridwidth = 4;
		gbc_ListaPersonas.gridheight = 3;
		gbc_ListaPersonas.fill = GridBagConstraints.BOTH;
		gbc_ListaPersonas.gridx = 2;
		gbc_ListaPersonas.gridy = 1;
		add(ListaPersonas, gbc_ListaPersonas);

	}

}
