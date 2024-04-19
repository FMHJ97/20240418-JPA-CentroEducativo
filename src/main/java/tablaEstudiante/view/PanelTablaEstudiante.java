package tablaEstudiante.view;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import tablaEstudiante.controladores.ControladorEstudianteJPA;
import tablaEstudiante.entities.Estudiante;

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
		
		// Inicializamos el DefaultTableModel.
		this.dtm = getDefaultTableModel();
		// Creo la tabla utilizando el DefaultTableModel.
		table = new JTable(dtm);
		
		JScrollPane scrollPane = new JScrollPane(table);
		splitPane.setLeftComponent(scrollPane);
		
		PanelEstudiante panelEst = new PanelEstudiante();
		splitPane.setRightComponent(panelEst);

		// Debemos agregar un Layout sobre nuestro JPanel,
		// antes de agregar el JSplitPane.
		this.setLayout(new BorderLayout());
		add(splitPane, BorderLayout.CENTER);
		splitPane.setResizeWeight(0.7);
		
		// Utilizo un MouseListener para conseguir que al seleccionar una fila
		// se muestre en el Panel Estudiante.
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				int indexRow = table.getSelectedRow();
				Integer idCelda = (Integer) dtm.getValueAt(indexRow, 0);
				Estudiante est = (Estudiante) ControladorEstudianteJPA
						.getInstance().findById(idCelda);
				panelEst.muestraEnPantalla(est);
			}
		});
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
