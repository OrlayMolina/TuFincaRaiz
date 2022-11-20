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

public class PropiedadesChalet {

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
    private ComboBox<?> cbAguaPotableChalet;

    @FXML
    private ComboBox<?> cbAlcantarilladoChalet;

    @FXML
    private ComboBox<?> cbEnergiaChalet;

    @FXML
    private ComboBox<?> cbGasChalet;

    @FXML
    private ComboBox<?> cbInternetChalet;

    @FXML
    private ComboBox<?> cbTipoOfertaChalet;

    @FXML
    private Label lblHeaderName;

    @FXML
    private Label lblPrincipal;

    @FXML
    private TableColumn<?, ?> tblAguaChalet;

    @FXML
    private TableColumn<?, ?> tblAlcantarilladoChalet;

    @FXML
    private TableColumn<?, ?> tblAreaChalet;

    @FXML
    private TableView<?> tblChalet;

    @FXML
    private TableColumn<?, ?> tblCorreo;

    @FXML
    private TableColumn<?, ?> tblDireccionChalet;

    @FXML
    private TableColumn<?, ?> tblPropietarioChalet;

    @FXML
    private TableColumn<?, ?> tblEnergiaChalet;

    @FXML
    private TableColumn<?, ?> tblInternetChalet;

    @FXML
    private TableColumn<?, ?> tblMaterialConstruccionChalet;

    @FXML
    private TableColumn<?, ?> tblNumeroBañosChalet;

    @FXML
    private TableColumn<?, ?> tblNumeroCuartosChalet;

    @FXML
    private TableColumn<?, ?> tblNumeroPisosChalet;

    @FXML
    private TableColumn<?, ?> tblTipoOfertaChalet;

    @FXML
    private TableColumn<?, ?> tblValorChalet;

    @FXML
    private TextField txtAreaChalet;

    @FXML
    private TextField txtDireccionChalet;

    @FXML
    private TextField txtMaterialConstruccionChalet;

    @FXML
    private TextField txtNumeroBañosChalet;

    @FXML
    private TextField txtNumeroCuartosChalet;

    @FXML
    private TextField txtPropietarioChalet;

    @FXML
    private TextField txtNumeroPisosChalet;

    @FXML
    private TextField txtValorChalet;

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
    void onComboBoxAguaPotableChalet(ActionEvent event) {

    }

    @FXML
    void onComboBoxAlcantarilladoChalet(ActionEvent event) {

    }

    @FXML
    void onComboBoxEnergiaChalet(ActionEvent event) {

    }

    @FXML
    void onComboBoxGasChalet(ActionEvent event) {

    }

    @FXML
    void onComboBoxInternetChalet(ActionEvent event) {

    }

    @FXML
    void onComboBoxTipoOfertaChalet(ActionEvent event) {

    }

    @FXML
    void onEliminar(ActionEvent event) {

    }

    @FXML
    void onSalirChaletClick(ActionEvent event) throws IOException {
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
    void onSalirClic(MouseEvent event) {

    }

    @FXML
    void onguardar(ActionEvent event) {

    }

}
