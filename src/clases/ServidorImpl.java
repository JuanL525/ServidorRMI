package clases;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class ServidorImpl extends UnicastRemoteObject implements Servidor {

    public ServidorImpl() throws RemoteException {
        super();
    }

    @Override
    public String consultar(int id) throws RemoteException {

        String query = "SELECT * FROM empleados";
        StringBuilder datos = new StringBuilder();

        try (Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            ResultSetMetaData metaData = rs.getMetaData();
            int columnas = metaData.getColumnCount();
            int contador = 1;

            while (rs.next()) {
                datos.append("Empleado #").append(contador).append("\n");

                for (int i = 1; i <= columnas; i++) {
                    datos.append(metaData.getColumnName(i))
                            .append(": ")
                            .append(rs.getString(i))
                            .append("\n");
                }
                datos.append("----------------------\n");
                contador++;
            }

            if (contador == 1) {
                return "No existen empleados registrados.";
            }

            return datos.toString();

        } catch (Exception e) {
            return "Error al consultar empleados: " + e.getMessage();
        }
    }
}