package test;

import clases.ServidorImpl;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class TestServidor {
    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(1099);

            ServidorImpl servidor = new ServidorImpl();

            Naming.rebind("Datos", servidor);

            System.out.println("Servidor RMI listo y esperando conexiones.");
        } catch (Exception e) {
            System.err.println("Excepción en el servidor: " + e.toString());
            e.printStackTrace();
        }
    }
}