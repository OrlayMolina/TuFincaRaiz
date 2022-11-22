package co.edu.uniquindio.engesis.proyectofinal.model.base.datos;

import co.edu.uniquindio.engesis.proyectofinal.model.AppController;
import co.edu.uniquindio.engesis.proyectofinal.model.CrearUsuarios;
import co.edu.uniquindio.engesis.proyectofinal.model.base.datos.Conexion;
import co.edu.uniquindio.engesis.proyectofinal.model.personas.Administrador;
import co.edu.uniquindio.engesis.proyectofinal.model.personas.Persona;
import co.edu.uniquindio.engesis.proyectofinal.model.personas.Usuario;
import javafx.scene.control.Alert;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UsuarioBD {

    public static void crearUsuarios(Usuario usuario) {
        Conexion bd_conexion = new Conexion();
        PreparedStatement ps = null;
        try (Connection conexion = bd_conexion.getConnection()) {
            if(usuario.getTipoUsuario()==3){
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

            if(usuario.getTipoUsuario() == 4) {
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

    public static void crearPersona(Persona persona) {
        Conexion bd_conexion = new Conexion();
        PreparedStatement ps = null;
        try (Connection conexion = bd_conexion.getConnection()) {
            if(persona.getTipoUsuario()==1){
                String query = "INSERT INTO `clientes`(`tipo_usuario`, `tipo_documento`, `numero_documento`, `empleado`," +
                        "`primer_nombre`, `segundo_nombre`, `primer_apellido`, `segundo_apellido`, `telefono`," +
                        " `correo`, `sede_cliente`, `estado_registro`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
                ps = conexion.prepareStatement(query);
                ps.setInt(1, persona.getTipoUsuario());
                ps.setInt(2, persona.getTipoDocumento());
                ps.setString(3, persona.getNumeroDocumento());
                ps.setInt(4, 1);
                ps.setString(5, persona.getPrimerNombre());
                ps.setString(6, persona.getSegundoNombre());
                ps.setString(7, persona.getPrimerApellido());
                ps.setString(8, persona.getSegundoApellido());
                ps.setString(9, persona.getTelefono());
                ps.setString(10, persona.getCorreo());
                ps.setInt(11, 1);
                ps.setInt(12, 1);
                ps.executeUpdate();
            }

            if(persona.getTipoUsuario() == 2) {
                String query = "INSERT INTO `propietarios`(`tipo_usuario`, `tipo_documento`, `numero_documento`, `empleado` , `sede_propietario`, " +
                        "`primer_nombre`, `segundo_nombre`, `primer_apellido`, `segundo_apellido`, `telefono`, `correo`, " +
                        "`estado_registro`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
                ps = conexion.prepareStatement(query);
                ps.setInt(1, persona.getTipoUsuario());
                ps.setInt(2, persona.getTipoDocumento());
                ps.setString(3, persona.getNumeroDocumento());
                ps.setInt(4, 1);
                ps.setInt(5, 1);
                ps.setString(6, persona.getPrimerNombre());
                ps.setString(7, persona.getSegundoNombre());
                ps.setString(8, persona.getPrimerApellido());
                ps.setString(9, persona.getSegundoApellido());
                ps.setString(10, persona.getTelefono());
                ps.setString(11, persona.getCorreo());
                ps.setInt(12, 1);
                ps.executeUpdate();
            }

        } catch (Exception ex) {
            AppController.showAlert(Alert.AlertType.WARNING, "Error", "No fue posible validar usuario y contraseña correctamente");
            AppController.showAlert(Alert.AlertType.ERROR, "Error", ex.getMessage());
        }
    }

    public static void eliminarUsuarios(String documento, int cargo) {
        Conexion bd_connect = new Conexion();
        try(Connection conexion = bd_connect.getConnection()){
            PreparedStatement ps = null;
            if (cargo ==1){
                String query = "UPDATE `clientes` SET `estado_registro` = 3 WHERE `numero_documento` ="+documento;
                ps = conexion.prepareStatement(query);
                ps.executeUpdate();
            }
            if(cargo ==2){
                String query = "UPDATE `propietarios` SET `estado_registro` = 3 WHERE `numero_documento` ="+documento;
                ps = conexion.prepareStatement(query);
                ps.executeUpdate();
            }
            if (cargo ==3){
                String query = "UPDATE `administradores` SET `estado_registro` = 3 WHERE `numero_documento` ="+documento;
                ps = conexion.prepareStatement(query);
                ps.executeUpdate();
            }
            if(cargo ==4){
                String query = "UPDATE `empleados` SET `estado_registro` = 3 WHERE `numero_documento` ="+documento;
                ps = conexion.prepareStatement(query);
                ps.executeUpdate();
            }
        } catch (Exception ex) {
            CrearUsuarios.mostrarMensaje(ex.getMessage());
        }
    }
}
