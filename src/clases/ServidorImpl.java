package clases;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class ServidorImpl extends UnicastRemoteObject implements Servidor {

    private static ArrayList<Persona> listPersonas(){
        ArrayList<Persona> lista = new ArrayList<Persona>();
        lista.add(new Persona(1, "Edwin Sarango", "edwin@gmail.com","administrador", 1000.00));
        lista.add(new Persona(2, "Maria Perez", "maria@gmail.com","empleado", 2000.00));
        lista.add(new Persona(3, "Juan Gomez", "juan@gmail.com","tecnico", 3000.00));
        return lista;
    }
    private static String getPersona(int id){
        Persona p = listPersonas().get(id - 1);
        return p.getNombre() + "\n"
                + "Correo: " + p.getCorreo() + "\n"
                + "Cargo: " + p.getCargo() + "\n"
                + "Sueldo: " + p.getSueldo();
    }


    public ServidorImpl() throws RemoteException {
        super();
    }

    @Override
    public String consultar(int id) throws RemoteException {
        ArrayList<Persona> personas = listPersonas();
        if (id > 0 && id <= personas.size()) {
            return getPersona(id);
        } else {
            return "No se encontro la persona con el id: " + id;
        }
    }
}