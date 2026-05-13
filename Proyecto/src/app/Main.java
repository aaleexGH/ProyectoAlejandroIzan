package app;

import clase.Cliente;
import clase.Empleado;
import dao.ClienteDAO;
import dao.EmpleadoDAO;

public class Main {

	public static void main(String[] args) {

		EmpleadoDAO eDao = new EmpleadoDAO();
		ClienteDAO cDao = new ClienteDAO();
		
		// 1.	Muestra todos los clientes, selecciona uno escribiendo el id y muestra sus datos y sus facturas.
		System.out.println("MOSTRAR TODOS LOS CLIENTES: ");
		for (Cliente cTodos : cDao.obtenerTodos()) {
			System.out.println(cTodos);
		}
		
		System.out.println("");
		
		System.out.println("MOSTRAR TODOS LOS DATOS DE UN CLIENTE POR ID: ");
		System.out.println(cDao.obtenerPorId(3));
		
		// 2.	Muestra todos los empleados y seleccionando un id muestra las facturas que ha emitido.
		System.out.println("");
		
		System.out.println("MOSTRAR TODOS LOS EMPLEADOS: ");
		for (Empleado eTodos : eDao.obtenerTodos()) {
			System.out.println(eTodos);
		}
		
		System.out.println("");
		
		System.out.println("MOSTRAR TODAS LAS FACTURAS DE UN EMPLEADO POR ID: ");
		eDao.obtenerPorId(3);
		
		// 3.	Muestra una factura por id junto con todas sus líneas de factura.
		
		// 4.	Muestra todas las facturas de un mes, pide el número del mes y calcula el total facturado ese mes.
		
		// 5.	Muestra todas las facturas de una fecha concreta, por ejemplo 05-05-2026
		
		// 6.	Añade un cliente: 12345678Z, Pepe Carrera, Plaza Mozart 3
		System.out.println("");
		
		System.out.println("INSERTAR CLIENTE: ");
		cDao.insertar(new Cliente("Plaza Mozart 3"));
		// 7.	Añadir nuevo producto: pide los datos por teclado e inserta un producto nuevo si no existe un producto con ese nombre.
		
		// 8.	Actualizar producto: muestra los productos, selecciona uno por id y actualiza su precio.
		
		/* 9.	Crear factura: muestra todos los clientes, selecciona uno. Muestra todos los empleados, selecciona uno.
		        Muestra los productos disponibles y ves añadiendo productos seleccionando su id hasta introducir 0. 
		        Crea una factura y ves creando líneas de factura con los productos seleccionados. 
		        Al final muestra la factura con todos sus datos y todas sus líneas.
		*/
		
		// 10.	Muestra todos los productos y selecciona uno. Muestras las facturas en las que aparece.
		
		// 11.	Muestra los productos, selecciona uno por id y elimínalo, si no aparece en ninguna línea de factura.
		
		/* 12.	Guarda los clientes en el fichero “clientes.dat”. Lee ese fichero en una lista y
		        muestra los datos de los clientes de esa lista.
		*/
		
		/* 13.	Duplica una factura existente en una nueva fecha: pide un idFactura, 
		      copia la factura y todas sus líneas en una nueva factura con la fecha actual y muestra la nueva factura creada.
		*/
		
		/* 14.	Elimina una línea de factura y rehace la factura: muestra una factura con sus líneas, 
		        selecciona una línea por id, elimínala, recalcula subtotal, IVA y total, actualiza la factura y vuelve a mostrarla
		*/
		
		/* 15.	Resumen mensual por empleado: pide un número de mes y muestra cada empleado con el número de facturas emitidas
		        y el importe total facturado por cada uno en ese mes
		*/
		System.out.println("");
		
		System.out.println("RESUMEN MENSUAL: ");
		for (Empleado eResumenMensual : eDao.resumenMensual(4)) {
			System.out.println(eResumenMensual);
		}
	}

}
