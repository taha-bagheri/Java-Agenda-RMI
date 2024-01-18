package server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;

import common.AgendaService;

public class AgendaServiceImpl extends UnicastRemoteObject implements AgendaService {
	private static final long serialVersionUID = 1L;
	private Map<String, String> contactos;

	protected AgendaServiceImpl() throws RemoteException {
		contactos = new HashMap<>();
	}

	@Override
	public void altaContacto(String nombre, String telefono) throws RemoteException {
		contactos.put(nombre, telefono);
	}

	@Override
	public void bajaContacto(String nombre) throws RemoteException {
		contactos.remove(nombre);
	}

	@Override
	public void modificarTelefono(String nombre, String nuevoTelefono) throws RemoteException {
		contactos.put(nombre, nuevoTelefono);
	}

	@Override
	public String buscarContacto(String nombre) throws RemoteException {
		return contactos.get(nombre);
	}

	@Override
	public void cerrarServidor() throws RemoteException {
		new Thread(() -> {
			try {
				Thread.sleep(1000); // Espera 1 segundo antes de cerrar
				System.exit(0);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();
	}

}
