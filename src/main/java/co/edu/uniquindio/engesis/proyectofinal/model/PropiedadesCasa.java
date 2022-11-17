package co.edu.uniquindio.engesis.proyectofinal.model;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class PropiedadesCasa {

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
    private ComboBox<TipoOferta> cbTipoOfertaCasa;

    @FXML
    private TextField txtValorCasa;

    @FXML
    private TextField txtDireccionCasa;

    @FXML
    private TextField txtAreaCasa;

    @FXML
    private TextField txtNumeroPisosCasa;

    @FXML
    private TextField txtNumeroCuartosCasa;

    @FXML
    private TextField txtNumeroBañosCasa;

    @FXML
    private TextField txtMaterialConstruccionCasa;

    @FXML
    private TableView <PropiedadesCasa> tblCasa;

    @FXML
    private TableColumn<PropiedadesCasa, TipoOferta> tblTipoOfertaCasa;

    @FXML
    private TableColumn<PropiedadesCasa, Integer> tblvalorCasa;

    @FXML
    private TableColumn<PropiedadesCasa, String> tblDireccionCasa;

    @FXML
        private TableColumn<PropiedadesCasa, Integer> tblAreaCasa;

    @FXML
    private TableColumn<PropiedadesCasa, Integer> tblNumeroPisosCasa;

    @FXML
    private TableColumn<PropiedadesCasa, Integer> tblNumeroCuartosCasa;

    @FXML
    private TableColumn<PropiedadesCasa, Integer> tblNumeroBañosCasa;

    @FXML
    private TableColumn<PropiedadesCasa, String> tblMaterialConstruccionCasa;


    @FXML
    void onComboBox(ActionEvent event) {
        //cbTipoDocumento.setValue(cbTipoDocumento.getValue());
        cbTipoDocumento.setItems(FXCollections.observableArrayList(TipoDocumento.values()));
    }

    @FXML
    void onComboBoxTipoUsuario(ActionEvent event) {
        //cbTipoUsuario.setValue(cbTipoUsuario.getValue());
        cbTipoUsuario.setItems(FXCollections.observableArrayList(TipoUsuario.values()));
    }

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
        Usuario usuario = new Usuario();
        int tipoUsuario = 3;
        int tipoDocumento = 2;
        String numeroDocumento = txtNumeroDocumento.getText();
        String primerNombre = txtPrimerNombre.getText().toUpperCase();
        String segundoNombre = txtSegundoNombre.getText().toUpperCase();
        String primerApellido = txtPrimerApellido.getText().toUpperCase();
        String segundoApellido = txtSegundoApellido.getText().toUpperCase();
        String telefono = txtTelefono.getText();
        String correo = txtCorreo.getText().toLowerCase();
        String nombreUsuario = txtNombreUsuario.getText();
        String contrasenia = txtContrasenia.getText();
        usuario = new Usuario(tipoUsuario, tipoDocumento, numeroDocumento, primerNombre, segundoNombre,
                primerApellido, segundoApellido, telefono, correo, nombreUsuario, contrasenia);
        UsuarioBD.crearUsuarios(usuario);
        //AppController.showAlert(Alert.AlertType.WARNING, "Error", "Tercero creado correctamente.");
        onCancelarRegistro(event);
    }

    @FXML
    void onCancelarRegistro(ActionEvent event) {
        txtContrasenia.setText("");
        txtCorreo.setText("");
        txtNombreUsuario.setText("");
        txtNumeroDocumento.setText("");
        txtPrimerApellido.setText("");
        txtPrimerNombre.setText("");
        txtSegundoApellido.setText("");
        txtSegundoNombre.setText("");
        txtTelefono.setText("");
    }
}
