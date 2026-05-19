package clase;

/**
 * Clase que representa a una Persona en el sistema.
 * Sirve como clase base (padre) para otras entidades que compartan 
 * características demográficas básicas como clientes o empleados.
 * 
 * @author AlejandroIzan
 * @version 1.0
 */
public class Persona {

	/** El identificador único de la persona. */
	private int id;
	
	/** El Documento Nacional de Identidad (DNI) de la persona. */
	private String dni;
	
	/** El nombre completo de la persona. */
	private String nombre;
	
	/**
	 * Constructor por defecto.
	 * Crea una nueva instancia de Persona vacía.
	 */
	public Persona() {
		super();
	}

	/**
	 * Constructor parcial para inicializar a la persona con su DNI y nombre.
	 * Útil cuando el identificador de la base de datos aún no se ha asignado.
	 * 
	 * @param dni    El Documento Nacional de Identidad de la persona.
	 * @param nombre El nombre completo de la persona.
	 */
	public Persona(String dni, String nombre) {
		super();
		this.dni = dni;
		this.nombre = nombre;
	}

	/**
	 * Constructor completo que inicializa todos los atributos de la persona.
	 * 
	 * @param id     El identificador único de la persona.
	 * @param dni    El Documento Nacional de Identidad de la persona.
	 * @param nombre El nombre completo de la persona.
	 */
	public Persona(int id, String dni, String nombre) {
		super();
		this.id = id;
		this.dni = dni;
		this.nombre = nombre;
	}

	/**
	 * Obtiene el identificador de la persona.
	 * 
	 * @return El id de la persona.
	 */
	public int getId() {
		return id;
	}

	/**
	 * Modifica el identificador de la persona.
	 * 
	 * @param id El nuevo id a asignar.
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Obtiene el DNI de la persona.
	 * 
	 * @return El DNI de la persona.
	 */
	public String getDni() {
		return dni;
	}

	/**
	 * Modifica el DNI de la persona.
	 * 
	 * @param dni El nuevo DNI a asignar.
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}

	/**
	 * Obtiene el nombre de la persona.
	 * 
	 * @return El nombre de la persona.
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Modifica el nombre de la persona.
	 * 
	 * @param nombre El nuevo nombre a asignar.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Devuelve una representación en formato de texto con los datos básicos de la persona.
	 * 
	 * @return Una cadena de caracteres detallando el id, DNI y nombre de la persona.
	 */
	@Override
	public String toString() {
		return "Id Persona: " + id + " | DNI: " + dni + " | Nombre: " + nombre;
	}
	
}
