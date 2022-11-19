package co.edu.uniquindio.engesis.proyectofinal.model;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class PropiedadesEdificio {

    @FXML
    private Button btnAcuatlizar;

    @FXML
    private Button btnBuscar;

    @FXML
    private Button btnCancelar;

    @FXML
    private Button btnEliminar;

    @FXML
    private Button btnGuardarUsuario;

    @FXML
    private Button btnSalir;

    @FXML
    private ComboBox<?> cbTipoOfertaEdificio;

    @FXML
    private Label lblHeaderName;

    @FXML
    private Label lblPrincipal;

    @FXML
    private TableColumn<?, ?> tblAreaEdificio;

    @FXML
    private TableColumn<?, ?> tblDireccionEdificio;

    @FXML
    private TableView<?> tblEdificio;

    @FXML
    private TableColumn<?, ?> tblNumeroPisosEdificio;

    @FXML
    private TableColumn<?, ?> tblTipoOfertaEdificio;

    @FXML
    private TableColumn<?, ?> tblValorEdificio;

    @FXML
    private TextField txValorEficio;

    @FXML
    private TextField txtAreaEdificio;

    @FXML
    private TextField txtDireccionEdificio;

    @FXML
    private TextField txtNumeroPisosEdificio;

    @FXML
    void onActualizar(ActionEvent event) {

    }

    @FXML
    void onBuscar(ActionEvent event) {

    }

    @FXML
    void onCancelarRegistro(ActionEvent event) {

    }

    @FXML
    void onComboBoxTipoOfertaEdificio(ActionEvent event) {

    }

    @FXML
    void onEliminar(ActionEvent event) {

    }

    @FXML
    void onSalirClic(MouseEvent event) {

    }

    @FXML
    void onSalirEdificioClick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Propiedades.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Tu Finca Raíz |  Propiedades");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.centerOnScreen();
        stage.show();

    }

    @FXML
    void onguardar(ActionEvent event) {

    }

}
