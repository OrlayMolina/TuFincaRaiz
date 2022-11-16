package co.edu.uniquindio.engesis.proyectofinal.model;

import co.edu.uniquindio.engesis.proyectofinal.model.base.datos.Conexion;
import co.edu.uniquindio.engesis.proyectofinal.model.personas.Usuario;
import javafx.scene.control.Alert;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UsuarioBD {

    public static void crearUsuarios(Usuario usuario) {
        Conexion bd_conexion = new Conexion();
        PreparedStatement ps = null;
        try (Connection conexion = bd_conexion.getConnection()) {
            if(usuario.getTipoUsuario()==1){
                String query = "INSERT INTO `administradores`(`tipo_usuarios`, `tipo_documento`, `numero_documento`, `sede_admin`, " +
                        "`primer_nombre`, `segundo_nombre`, `primer_apellido`, `segundo_apellido`, `telefono`, `correo`, `user_name`, `admin_password`, " +
                        "`estado_registro`, `estado_login`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? ,?, ?, ?);";
                ps = conexion.prepareStatement(query);
                ps.setInt(1, usuario.getTipoUsuario());
                ps.setInt(2, usuario.getTipoDocumento());
                ps.setString(3, usuario.getNumeroDocumento());
                ps.setInt(4, 1);
                ps.setString(5, usuario.getPrimerNombre());
                ps.setString(6, usuario.getSegundoNombre());
                ps.setString(7, usuario.getPrimerApellido());
                ps.setString(8, usuario.getSegundoApellido());
                ps.setString(9, usuario.getTelefono());
                ps.setString(10, usuario.getCorreo());
                ps.setString(11, usuario.getUserName());
                ps.setString(12, usuario.getPassword());
                ps.setInt(13, 1);
                ps.setInt(14, 0);
                ps.executeUpdate();
            }

            if(usuario.getTipoUsuario() == 2) {
                String query = "INSERT INTO `empleados`(`tipo_usuarios`, `tipo_documento`, `numero_documento`, `sede_empleado`, " +
                        "`primer_nombre`, `segundo_nombre`, `primer_apellido`, `segundo_apellido`, `telefono`, `correo`, `user_name`, `empleado_password`, " +
                        "`estado_registro`, `estado_login`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? ,?, ?, ?);";
                ps = conexion.prepareStatement(query);
                ps.setInt(1, usuario.getTipoUsuario());
                ps.setInt(2, usuario.getTipoDocumento());
                ps.setString(3, usuario.getNumeroDocumento());
                ps.setInt(4, 1);
                ps.setString(5, usuario.getPrimerNombre());
                ps.setString(6, usuario.getSegundoNombre());
                ps.setString(7, usuario.getPrimerApellido());
                ps.setString(8, usuario.getSegundoApellido());
                ps.setString(9, usuario.getTelefono());
                ps.setString(10, usuario.getCorreo());
                ps.setString(11, usuario.getUserName());
                ps.setString(12, usuario.getPassword());
                ps.setInt(13, 1);
                ps.setInt(14, 0);
                ps.executeUpdate();
            }

        } catch (Exception ex) {
            AppController.showAlert(Alert.AlertType.WARNING, "Error", "No fue posible validar usuario y contraseña correctamente");
            AppController.showAlert(Alert.AlertType.ERROR, "Error", ex.getMessage());
        }
    }
}
