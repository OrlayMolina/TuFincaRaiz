package co.edu.uniquindio.engesis.proyectofinal.model;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class Propiedades {

    @FXML
    private Button btnApartamento;

    @FXML
    private Button btnBodega;

    @FXML
    private Button btnCasa;

    @FXML
    private Button btnChalet;

    @FXML
    private Button btnEdificio;

    @FXML
    private Button btnLote;

    @FXML
    private Button btnParqueadero;

    @FXML
    private Button btnSalir;

    @FXML
    private Label lblHeaderName;

    @FXML
    private Label lblPrincipal;

    @FXML
    void onApartamentoClick(ActionEvent event) {

    }

    @FXML
    void onBodegaClick(ActionEvent event) {

    }

    @FXML
    void onCasaClick(ActionEvent event) {

    }

    @FXML
    void onChaletClick(ActionEvent event) {

    }

    @FXML
    void onEdificioClick(ActionEvent event) {

    }

    @FXML
    void onLoteClick(ActionEvent event) {

    }

    @FXML
    void onParqueaderoClick(ActionEvent event) {

    }

    @FXML
    void onSalirClickPropiedades(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("InicioForm.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Tu Finca Raíz | Inicio");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.centerOnScreen();
        stage.show();
        //Prueba

    }


}