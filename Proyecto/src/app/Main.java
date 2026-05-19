package app;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import dao.ClienteDAO;
import dao.EmpleadoDAO;
import util.ConexionBD;  
import clase.*;
import dao.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		EmpleadoDAO eDao = new EmpleadoDAO();
		ClienteDAO cDao = new ClienteDAO();
		LineaFacturaDAO lfDao = new LineaFacturaDAO();
		FacturaDAO fDao = new FacturaDAO();
		ProductoDAO pDao = new ProductoDAO();
		Producto p = new Producto("maria", 6.4, 150);
		Factura f = new Factura(2, null, 4, 3, 5, 5.5, 400);
		
		System.out.println("mostrar consultas del 1 al 15: ");
		int respuesta = Integer.parseInt(sc.nextLine());
		switch (respuesta) {
		case 1:
			System.out.println("MOSTRAR TODOS LOS CLIENTES: ");
			for (Cliente cTodos : cDao.obtenerTodos()) {
				System.out.println(cTodos);
			}

			System.out.println("");

			System.out.println("MOSTRAR TODOS LOS DATOS DE UN CLIENTE POR ID: ");
			System.out.println(cDao.obtenerPorId(3));

			
			break;
			
		case 2:
			System.out.println("");

			System.out.println("MOSTRAR TODOS LOS EMPLEADOS: ");
			for (Empleado eTodos : eDao.obtenerTodos()) {
				System.out.println(eTodos);
			}

			System.out.println("");

			System.out.println("MOSTRAR TODAS LAS FACTURAS DE UN EMPLEADO POR ID: ");
			eDao.obtenerPorId(3);

			
			break;	
		case 3:
			System.out.println("lista de lineas de factura por id");
			
			for (LineaFactura leer : lfDao.obtenerporIdFactura(4)) {
					System.out.println(leer);
			}
			break;
		case 4:
			System.out.println("muestra todas las facturas de un mes: ");
			for (Factura leer : fDao.mostrarFacturasPorMes(5)) {
				System.out.println(leer);
			}
			
			break;
		case 5:
			System.out.println("muesta todas las facturas con la fecha concreta");
			
			LocalDate ld =  LocalDate.of(2026, 05, 05);
			for (Factura leer : fDao.mostrarFacturasPorFecha(ld)) {
				System.out.println(leer);
			}
			
			break;
			
		case 6:
			System.out.println("");

			System.out.println("INSERTAR CLIENTE: ");
			System.out.println(cDao.insertar(new Cliente(6, "Plaza Mozart 3")));
			
			break;	
		case 7:
			System.out.println("añadir nuevo producto");
			
			
			
			if (pDao.obtenerPorNombre(p.getNombre()) == 0) {
				System.out.println(pDao.insertar(p));
			}
			else {
				System.out.println("El producto " + p.getNombre() + " ya existe.");
			}
			
			break;
		case 8:
			System.out.println("muestra todos");
			for (Producto leer : pDao.obtenerTodos()) {
				System.out.println(leer);
			}
			System.out.println("actualizar");
			System.out.println(pDao.actualizar(p));
			
			break;
		case 9:
			System.out.println("muestra todas facturas");
			for (Factura leer : fDao.obtenerTodos()) {
				System.out.println(leer);
			}
			
			System.out.println("muestra todos empleados");
			for (Empleado leer : eDao.obtenerTodos()) {
				System.out.println(leer);
			}
			System.out.println("muestra todos productos");
			for (Producto leer : pDao.obtenerTodos()) {
				System.out.println(leer);
			}
			
			fDao.insertar(f);
			
			
			
			break;
			
		case 10:
			System.out.println("muestra todos los productos");
			for (Producto leer : pDao.obtenerTodos()) {
				System.out.println(leer);
			}
			
			System.out.println(fDao.obtenerPorProducto(6));
			
			break;	
		case 11:
			System.out.println("muestra todos los productos");
			for (Producto leer : pDao.obtenerTodos()) {
				System.out.println(leer);
			}
			
			if (lfDao.obtenerPorIdProducto(4)>0) {
				System.out.println("existe");
			}else {
				System.out.println(pDao.eliminarProductoSiEstaEnLineaFactura(4));
			}
				
			
			break;
		case 12:
			ClienteDAO dao = new ClienteDAO();
			List<Cliente> listaClientes = dao.obtenerTodos();

			try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("clientes.dat"))) {

				out.writeObject(listaClientes);
				System.out.println("Clientes guardados en el fichero.");

			} catch (Exception e) {
				e.printStackTrace();
			}

			try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("clientes.dat"))) {

				List<Cliente> listaLeida = (List<Cliente>) in.readObject();

				System.out.println("\nMostrando clientes desde el fichero:");
				for (Cliente c : listaLeida) {
					System.out.println(c);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

			
			break;
		case 13:
				System.out.println("no esta el ejercicio");
			break;
			
		case 14:
				System.out.println("no esta el ejercicio");
			break;	
		case 15:
			System.out.println("");

			System.out.println("RESUMEN MENSUAL: ");
			for (Empleado eResumenMensual : eDao.resumenMensual(4)) {
				System.out.println(eResumenMensual);
			}
			
			break;

		default:
			System.out.println("numero invalido");
			break;
		} 	
	}

}
