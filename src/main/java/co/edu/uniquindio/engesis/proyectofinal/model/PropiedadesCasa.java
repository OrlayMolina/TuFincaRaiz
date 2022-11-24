package co.edu.uniquindio.engesis.proyectofinal.model;

import co.edu.uniquindio.engesis.proyectofinal.model.base.datos.Conexion;
import co.edu.uniquindio.engesis.proyectofinal.model.propiedades.Casa;
import co.edu.uniquindio.engesis.proyectofinal.model.propiedades.Propiedad;
import co.edu.uniquindio.engesis.proyectofinal.model.propiedades.TipoOferta;
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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static co.edu.uniquindio.engesis.proyectofinal.model.InmobiliariaController.INSTANCIA;

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
    private Label lblHeaderName;

    @FXML
    private Label lblPrincipal;

    @FXML
    private TableColumn<Propiedad, String> tblAreaCasa;

    @FXML
    private TableView<Propiedad> tblCasa;

    @FXML
    private TableColumn<Propiedad, String> tblDireccionCasa;

    @FXML
    private TableColumn<Propiedad, String> tblMaterialConstruccionCasa;

    @FXML
    private TableColumn<Propiedad, Integer> tblNumeroBañosCasa;

    @FXML
    private TableColumn<Propiedad, Integer> tblNumeroCuartosCasa;

    @FXML
    private TableColumn<Propiedad, Integer> tblNumeroPisosCasa;

    @FXML
    private TableColumn<Propiedad, Integer> tblPropietarioCasa;

    @FXML
    private TableColumn<Propiedad, TipoOferta> tblTipoOfertaCasa;

    @FXML
    private TableColumn<Propiedad, Float> tblValorCasa;

    @FXML
    private TextField txtAreaCasa;

    @FXML
    private TextField txtDireccionCasa;

    @FXML
    private TextField txtPropietaroCasa;

    @FXML
    private TextField txtMaterialConstruccionCasa;

    @FXML
    private TextField txtNumeroBañosCasa;

    @FXML
    private TextField txtNumeroCuartosCasa;

    @FXML
    private TextField txtNumeroPisosCasa;

    @FXML
    private TextField txtValorCasa;

    @FXML
    public void initialize() throws SQLException {
        llenarTablaCasa(INSTANCIA.getInmobiliaria().buscarCasa(null, null, null, null, null, null));
        tblPropietarioCasa.setCellValueFactory(new PropertyValueFactory<>("propietario"));
        tblDireccionCasa.setCellValueFactory(new PropertyValueFactory<>("direccion"));
        tblAreaCasa.setCellValueFactory(new PropertyValueFactory<>("area"));
        tblValorCasa.setCellValueFactory(new PropertyValueFactory<>("valorTransaccion"));
        tblNumeroCuartosCasa.setCellValueFactory(new PropertyValueFactory<>("numeroCuartos"));
        tblNumeroBañosCasa.setCellValueFactory(new PropertyValueFactory<>("numeroBanios"));
        tblNumeroPisosCasa.setCellValueFactory(new PropertyValueFactory<>("numeroPisos"));
        tblMaterialConstruccionCasa.setCellValueFactory(new PropertyValueFactory<>("materialConstruccion"));
        tblCasa.getSelectionModel().selectedItemProperty()
                .addListener((observable, oldValue, newValue) -> llenarCampos((Casa) newValue));
        txtDireccionCasa.setTextFormatter(new TextFormatter<>(TextFormatterUtil::upperCaseFormat));
        txtAreaCasa.setTextFormatter(new TextFormatter<>(TextFormatterUtil::upperCaseFormat));
        txtMaterialConstruccionCasa.setTextFormatter(new TextFormatter<>(TextFormatterUtil::upperCaseFormat));
        cbTipoOfertaCasa.setItems(FXCollections.observableArrayList(TipoOferta.values()));

    }

    @FXML
    void onActualizar(ActionEvent event) {

    }

    @FXML
    void onBuscar(ActionEvent event) throws SQLException {
        llenarTablaCasa(
                INSTANCIA.getInmobiliaria().buscarCasa(txtMaterialConstruccionCasa.getText(), txtAreaCasa.getText(),
                        txtDireccionCasa.getText(), txtNumeroCuartosCasa.getText(), txtNumeroBañosCasa.getText(), txtNumeroPisosCasa.getText())
        );
    }

    @FXML
    void onCancelarRegistro(ActionEvent event) throws SQLException {
        limpiarCampos();
        tblCasa.getSelectionModel().clearSelection();
        initialize();
    }

    @FXML
    void onComboBoxTipoOfertaCasa(ActionEvent event) {

    }

    @FXML
    void onEliminar(ActionEvent event) {

    }

    @FXML
    void onSalirCasaClick(ActionEvent event) throws IOException {
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

    private void limpiarCampos(){
        txtMaterialConstruccionCasa.setText("");
        txtNumeroCuartosCasa.setText("");
        txtNumeroBañosCasa.setText("");
        txtNumeroPisosCasa.setText("");
        txtAreaCasa.setText("");
        txtDireccionCasa.setText("");
        txtValorCasa.setText("");
        txtPropietaroCasa.setText("");
        cbTipoOfertaCasa.setValue(null);

    }

    private void llenarCampos(Casa casa) {
        if (casa != null) {
            Conexion bd_connect = new Conexion();
            String documento ="";
            try (Connection conexion = bd_connect.getConnection()){
                PreparedStatement ps = null;
                ResultSet rs = null;

                String query = "SELECT `numero_documento` FROM `propietarios` WHERE propietarios_id="+casa.getPropietario();
                ps = conexion.prepareStatement(query);
                rs = ps.executeQuery();
                if (rs.next()) {
                    documento = rs.getString("numero_documento");

                }
            } catch (Exception ex) {
                CrearUsuarios.mostrarMensaje(ex.getMessage());
            }
            if(casa.getVenta() == 1 && casa.getArriendo() == 0)
                cbTipoOfertaCasa.setValue(TipoOferta.VENTA);
            if(casa.getArriendo() ==1 && casa.getVenta() == 0)
                cbTipoOfertaCasa.setValue(TipoOferta.ARRIENDO);
            txtPropietaroCasa.setText(documento);
            txtNumeroPisosCasa.setText(String.valueOf(casa.getNumeroPisos()));
            txtNumeroCuartosCasa.setText(String.valueOf(casa.getNumeroCuartos()));
            txtNumeroBañosCasa.setText(String.valueOf(casa.getNumeroBanios()));
            txtMaterialConstruccionCasa.setText(casa.getMaterialConstruccion());
            txtAreaCasa.setText(casa.getArea());
            txtDireccionCasa.setText(casa.getDireccion());
            txtValorCasa.setText(String.valueOf(casa.getValorTransaccion()));
        }
    }

    private void llenarTablaCasa(List<Casa> casas) throws SQLException {
        tblCasa.setItems(FXCollections.observableArrayList(casas));
        tblCasa.refresh();
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

