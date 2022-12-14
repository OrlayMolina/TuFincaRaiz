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

public class PropiedadesApartamento {

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
    private ComboBox<?> cbAscensorApto;

    @FXML
    private ComboBox<?> cbBalconApto;

    @FXML
    private ComboBox<?> cbTipoOfertaApto;

    @FXML
    private Label lblHeaderName;

    @FXML
    private Label lblPrincipal;

    @FXML
    private TableColumn<?, ?> tblAdminitracionApto;

    @FXML
    private TableView<?> tblApartamento;

    @FXML
    private TableColumn<?, ?> tblAreaApto;

    @FXML
    private TableColumn<?, ?> tblAscensorApto;

    @FXML
    private TableColumn<?, ?> tblBalconApto;

    @FXML
    private TableColumn<?, ?> tblCuartosApto;

    @FXML
    private TableColumn<?, ?> tblDireccionApto;

    @FXML
    private TableColumn<?, ?> tblNumeroPisosChalet;

    @FXML
    private TableColumn<?, ?> tblParqueaderosApto;

    @FXML
    private TableColumn<?, ?> tblPisoApto;

    @FXML
    private TableColumn<?, ?> tblTipoOfertaApto;

    @FXML
    private TableColumn<?, ?> tblValorApto;

    @FXML
    private TextField txtAreaApto;

    @FXML
    private TextField txtDireccionApto;

    @FXML
    private TextField txtNumeroBañosApto;

    @FXML
    private TextField txtNumeroCuartosApto;

    @FXML
    private TextField txtNumeroParqueaderosApto;

    @FXML
    private TextField txtPisoApto;

    @FXML
    private TextField txtValorAdministracionApto;

    @FXML
    private TextField txtValorApto;

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
    void onComboBoxEnergiaChalet(ActionEvent event) {

    }

    @FXML
    void onComboBoxTipoOfertaChalet(ActionEvent event) {

    }

    @FXML
    void onEliminar(ActionEvent event) {

    }

    @FXML
    void onSalirAptoClick(ActionEvent event) throws IOException {
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
