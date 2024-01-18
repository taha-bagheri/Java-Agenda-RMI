package server;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class AgendaServer {
    public static void main(String[] args) {
        try {
            // Crear instancia de la implementación del servicio
            AgendaServiceImpl obj = new AgendaServiceImpl();

            // Iniciar el registro RMI en el puerto 1099
            Registry registry = LocateRegistry.createRegistry(1099);

            // Registrar el objeto remoto con un nombre específico
            registry.rebind("AgendaService", obj);

            System.out.println("Servidor RMI listo");
        } catch (Exception e) {
            System.err.println("Excepción del servidor: " + e.toString());
            e.printStackTrace();
        }
    }
}
