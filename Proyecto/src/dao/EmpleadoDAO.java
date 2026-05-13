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

public class EmpleadoDAO implements GenericDAO<Empleado> {

	@Override
	public boolean insertar(Empleado objeto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Empleado> obtenerTodos() {
		List<Empleado> lista = new ArrayList<Empleado>();
		String sql = """
				SELECT id, puesto, salario
				FROM empleado
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
	public Empleado obtenerPorId(int id) {
		String sql = """
				SELECT f.*
				FROM empleado e
				INNER JOIN factura f on e.id = f.id_empleado
				WHERE f.id = ?;
				""";
		try (Connection con = ConexionBD.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
			ResultSet rs = ps.executeQuery();

			ps.setInt(1, id);

			while (rs.next()) {
				return mapearFila(rs);
			}

		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}
		return null;

	}

	@Override
	public boolean actualizar(Empleado objeto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	public List<Empleado> resumenMensual(int mes) {
		List<Empleado> lista = new ArrayList<Empleado>();
		String sql = """
				SELECT e.id, count(f.id_empleado) as FacturasTotales, sum(total) as TotalFacturado
				FROM empleado e
				LEFT JOIN factura f on e.id = f.id_empleado
				WHERE MONTH(f.fecha) = ?
				GROUP BY e.id;
				""";

		try (Connection con = ConexionBD.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
			ResultSet rs = ps.executeQuery();
			ps.setInt(1, mes);

			while (rs.next()) {
				lista.add(mapearFila(rs));
			}
			return lista;

		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}
		return null;

	}

	private Empleado mapearFila(ResultSet rs) throws SQLException {
		Empleado a = new Empleado();
		a.setId(rs.getInt("id"));
		a.setPuesto(rs.getString("puesto"));
		a.setSalario(rs.getDouble("salario"));
		return a;
	}

}
