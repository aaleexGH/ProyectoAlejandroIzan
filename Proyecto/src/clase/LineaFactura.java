package clase;

/**
 * Clase que representa una línea de detalle dentro de una factura.
 * Vincula un producto específico con la factura correspondiente, registrando 
 * las cantidades e importes de dicha transacción.
 * 
 * @author AlejandroIzan
 * @version 1.0
 */
public class LineaFactura {
		
	/** El identificador único de la línea de factura. */
	private int id;
	
	/** El identificador de la factura a la que pertenece esta línea. */
	private int id_factura;
	
	/** El identificador del producto incluido en esta línea. */
	private int id_producto;
	
	/** La cantidad de unidades del producto solicitadas. */
	private int cantidad;
	
	/** El precio por unidad del producto en el momento de la venta. */
	private double precio_unitario;
	
	/** El importe total de la línea (generalmente calculado como cantidad por precio unitario). */
	private double importe;
	
	/**
	 * Constructor por defecto.
	 * Crea una nueva instancia de LineaFactura vacía.
	 */
	public LineaFactura() {
		super();
	}

	/**
	 * Constructor parcial para inicializar la línea de factura sin especificar un ID.
	 * Útil para registros que aún no han sido persistidos en la base de datos.
	 * 
	 * @param id_factura     El ID de la factura asociada.
	 * @param id_producto    El ID del producto vendido.
	 * @param cantidad       La cantidad de unidades del producto.
	 * @param precio_unitario El precio individual de cada unidad.
	 * @param importe        El importe total derivado de la línea.
	 */
	public LineaFactura(int id_factura, int id_producto, int cantidad, double precio_unitario, double importe) {
		super();
		this.id_factura = id_factura;
		this.id_producto = id_producto;
		this.cantidad = cantidad;
		this.precio_unitario = precio_unitario;
		this.importe = importe;
	}

	/**
	 * Constructor completo que inicializa todos los atributos de la línea de factura.
	 * 
	 * @param id             El identificador único de la línea.
	 * @param id_factura     El ID de la factura asociada.
	 * @param id_producto    El ID del producto vendido.
	 * @param cantidad       La cantidad de unidades del producto.
	 * @param precio_unitario El precio individual de cada unidad.
	 * @param importe        El importe total derivado de la línea.
	 */
	public LineaFactura(int id, int id_factura, int id_producto, int cantidad, double precio_unitario, double importe) {
		super();
		this.id = id;
		this.id_factura = id_factura;
		this.id_producto = id_producto;
		this.cantidad = cantidad;
		this.precio_unitario = precio_unitario;
		this.importe = importe;
	}

	/**
	 * Obtiene el identificador de la línea de factura.
	 * 
	 * @return El id de la línea.
	 */
	public int getId() {
		return id;
	}

	/**
	 * Modifica el identificador de la línea de factura.
	 * 
	 * @param id El nuevo id a asignar.
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Obtiene el identificador de la factura asociada.
	 * 
	 * @return El id de la factura.
	 */
	public int getId_factura() {
		return id_factura;
	}

	/**
	 * Modifica el identificador de la factura asociada.
	 * 
	 * @param id_factura El nuevo id de la factura.
	 */
	public void setId_factura(int id_factura) {
		this.id_factura = id_factura;
	}

	/**
	 * Obtiene el identificador del producto.
	 * 
	 * @return El id del producto.
	 */
	public int getId_producto() {
		return id_producto;
	}

	/**
	 * Modifica el identificador del producto.
	 * 
	 * @param id_producto El nuevo id del producto.
	 */
	public void setId_producto(int id_producto) {
		this.id_producto = id_producto;
	}

	/**
	 * Obtiene la cantidad de productos de esta línea.
	 * 
	 * @return La cantidad registrada.
	 */
	public int getCantidad() {
		return cantidad;
	}

	/**
	 * Modifica la cantidad de productos de esta línea.
	 * 
	 * @param cantidad La nueva cantidad de unidades.
	 */
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	/**
	 * Obtiene el precio unitario del producto.
	 * 
	 * @return El precio de una sola unidad.
	 */
	public double getPrecio_unitario() {
		return precio_unitario;
	}

	/**
	 * Modifica el precio unitario del producto.
	 * 
	 * @param precio_unitario El nuevo precio unitario a establecer.
	 */
	public void setPrecio_unitario(double precio_unitario) {
		this.precio_unitario = precio_unitario;
	}

	/**
	 * Obtiene el importe total acumulado en esta línea.
	 * 
	 * @return El importe total.
	 */
	public double getImporte() {
		return importe;
	}

	/**
	 * Modifica el importe total de esta línea.
	 * 
	 * @param importe El nuevo importe a asignar.
	 */
	public void setImporte(double importe) {
		this.importe = importe;
	}

	/**
	 * Devuelve una representación en formato de texto con todas las propiedades de la línea de factura.
	 * 
	 * @return Una cadena de texto con el estado del objeto.
	 */
	@Override
	public String toString() {
		return "LineaFactura [id=" + id + ", id_factura=" + id_factura + ", id_producto=" + id_producto + ", cantidad="
				+ cantidad + ", precio_unitario=" + precio_unitario + ", importe=" + importe + "]";
	}
	
}