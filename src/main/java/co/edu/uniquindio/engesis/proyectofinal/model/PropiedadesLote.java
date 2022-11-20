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

public class PropiedadesLote {

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
    private ComboBox<?> cbPerimetroLote;

    @FXML
    private ComboBox<?> cbTipoOfertaLote;

    @FXML
    private Label lblHeaderName;

    @FXML
    private Label lblPrincipal;

    @FXML
    private TableColumn<?, ?> tblAreaLote;

    @FXML
    private TableColumn<?, ?> tblDireccionLote;

    @FXML
    private TableView<?> tblLote;

    @FXML
    private TableColumn<?, ?> tblPerimetroLote;

    @FXML
    private TableColumn<?, ?> tblPropietarioLote;

    @FXML
    private TableColumn<?, ?> tblTipoOfertaLote;

    @FXML
    private TableColumn<?, ?> tblValorLote;

    @FXML
    private TextField txValorLote;

    @FXML
    private TextField txtAreaLote;

    @FXML
    private TextField txPropietarioLote;

    @FXML
    private TextField txtDireccionLote;

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
    void onComboBoxPerimetroLote(ActionEvent event) {

    }

    @FXML
    void onComboBoxTipoOfertaLote(ActionEvent event) {

    }

    @FXML
    void onEliminar(ActionEvent event) {

    }

    @FXML
    void onSalirClic(MouseEvent event) {

    }

    @FXML
    void onSalirLoteClick(ActionEvent event) throws IOException {
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
