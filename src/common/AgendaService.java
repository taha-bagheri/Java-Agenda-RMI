package common;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface AgendaService extends Remote {
    void altaContacto(String nombre, String telefono) throws RemoteException;
    void bajaContacto(String nombre) throws RemoteException;
    void modificarTelefono(String nombre, String nuevoTelefono) throws RemoteException;
    String buscarContacto(String nombre) throws RemoteException;
    void cerrarServidor() throws RemoteException;
}
