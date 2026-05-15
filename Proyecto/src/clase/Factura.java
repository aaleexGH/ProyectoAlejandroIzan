package clase;

import java.sql.Date;
import java.time.LocalDate;

public class Factura {
	
	private int id;
	private LocalDate fecha;
	private int id_cliente;
	private int id_empleado;
	private double subtotal;
	private double iva;
	private double total;
	
	
	public Factura() {
		super();
	}


	public Factura(LocalDate fecha, int id_cliente, int id_empleado, double subtotal, double iva, double total) {
		this(0, fecha, id_cliente, id_empleado, subtotal, iva, total);
	}


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


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public LocalDate getFecha() {
		return fecha;
	}


	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}


	public int getId_cliente() {
		return id_cliente;
	}


	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}


	public int getId_empleado() {
		return id_empleado;
	}


	public void setId_empleado(int id_empleado) {
		this.id_empleado = id_empleado;
	}


	public double getSubtotal() {
		return subtotal;
	}


	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}


	public double getIva() {
		return iva;
	}


	public void setIva(double iva) {
		this.iva = iva;
	}


	public double getTotal() {
		return total;
	}


	public void setTotal(double total) {
		this.total = total;
	}


	@Override
	public String toString() {
		return "Factura [id=" + id + ", fecha=" + fecha + ", id_cliente=" + id_cliente + ", id_empleado=" + id_empleado
				+ ", subtotal=" + subtotal + ", iva=" + iva + ", total=" + total + "]";
	}
	
	
	
	
	
}



