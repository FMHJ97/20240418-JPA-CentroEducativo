package tablaEstudiante.view;

import javax.swing.JPanel;
import javax.swing.JPopupMenu;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JToolBar;
import javax.swing.filechooser.FileFilter;

import tablaEstudiante.entities.TipologiaSexo;

import javax.swing.JButton;
import javax.swing.JColorChooser;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.nio.file.Files;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class PanelDatosPersonales extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField jtfId;
	private JTextField jtfNombre;
	private JLabel jlbTitulo;
	private JTextField jtfApellido1;
	private JTextField jtfApellido2;
	private JTextField jtfDni;
	private JTextField jtfDireccion;
	private JTextField jtfEmail;
	private JTextField jtfTelefono;
	private JComboBox<TipologiaSexo> jcbSexo;
	private JScrollPane jspImagen;
	JButton btnCambiarImagen;
	byte[] imagenEnArrayDeBytes;
	private JTextField jtfColor;
	JColorChooser jColorChooser;
	JPanel panel;
	Color colorPanel;
	
	private Runnable runnableMostrarPrimerRegistro;
	private Runnable runnableMostrarSiguienteRegistro;
	private Runnable runnableMostrarAnteriorRegistro;
	private Runnable runnableMostrarUltimoRegistro;
	private Runnable runnableNuevoRegistro;
	private Runnable runnableGuardarRegistro;
	private Runnable runnableEliminarRegistro;

	/**
	 * Create the panel.
	 */
	public PanelDatosPersonales() {
		setLayout(new BorderLayout(0, 0));
		
		JToolBar toolBar = new JToolBar();
		add(toolBar, BorderLayout.NORTH);
		
		JButton btnPrimero = new JButton("");
		btnPrimero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				runnableMostrarPrimerRegistro.run();
			}
		});
		btnPrimero.setIcon(new ImageIcon(PanelDatosPersonales.class.getResource("/tablaEstudiante/res/gotostart.png")));
		toolBar.add(btnPrimero);
		
		JButton btnAnterior = new JButton("");
		btnAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				runnableMostrarAnteriorRegistro.run();
			}
		});
		btnAnterior.setIcon(new ImageIcon(PanelDatosPersonales.class.getResource("/tablaEstudiante/res/previous.png")));
		toolBar.add(btnAnterior);
		
		JButton btnSiguiente = new JButton("");
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				runnableMostrarSiguienteRegistro.run();
			}
		});
		btnSiguiente.setIcon(new ImageIcon(PanelDatosPersonales.class.getResource("/tablaEstudiante/res/next.png")));
		toolBar.add(btnSiguiente);
		
		JButton btnUltimo = new JButton("");
		btnUltimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				runnableMostrarUltimoRegistro.run();
			}
		});
		btnUltimo.setIcon(new ImageIcon(PanelDatosPersonales.class.getResource("/tablaEstudiante/res/gotoend.png")));
		toolBar.add(btnUltimo);
		
		JButton btnNuevo = new JButton("");
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				runnableNuevoRegistro.run();
			}
		});
		btnNuevo.setIcon(new ImageIcon(PanelDatosPersonales.class.getResource("/tablaEstudiante/res/nuevo.png")));
		toolBar.add(btnNuevo);
		
		JButton btnGuardar = new JButton("");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				runnableGuardarRegistro.run();
			}
		});
		btnGuardar.setIcon(new ImageIcon(PanelDatosPersonales.class.getResource("/tablaEstudiante/res/guardar.png")));
		toolBar.add(btnGuardar);
		
		JButton btnEliminar = new JButton("");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				runnableEliminarRegistro.run();
			}
		});
		btnEliminar.setIcon(new ImageIcon(PanelDatosPersonales.class.getResource("/tablaEstudiante/res/eliminar.png")));
		toolBar.add(btnEliminar);
		
		panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 361, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		jlbTitulo = new JLabel("Titulo del Componente");
		jlbTitulo.setFont(new Font("Dialog", Font.BOLD, 18));
		GridBagConstraints gbc_jlbTitulo = new GridBagConstraints();
		gbc_jlbTitulo.insets = new Insets(15, 0, 15, 0);
		gbc_jlbTitulo.gridwidth = 3;
		gbc_jlbTitulo.gridx = 0;
		gbc_jlbTitulo.gridy = 0;
		panel.add(jlbTitulo, gbc_jlbTitulo);
		
		JLabel lblId = new JLabel("Id:");
		lblId.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_lblId = new GridBagConstraints();
		gbc_lblId.insets = new Insets(0, 0, 5, 5);
		gbc_lblId.anchor = GridBagConstraints.EAST;
		gbc_lblId.gridx = 0;
		gbc_lblId.gridy = 1;
		panel.add(lblId, gbc_lblId);
		
		jtfId = new JTextField();
		jtfId.setEnabled(false);
		jtfId.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_jtfId = new GridBagConstraints();
		gbc_jtfId.insets = new Insets(0, 0, 5, 5);
		gbc_jtfId.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfId.gridx = 1;
		gbc_jtfId.gridy = 1;
		panel.add(jtfId, gbc_jtfId);
		jtfId.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.anchor = GridBagConstraints.EAST;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 0;
		gbc_lblNombre.gridy = 2;
		panel.add(lblNombre, gbc_lblNombre);
		
		jtfNombre = new JTextField();
		jtfNombre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_jtfNombre = new GridBagConstraints();
		gbc_jtfNombre.insets = new Insets(0, 0, 5, 5);
		gbc_jtfNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfNombre.gridx = 1;
		gbc_jtfNombre.gridy = 2;
		panel.add(jtfNombre, gbc_jtfNombre);
		jtfNombre.setColumns(10);
		
		jspImagen = new JScrollPane();
		jspImagen.addMouseListener(new MouseAdapter() {
			
            @Override
            public void mousePressed(MouseEvent e) {
                showPopup(e);
            }
 
            @Override
            public void mouseReleased(MouseEvent e) {
                showPopup(e);
            }
 
            /**
             * M�todo llamado cuando se detecta el evento de rat�n, mostrar� el men�
             * @param e
             */
            private void showPopup(MouseEvent e) {
            	// Inicializo el menú de popup
            	JPopupMenu popup = getPopUpMenu();
                if (e.isPopupTrigger()) {
                    popup.show(e.getComponent(),
                            e.getX(), e.getY());
                }
            }
			
		});
		GridBagConstraints gbc_jspImagen = new GridBagConstraints();
		gbc_jspImagen.gridheight = 3;
		gbc_jspImagen.insets = new Insets(0, 5, 5, 10);
		gbc_jspImagen.fill = GridBagConstraints.BOTH;
		gbc_jspImagen.gridx = 2;
		gbc_jspImagen.gridy = 2;
		panel.add(jspImagen, gbc_jspImagen);
		
		JLabel jlbApellido1 = new JLabel("Apellido 1:");
		jlbApellido1.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_jlbApellido1 = new GridBagConstraints();
		gbc_jlbApellido1.anchor = GridBagConstraints.ABOVE_BASELINE_TRAILING;
		gbc_jlbApellido1.insets = new Insets(0, 10, 5, 5);
		gbc_jlbApellido1.gridx = 0;
		gbc_jlbApellido1.gridy = 3;
		panel.add(jlbApellido1, gbc_jlbApellido1);
		
		jtfApellido1 = new JTextField();
		jtfApellido1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_jtfApellido1 = new GridBagConstraints();
		gbc_jtfApellido1.insets = new Insets(0, 0, 5, 5);
		gbc_jtfApellido1.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfApellido1.gridx = 1;
		gbc_jtfApellido1.gridy = 3;
		panel.add(jtfApellido1, gbc_jtfApellido1);
		jtfApellido1.setColumns(10);
		
		JLabel jlbApellido2 = new JLabel("Apellido 2:");
		jlbApellido2.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_jlbApellido2 = new GridBagConstraints();
		gbc_jlbApellido2.anchor = GridBagConstraints.ABOVE_BASELINE_TRAILING;
		gbc_jlbApellido2.insets = new Insets(0, 0, 5, 5);
		gbc_jlbApellido2.gridx = 0;
		gbc_jlbApellido2.gridy = 4;
		panel.add(jlbApellido2, gbc_jlbApellido2);
		
		jtfApellido2 = new JTextField();
		jtfApellido2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_jtfApellido2 = new GridBagConstraints();
		gbc_jtfApellido2.insets = new Insets(0, 0, 5, 5);
		gbc_jtfApellido2.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfApellido2.gridx = 1;
		gbc_jtfApellido2.gridy = 4;
		panel.add(jtfApellido2, gbc_jtfApellido2);
		jtfApellido2.setColumns(10);
		
		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setFont(new Font("Dialog", Font.BOLD, 15));
		GridBagConstraints gbc_lblSexo = new GridBagConstraints();
		gbc_lblSexo.anchor = GridBagConstraints.EAST;
		gbc_lblSexo.insets = new Insets(0, 0, 5, 5);
		gbc_lblSexo.gridx = 0;
		gbc_lblSexo.gridy = 5;
		panel.add(lblSexo, gbc_lblSexo);
		
		jcbSexo = new JComboBox<TipologiaSexo>();
		jcbSexo.setFont(new Font("Dialog", Font.BOLD, 15));
		GridBagConstraints gbc_jcbSexo = new GridBagConstraints();
		gbc_jcbSexo.insets = new Insets(0, 0, 5, 5);
		gbc_jcbSexo.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbSexo.gridx = 1;
		gbc_jcbSexo.gridy = 5;
		panel.add(jcbSexo, gbc_jcbSexo);
		
		JButton btnCambiarImagen = new JButton("Cambiar Imagen");
		btnCambiarImagen.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				seleccionaImagen();
			}
		});
		GridBagConstraints gbc_btnCambiarImagen = new GridBagConstraints();
		gbc_btnCambiarImagen.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnCambiarImagen.insets = new Insets(0, 5, 5, 10);
		gbc_btnCambiarImagen.gridx = 2;
		gbc_btnCambiarImagen.gridy = 5;
		panel.add(btnCambiarImagen, gbc_btnCambiarImagen);
		
		JLabel jlbDni = new JLabel("DNI:");
		jlbDni.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_jlbDni = new GridBagConstraints();
		gbc_jlbDni.anchor = GridBagConstraints.EAST;
		gbc_jlbDni.insets = new Insets(0, 0, 5, 5);
		gbc_jlbDni.gridx = 0;
		gbc_jlbDni.gridy = 6;
		panel.add(jlbDni, gbc_jlbDni);
		
		jtfDni = new JTextField();
		jtfDni.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_jtfDni = new GridBagConstraints();
		gbc_jtfDni.insets = new Insets(0, 0, 5, 5);
		gbc_jtfDni.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfDni.gridx = 1;
		gbc_jtfDni.gridy = 6;
		panel.add(jtfDni, gbc_jtfDni);
		jtfDni.setColumns(10);
		
		JLabel jlbDireccion = new JLabel("Dirección:");
		jlbDireccion.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_jlbDireccion = new GridBagConstraints();
		gbc_jlbDireccion.anchor = GridBagConstraints.EAST;
		gbc_jlbDireccion.insets = new Insets(0, 0, 5, 5);
		gbc_jlbDireccion.gridx = 0;
		gbc_jlbDireccion.gridy = 7;
		panel.add(jlbDireccion, gbc_jlbDireccion);
		
		jtfDireccion = new JTextField();
		jtfDireccion.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_jtfDireccion = new GridBagConstraints();
		gbc_jtfDireccion.insets = new Insets(0, 0, 5, 5);
		gbc_jtfDireccion.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfDireccion.gridx = 1;
		gbc_jtfDireccion.gridy = 7;
		panel.add(jtfDireccion, gbc_jtfDireccion);
		jtfDireccion.setColumns(10);
		
		JLabel jlbEmail = new JLabel("Email:");
		jlbEmail.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_jlbEmail = new GridBagConstraints();
		gbc_jlbEmail.anchor = GridBagConstraints.EAST;
		gbc_jlbEmail.insets = new Insets(0, 0, 5, 5);
		gbc_jlbEmail.gridx = 0;
		gbc_jlbEmail.gridy = 8;
		panel.add(jlbEmail, gbc_jlbEmail);
		
		jtfEmail = new JTextField();
		jtfEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_jtfEmail = new GridBagConstraints();
		gbc_jtfEmail.insets = new Insets(0, 0, 5, 5);
		gbc_jtfEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfEmail.gridx = 1;
		gbc_jtfEmail.gridy = 8;
		panel.add(jtfEmail, gbc_jtfEmail);
		jtfEmail.setColumns(10);
		
		JLabel jlbTelefono = new JLabel("Teléfono:");
		jlbTelefono.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_jlbTelefono = new GridBagConstraints();
		gbc_jlbTelefono.anchor = GridBagConstraints.EAST;
		gbc_jlbTelefono.insets = new Insets(0, 0, 5, 5);
		gbc_jlbTelefono.gridx = 0;
		gbc_jlbTelefono.gridy = 9;
		panel.add(jlbTelefono, gbc_jlbTelefono);
		
		jtfTelefono = new JTextField();
		jtfTelefono.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_jtfTelefono = new GridBagConstraints();
		gbc_jtfTelefono.insets = new Insets(0, 0, 5, 5);
		gbc_jtfTelefono.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfTelefono.gridx = 1;
		gbc_jtfTelefono.gridy = 9;
		panel.add(jtfTelefono, gbc_jtfTelefono);
		jtfTelefono.setColumns(10);
		
		JLabel lblColorPreferido = new JLabel("Color Preferido:");
		lblColorPreferido.setFont(new Font("Dialog", Font.BOLD, 15));
		GridBagConstraints gbc_lblColorPreferido = new GridBagConstraints();
		gbc_lblColorPreferido.anchor = GridBagConstraints.EAST;
		gbc_lblColorPreferido.insets = new Insets(0, 10, 0, 5);
		gbc_lblColorPreferido.gridx = 0;
		gbc_lblColorPreferido.gridy = 10;
		panel.add(lblColorPreferido, gbc_lblColorPreferido);
		
		jtfColor = new JTextField();
		jtfColor.setEnabled(false);
		jtfColor.setFont(new Font("Dialog", Font.PLAIN, 15));
		jtfColor.setColumns(10);
		GridBagConstraints gbc_jtfColor = new GridBagConstraints();
		gbc_jtfColor.insets = new Insets(0, 0, 0, 5);
		gbc_jtfColor.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfColor.gridx = 1;
		gbc_jtfColor.gridy = 10;
		panel.add(jtfColor, gbc_jtfColor);
		
		JButton btnCambiarColor = new JButton("Cambiar Color");
		btnCambiarColor.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				seleccionaColor();
			}
		});
		GridBagConstraints gbc_btnCambiarColor = new GridBagConstraints();
		gbc_btnCambiarColor.gridx = 2;
		gbc_btnCambiarColor.gridy = 10;
		panel.add(btnCambiarColor, gbc_btnCambiarColor);

	}
	
	/**
	 * 
	 * @param titulo
	 * @param nombreIcono
	 * @return
	 */
	private JMenuItem itemPickImage (String titulo) {
        JMenuItem item = new JMenuItem(titulo);
        item.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                seleccionaImagen();
            }
        });
        
        return item;
	}
	
	/**
	 * 
	 * @return
	 */
	private JPopupMenu getPopUpMenu() {
		JPopupMenu menu = new JPopupMenu();
		
		if (imagenEnArrayDeBytes != null) {
			ImageIcon imagen = new ImageIcon(imagenEnArrayDeBytes);
			
			menu.add("Dimensiones: " 
					+ imagen.getIconWidth()
					+ "x" + imagen.getIconHeight() + " píxeles");
			menu.addSeparator();
		}
		
		menu.add(itemPickImage("Cambiar Imagen"));
		
		return menu;
	}
	
	/**
	 * 
	 * @param color
	 */
	public void setColor(Color color) {
		this.panel.setBackground(color);
	}
	
	/**
	 * 
	 */
	private void seleccionaColor () {
		this.colorPanel = jColorChooser.showDialog(null, "Seleccione un Color", Color.gray);
		// Si el usuario pulsa sobre aceptar, el color elegido no será nulo
		if (this.colorPanel != null) {
			String strColor = "#"+Integer.toHexString(this.colorPanel.getRGB()).substring(2);
			this.jtfColor.setText(strColor);
			setColor(this.colorPanel);
		}
	}
	
	/**
	 * 
	 * @param imagen
	 */
	public void setImagen (byte[] imagen) {
		if (imagen != null && imagen.length > 0) {
			this.imagenEnArrayDeBytes = imagen;
			ImageIcon icono = new ImageIcon(imagen);
			
			if (icono.getIconHeight() > 100 || 
					icono.getIconWidth() > 100 ) {
				JOptionPane.showMessageDialog(null, 
						"La imagen debe tener unas "
						+ "dimensiones máximas de 100x100 "
						+ "píxeles. Seleccione una imagen adecuada.");
				JLabel lblIcono = new JLabel("Sin imagen");
				this.jspImagen.setViewportView(lblIcono);
				return;
			}
			
			JLabel lblIcono = new JLabel(icono);
			this.jspImagen.setViewportView(lblIcono);
		}
		else {
			JLabel lblIcono = new JLabel("Sin imagen");
			this.jspImagen.setViewportView(lblIcono);
			this.imagenEnArrayDeBytes = null;
			
		}

	}
	
	/**
	 * 
	 */
	private void seleccionaImagen () {
		JFileChooser jfileChooser = new JFileChooser();
		
		// Configurando el componente
		
		// Tipo de selección que se hace en el diálogo
		jfileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES); // Sólo selecciona ficheros

		// Filtro del tipo de ficheros que puede abrir
		jfileChooser.setFileFilter(new FileFilter() {
			
			@Override
			public String getDescription() {
				return "Archivos de imagen *.jpg *.png *.gif";
			}
			
			@Override
			public boolean accept(File f) {
				if (f.isDirectory() || (f.isFile() &&
						(f.getAbsolutePath().toLowerCase().endsWith(".jpg") || 
								f.getAbsolutePath().toLowerCase().endsWith(".jpeg")|| 
								f.getAbsolutePath().toLowerCase().endsWith(".png")|| 
								f.getAbsolutePath().toLowerCase().endsWith(".gif")))) 
					return true;
				return false;
			}
		});
		
		// Abro el diálogo para la elección del usuario
		int seleccionUsuario = jfileChooser.showOpenDialog(null);
		
		if (seleccionUsuario == JFileChooser.APPROVE_OPTION) {
			File fichero = jfileChooser.getSelectedFile();
			
			if (fichero.isFile()) {
				try {
					this.imagenEnArrayDeBytes = Files.readAllBytes(fichero.toPath());
					setImagen(this.imagenEnArrayDeBytes);
				}
				catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * 
	 * @param newTitle String.
	 */
	public void setTitulo(String newTitle) {
		this.jlbTitulo.setText(newTitle);
	}
	

	public String getJtfId() {
		return this.jtfId.getText();
	}

	public void setJtfId(String newId) {
		this.jtfId.setText(newId);;
	}

	public String getJtfNombre() {
		return this.jtfNombre.getText();
	}

	public void setJtfNombre(String newNombre) {
		this.jtfNombre.setText(newNombre);;
	}

	public String getJtfApellido1() {
		return this.jtfApellido1.getText();
	}

	public void setJtfApellido1(String newApellido1) {
		this.jtfApellido1.setText(newApellido1);;
	}

	public String getJtfApellido2() {
		return this.jtfApellido2.getText();
	}

	public void setJtfApellido2(String newApellido2) {
		this.jtfApellido2.setText(newApellido2);
	}

	public JComboBox<TipologiaSexo> getJcbSexo() {
		return jcbSexo;
	}

	public void setJcbSexo(JComboBox<TipologiaSexo> jcbSexo) {
		this.jcbSexo = jcbSexo;
	}

	public String getJtfDni() {
		return this.jtfDni.getText();
	}

	public void setJtfDni(String newDni) {
		this.jtfDni.setText(newDni);
	}

	public String getJtfDireccion() {
		return this.jtfDireccion.getText();
	}

	public void setJtfDireccion(String newDireccion) {
		this.jtfDireccion.setText(newDireccion);
	}

	public String getJtfEmail() {
		return this.jtfEmail.getText();
	}

	public void setJtfEmail(String newEmail) {
		this.jtfEmail.setText(newEmail);
	}

	public String getJtfTelefono() {
		return this.jtfTelefono.getText();
	}

	public void setJtfTelefono(String newTelefono) {
		this.jtfTelefono.setText(newTelefono);
	}

	public JScrollPane getJspImagen() {
		return jspImagen;
	}

	public void setJspImagen(JScrollPane jspImagen) {
		this.jspImagen = jspImagen;
	}
	
	public String getJtfColor() {
		return this.jtfColor.getText();
	}

	public void setJtfColor(String newJtfColor) {
		this.jtfColor.setText(newJtfColor);;
	}

	public Runnable getRunnableMostrarPrimerRegistro() {
		return runnableMostrarPrimerRegistro;
	}

	public void setRunnableMostrarPrimerRegistro(Runnable runnableMostrarPrimerRegistro) {
		this.runnableMostrarPrimerRegistro = runnableMostrarPrimerRegistro;
	}

	public Runnable getRunnableMostrarSiguienteRegistro() {
		return runnableMostrarSiguienteRegistro;
	}

	public void setRunnableMostrarSiguienteRegistro(Runnable runnableMostrarSiguienteRegistro) {
		this.runnableMostrarSiguienteRegistro = runnableMostrarSiguienteRegistro;
	}

	public Runnable getRunnableMostrarAnteriorRegistro() {
		return runnableMostrarAnteriorRegistro;
	}

	public void setRunnableMostrarAnteriorRegistro(Runnable runnableMostrarAnteriorRegistro) {
		this.runnableMostrarAnteriorRegistro = runnableMostrarAnteriorRegistro;
	}

	public Runnable getRunnableMostrarUltimoRegistro() {
		return runnableMostrarUltimoRegistro;
	}

	public void setRunnableMostrarUltimoRegistro(Runnable runnableMostrarUltimoRegistro) {
		this.runnableMostrarUltimoRegistro = runnableMostrarUltimoRegistro;
	}

	public Runnable getRunnableNuevoRegistro() {
		return runnableNuevoRegistro;
	}

	public void setRunnableNuevoRegistro(Runnable runnableNuevoRegistro) {
		this.runnableNuevoRegistro = runnableNuevoRegistro;
	}

	public Runnable getRunnableGuardarRegistro() {
		return runnableGuardarRegistro;
	}

	public void setRunnableGuardarRegistro(Runnable runnableGuardarRegistro) {
		this.runnableGuardarRegistro = runnableGuardarRegistro;
	}

	public Runnable getRunnableEliminarRegistro() {
		return runnableEliminarRegistro;
	}

	public void setRunnableEliminarRegistro(Runnable runnableEliminarRegistro) {
		this.runnableEliminarRegistro = runnableEliminarRegistro;
	}

}
