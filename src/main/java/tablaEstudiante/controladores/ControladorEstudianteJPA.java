package tablaEstudiante.controladores;

import javax.persistence.EntityManager;

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
	
	/**
	 * 
	 * @param e
	 */
	public void insertEstudiante(Estudiante e) {
		EntityManager em = getEntityManager();
		
		em.getTransaction().begin();
		em.persist(e);
		em.getTransaction().commit();
	}
	
	/**
	 * 
	 * @param e
	 */
	public void updateEstudiante(Estudiante e) {
		EntityManager em = getEntityManager();
		
		em.getTransaction().begin();
		em.merge(e);
		em.getTransaction().commit();
	}
	
	/**
	 * 
	 * @param id
	 */
	public void deleteEstudiante(int id) {
		EntityManager em = getEntityManager();
		
		Estudiante e = (Estudiante) findById(id);
		
		em.getTransaction().begin();
		// Volvemos a enlazar nuestra entidad con nuestro manager.
		e = em.merge(e);
		em.remove(e);
		em.getTransaction().commit();
	}
	
}
