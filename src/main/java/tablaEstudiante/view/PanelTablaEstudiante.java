package tablaEstudiante.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.table.DefaultTableModel;

import tablaEstudiante.controladores.ControladorEstudianteJPA;
import tablaEstudiante.entities.Estudiante;

public class PanelTablaEstudiante extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public PanelTablaEstudiante() {
		
		// Debemos agregar un Layout sobre nuestro JPanel,
		// antes de agregar el JSplitPane.
		this.setLayout(new BorderLayout());
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		
		this.add(splitPane, BorderLayout.CENTER);
		splitPane.setResizeWeight(0.9);
		
		PanelEstudiante panelEst = new PanelEstudiante();
		splitPane.setRightComponent(panelEst);
		
		// Al crear el panelTabla, le pasamos como parámetro del constructor
		// el panelEstudiante. Lo hacemos para mostrar los datos de cada
		// registro de la tabla en el PanelEstudiante creado.
		PanelTabla panelTabla = new PanelTabla(panelEst);
		splitPane.setLeftComponent(panelTabla);
		
		// Al panelEstudiante le referenciamos el panelTabla creado
		// para poder actualizar la tabla en tiempo real.
		panelEst.setPanelTabla(panelTabla);
		
	}

}
