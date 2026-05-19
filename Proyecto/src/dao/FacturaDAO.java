package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import clase.Cliente;
import clase.Factura;
import clase.LineaFactura;
import util.ConexionBD;

/**
 * DAO para gestionar la tabla factura.
 * 
 * @author alejandroEizan
 */
public class FacturaDAO implements GenericDAO<Factura> {

	/**
	 * Inserta una factura en la base de datos.
	 *
	 * @param objeto Factura a insertar.
	 * @return true si se inserta, false si no.
	 */
	@Override
	public boolean insertar(Factura objeto) {
		String sql = "insert into factura ( fecha, id_cliente, id_empleado, subtotal, iva, total) values (?,?,?,?,?,?)";
	    try (Connection con = ConexionBD.getConnection();
	         PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

	          ps.setObject(1, objeto.getFecha());
	          ps.setInt(2, objeto.getId_cliente());
	          ps.setInt(3, objeto.getId_empleado());
	          ps.setDouble(4, objeto.getSubtotal());
	          ps.setDouble(5, objeto.getIva());
	          ps.setDouble(6, objeto.getTotal());
	          
	          int filas = ps.executeUpdate();
	          if (filas > 0) {
	                ResultSet rs = ps.getGeneratedKeys();
	                if (rs.next()) {
	                    objeto.setId(rs.getInt(1));
	                }
	                return true;
	            }
	      } catch (SQLException e) {
	            System.out.println("Error al insertar: " + e.getMessage());
	      }
	        return false;
	    }

	/**
	 * Obtiene todas las facturas de la base de datos.
	 *
	 * @return Lista de facturas.
	 */
	@Override
	public List<Factura> obtenerTodos() {
		List<Factura> lista = new ArrayList<Factura>();
		String sql = "select * from factura";
		try (Connection con = ConexionBD.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				lista.add(mapearFila(rs));
			}
			return lista;

		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}
		return null;

	}

	/**
	 * Busca una factura por su ID.
	 *
	 * @param id ID de la factura.
	 * @return Factura encontrada o null.
	 */
	@Override
	public Factura obtenerPorId(int id) {
		String sql = "select id, fecha, id_cliente, id_empleado, subtotal, iva, total from factura where id = ?";
		try (Connection con = ConexionBD.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
			
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				return mapearFila(rs);
			}

		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}
		return null;

	}

	/**
	 * Actualiza los datos de una factura.
	 *
	 * @param objeto Factura a actualizar.
	 * @return true si se actualiza, false si no.
	 */
	@Override
	public boolean actualizar(Factura objeto) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Elimina una factura por su ID.
	 *
	 * @param id ID de la factura.
	 * @return true si se elimina, false si no.
	 */
	@Override
	public boolean eliminar(int id) {
		// TODO Auto-generated method stub
		return false;
	}
	
	/**
	 * Convierte una fila de ResultSet en un objeto Factura.
	 *
	 * @param rs Fila de la consulta.
	 * @return Factura mapeada.
	 */
	private Factura mapearFila(ResultSet rs) throws SQLException {
		Factura a = new Factura();
		a.setId(rs.getInt("id"));
		a.setFecha((LocalDate) rs.getObject("fecha"));
		a.setId_cliente(rs.getInt("Id_cliente"));
		a.setId_empleado(rs.getInt("Id_empleado"));
		a.setIva(rs.getDouble("Iva"));
		a.setSubtotal(rs.getDouble("Subtotal"));
		a.setTotal(rs.getDouble("Total"));
		return a;
	}
	
	/**
	 * Filtra y obtiene las facturas de un mes específico.
	 *
	 * @param mes Número del mes (1 a 12).
	 * @return Lista de facturas de ese mes.
	 */
	public List<Factura> mostrarFacturasPorMes(int mes) {
		List<Factura> lista = new ArrayList<Factura>();
		// Nota: Recuerda poner el "?" al final de esta query si te da error al probarlo
		String sql = "SELECT id, fecha, id_cliente, id_empleado, subtotal, iva, total FROM factura WHERE MONTH(fecha) = ?";
		try (Connection con = ConexionBD.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
		
			ps.setInt(1, mes);
			
			ResultSet rs = ps.executeQuery();
		
			while (rs.next()) {
				lista.add(mapearFila(rs));
			}
			return lista;

		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}
		return null;
	}
		
	/**
	 * Filtra y obtiene las facturas de una fecha concreta.
	 *
	 * @param fecha Fecha a buscar.
	 * @return Lista de facturas de esa fecha.
	 */
	public List<Factura> mostrarFacturasPorFecha(LocalDate fecha) {
		List<Factura> lista = new ArrayList<Factura>();
		String sql = "SELECT id, fecha, id_cliente, id_empleado, subtotal, iva, total FROM factura WHERE fecha = ?";
		try (Connection con = ConexionBD.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
		
			ps.setObject(1, fecha);
			
			ResultSet rs = ps.executeQuery();
		
			while (rs.next()) {
				lista.add(mapearFila(rs));
			}
			return lista;

		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}
		return null;

	}
		
	/**
	 * Busca una factura asociada a un producto.
	 *
	 * @param id ID del producto.
	 * @return Factura encontrada o null.
	 */
	public Factura obtenerPorProducto(int id) {
		String sql = "select id, fecha, id_cliente, id_empleado, subtotal, iva, total from factura where id_producto = ?";
		try (Connection con = ConexionBD.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
			
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				return mapearFila(rs);
			}

		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}
		return null;

	}
}