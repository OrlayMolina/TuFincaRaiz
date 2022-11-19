package co.edu.uniquindio.engesis.proyectofinal.model;

import co.edu.uniquindio.engesis.proyectofinal.model.base.datos.ConversionBD;
import co.edu.uniquindio.engesis.proyectofinal.model.base.datos.UsuarioBD;
import co.edu.uniquindio.engesis.proyectofinal.model.exceptiones.PersonaExisteException;
import co.edu.uniquindio.engesis.proyectofinal.model.exceptiones.valorRequeridoException;
import co.edu.uniquindio.engesis.proyectofinal.model.personas.Persona;
import co.edu.uniquindio.engesis.proyectofinal.model.personas.TipoDocumento;
import co.edu.uniquindio.engesis.proyectofinal.model.personas.TipoUsuario;
import co.edu.uniquindio.engesis.proyectofinal.model.personas.Usuario;
import co.edu.uniquindio.engesis.proyectofinal.model.util.TextFormatterUtil;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import static co.edu.uniquindio.engesis.proyectofinal.model.InmobiliariaController.INSTANCIA;


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
    private TableView<Persona> tblUsuarios;

    @FXML
    private TableColumn<Persona, String> tblCorreo;

    @FXML
    private TableColumn<Persona, String> tblTelefono;

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
    public void initialize() throws SQLException {
        llenarTabla(INSTANCIA.getInmobiliaria().buscar(null, null, null, null, null, null, null));
        tblDocumento.setCellValueFactory(new PropertyValueFactory<>("numeroDocumento"));
        tblPrimerNombre.setCellValueFactory(new PropertyValueFactory<>("primerNombre"));
        tblSegundoNombre.setCellValueFactory(new PropertyValueFactory<>("segundoNombre"));
        tblPrimerApellido.setCellValueFactory(new PropertyValueFactory<>("primerApellido"));
        tblSegundoApellido.setCellValueFactory(new PropertyValueFactory<>("segundoApellido"));
        tblTelefono.setCellValueFactory(new PropertyValueFactory<>("telefono"));
        tblCorreo.setCellValueFactory(new PropertyValueFactory<>("correo"));
        tblUsuarios.getSelectionModel().selectedItemProperty()
                .addListener((observable, oldValue, newValue) -> llenarCampos(newValue));
        txtNumeroDocumento.setTextFormatter(new TextFormatter<>(TextFormatterUtil::integerFormat));
        txtPrimerNombre.setTextFormatter(new TextFormatter<>(TextFormatterUtil::upperCaseFormat));
        txtSegundoNombre.setTextFormatter(new TextFormatter<>(TextFormatterUtil::upperCaseFormat));
        txtPrimerApellido.setTextFormatter(new TextFormatter<>(TextFormatterUtil::upperCaseFormat));
        txtSegundoApellido.setTextFormatter(new TextFormatter<>(TextFormatterUtil::upperCaseFormat));
        txtTelefono.setTextFormatter(new TextFormatter<>(TextFormatterUtil::integerFormat));
        txtNombreUsuario.setTextFormatter(new TextFormatter<>(TextFormatterUtil::upperCaseFormat));
        txtContrasenia.setTextFormatter(new TextFormatter<>(TextFormatterUtil::upperCaseFormat));
        cbTipoDocumento.setItems(FXCollections.observableArrayList(TipoDocumento.values()));
        cbTipoUsuario.setItems(FXCollections.observableArrayList(TipoUsuario.ADMINISTRADOR,TipoUsuario.EMPLEADO));
    }
    @FXML
    void onComboBox(ActionEvent event) {

    }

    @FXML
    void onComboBoxTipoUsuario(ActionEvent event) {


    }

    @FXML
    void onActualizar(ActionEvent event) {

    }

    @FXML
    void onBuscarUsuario() throws SQLException {
        llenarTabla(
                INSTANCIA.getInmobiliaria().buscar(txtNumeroDocumento.getText(), txtPrimerNombre.getText(),
                        txtSegundoNombre.getText(), txtPrimerApellido.getText(), txtSegundoApellido.getText(),
                        txtTelefono.getText(), txtCorreo.getText())
        );
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
    void onguardar(ActionEvent event) throws PersonaExisteException, valorRequeridoException, SQLException {
        try{
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
            Persona persona = Usuario.of(tipoUsuario, tipoDocumento, txtNumeroDocumento.getText(), txtPrimerNombre.getText(), txtSegundoNombre.getText(), txtPrimerApellido.getText(),
                    txtSegundoApellido.getText(), txtTelefono.getText(), txtCorreo.getText(), txtNombreUsuario.getText(),txtContrasenia.getText());
            UsuarioBD.crearUsuarios(usuario);
            mostrarInformacion("Usuario creado correctamente");
            onCancelarRegistro(event);
            INSTANCIA.getInmobiliaria().adicionarPersona(persona);
            llenarTabla(INSTANCIA.getInmobiliaria().buscar(null, null, null, null, null, null, null));
        } catch (Exception e) {
            mostrarMensaje(e.getMessage());
        }
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

    private void llenarTabla(List<Persona> persona) throws SQLException {
        List<Persona> admin = ConversionBD.getAdministradoresBD();
        List<Persona> empleados = ConversionBD.getEmpleadosBD();
        persona = ConversionBD.sumarListas( admin, empleados);
        tblUsuarios.setItems(FXCollections.observableArrayList(persona));
        tblUsuarios.refresh();
    }

    private void llenarCampos(Persona persona) {
        if (persona != null) {
            if(persona.getTipoDocumento() ==1){
                cbTipoDocumento.setValue(TipoDocumento.NIT);
            }
            if(persona.getTipoDocumento() ==2){
                cbTipoDocumento.setValue(TipoDocumento.CC);
            }
            if(persona.getTipoDocumento() ==3){
                cbTipoDocumento.setValue(TipoDocumento.CE);
            }
            if(persona.getTipoDocumento() ==4){
                cbTipoDocumento.setValue(TipoDocumento.PE);
            }
            txtNumeroDocumento.setText(persona.getNumeroDocumento());
            if(persona.getTipoUsuario() == 3){
                cbTipoUsuario.setValue(TipoUsuario.ADMINISTRADOR);
            }
            if(persona.getTipoUsuario() == 4){
                cbTipoUsuario.setValue(TipoUsuario.EMPLEADO);
            }
            txtPrimerNombre.setText(persona.getPrimerNombre());
            txtSegundoNombre.setText(persona.getSegundoNombre());
            txtPrimerApellido.setText(persona.getPrimerApellido());
            txtSegundoApellido.setText(persona.getSegundoApellido());
            txtTelefono.setText(persona.getTelefono());
            txtCorreo.setText(persona.getCorreo());
        }
    }

    private void mostrarMensaje(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Error");
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    private void mostrarInformacion(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Información");
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}
