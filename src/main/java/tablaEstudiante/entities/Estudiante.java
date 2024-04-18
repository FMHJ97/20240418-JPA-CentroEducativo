package tablaEstudiante.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "estudiante")
public class Estudiante extends Entidad {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "apellido1")
	private String apellido1;
	
	@Column(name = "apellido2")
	private String apellido2;
	
	@Column(name = "idTipologiaSexo")
	private int idTipologiaSexo;
	
	@Column(name = "dni")
	private String dni;
	
	@Column(name = "direccion")
	private String direccion;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "telefono")
	private String telefono;
	
	@Column(name = "imagen")
	private byte[] imagen;
	
	@Column(name = "colorPreferido")
	private String colorPreferido;
	
	/**
	 * Constructor.
	 */
	public Estudiante() {
		super();
	}
	
	/// GETTERS & SETTERS ///

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public int getIdTipologiaSexo() {
		return idTipologiaSexo;
	}

	public void setIdTipologiaSexo(int idTipologiaSexo) {
		this.idTipologiaSexo = idTipologiaSexo;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public byte[] getImagen() {
		return imagen;
	}

	public void setImagen(byte[] imagen) {
		this.imagen = imagen;
	}

	public String getColorPreferido() {
		return colorPreferido;
	}

	public void setColorPreferido(String colorPreferido) {
		this.colorPreferido = colorPreferido;
	}	
	
}
