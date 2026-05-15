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
import clase.Producto;
import util.ConexionBD;

public class ProductoDAO implements GenericDAO<Producto>{

	@Override
	public boolean insertar(Producto objeto) {
		String sql = "insert into factura (nombre, precio, stock) values (?,?,?)";
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

	@Override
	public Producto obtenerPorId(int id) {
		String sql = "select id, nombre, preio, stock from factura where id = ?";
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
	public boolean actualizar(Producto objeto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(int id) {
		// TODO Auto-generated method stub
		return false;
	}
	
	private Producto mapearFila(ResultSet rs) throws SQLException {
		Producto a = new Producto();
		a.setId(rs.getInt("id"));
		a.setNombre(rs.getString("nombre"));
		a.setPrecio(rs.getDouble("precio"));
		a.setStock(rs.getInt("stock"));
		return a;
	}
	

}
