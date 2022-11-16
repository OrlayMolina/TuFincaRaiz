package co.edu.uniquindio.engesis.proyectofinal.model;

import co.edu.uniquindio.engesis.proyectofinal.model.personas.Persona;
import co.edu.uniquindio.engesis.proyectofinal.model.personas.Usuario;
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


public class CrearUsuarios {

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
    private ComboBox<TipoDocumento> cbTipoDocumento;

    @FXML
    private ComboBox<TipoUsuario> cbTipoUsuario;

    @FXML
    private Label lblHeaderName;

    @FXML
    private Label lblPrincipal;

    @FXML
    private TableColumn<Persona, Integer> tblConsecutivo;

    @FXML
    private TableColumn<Persona, String> tblCorreo;

    @FXML
    private TableColumn<Persona, TipoDocumento> tblDocumento;

    @FXML
    private TableColumn<Persona, String> tblPrimerApellido;

    @FXML
    private TableColumn<Persona, String> tblPrimerNombre;

    @FXML
    private TableColumn<Persona, String> tblSegundoApellido;

    @FXML
    private TableColumn<Persona, String> tblSegundoNombre;

    @FXML
    private TableColumn<Persona, TipoDocumento> tblTipoDocumento;

    @FXML
    private PasswordField txtContrasenia;

    @FXML
    private TextField txtCorreo;// String Correo = txtCorreo.getText();

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
    public void initialize(){
        cbTipoDocumento.setItems(FXCollections.observableArrayList(TipoDocumento.values()));
    }
    @FXML
    void onComboBox(ActionEvent event) {
        //cbTipoDocumento.setValue(cbTipoDocumento.getValue());

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
