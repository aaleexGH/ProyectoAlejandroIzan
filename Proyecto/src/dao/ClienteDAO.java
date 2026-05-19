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

/**
 * DAO para gestionar la tabla cliente.
 * 
 * @author alejandroEizan
 */
public class ClienteDAO implements GenericDAO<Cliente> {

	/**
	 * Inserta un cliente en la base de datos.
	 * 
	 * @param objeto Cliente a insertar.
	 * @return true si se inserta, false si no.
	 */
	@Override
	public boolean insertar(Cliente objeto) {
		String sql = "INSERT INTO cliente(id, direccion) VALUES(?, ?)";
		try (Connection con = ConexionBD.getConnection();
		     PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			  ps.setInt(1, objeto.getId());
			  ps.setString(2, objeto.getDireccion());	
			  
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
	 * Obtiene todos los clientes de la base de datos.
	 * 
	 * @return Lista de clientes.
	 */
	@Override
	public List<Cliente> obtenerTodos() {
		List<Cliente> lista = new ArrayList<Cliente>();
		String sql = "SELECT id, direccion FROM cliente";
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
	 * Busca un cliente por su ID.
	 * 
	 * @param id ID del cliente.
	 * @return Cliente encontrado o null.
	 */
	@Override
	public Cliente obtenerPorId(int id) {
		String sql = "SELECT * FROM cliente cl INNER JOIN factura f on cl.id = f.id_Cliente	WHERE cl.id = ?";
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
	 * Actualiza los datos de un cliente.
	 * 
	 * @param objeto Cliente a actualizar.
	 * @return true si se actualiza, false si no.
	 */
	@Override
	public boolean actualizar(Cliente objeto) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Elimina un cliente por su ID.
	 * 
	 * @param id ID del cliente.
	 * @return true si se elimina, false si no.
	 */
	@Override
	public boolean eliminar(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Convierte una fila de ResultSet en un objeto Cliente.
	 * 
	 * @param rs Fila de la consulta.
	 * @return Cliente mapeado.
	 */
	private Cliente mapearFila(ResultSet rs) throws SQLException {
		Cliente a = new Cliente();
		a.setId(rs.getInt("id"));
		a.setDireccion(rs.getString("direccion"));
		return a;
	}

}