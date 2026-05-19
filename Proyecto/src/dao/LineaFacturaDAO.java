package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import clase.Factura;
import clase.LineaFactura;
import clase.Producto;
import util.ConexionBD;

/**
 * DAO para gestionar la tabla lineafactura.
 * 
 * @author alejandroEizan
 */
public class LineaFacturaDAO implements GenericDAO<LineaFactura> {

	/**
	 * Inserta una línea de factura en la base de datos.
	 *
	 * @param objeto Línea de factura a insertar.
	 * @return true si se inserta, false si no.
	 */
	@Override
	public boolean insertar(LineaFactura objeto) {
		String sql = "insert into lineafactura (id_factura, id_producto, cantidad, precio_unitario, importe) values (?,?,?,?,?)";
		try (Connection con = ConexionBD.getConnection();
				PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

			ps.setInt(1, objeto.getId_factura());
			ps.setInt(2, objeto.getId_producto());
			ps.setInt(3, objeto.getCantidad());
			ps.setDouble(4, objeto.getPrecio_unitario());
			ps.setDouble(5, objeto.getImporte());

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
	 * Obtiene todas las líneas de factura de la base de datos.
	 *
	 * @return Lista de líneas de factura.
	 */
	@Override
	public List<LineaFactura> obtenerTodos() {
		List<LineaFactura> lista = new ArrayList<LineaFactura>();
		String sql = "select * from lineafactura";
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
	 * Busca una línea de factura por su ID.
	 *
	 * @param id ID de la línea de factura.
	 * @return Línea de factura encontrada o null.
	 */
	@Override
	public LineaFactura obtenerPorId(int id) {
		String sql = "select * from lineafactura where id = ?";
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
	 * Actualiza los datos de una línea de factura.
	 *
	 * @param objeto Línea de factura a actualizar.
	 * @return true si se actualiza, false si no.
	 */
	@Override
	public boolean actualizar(LineaFactura objeto) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Elimina una línea de factura por su ID.
	 *
	 * @param id ID de la línea a borrar.
	 * @return true si se elimina, false si no.
	 */
	@Override
	public boolean eliminar(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Convierte una fila de ResultSet en un objeto LineaFactura.
	 *
	 * @param rs Fila de la consulta.
	 * @return Línea de factura mapeada.
	 */
	private LineaFactura mapearFila(ResultSet rs) throws SQLException {
		LineaFactura a = new LineaFactura();
		a.setId(rs.getInt("id"));
		a.setId_factura(rs.getInt("id_factura"));
		a.setId_producto(rs.getInt("id_producto"));
		return a;

	}

	/**
	 * Obtiene todas las líneas asociadas a una factura concreta.
	 *
	 * @param id ID de la factura.
	 * @return Lista de líneas asociadas a la factura.
	 */
	public List<LineaFactura> obtenerporIdFactura(int id) {
		List<LineaFactura> lista = new ArrayList<LineaFactura>();
		String sql = "select id, id_factura, id_producto, cantidad, precio_unitario, importe from lineafactura where id = ?";
		try (Connection con = ConexionBD.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setInt(1, id);

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
	 * Cuenta cuántas veces se ha vendido un producto específico.
	 *
	 * @param id ID del producto.
	 * @return Cantidad total de veces que aparece el producto en las líneas.
	 */
	public int obtenerPorIdProducto(int id) {

		String sql = "select count(*) as total from lineafactura where id_producto = ?";

		try (Connection con = ConexionBD.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				return (rs.getInt("total"));

			}

		} catch (SQLException e) {

			System.out.println("Error: " + e.getMessage());

		}

		return 0;

	}

}