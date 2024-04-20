package tablaEstudiante.view;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import tablaEstudiante.controladores.ControladorEstudianteJPA;
import tablaEstudiante.controladores.ControladorTipologiaSexoJPA;
import tablaEstudiante.entities.Estudiante;
import tablaEstudiante.entities.TipologiaSexo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.List;

public class PanelEstudiante extends JPanel {

	private static final long serialVersionUID = 1L;
	private PanelDatosPersonales panelDatos = new PanelDatosPersonales();
	JComboBox<TipologiaSexo> jCBSexo = this.panelDatos.getJcbSexo();
	
	// Referencia del PanelTabla.
	// Se usará para actualizar los datos de la tabla.
	private PanelTabla panelTabla;
	
	/**
	 * Método setter que establece una referencia al JPanel PanelTabla 
	 * actual.
	 * @return 
	 */
	public PanelTabla setPanelTabla(PanelTabla panelTabla) {
		return this.panelTabla = panelTabla;
	}
	
	/**
	 * Create the panel.
	 */
	public PanelEstudiante() {
		setLayout(new BorderLayout(0, 0));
		this.add(panelDatos, BorderLayout.CENTER);
		
		panelDatos.setTitulo("Gestión de Estudiante");
		
		// Cargamos todos los elementos del jComboBox.
		loadAllTipologiaSexo();
	
		this.panelDatos.setRunnableNew(new Runnable() {
			@Override
			public void run() {
				nuevo();
			}
		});
		
		this.panelDatos.setRunnableSave(new Runnable() {
			@Override
			public void run() {
				guardar();
			}
		});
		
		this.panelDatos.setRunnableDelete(new Runnable() {
			@Override
			public void run() {
				eliminar();
			}
		});
		
	}
	
	/**
	 * 
	 */
	private void loadAllTipologiaSexo() {
		List<TipologiaSexo> lista = (List<TipologiaSexo>) ControladorTipologiaSexoJPA
				.getInstance().findAll();
		for (TipologiaSexo ts : lista) {
			this.jCBSexo.addItem(ts);
		}
	}
	
	/**
	 * 
	 */
	private void eliminar() {
		String respuestas[] = new String[] { "Sí", "No" };
		int opcionElegida = JOptionPane.showOptionDialog(null,
				"¿Realmente desea eliminar el registro?",
				"Eliminación de Estudiante", JOptionPane.DEFAULT_OPTION,
				JOptionPane.WARNING_MESSAGE, null,
				respuestas, respuestas[1]);

		if (opcionElegida == 0) {	// Si la opción es 0 (= Si).
			
			String str = this.panelDatos.getJtfId();
			if (!str.trim().equals("")) {
				int idActual = Integer.parseInt(str);
				ControladorEstudianteJPA.getInstance()
					.deleteEstudiante(idActual);
				
				// A continuación, mostraremos en pantalla el registro
				// siguiente.
				Estudiante actual = (Estudiante) ControladorEstudianteJPA
						.getInstance().findNext(idActual);
				
				// Si hay registro, es decir, el registro borrado es
				// ocupado por su siguiente registro (id).
				if (actual != null) {
					muestraEnPantalla(actual);
				} else {
					// Si hay no registro, miramos si hay registro anterior
					// al registro borrado.
					actual = (Estudiante) ControladorEstudianteJPA
							.getInstance().findPrevious(idActual);
					if (actual != null) {
						muestraEnPantalla(actual);
					} else {
						// Llegados a este punto, no hay registros previos
						// ni posteriores.
						nuevo();
					}
					
				}
			}
		}
		
		// Actualizamos los datos de la Tabla Estudiante.
		panelTabla.updateTable();
	}
	
	/**
	 * 
	 */
	private void guardar() {

		Estudiante o = new Estudiante();
		o.setNombre(this.panelDatos.getJtfNombre());
		o.setApellido1(this.panelDatos.getJtfApellido1());
		o.setApellido2(this.panelDatos.getJtfApellido2());
		o.setDni(this.panelDatos.getJtfDni());
		o.setDireccion(this.panelDatos.getJtfDireccion());
		o.setEmail(this.panelDatos.getJtfEmail());
		o.setTelefono(this.panelDatos.getJtfTelefono());

		o.setImagen(this.panelDatos.imagenEnArrayDeBytes);
		
		// Guardamos el color.
		if (!this.panelDatos.getJtfColor().trim().equals("")) {
			o.setColorPreferido(this.panelDatos.getJtfColor());
		} else {
			o.setColorPreferido(null);
		}
		
		// Como el item seleccionado del comboBox es tipo Object, realizamos
		// un casteo TipologiaSexo para obtener un objeto TipologiaSexo.
		// A continuación, obtenemos el id TipologiaSexo respectivo.
		int tipologiaSexoId = ((TipologiaSexo) jCBSexo.getSelectedItem()).getId();
		o.setIdTipologiaSexo(tipologiaSexoId);
		
		String str = this.panelDatos.getJtfId();
		if (!str.trim().equals("")) {
			
			o.setId(Integer.parseInt(str));
			ControladorEstudianteJPA.getInstance()
				.updateEstudiante(o);
		} else {
			ControladorEstudianteJPA.getInstance()
				.insertEstudiante(o);
			muestraEnPantalla(o);
		}
		
		// Actualizamos los datos de la Tabla Estudiante.
		panelTabla.updateTable();
	}
	
	/**
	 * 
	 */
	private void nuevo() {
		this.panelDatos.setJtfId("");
		this.panelDatos.setJtfNombre("");
		this.panelDatos.setJtfApellido1("");
		this.panelDatos.setJtfApellido2("");
		this.panelDatos.setJtfDni("");
		this.panelDatos.setJtfDireccion("");
		this.panelDatos.setJtfEmail("");
		this.panelDatos.setJtfTelefono("");
		this.panelDatos.setImagen(null);
		this.panelDatos.setJtfColor("");
		this.panelDatos.setColor(null);
	}
	
	/**
	 * 
	 * @param o
	 */
	public void muestraEnPantalla(Estudiante o) {
		if (o != null) {
			this.panelDatos.setJtfId(String.valueOf(o.getId()));
			this.panelDatos.setJtfNombre(o.getNombre());
			this.panelDatos.setJtfApellido1(o.getApellido1());
			this.panelDatos.setJtfApellido2(o.getApellido2());
			this.panelDatos.setJtfDni(o.getDni());
			this.panelDatos.setJtfDireccion(o.getDireccion());
			this.panelDatos.setJtfEmail(o.getEmail());
			this.panelDatos.setJtfTelefono(o.getTelefono());
			this.panelDatos.setJtfColor(o.getColorPreferido());
			
			// Si el id del elemento jcombobox en la posición i es igual a
			// el id del objeto TipologiaSexo, seleccionamos dicho item.
			for (int i = 0; i < jCBSexo.getItemCount(); i++) {
				if (jCBSexo.getItemAt(i).getId() == o.getIdTipologiaSexo()) {
					jCBSexo.setSelectedIndex(i);
				}
			}
			
			// Mostramos la posible imagen del registro actual.
			this.panelDatos.setImagen(o.getImagen());
			
			// Mostramos el posible color preferido del registro actual.
			try {
				if (o.getColorPreferido() != null) {
					Color color = Color.decode(o.getColorPreferido());
					this.panelDatos.setColor(color);
				} else {
					this.panelDatos.setColor(null);
					this.panelDatos.setJtfColor("");
				}
			} catch (NumberFormatException e) {
				this.panelDatos.setColor(null);
				this.panelDatos.setJtfColor("");
			}
		}
	}

}
