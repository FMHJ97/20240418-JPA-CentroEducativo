package tablaEstudiante;

import javax.swing.JFrame;

import tablaEstudiante.utils.Apariencia;
import tablaEstudiante.view.PanelTablaEstudiante;

public class Principal extends JFrame {

	private static final long serialVersionUID = 1L;
	private static Principal instance = null;
	
	static {
		Apariencia.setAparienciasOrdenadas(Apariencia.aparienciasOrdenadas);
	}
	
	/**
	 * Constructor.
	 */
	public Principal() {
		super("Centro Educativo JPA - Datos Estudiantes");
		
		this.setBounds(100, 100, 700, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		PanelTablaEstudiante panel = new PanelTablaEstudiante();
		
		this.getContentPane().add(panel);
	}
	
	/**
	 * Singleton.
	 * @return
	 */
	public static Principal getInstance() {
		if (instance == null) {
			instance = new Principal();
		}
		return instance;
	}

	/**
	 * Método Principal.
	 * @param args
	 */
	public static void main(String[] args) {
		getInstance().setVisible(true);
	}

}
