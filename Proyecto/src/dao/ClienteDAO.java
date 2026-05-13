package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import clase.Cliente;
import util.ConexionBD;

public class ClienteDAO implements GenericDAO<Cliente> {

	@Override
	public boolean insertar(Cliente objeto) {
	    String sql = "INSERT INTO cliente(direccion) VALUES(?)";
	    try (Connection con = ConexionBD.getConnection();
	         PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
	          ps.setString(1, objeto.getDireccion());
	          
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
	public List<Cliente> obtenerTodos() {
		List<Cliente> lista = new ArrayList<Cliente>();
		String sql = """
				SELECT id, direccion
				FROM cliente
				""";
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
	public Cliente obtenerPorId(int id) {
		String sql = """
				SELECT *
				FROM cliente cl
				INNER JOIN factura f on cl.id = f.id_Cliente
				WHERE cl.id = ?;
				""";
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
	public boolean actualizar(Cliente objeto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	private Cliente mapearFila(ResultSet rs) throws SQLException {
		Cliente a = new Cliente();
		a.setId(rs.getInt("id"));
		a.setDireccion(rs.getString("direccion"));
		return a;
	}

}
