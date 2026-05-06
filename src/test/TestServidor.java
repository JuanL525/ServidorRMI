package test;

import clases.Servidor;
import clases.ServidorImpl;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class TestServidor {

    public static void main(String[] args) throws Exception{
        LocateRegistry.createRegistry(1099);
        ServidorImpl servidor = new ServidorImpl();
        String rmiObjectName= "rmi://localhost/Datos";
        Naming.rebind(rmiObjectName, servidor);
        System.out.println("Servidor Remoto corriendo");
    }
}
