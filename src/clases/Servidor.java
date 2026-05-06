package clases;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Servidor extends Remote {
    public String consultar(int id) throws RemoteException;
}
