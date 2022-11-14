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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class CrearUsuarios {

    @FXML
    private Button btnAcuatlizar;

    @FXML
    private Button btnBuscar;

    @FXML
    private Button btnEliminar;

    @FXML
    private Button btnGuardarUsuario;

    @FXML
    private Button btnSalir;

    @FXML
    private ComboBox<?> cbTipoDocumento;

    @FXML
    private ComboBox<?> cbTipoUsuario;

    @FXML
    private Label lblHeaderName;

    @FXML
    private Label lblPrincipal;

    @FXML
    private TableColumn<?, ?> tblConsecutivo;

    @FXML
    private TableColumn<?, ?> tblCorreo;

    @FXML
    private TableColumn<?, ?> tblDocumento;

    @FXML
    private TableColumn<?, ?> tblPrimerApellido;

    @FXML
    private TableColumn<?, ?> tblPrimerNombre;

    @FXML
    private TableColumn<?, ?> tblSegundoApellido;

    @FXML
    private TableColumn<?, ?> tblSegundoNombre;

    @FXML
    private TableColumn<?, ?> tblTipoDocumento;

    @FXML
    private PasswordField txtContrasenia;

    @FXML
    private TextField txtCorreo;

    @FXML
    private TextField txtNombreUsuario;

    @FXML
    private TextField txtNumeroDocumento;

    @FXML
    private TextField txtPrimerApellido;

    @FXML
    private TextField txtPrimerNombre;

    @FXML
    private TextField txtSegundoApellido;

    @FXML
    private TextField txtSegundoNombre;

    @FXML
    private TextField txtTelefono;

    @FXML
    void onActualizar(ActionEvent event) {

    }

    @FXML
    void onBuscar(ActionEvent event) {

    }

    @FXML
    void onEliminar(ActionEvent event) {

    }

    @FXML
    void onSalirClic(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("InicioForm.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.centerOnScreen();
        stage.setTitle("Tu Finca Raíz | Inicio");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.centerOnScreen();
        stage.show();
    }

    @FXML
    void onguardar(ActionEvent event) {

    }

}
