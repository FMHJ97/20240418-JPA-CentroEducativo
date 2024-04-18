package tablaEstudiante.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tipologiaSexo")
public class TipologiaSexo extends Entidad {

	@Id
	@Column(name = "id")
	private int id;
	
	@Column(name = "descripcion")
	private String descripcion;
	
	/**
	 * Constructor.
	 */
	public TipologiaSexo() {
		super();
	}

	/**
	 * 
	 * @param id
	 * @param descripcion
	 */
	public TipologiaSexo(int id, String descripcion) {
		this.id = id;
		this.descripcion = descripcion;
	}
	
	@Override
	public String toString() {
		return descripcion;
	}
	
	
	/// GETTERS & SETTERS ///

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}
