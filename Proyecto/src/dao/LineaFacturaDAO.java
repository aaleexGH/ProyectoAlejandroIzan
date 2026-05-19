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

public class LineaFacturaDAO implements GenericDAO<LineaFactura> {

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

	@Override
	public boolean actualizar(LineaFactura objeto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	private LineaFactura mapearFila(ResultSet rs) throws SQLException {
		LineaFactura a = new LineaFactura();
		a.setId(rs.getInt("id"));
		a.setId_factura(rs.getInt("id_factura"));
		a.setId_producto(rs.getInt("id_producto"));
		return a;

	}

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
