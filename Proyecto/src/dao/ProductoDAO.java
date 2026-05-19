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
import clase.Producto;
import util.ConexionBD;

/**
 * DAO para gestionar la tabla producto.
 * 
 * @author alejandroEizan
 */
public class ProductoDAO implements GenericDAO<Producto> {

	/**
	 * Inserta un producto en la base de datos.
	 *
	 * @param objeto Producto a insertar.
	 * @return true si se inserta, false si no.
	 */
	@Override
	public boolean insertar(Producto objeto) {
		String sql = "insert into producto (nombre, precio, stock) values (?,?,?)";
		try (Connection con = ConexionBD.getConnection();
				PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

			ps.setString(1, objeto.getNombre());
			ps.setDouble(2, objeto.getPrecio());
			ps.setInt(3, objeto.getStock());

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
	 * Obtiene todos los productos de la base de datos.
	 *
	 * @return Lista de productos.
	 */
	@Override
	public List<Producto> obtenerTodos() {
		List<Producto> lista = new ArrayList<Producto>();
		String sql = "select * from producto";
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
	 * Busca un producto por su ID.
	 *
	 * @param id ID del producto.
	 * @return Producto encontrado o null.
	 */
	@Override
	public Producto obtenerPorId(int id) {
		String sql = "select id, nombre, preio, stock from Producto where id = ?";
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
	 * Actualiza el precio de un producto.
	 *
	 * @param objeto Producto con el precio actualizado.
	 * @return true si se modifica, false si no.
	 */
	@Override
	public boolean actualizar(Producto objeto) {

		String sql = "UPDATE producto SET precio = ? WHERE id = ?";
		try (Connection con = ConexionBD.getConnection();
				PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			ps.setDouble(1, objeto.getPrecio());
			ps.setInt(2, objeto.getId());
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
	 * Elimina un producto por su ID.
	 *
	 * @param id ID del producto a borrar.
	 * @return true si se elimina, false si no.
	 */
	@Override
	public boolean eliminar(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Convierte una fila de ResultSet en un objeto Producto.
	 *
	 * @param rs Fila de la consulta.
	 * @return Producto mapeado.
	 */
	private Producto mapearFila(ResultSet rs) throws SQLException {
		Producto a = new Producto();
		a.setId(rs.getInt("id"));
		a.setNombre(rs.getString("nombre"));
		a.setPrecio(rs.getDouble("precio"));
		a.setStock(rs.getInt("stock"));
		return a;
	}

	/**
	 * Cuenta cuántas veces se repite un nombre de producto.
	 *
	 * @param nombre Nombre del producto.
	 * @return Cantidad de coincidencias encontradas.
	 */
	public int obtenerPorNombre(String nombre) {
		String sql = "select count(nombre) as contar from factura where nombre = ?";
		try (Connection con = ConexionBD.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setString(1, nombre);

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return (rs.getInt("contar"));
			}

		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}
		return 0;
	}

	/**
	 * Elimina un producto de la base de datos por su ID.
	 *
	 * @param id ID del producto.
	 * @return true si se borra con éxito, false si falla.
	 */
	public boolean eliminarProductoSiEstaEnLineaFactura(int id) {

		String sql = "DELETE FROM producto where id = ?";

		try (Connection con = ConexionBD.getConnection();

				PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

			ps.setInt(1, id);

			int filas = ps.executeUpdate();

			if (filas > 0) {

				ResultSet rs = ps.getGeneratedKeys();

				if (rs.next()) {

					return true;

				}

			}

		} catch (SQLException e) {

			System.out.println("Error al insertar: " + e.getMessage());

		}

		return false;

	}

}