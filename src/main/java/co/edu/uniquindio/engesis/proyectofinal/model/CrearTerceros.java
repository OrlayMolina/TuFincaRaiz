package co.edu.uniquindio.engesis.proyectofinal.model;

import co.edu.uniquindio.engesis.proyectofinal.model.base.datos.ConversionBD;
import co.edu.uniquindio.engesis.proyectofinal.model.base.datos.UsuarioBD;
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
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import static co.edu.uniquindio.engesis.proyectofinal.model.InmobiliariaController.INSTANCIA;

public class CrearTerceros {

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
    private TableView<Persona> tblTerceros;

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
    private TextField txtCorreo;

    @FXML
    private TextField txtTelefono;

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
    private TableColumn<Persona, String> tblTelefono;

    @FXML
    public void initialize() throws SQLException {
        llenarTablaTerceros(INSTANCIA.getInmobiliaria().buscarTercero(null, null, null, null, null, null, null));
        tblDocumento.setCellValueFactory(new PropertyValueFactory<>("numeroDocumento"));
        tblPrimerNombre.setCellValueFactory(new PropertyValueFactory<>("primerNombre"));
        tblSegundoNombre.setCellValueFactory(new PropertyValueFactory<>("segundoNombre"));
        tblPrimerApellido.setCellValueFactory(new PropertyValueFactory<>("primerApellido"));
        tblSegundoApellido.setCellValueFactory(new PropertyValueFactory<>("segundoApellido"));
        tblTelefono.setCellValueFactory(new PropertyValueFactory<>("telefono"));
        tblCorreo.setCellValueFactory(new PropertyValueFactory<>("correo"));
        tblTerceros.getSelectionModel().selectedItemProperty()
                .addListener((observable, oldValue, newValue) -> llenarCampos(newValue));
        txtNumeroDocumento.setTextFormatter(new TextFormatter<>(TextFormatterUtil::integerFormat));
        txtPrimerNombre.setTextFormatter(new TextFormatter<>(TextFormatterUtil::upperCaseFormat));
        txtSegundoNombre.setTextFormatter(new TextFormatter<>(TextFormatterUtil::upperCaseFormat));
        txtPrimerApellido.setTextFormatter(new TextFormatter<>(TextFormatterUtil::upperCaseFormat));
        txtSegundoApellido.setTextFormatter(new TextFormatter<>(TextFormatterUtil::upperCaseFormat));
        txtTelefono.setTextFormatter(new TextFormatter<>(TextFormatterUtil::integerFormat));
        cbTipoDocumento.setItems(FXCollections.observableArrayList(TipoDocumento.values()));
        cbTipoUsuario.setItems(FXCollections.observableArrayList(TipoUsuario.CLIENTE,TipoUsuario.PROPIETARIO));

    }

    @FXML
    void onActualizar(ActionEvent event) {

    }

    @FXML
    void onBuscar(ActionEvent event) throws SQLException {
        llenarTablaTerceros(
                INSTANCIA.getInmobiliaria().buscarTercero(txtNumeroDocumento.getText(), txtPrimerNombre.getText(),
                        txtSegundoNombre.getText(), txtPrimerApellido.getText(), txtSegundoApellido.getText(),
                        txtTelefono.getText(), txtCorreo.getText())
        );
    }

    @FXML
    void onCancelarRegistro(ActionEvent event) throws SQLException {
        limpiarCampos();
        tblTerceros.getSelectionModel().clearSelection();
        initialize();
    }

    @FXML
    void onEliminar(ActionEvent event) {

        try{
            INSTANCIA.getInmobiliaria().removerPersonaTerceros(txtNumeroDocumento.getText());
            llenarTablaTerceros(INSTANCIA.getInmobiliaria().buscarTercero(null, null, null, null,null, null, null));
            String documento = txtNumeroDocumento.getText();
            int cargoUsuario = 0;
            if (cbTipoUsuario.getValue() == TipoUsuario.CLIENTE){
                cargoUsuario=1;
            }
            if (cbTipoUsuario.getValue() == TipoUsuario.PROPIETARIO){
                cargoUsuario=2;
            }
            UsuarioBD.eliminarUsuarios(documento, cargoUsuario);
            limpiarCampos();
            tblTerceros.refresh();
            mostrarInformacion("Tercero eliminado correctamente");

        } catch (Exception e) {
            mostrarMensaje(e.getMessage());
        }

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
        try{
            Persona persona = new Persona();
            int tipoUsuario = 0;
            if (cbTipoUsuario.getValue() == TipoUsuario.CLIENTE){
                tipoUsuario=1;
            }
            if (cbTipoUsuario.getValue() == TipoUsuario.PROPIETARIO){
                tipoUsuario=2;
            }
            int tipoDocumento = 0;
            if (cbTipoDocumento.getValue() == TipoDocumento.NIT){
                tipoDocumento=1;
            }
            if (cbTipoDocumento.getValue() == TipoDocumento.CC){
                tipoDocumento=2;
            }
            if (cbTipoDocumento.getValue() == TipoDocumento.CE){
                tipoDocumento=3;
            }
            if (cbTipoDocumento.getValue() == TipoDocumento.PE){
                tipoDocumento=4;
            }
            String numeroDocumento = txtNumeroDocumento.getText();
            String primerNombre = txtPrimerNombre.getText().toUpperCase();
            String segundoNombre = txtSegundoNombre.getText().toUpperCase();
            String primerApellido = txtPrimerApellido.getText().toUpperCase();
            String segundoApellido = txtSegundoApellido.getText().toUpperCase();
            String telefono = txtTelefono.getText();
            String correo = txtCorreo.getText().toLowerCase();

            persona = new Persona(tipoUsuario, tipoDocumento, numeroDocumento, primerNombre, segundoNombre,
                    primerApellido, segundoApellido, telefono, correo);
            persona = Persona.of(tipoUsuario, tipoDocumento, txtNumeroDocumento.getText(), txtPrimerNombre.getText(), txtPrimerApellido.getText(),
                    txtTelefono.getText(), txtCorreo.getText());
            UsuarioBD.crearPersona(persona);
            mostrarInformacion("Persona creada correctamente");
            onCancelarRegistro(event);
            INSTANCIA.getInmobiliaria().adicionarPersonaTerceros(persona);
            llenarTablaTerceros(INSTANCIA.getInmobiliaria().buscarTercero(null, null, null, null, null, null, null));
        } catch (Exception e) {
            mostrarMensaje(e.getMessage());
        }

    }

    private void limpiarCampos(){
        txtCorreo.setText("");
        txtNumeroDocumento.setText("");
        txtPrimerApellido.setText("");
        txtPrimerNombre.setText("");
        txtSegundoApellido.setText("");
        txtSegundoNombre.setText("");
        txtTelefono.setText("");
        cbTipoDocumento.setValue(null);
        cbTipoUsuario.setValue(null);

    }

    private void llenarTablaTerceros(List<Persona> terceros) throws SQLException {
        tblTerceros.setItems(FXCollections.observableArrayList(terceros));
        tblTerceros.refresh();
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
            if(persona.getTipoUsuario() == 1){
                cbTipoUsuario.setValue(TipoUsuario.CLIENTE);
            }
            if(persona.getTipoUsuario() == 2){
                cbTipoUsuario.setValue(TipoUsuario.PROPIETARIO);
            }
            txtPrimerNombre.setText(persona.getPrimerNombre());
            txtSegundoNombre.setText(persona.getSegundoNombre());
            txtPrimerApellido.setText(persona.getPrimerApellido());
            txtSegundoApellido.setText(persona.getSegundoApellido());
            txtTelefono.setText(persona.getTelefono());
            txtCorreo.setText(persona.getCorreo());
        }
    }



    public static void mostrarMensaje(String mensaje) {
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
