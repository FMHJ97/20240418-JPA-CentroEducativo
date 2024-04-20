package tablaEstudiante.view;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Iterator;

import javax.swing.JToolBar;
import javax.swing.table.DefaultTableModel;

import tablaEstudiante.controladores.ControladorEstudianteJPA;
import tablaEstudiante.entities.Estudiante;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;

public class PanelTabla extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private DefaultTableModel dtm = null;
	private Object datosTabla[][] = DatosDeTabla.getDatosDeTabla();
	private String titulosTabla[] = DatosDeTabla.getTitulosColumnas();
	
	// Referencia al PanelEstudiante actual.
	private PanelEstudiante panelEstudiante;

	/**
	 * Create the panel.
	 * Le pasamos como parámetro el PanelEstudiante que usaremos
	 * junto al JSplitPane.
	 */
	public PanelTabla(PanelEstudiante panelEstudiante) {
		
		this.panelEstudiante = panelEstudiante;
		
		setLayout(new BorderLayout(0, 0));
		
		JToolBar toolBar = new JToolBar();
		add(toolBar, BorderLayout.NORTH);
		
		JButton jbtnFirst = new JButton("");
		jbtnFirst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showFirstRow();
			}
		});
		jbtnFirst.setIcon(new ImageIcon(PanelTabla.class.getResource("/tablaEstudiante/res/FirstRow.png")));
		toolBar.add(jbtnFirst);
		
		JButton jbtnPrevious = new JButton("");
		jbtnPrevious.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				showPreviousRow();
			}
		});
		jbtnPrevious.setIcon(new ImageIcon(PanelTabla.class.getResource("/tablaEstudiante/res/PreviousRow.png")));
		toolBar.add(jbtnPrevious);
		
		JButton jbtnNext = new JButton("");
		jbtnNext.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				showNextRow();
			}
		});
		jbtnNext.setIcon(new ImageIcon(PanelTabla.class.getResource("/tablaEstudiante/res/NextRow.png")));
		toolBar.add(jbtnNext);
		
		JButton jbtnLast = new JButton("");
		jbtnLast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showLastRow();
			}
		});
		jbtnLast.setIcon(new ImageIcon(PanelTabla.class.getResource("/tablaEstudiante/res/LastRow.png")));
		toolBar.add(jbtnLast);
		
		// Inicializamos el DefaultTableModel.
		this.dtm = getDefaultTableModel();
		// Creo la tabla utilizando el DefaultTableModel.
		this.table = new JTable(dtm);
		// Limitamos el modo selección de filas a una única selección.
		this.table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		// Agregamos la JTable al JScrollPane.
		JScrollPane scrollPane = new JScrollPane(table);
		add(scrollPane, BorderLayout.CENTER);
		
		// Mostramos el posible primer registro.
		showFirstRow();
		
		// Utilizo un MouseListener para conseguir que al seleccionar una fila
		// se muestre en el Panel Estudiante.
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				// Mostramos los datos del registro.
				showSelectedRow();
			}
		});

	}
	
	/**
	 * Selecciona y muestra el posible registro anterior.
	 */
	public void showPreviousRow() {
		int indexActualRow = this.table.getSelectedRow();
		if (indexActualRow > 0) {
			indexActualRow--;
			this.table.setRowSelectionInterval(indexActualRow, indexActualRow);
			// Mostramos los datos del registro.
			showSelectedRow();
		}
	}
	
	/**
	 * Selecciona y muestra el posible siguiente registro.
	 */
	public void showNextRow() {
		int indexActualRow = this.table.getSelectedRow();
		if (this.dtm.getRowCount() - 1 > indexActualRow) {
			indexActualRow++;
			this.table.setRowSelectionInterval(indexActualRow, indexActualRow);
			// Mostramos los datos del registro.
			showSelectedRow();
		}
	}
	
	/**
	 * Selecciona y muestra el posible último registro.
	 */
	public void showLastRow() {
		if (this.dtm.getRowCount() > 0) {
			this.table.setRowSelectionInterval(
					this.dtm.getRowCount() - 1, this.dtm.getRowCount() - 1);
			// Mostramos los datos del registro.
			showSelectedRow();
		}
	}
	
	/**
	 * Selecciona y muestra el posible primer registro.
	 */
	public void showFirstRow() {
		if (this.dtm.getRowCount() > 0) {
			this.table.setRowSelectionInterval(0, 0);
			// Mostramos los datos del registro.
			showSelectedRow();
		}
	}
	
	/**
	 * Método que consigue actualizar los valores de la tabla.
	 */
	public void updateTable() {
		// Obtenemos los datos actualizados de la BBDD.
		this.datosTabla = DatosDeTabla.getDatosDeTabla();
		this.dtm.setDataVector(datosTabla, titulosTabla);
		// Se notifican los posibles cambios de las celdas de la tabla.
		this.dtm.fireTableDataChanged();
	}
	
	/**
	 * Mostramos en el panel Estudiante el registro seleccionado 
	 * en la tabla. Para ello, hacemos uso de la variable referencia 
	 * panelEstudiante.
	 */
	public void showSelectedRow() {
		try {
			int indexRow = table.getSelectedRow();
			Integer idCelda = (Integer) dtm.getValueAt(indexRow, 0);
			Estudiante est = (Estudiante) ControladorEstudianteJPA
					.getInstance().findById(idCelda);
			this.panelEstudiante.muestraEnPantalla(est);
		} catch (Exception e) {
			this.panelEstudiante.muestraEnPantalla(null);
		}
	}
	
	/**
	 * Selecciona y muestra un registro en la tabla según el id del mismo.
	 * @param e
	 */
	public void selectRowById(Estudiante e) {
		for (int i = 0; i < this.dtm.getRowCount(); i++) {
			Integer idCell = (Integer) this.dtm.getValueAt(i, 0);
			if (idCell == e.getId()) {
				this.table.setRowSelectionInterval(i, i);
				showSelectedRow();
			}
		}
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
