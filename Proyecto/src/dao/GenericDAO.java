package dao;

import java.util.List;

/**
 * Interfaz genérica para definir las operaciones CRUD básicas.
 * 
 * @author alejandroEizan
 * @param <T> Tipo de la entidad con la que trabajará el DAO.
 */
public interface GenericDAO<T> {
	
	/**
	 * Inserta un nuevo registro en la base de datos.
	 *
	 * @param objeto Entidad a insertar.
	 * @return true si se inserta, false si no.
	 */
	boolean insertar(T objeto);

	/**
	 * Obtiene todos los registros disponibles.
	 *
	 * @return Lista de entidades encontradas.
	 */
	List<T> obtenerTodos();

	/**
	 * Busca un registro por su ID único.
	 *
	 * @param id Identificador único a buscar.
	 * @return La entidad encontrada o null si no existe.
	 */
	T obtenerPorId(int id);

	/**
	 * Actualiza los datos de un registro existente.
	 *
	 * @param objeto Entidad con los datos actualizados.
	 * @return true si se actualiza, false si no.
	 */
	boolean actualizar(T objeto);

	/**
	 * Elimina un registro por su ID.
	 *
	 * @param id Identificador único del registro a borrar.
	 * @return true si se elimina, false si no.
	 */
	boolean eliminar(int id);
}