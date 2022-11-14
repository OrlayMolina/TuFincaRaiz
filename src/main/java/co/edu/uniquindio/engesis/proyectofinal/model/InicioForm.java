package co.edu.uniquindio.engesis.proyectofinal.model;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

import static co.edu.uniquindio.engesis.proyectofinal.model.AppController.showAlert;

public class InicioForm {

    @FXML
    private Button btnSalir;

    @FXML
    private Button btnUsuarios;

    @FXML
    private Label lblPrincipal;

    @FXML
    private Label lblHeaderName;

    void init(String name, String cargo) {
        lblPrincipal.setText("¡Hola, "+name+"! ¿Qué quieres gestionar hoy?");
        lblHeaderName.setText(name+" | "+cargo);
    }

    @FXML
    void onSalirClic(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        //name = user;
        stage.setTitle("Tu Finca Raíz | Iniciar sesión");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.centerOnScreen();
        stage.show();
    }

    @FXML
    void onUsuariosClick(ActionEvent event) {
        showAlert(Alert.AlertType.WARNING, "Error", "Código pendiente por construir");
    }

}
