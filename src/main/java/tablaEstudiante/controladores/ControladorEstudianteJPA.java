package tablaEstudiante.controladores;

import tablaEstudiante.entities.Estudiante;

public class ControladorEstudianteJPA extends SuperControladorJPA {
	
	public ControladorEstudianteJPA() {
		super("estudiante", Estudiante.class);
	}

	private static ControladorEstudianteJPA instance = null;
	
	/**
	 * Singleton.
	 * @return
	 */
	public static ControladorEstudianteJPA getInstance() {
		if (instance == null) {
			instance = new ControladorEstudianteJPA();
		}
		return instance;
	}
	
}
