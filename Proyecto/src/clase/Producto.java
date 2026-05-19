package clase;

/**
 * Clase que representa un Producto dentro del inventario del sistema.
 * Almacena la información comercial básica como el nombre, el precio 
 * y las existencias disponibles en almacén.
 * 
 * @author AlejandroIzan
 * @version 1.0
 */
public class Producto {
	
	/** El identificador único del producto. */
	private int id;
	
	/** El nombre comercial del producto. */
	private String nombre;
	
	/** El precio unitario de venta del producto. */
	private double precio;
	
	/** La cantidad de unidades disponibles en el inventario. */
	private int stock;
	
	/**
	 * Constructor por defecto.
	 * Crea una nueva instancia de Producto vacía.
	 */
	public Producto() {
		super();
	}

	/**
	 * Constructor intermedio que inicializa el producto sin un ID explícito.
	 * Delega la creación al constructor completo asignando de forma predeterminada un 0 al id.
	 * 
	 * @param nombre El nombre del producto.
	 * @param precio El precio de venta.
	 * @param stock  La cantidad inicial en almacén.
	 */
	public Producto(String nombre, double precio, int stock) {
		this(0, nombre, precio, stock);
	}

	/**
	 * Constructor completo para inicializar todos los atributos del producto.
	 * 
	 * @param id     El identificador único del producto.
	 * @param nombre El nombre del producto.
	 * @param precio El precio de venta.
	 * @param stock  La cantidad inicial en almacén.
	 */
	public Producto(int id, String nombre, double precio, int stock) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.stock = stock;
	}

	/**
	 * Obtiene el identificador del producto.
	 * 
	 * @return El id del producto.
	 */
	public int getId() {
		return id;
	}

	/**
	 * Modifica el identificador del producto.
	 * 
	 * @param id El nuevo id a asignar.
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Obtiene el nombre del producto.
	 * 
	 * @return El nombre comercial del producto.
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Modifica el nombre del producto.
	 * 
	 * @param nombre El nuevo nombre comercial a asignar.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Obtiene el precio del producto.
	 * 
	 * @return El precio unitario.
	 */
	public double getPrecio() {
		return precio;
	}

	/**
	 * Modifica el precio del producto.
	 * 
	 * @param precio El nuevo precio unitario a establecer.
	 */
	public void setPrecio(double precio) {
		this.precio = precio;
	}

	/**
	 * Obtiene la cantidad de existencias disponibles en almacén.
	 * 
	 * @return Las unidades en stock.
	 */
	public int getStock() {
		return stock;
	}

	/**
	 * Modifica la cantidad de existencias disponibles en almacén.
	 * 
	 * @param stock La nueva cantidad de unidades disponibles.
	 */
	public void setStock(int stock) {
		this.stock = stock;
	}

	/**
	 * Devuelve una representación en formato de texto con todas las propiedades del producto.
	 * 
	 * @return Una cadena de caracteres detallando el id, nombre, precio y stock.
	 */
	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", stock=" + stock + "]";
	}
}