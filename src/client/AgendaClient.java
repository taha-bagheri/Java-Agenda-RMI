package client;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

import common.AgendaService;

public class AgendaClient {
	public static void main(String[] args) {
		try {
			// Conexión con el servidor
			Registry registry = LocateRegistry.getRegistry("localhost", 1099);
			AgendaService stub = (AgendaService) registry.lookup("AgendaService");

			// Crear un Scanner para leer la entrada del usuario
			Scanner scanner = new Scanner(System.in);

			while (true) {
				System.out.println("\nOpciones:");
				System.out.println("1. Alta de contacto");
				System.out.println("2. Baja de contacto");
				System.out.println("3. Modificar teléfono de contacto");
				System.out.println("4. Buscar contacto");
				System.out.println("5. Salir");
				System.out.print("Elige una opción: ");

				int opcion = scanner.nextInt();
				scanner.nextLine(); // Consumir el salto de línea

				String nombre, telefono;

				switch (opcion) {
				case 1: // Alta de contacto
					System.out.print("Introduce el nombre del contacto: ");
					nombre = scanner.nextLine();
					System.out.print("Introduce el teléfono del contacto: ");
					telefono = scanner.nextLine();
					stub.altaContacto(nombre, telefono);
					System.out.println("Contacto añadido.");
					break;

				case 2: // Baja de contacto
					System.out.print("Introduce el nombre del contacto a eliminar: ");
					nombre = scanner.nextLine();
					stub.bajaContacto(nombre);
					System.out.println("Contacto eliminado.");
					break;

				case 3: // Modificar teléfono
					System.out.print("Introduce el nombre del contacto: ");
					nombre = scanner.nextLine();
					System.out.print("Introduce el nuevo teléfono del contacto: ");
					telefono = scanner.nextLine();
					stub.modificarTelefono(nombre, telefono);
					System.out.println("Teléfono actualizado.");
					break;

				case 4: // Buscar contacto
					System.out.print("Introduce el nombre del contacto: ");
					nombre = scanner.nextLine();
					telefono = stub.buscarContacto(nombre);
					if (telefono != null) {
						System.out.println("El teléfono de " + nombre + " es: " + telefono);
					} else {
						System.out.println("Contacto no encontrado.");
					}
					break;

				case 5: // Salir
					System.out.println("Saliendo...");
					stub.cerrarServidor();
					scanner.close();
					return;

				default:
					System.out.println("Opción no válida.");
				}
			}
		} catch (Exception e) {
			System.err.println("Excepción del cliente: " + e.toString());
			e.printStackTrace();
		}
	}
}
