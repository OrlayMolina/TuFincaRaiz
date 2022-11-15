package co.edu.uniquindio.engesis.proyectofinal.model;


import co.edu.uniquindio.engesis.proyectofinal.model.base.datos.Conexion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RecuperarAcceso {


    @FXML
    private Button btnEnviar;

    @FXML
    private Button btnSalir;

    @FXML
    private TextField txCapturarCorreo;

    @FXML
    private Label lblPrincipal;

    @FXML
    void onSalirClic(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Tu Finca Raíz | Iniciar sesión");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.centerOnScreen();
        stage.show();
    }

    @FXML
    void onEnviarCorreo(ActionEvent event) throws UnsupportedEncodingException {
        String correo = txCapturarCorreo.getText();
        String body;
        Conexion bd_connect = new Conexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String consultaNombre ="";
        String consultaUsuario = "";
        String consultaContrasenia = "";
        String nombreConsultado = "";
        String usuarioConsultado = "";
        String contraseniaConsultada = "";
        boolean correoNoEncontrados = false;
        try(Connection conexion = bd_connect.getConnection()){
            String query = "SELECT * FROM empleados WHERE estado_registro=1";
            ps = conexion.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next() ) {
                if ((correo.equals(rs.getString("correo")))) {
                    correoNoEncontrados = true;
                    consultaNombre = "SELECT `primer_nombre` FROM `empleados` WHERE `correo`= " + correo;
                    nombreConsultado = rs.getString("primer_nombre");
                    consultaUsuario = "SELECT `user_name` FROM `empleados` WHERE `correo`= " + correo;
                    usuarioConsultado= rs.getString("user_name");
                    consultaContrasenia = "SELECT `empleado_password` FROM `empleados` WHERE `correo`= " + correo;
                    contraseniaConsultada = rs.getString("empleado_password");

                }
            }
            String query2 = "SELECT * FROM administradores WHERE estado_registro=1";
            ps = conexion.prepareStatement(query2);
            rs = ps.executeQuery();
            while (rs.next()) {
                if ((correo.equals(rs.getString("correo")))) {
                    correoNoEncontrados = true;
                }
            }
            if (correoNoEncontrados == false){
                AppController.showAlert(Alert.AlertType.WARNING, "Error", "El correo ingresado no esta registrado.");
            }

        } catch (SQLException e) {
            AppController.showAlert(Alert.AlertType.WARNING, "Error", "No fue posible conectar con la base de datos");
            AppController.showAlert(Alert.AlertType.ERROR, "Error", e.getMessage());
        }
        MailSend mailSend;
        String template = "<p style=\"text-align:center\"><span style=\"font-size:22px\"><span style=\"font-family:Verdana,Geneva,sans-serif\">Hola <span style=\"color:#16a085\">[Primer_Nombre]</span>, recibimos tu solicitud para recuperar el acceso a tu cuenta</span></span></p>\n" +
                "\n" +
                "<p style=\"text-align:center\"><img src=\"https://ckeditor.com/apps/ckfinder/userfiles/files/image-20221114104122-3.jpeg\" style=\"height:331px; width:820px\" /></p>\n" +
                "\n" +
                "<p style=\"text-align:center\"><span style=\"font-size:22px\"><span style=\"font-family:Verdana,Geneva,sans-serif\">Usuario: <span style=\"color:#16a085\">[userName]</span></span></span></p>\n" +
                "\n" +
                "<p style=\"text-align:center\"><span style=\"font-size:22px\"><span style=\"font-family:Verdana,Geneva,sans-serif\">Contrase&ntilde;a: <span style=\"color:#16a085\">[password]</span></span></span></p>\n" +
                "\n" +
                "<p style=\"text-align:center\"><span style=\"font-size:22px\"><span style=\"font-family:Verdana,Geneva,sans-serif\">Recuerda cambiar tu clave periodicamente</span></span></p>\n" +
                "\n" +
                "<p style=\"text-align:center\"><span style=\"font-size:22px\"><span style=\"font-family:Verdana,Geneva,sans-serif\">Cordialmente, Tu Finca Ra&iacute;z</span></span></p>\n" +
                "\n" +
                "<p style=\"text-align:center\">&nbsp;</p>\n" +
                "\n" +
                "<p style=\"text-align:center\"><img src=\"https://ckeditor.com/apps/ckfinder/userfiles/files/image-20221114103825-2.png\" style=\"height:199px; width:300px\" /></p>";

        mailSend =new MailSend();
        body = template.replace("[Primer_Nombre]", nombreConsultado).replace("[userName]",usuarioConsultado).replace("[password]",contraseniaConsultada);
        mailSend.createEmail(correo, nombreConsultado+", tenemos novedades de tu cuenta: ", new String(body.getBytes("ISO-8859-1"),"UTF-8"));
        mailSend.sendEmail();
    }

    @FXML
    void onSalirClic(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Tu Finca Raíz | Iniciar sesión");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.centerOnScreen();
        stage.show();
    }

}
