package tablaEstudiante.controladores;

import tablaEstudiante.entities.TipologiaSexo;

public class ControladorTipologiaSexoJPA extends SuperControladorJPA {
	
	public ControladorTipologiaSexoJPA() {
		super("tipologiaSexo", TipologiaSexo.class);
	}

	private static ControladorTipologiaSexoJPA instance = null;
	
	/**
	 * Singleton.
	 * @return
	 */
	public static ControladorTipologiaSexoJPA getInstance() {
		if (instance == null) {
			instance = new ControladorTipologiaSexoJPA();
		}
		return instance;
	}
	
}
