package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import clase.Empleado;

public class EmpleadoDAO implements GenericDAO<Empleado> {

	@Override
	public boolean insertar(Empleado objeto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Empleado> obtenerTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Empleado obtenerPorId(int id) {
		// TODO Auto-generated method stub
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

	private Empleado mapearFila(ResultSet rs) throws SQLException {
		Empleado a = new Empleado();
	  a.setId(rs.getInt("id"));
	  a.setPuesto(rs.getString("puesto"));
	  a.setPuesto(rs.getString("salario"));
	  return a;
    }

	
}
