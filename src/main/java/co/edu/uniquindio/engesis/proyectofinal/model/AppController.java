package co.edu.uniquindio.engesis.proyectofinal.model;
import co.edu.uniquindio.engesis.proyectofinal.model.base.datos.Conexion;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;


import java.io.IOException;
import java.lang.reflect.MalformedParameterizedTypeException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AppController {

    @FXML
    private Button btnCancelar;

    @FXML
    private Button btnIngresar;

    @FXML
    private Label lblIniciarSesion;

    @FXML
    private PasswordField txtContrasenia;

    @FXML
    private TextField txtNombreUsuario;

    @FXML
    private Button btnRecuperarAcceso;

    @FXML
    private Button btnSalir;

    @FXML
    private Button btnUsuarios;

    @FXML
    private Label lblPrincipal;

    @FXML
    void onCancelarClick(ActionEvent event) throws IOException {
        txtNombreUsuario.setText("");
        txtContrasenia.setText("");
    }

    @FXML
    void onIngresarClick(ActionEvent event) throws IOException, NoSuchFieldException {
        String user = txtNombreUsuario.getText();
        String pass = txtContrasenia.getText();

        if(ingresarSistema(user, pass)){
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("InicioForm.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            InicioForm inicioForm = loader.getController();
            inicioForm.init(user,cargoUsuario(user, pass));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle("Tu Finca Raíz | Inicio");
            stage.setScene(scene);
            stage.setResizable(false);
            stage.centerOnScreen();
            stage.show();
        }
        if(!ingresarSistema(user, pass))
            showAlert(Alert.AlertType.WARNING, "Error", "El usuario y/o contraseña ingresados son incorrectos");

    }

    public static void showAlert(Alert.AlertType alertType, String tittle, String message){
        Alert alert = new Alert(alertType);
        alert.setTitle(tittle);
        alert.setContentText(message);
        alert.show();
    }

     public static boolean ingresarSistema(String user, String pass){
        boolean ingreso = false;
         Conexion bd_connect = new Conexion();
         PreparedStatement ps = null;
         ResultSet rs = null;
         try(Connection conexion = bd_connect.getConnection()){

             try{

                 String query = "SELECT * FROM empleados WHERE estado_registro=1";
                 ps = conexion.prepareStatement(query);
                 rs = ps.executeQuery();
                 while (rs.next() && ingreso == false) {
                     if ((user.equals(rs.getString("user_name"))) && (pass.equals(rs.getString("empleado_password")))) {
                         ingreso = true;
                     }
                 }
                 String query2 = "SELECT * FROM administradores WHERE estado_registro=1";
                 ps = conexion.prepareStatement(query2);
                 rs = ps.executeQuery();
                 while (rs.next() && ingreso == false) {
                     if ((user.equals(rs.getString("user_name"))) && (pass.equals(rs.getString("admin_password")))) {
                         ingreso = true;
                     }
                 }
                 return ingreso;

             } catch (Exception ex) {
                 AppController.showAlert(Alert.AlertType.WARNING, "Error", "No fue posible validar usuario y contraseña correctamente");
                 AppController.showAlert(Alert.AlertType.ERROR, "Error", ex.getMessage());
             }

         } catch (SQLException e) {
             AppController.showAlert(Alert.AlertType.WARNING, "Error", "No fue posible conectar con la base de datos");
             AppController.showAlert(Alert.AlertType.ERROR, "Error", e.getMessage());
         }

         return ingreso;
     }

     public static String cargoUsuario(String user, String pass) {
        String cargo ="";
        int conteo =0;
         Conexion bd_connect = new Conexion();
         PreparedStatement ps = null;
         ResultSet rs = null;
         try(Connection conexion = bd_connect.getConnection()){
             String query = "SELECT * FROM empleados WHERE estado_registro=1";
             ps = conexion.prepareStatement(query);
             rs = ps.executeQuery();
             while (rs.next()){
                 if ((user.equals(rs.getString("user_name"))) && (pass.equals(rs.getString("empleado_password")))) {
                     cargo = "Empleado de Tu Finca Raíz";
                 }
             }
             String query2 = "SELECT * FROM administradores WHERE estado_registro=1";
             ps = conexion.prepareStatement(query2);
             rs = ps.executeQuery();
             while(rs.next()){
                 if ((user.equals(rs.getString("user_name"))) && (pass.equals(rs.getString("admin_password")))) {
                     cargo = "Administrador del Sistema";
                 }
             }
             conteo++;
             conteoIntentos(conteo);
         } catch (Exception e){
             AppController.showAlert(Alert.AlertType.WARNING, "Error", "No fue posible conectar con la base de datos");
             AppController.showAlert(Alert.AlertType.ERROR, "Error", e.getMessage());
         }

         return cargo;
     }

     public static boolean conteoIntentos(int conteoIntentos){
        boolean mostrarEnviarCorreo =false;
        if (conteoIntentos == 3){
            mostrarEnviarCorreo = true;
        } else {
            mostrarEnviarCorreo = false;
        }
         return mostrarEnviarCorreo;
     }

    @FXML
    void onClicAcceso(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("RecuperarAcceso.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Tu Finca Raíz | Recuperar Acceso");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.centerOnScreen();
        stage.show();
    }

}
