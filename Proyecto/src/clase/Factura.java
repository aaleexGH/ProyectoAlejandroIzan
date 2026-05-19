package clase;

import java.sql.Date;
import java.time.LocalDate;

/**
 * Clase que representa una Factura dentro del sistema comercial.

 * @author AlejandroIzan
 * @version 1.0
 */
public class Factura {
	
	/** El identificador único de la factura. */
	private int id;
	
	/** La fecha de emisión de la factura utilizando la API java.time. */
	private LocalDate fecha;
	
	/** El identificador del cliente asociado a la factura. */
	private int id_cliente;
	
	/** El identificador del empleado que gestionó la factura. */
	private int id_empleado;
	
	/** El importe subtotal de la factura (antes de impuestos). */
	private double subtotal;
	
	/** El importe correspondiente al IVA aplicado. */
	private double iva;
	
	/** El importe total de la factura (subtotal + IVA). */
	private double total;
	
	/**
	 * Constructor por defecto.
	 * Crea una nueva instancia de Factura vacía.
	 */
	public Factura() {
		super();
	}

	/**
	 * Constructor intermedio que inicializa la factura sin un ID explícito.
	 * Delega la creación al constructor completo asignando un 0 de forma predeterminada al id.
	 * 
	 * @param fecha La fecha de emisión.
	 * @param id_cliente El ID del cliente.
	 * @param id_empleado El ID del empleado.
	 * @param subtotal El importe subtotal.
	 * @param iva El importe del IVA.
	 * @param total El importe total.
	 */
	public Factura(LocalDate fecha, int id_cliente, int id_empleado, double subtotal, double iva, double total) {
		this(0, fecha, id_cliente, id_empleado, subtotal, iva, total);
	}

	/**
	 * Constructor completo para inicializar todos los atributos de la factura.
	 * 
	 * @param id El identificador único de la factura.
	 * @param fecha La fecha de emisión.
	 * @param id_cliente El ID del cliente.
	 * @param id_empleado El ID del empleado.
	 * @param subtotal El importe subtotal.
	 * @param iva El importe del IVA.
	 * @param total El importe total.
	 */
	public Factura(int id, LocalDate fecha, int id_cliente, int id_empleado, double subtotal, double iva,
			double total) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.id_cliente = id_cliente;
		this.id_empleado = id_empleado;
		this.subtotal = subtotal;
		this.iva = iva;
		this.total = total;
	}

	/**
	 * Obtiene el identificador de la factura.
	 * 
	 * @return El id de la factura.
	 */
	public int getId() {
		return id;
	}

	/**
	 * Modifica el identificador de la factura.
	 * 
	 * @param id El nuevo id a asignar.
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Obtiene la fecha de emisión de la factura.
	 * 
	 * @return Un objeto {@link LocalDate} con la fecha.
	 */
	public LocalDate getFecha() {
		return fecha;
	}

	/**
	 * Modifica la fecha de emisión de la factura.
	 * 
	 * @param fecha La nueva fecha a asignar.
	 */
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	/**
	 * Obtiene el identificador del cliente asociado.
	 * 
	 * @return El id del cliente.
	 */
	public int getId_cliente() {
		return id_cliente;
	}

	/**
	 * Modifica el identificador del cliente asociado.
	 * 
	 * @param id_cliente El nuevo id del cliente.
	 */
	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}

	/**
	 * Obtiene el identificador del empleado asociado.
	 * 
	 * @return El id del empleado.
	 */
	public int getId_empleado() {
		return id_empleado;
	}

	/**
	 * Modifica el identificador del empleado asociado.
	 * 
	 * @param id_empleado El nuevo id del empleado.
	 */
	public void setId_empleado(int id_empleado) {
		this.id_empleado = id_empleado;
	}

	/**
	 * Obtiene el subtotal de la factura.
	 * 
	 * @return El subtotal económico.
	 */
	public double getSubtotal() {
		return subtotal;
	}

	/**
	 * Modifica el subtotal de la factura.
	 * 
	 * @param subtotal El nuevo subtotal económico.
	 */
	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}

	/**
	 * Obtiene el valor del IVA aplicado.
	 * 
	 * @return El importe del IVA.
	 */
	public double getIva() {
		return iva;
	}

	/**
	 * Modifica el valor del IVA aplicado.
	 * 
	 * @param iva El nuevo importe de IVA.
	 */
	public void setIva(double iva) {
		this.iva = iva;
	}

	/**
	 * Obtiene el importe total acumulado.
	 * 
	 * @return El total de la factura.
	 */
	public double getTotal() {
		return total;
	}

	/**
	 * Modifica el importe total de la factura.
	 * 
	 * @param total El nuevo importe total.
	 */
	public void setTotal(double total) {
		this.total = total;
	}

	/**
	 * Devuelve una representación en formato de texto con el estado completo de la factura.
	 * 
	 * @return Una cadena de caracteres detallando todos los campos de la factura.
	 */
	@Override
	public String toString() {
		return "Factura [id=" + id + ", fecha=" + fecha + ", id_cliente=" + id_cliente + ", id_empleado=" + id_empleado
				+ ", subtotal=" + subtotal + ", iva=" + iva + ", total=" + total + "]";
	}
	
}