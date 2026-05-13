package test;

import clases.ServidorImpl;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class TestServidor {
    public static void main(String[] args) {
        try {
            ServidorImpl servidor = new ServidorImpl();

            Registry registry = LocateRegistry.createRegistry(1099);

            registry.rebind("ServidorRMI", servidor);

            System.out.println("Servidor RMI listo y esperando conexiones.");
        } catch (Exception e) {
            System.err.println("Excepción en el servidor: " + e.toString());
            e.printStackTrace();
        }
    }
}
