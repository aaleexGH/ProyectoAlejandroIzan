package clase;

/**
 * Clase que representa a un Cliente en el sistema.
 * 
 * @author AlejandroIzan
 * @version 1.0
 */
public class Cliente extends Persona {

	/** El identificador único del cliente. */
	private int id;
	
	/** La dirección de residencia o envío del cliente. */
	private String direccion;
	
	/**
	 * Constructor por defecto. 
	 * Crea una nueva instancia de Cliente invocando al constructor de la clase padre.
	 */
	public Cliente() {
		super();
	}

	/**
	 * Constructor que inicializa al cliente únicamente con su dirección.
	 * 
	 * @param direccion La dirección del cliente.
	 */
	public Cliente(String direccion) {
		super();
		this.direccion = direccion;
	}
	
	/**
	 * Constructor completo que inicializa el id y la dirección del cliente.
	 * 
	 * @param id El identificador único para el cliente.
	 * @param direccion La dirección del cliente.
	 */
	public Cliente(int id, String direccion) {
		super();
		this.id = id;
		this.direccion = direccion;
	}

	/**
	 * Obtiene el identificador del cliente.
	 * 
	 * @return El id del cliente.
	 */
	public int getId() {
		return id;
	}

	/**
	 * Modifica el identificador del cliente.
	 * 
	 * @param id El nuevo id a asignar al cliente.
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Obtiene la dirección del cliente.
	 * 
	 * @return La dirección actual del cliente.
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * Modifica la dirección del cliente.
	 * 
	 * @param direccion La nueva dirección a asignar al cliente.
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	/**
	 * Devuelve una representación en formato de texto de los datos del cliente.
	 * 
	 * @return Una cadena de texto con el id y la dirección del cliente.
	 */
	@Override
	public String toString() {
		return "Cliente: " + id + " | Direccion: " + direccion;
	}


	
	
	
	}