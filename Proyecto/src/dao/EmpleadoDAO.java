package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import clase.Cliente;
import clase.Empleado;
import util.ConexionBD;

/**
 * DAO para gestionar la tabla empleado.
 * 
 * @author alejandroEizan
 */
public class EmpleadoDAO implements GenericDAO<Empleado> {

	/**
	 * Inserta un empleado en la base de datos.
	 *
	 * @param objeto Empleado a insertar.
	 * @return true si se inserta, false si no.
	 */
	@Override
	public boolean insertar(Empleado objeto) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Obtiene todos los empleados de la base de datos.
	 *
	 * @return Lista de empleados.
	 */
	@Override
	public List<Empleado> obtenerTodos() {
		List<Empleado> lista = new ArrayList<Empleado>();
		String sql = "SELECT id, puesto, salario FROM empleado";
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
	 * Busca un empleado por su ID.
	 *
	 * @param id ID del empleado.
	 * @return Empleado encontrado o null.
	 */
	@Override
	public Empleado obtenerPorId(int id) {
		String sql = "SELECT f.* FROM empleado e INNER JOIN factura f on e.id = f.id_empleado WHERE e.id = ?;";
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
	 * Actualiza los datos de un empleado.
	 *
	 * @param objeto Empleado a actualizar.
	 * @return true si se actualiza, false si no.
	 */
	@Override
	public boolean actualizar(Empleado objeto) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Elimina un empleado por su ID.
	 *
	 * @param id ID del empleado.
	 * @return true si se elimina, false si no.
	 */
	@Override
	public boolean eliminar(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Obtiene el resumen de facturación de los empleados en un mes.
	 *
	 * @param mes Número del mes (1 a 12).
	 * @return Lista de empleados con su resumen mensual.
	 */
	public List<Empleado> resumenMensual(int mes) {
		List<Empleado> lista = new ArrayList<Empleado>();
		String sql = "SELECT e.id, e.puesto, e.salario, count(f.id_empleado) as FacturasTotales, sum(total) as TotalFacturado FROM empleado e LEFT JOIN factura f on e.id = f.id_empleado WHERE MONTH(f.fecha) = ? GROUP BY e.id";

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
	 * Convierte una fila de ResultSet en un objeto Empleado.
	 *
	 * @param rs Fila de la consulta.
	 * @return Empleado mapeado.
	 */
	private Empleado mapearFila(ResultSet rs) throws SQLException {
		Empleado a = new Empleado();
		a.setId(rs.getInt("id"));
		a.setPuesto(rs.getString("puesto"));
		a.setSalario(rs.getDouble("salario"));
		return a;
	}

}