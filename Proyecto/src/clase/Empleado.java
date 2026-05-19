package clase;

/**
 * Clase que representa a un Empleado en el sistema.
 * 
 * @author AlejandroIzan
 * @version 1.0
 */
public class Empleado extends Persona {

	/** El identificador único del empleado. */
	private int id;
	
	/** El puesto o cargo que ocupa el empleado en la empresa. */
	private String puesto;
	
	/** El salario mensual o asignado al empleado. */
	private double salario;
	
	/**
	 * Constructor por defecto.
	 * Crea una nueva instancia de Empleado invocando al constructor de la clase padre.
	 */
	public Empleado() {
		super();
	}
	
	/**
	 * Constructor que inicializa al empleado con su puesto y salario.
	 * 
	 * @param puesto El cargo del empleado.
	 * @param salario El salario del empleado.
	 */
	public Empleado(String puesto, double salario) {
		super();
		this.puesto = puesto;
		this.salario = salario;
	}

	/**
	 * Constructor completo que inicializa el id, puesto y salario del empleado.
	 * 
	 * @param id El identificador único para el empleado.
	 * @param puesto El cargo del empleado.
	 * @param salario El salario del empleado.
	 */
	public Empleado(int id, String puesto, double salario) {
		super();
		this.id = id;
		this.puesto = puesto;
		this.salario = salario;
	}

	/**
	 * Obtiene el identificador del empleado.
	 * 
	 * @return El id del empleado.
	 */
	public int getId() {
		return id;
	}

	/**
	 * Modifica el identificador del empleado.
	 * 
	 * @param id El nuevo id a asignar al empleado.
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Obtiene el puesto del empleado.
	 * 
	 * @return El cargo actual del empleado.
	 */
	public String getPuesto() {
		return puesto;
	}

	/**
	 * Modifica el puesto del empleado.
	 * 
	 * @param puesto El nuevo cargo a asignar al empleado.
	 */
	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}

	/**
	 * Obtiene el salario del empleado.
	 * 
	 * @return El salario actual del empleado.
	 */
	public double getSalario() {
		return salario;
	}

	/**
	 * Modifica el salario del empleado.
	 * 
	 * @param salario El nuevo salario a asignar al empleado.
	 */
	public void setSalario(double salario) {
		this.salario = salario;
	}

	/**
	 * Devuelve una representación en formato de texto de los datos del empleado.
	 * 
	 * @return Una cadena de texto con el id, puesto y salario del empleado.
	 */
	@Override
	public String toString() {
		return "Empleado Id: " + id + " | Puesto: " + puesto + " | Salario: " + salario;
	}
	
}
