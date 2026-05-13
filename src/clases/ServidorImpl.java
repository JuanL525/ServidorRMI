package clases;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ServidorImpl extends UnicastRemoteObject implements Servidor {

    public ServidorImpl() throws RemoteException {
        super();
    }

    @Override
    public String consultar(int id) throws RemoteException {
        String query = "SELECT * FROM usuarios WHERE id = ?";
        try (Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    //Cambiar luego
                    return "Nombre: " + rs.getString("nombre") + "\n"
                            + "Correo: " + rs.getString("correo") + "\n"
                            + "Cargo: " + rs.getString("cargo") + "\n"
                            + "Sueldo: " + rs.getDouble("sueldo");
                } else {
                    return "No se encontró el usuario con el id: " + id;
                }
            }
        } catch (SQLException e) {
            return "Error al consultar la base de datos: " + e.getMessage();
        }
    }
}
