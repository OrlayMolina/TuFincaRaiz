package co.edu.uniquindio.engesis.proyectofinal.model.base.datos;

import co.edu.uniquindio.engesis.proyectofinal.model.AppController;
import javafx.scene.control.Alert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    public static Connection getConnection() throws SQLException {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/inmobiliaria?serverTimezone=UTC", "root", "Lechevarsinodioxogen56");
        } catch (SQLException e) {
            AppController.showAlert(Alert.AlertType.WARNING, "Error", "No fue posible conectar con la base de datos");
            AppController.showAlert(Alert.AlertType.ERROR, "Error", e.getMessage());
        }
        return connection;
    }
}
