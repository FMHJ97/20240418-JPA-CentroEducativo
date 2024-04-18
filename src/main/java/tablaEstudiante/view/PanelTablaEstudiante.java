package tablaEstudiante.view;

import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class PanelTablaEstudiante extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private DefaultTableModel dtm = null;
	private Object datosTabla[][] = DatosDeTabla.getDatosDeTabla();
	private String titulosTabla[] = DatosDeTabla.getTitulosColumnas();

	/**
	 * Create the panel.
	 */
	public PanelTablaEstudiante() {
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane.setResizeWeight(0.5);
		add(splitPane);
		
		
		JScrollPane scrollPane = new JScrollPane();
		splitPane.setLeftComponent(scrollPane);
		
		// Inicializamos el DefaultTableModel.
		this.dtm = getDefaultTableModel();
		// Creo la tabla utilizando el DefaultTableModel.
		table = new JTable(dtm);
		// Agrego la tabla al scrollPane.
		scrollPane.setViewportView(table);
		
		PanelEstudiante panelEst = new PanelEstudiante();
		splitPane.setRightComponent(panelEst);

	}
	
	/**
	 * 
	 * @return
	 */
	private DefaultTableModel getDefaultTableModel() {
		DefaultTableModel dtm = 
				new DefaultTableModel(datosTabla, titulosTabla) {
			
			/**
			 * La sobreescritura de este método nos permite controlar 
			 * qué celdas queremos que sean editables
			 */
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
			
		};
		return dtm;
	}

}
