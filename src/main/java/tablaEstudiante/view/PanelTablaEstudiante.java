package tablaEstudiante.view;

import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class PanelTablaEstudiante extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public PanelTablaEstudiante() {
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane.setDividerLocation(0.5);
		add(splitPane);
		
		
		JScrollPane scrollPane = new JScrollPane();
		splitPane.setLeftComponent(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		PanelEstudiante panelEst = new PanelEstudiante();
		splitPane.setRightComponent(panelEst);

	}

}
