package co.edu.uniquindio.engesis.proyectofinal.model.base.datos;

import co.edu.uniquindio.engesis.proyectofinal.model.base.datos.Conexion;
import co.edu.uniquindio.engesis.proyectofinal.model.personas.Persona;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConversionBD {

    public static ArrayList<Persona> getAdministradoresBD() throws SQLException {
        Connection con = Conexion.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Persona> listaAdmin = new ArrayList<>();
        try {
            String query = "SELECT * FROM `administradores` WHERE estado_registro=1";
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                Persona persona = new Persona();
                persona.setTipoUsuario(rs.getInt("tipo_usuarios"));
                persona.setTipoDocumento(rs.getInt("tipo_documento"));
                persona.setNumeroDocumento(rs.getString("numero_documento"));
                persona.setPrimerNombre(rs.getString("primer_nombre"));
                persona.setSegundoNombre(rs.getString("segundo_nombre"));
                persona.setPrimerApellido(rs.getString("primer_apellido"));
                persona.setSegundoApellido(rs.getString("segundo_apellido"));
                persona.setTelefono(rs.getString("telefono"));
                persona.setCorreo(rs.getString("correo"));
                listaAdmin.add(persona);
            }


        } catch (Exception e) {
            Logger.getLogger(ConversionBD.class.getName()).log(Level.SEVERE,null,e);
        }
        return listaAdmin;
    }
}
