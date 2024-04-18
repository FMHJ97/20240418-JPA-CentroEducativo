package tablaEstudiante.view;

import java.util.List;

import tablaEstudiante.controladores.ControladorEstudianteJPA;
import tablaEstudiante.controladores.ControladorTipologiaSexoJPA;
import tablaEstudiante.entities.Estudiante;
import tablaEstudiante.entities.TipologiaSexo;

public class DatosDeTabla {

	/** 
	 * 
	 * @return
	 */
	public static String[] getTitulosColumnas() {
		return new String[] {"Id", "Nombre", "Primer Apellido", "Segundo Apellido", 
				"Sexo", "DNI", "Dirección", "E-mail", "Teléfono"};
	}

	/**
	 * 
	 * @return
	 */
	public static Object[][] getDatosDeTabla() {
		// Obtengo todos los estudiantes.
		List<Estudiante> estudiantes = (List<Estudiante>) ControladorEstudianteJPA
				.getInstance().findAll();
		
		// Obtengo todas las tipologias sexo.
		List<TipologiaSexo> l = (List<TipologiaSexo>) ControladorTipologiaSexoJPA
				.getInstance().findAll();
		
		// Preparo una estructura para pasar al constructor de la JTable
		Object[][] datos = new Object[estudiantes.size()][9];
		// Cargo los datos de la lista de estudiantes en la matriz de los datos
		for (int i = 0; i < estudiantes.size(); i++) {
			Estudiante est = estudiantes.get(i);
			datos[i][0] = est.getId();
			datos[i][1] = est.getNombre();
			datos[i][2] = est.getApellido1();
			datos[i][3] = est.getApellido2();
			
			// Si coinciden los id, guardo el nombre de tipologiaSexo.
			for (TipologiaSexo o : l) {
				if (o.getId() == est.getIdTipologiaSexo()) {
					datos[i][4] = o.getDescripcion();
				}
			}
			 
			datos[i][5] = est.getDni();
			datos[i][6] = est.getDireccion();
			datos[i][7] = est.getEmail();
			datos[i][8] = est.getTelefono();
		}
		
		return datos;
	}
	
	
}
