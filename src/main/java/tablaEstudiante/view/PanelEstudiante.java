package tablaEstudiante.view;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import tablaEstudiante.entities.Estudiante;
import tablaEstudiante.entities.TipologiaSexo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.List;

public class PanelEstudiante extends JPanel {

	private static final long serialVersionUID = 1L;
	private PanelDatosPersonales panelDatos = new PanelDatosPersonales();
	JComboBox<TipologiaSexo> jCBSexo = this.panelDatos.getJcbSexo();
	
	/**
	 * Create the panel.
	 */
	public PanelEstudiante() {
		setLayout(new BorderLayout(0, 0));
		this.add(panelDatos, BorderLayout.CENTER);
		
		panelDatos.setTitulo("Gestión de Estudiante");
		
		// Cargamos todos los elementos del jComboBox.
		loadAllTipologiaSexo();
		
		cargarPrimero();
		
		// Llama a la ejecución de mostrar Primer Registro.
		this.panelDatos.setRunnableMostrarPrimerRegistro(
				new Runnable() {
					@Override
					public void run() {
						cargarPrimero();
					}
				});
		
		// Llama a la ejecución de mostrar Ultimo Registro.		
		this.panelDatos.setRunnableMostrarUltimoRegistro(
				new Runnable() {
					@Override
					public void run() {
						cargarUltimo();
					}
				});

		// Llama a la ejecución de mostrar Siguiente Registro.		
		this.panelDatos.setRunnableMostrarSiguienteRegistro(
				new Runnable() {
					@Override
					public void run() {
						cargarSiguiente();
					}
				});
		
		// Llama a la ejecución de mostrar Anterior Registro.		
		this.panelDatos.setRunnableMostrarAnteriorRegistro(
				new Runnable() {
					@Override
					public void run() {
						cargarAnterior();
					}
				});
		
		// Llama a la ejecución de Nuevo.		
		this.panelDatos.setRunnableNuevoRegistro(
				new Runnable() {
					@Override
					public void run() {
						nuevo();
					}
				});
		
		// Llama a la ejecución de Guardar.		
		this.panelDatos.setRunnableGuardarRegistro(
				new Runnable() {
					@Override
					public void run() {
						guardar();
					}
				});
		
		// Llama a la ejecución de Eliminar.		
		this.panelDatos.setRunnableEliminarRegistro(
				new Runnable() {
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
		
	}
	
	/**
	 * 
	 */
	private void eliminar() {
		
	}
	
	/**
	 * 
	 */
	private void guardar() {
		
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
	 */
	private void cargarSiguiente() {
		
	}
	
	/**
	 * 
	 */
	private void cargarAnterior() {
		
	}
	
	/**
	 * 
	 */
	private void cargarUltimo() {
		
	}
	
	/**
	 * 
	 */
	private void cargarPrimero() {
		
	}
	
	/**
	 * 
	 * @param o
	 */
	private void muestraEnPantalla(Estudiante o) {
		
	}

}
