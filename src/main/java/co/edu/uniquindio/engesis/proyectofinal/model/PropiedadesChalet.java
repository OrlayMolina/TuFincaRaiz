package co.edu.uniquindio.engesis.proyectofinal.model;

import co.edu.uniquindio.engesis.proyectofinal.model.base.datos.Conexion;
import co.edu.uniquindio.engesis.proyectofinal.model.propiedades.*;
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
    private ComboBox<EnumOpciones> cbAguaPotableChalet;

    @FXML
    private ComboBox<EnumOpciones>  cbAlcantarilladoChalet;

    @FXML
    private ComboBox<EnumOpciones>  cbEnergiaChalet;

    @FXML
    private ComboBox<EnumOpciones>  cbGasChalet;

    @FXML
    private ComboBox<EnumOpciones>  cbInternetChalet;

    @FXML
    private ComboBox<TipoOferta> cbTipoOfertaChalet;

    @FXML
    private Label lblHeaderName;

    @FXML
    private Label lblPrincipal;

    @FXML
    private TableColumn<Propiedad, EnumOpciones> tblAguaChalet;

    @FXML
    private TableColumn<Propiedad, EnumOpciones> tblAlcantarilladoChalet;

    @FXML
    private TableColumn<Propiedad, String> tblAreaChalet;

    @FXML
    private TableView<Propiedad> tblChalet;

    @FXML
    private TableColumn<Propiedad, String> tblCorreo;

    @FXML
    private TableColumn<Propiedad, String> tblDireccionChalet;

    @FXML
    private TableColumn<Propiedad, EnumOpciones> tblEnergiaChalet;

    @FXML
    private TableColumn<Propiedad, EnumOpciones> tblInternetChalet;

    @FXML
    private TableColumn<Propiedad, String> tblMaterialConstruccionChalet;

    @FXML
    private TableColumn<Propiedad, String> tblNumeroBañosChalet;

    @FXML
    private TableColumn<Propiedad, String> tblNumeroCuartosChalet;

    @FXML
    private TableColumn<Propiedad, String> tblNumeroPisosChalet;

    @FXML
    private TableColumn<Propiedad, TipoOferta> tblTipoOfertaChalet;

    @FXML
    private TableColumn<Propiedad, Float> tblValorChalet;

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
    private TextField txtNumeroPisosChalet;

    @FXML
    private TextField txtValorChalet;

    @FXML
    public void initialize() throws SQLException {
        llenarTablaCasa(INSTANCIA.getInmobiliaria().buscarChalet(null, null, null, null, null, null));
        //tblPropietarioChalet.setCellValueFactory(new PropertyValueFactory<>("propietario"));
        tblDireccionChalet.setCellValueFactory(new PropertyValueFactory<>("direccion"));
        tblAreaChalet.setCellValueFactory(new PropertyValueFactory<>("area"));
        tblValorChalet.setCellValueFactory(new PropertyValueFactory<>("valorTransaccion"));
        tblNumeroCuartosChalet.setCellValueFactory(new PropertyValueFactory<>("numeroCuartos"));
        tblNumeroBañosChalet.setCellValueFactory(new PropertyValueFactory<>("numeroBanios"));
        tblNumeroPisosChalet.setCellValueFactory(new PropertyValueFactory<>("numeroPisos"));
        tblMaterialConstruccionChalet.setCellValueFactory(new PropertyValueFactory<>("materialConstruccion"));
        tblChalet.getSelectionModel().selectedItemProperty()
                .addListener((observable, oldValue, newValue) -> llenarCampos((Chalet) newValue));
        txtDireccionChalet.setTextFormatter(new TextFormatter<>(TextFormatterUtil::upperCaseFormat));
        txtAreaChalet.setTextFormatter(new TextFormatter<>(TextFormatterUtil::upperCaseFormat));
        txtMaterialConstruccionChalet.setTextFormatter(new TextFormatter<>(TextFormatterUtil::upperCaseFormat));
        cbTipoOfertaChalet.setItems(FXCollections.observableArrayList(TipoOferta.values()));

    }

    @FXML
    void onActualizar(ActionEvent event) {

    }

    @FXML
    void onBuscar(ActionEvent event) throws SQLException {
        llenarTablaCasa(
                INSTANCIA.getInmobiliaria().buscarChalet(txtMaterialConstruccionChalet.getText(), txtAreaChalet.getText(),
                        txtDireccionChalet.getText(), txtNumeroCuartosChalet.getText(), txtNumeroBañosChalet.getText(), txtNumeroPisosChalet.getText())
        );
    }

    @FXML
    void onCancelarRegistro(ActionEvent event) throws SQLException {
        limpiarCampos();
        tblChalet.getSelectionModel().clearSelection();
        initialize();
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

    private void limpiarCampos(){
        txtMaterialConstruccionChalet.setText("");
        txtNumeroCuartosChalet.setText("");
        txtNumeroBañosChalet.setText("");
        txtNumeroPisosChalet.setText("");
        txtAreaChalet.setText("");
        txtDireccionChalet.setText("");
        txtValorChalet.setText("");
        //txtPropietaroChalet.setText("");
        cbTipoOfertaChalet.setValue(null);

    }

    @FXML
    void onguardar(ActionEvent event) {

    }

    private void llenarCampos(Chalet  chalet) {
        if (chalet != null) {
            Conexion bd_connect = new Conexion();
            String documento ="";
            try (Connection conexion = bd_connect.getConnection()){
                PreparedStatement ps = null;
                ResultSet rs = null;

                String query = "SELECT `numero_documento` FROM `propietarios` WHERE propietarios_id="+chalet.getPropietario();
                ps = conexion.prepareStatement(query);
                rs = ps.executeQuery();
                if (rs.next()) {
                    documento = rs.getString("numero_documento");

                }
            } catch (Exception ex) {
                CrearUsuarios.mostrarMensaje(ex.getMessage());
            }
            if(chalet.getVenta() == 1 && chalet.getArriendo() == 0)
                cbTipoOfertaChalet.setValue(TipoOferta.VENTA);
            if(chalet.getArriendo() ==1 && chalet.getVenta() == 0)
                cbTipoOfertaChalet.setValue(TipoOferta.ARRIENDO);

            //txtP.setText(documento);
            txtNumeroPisosChalet.setText(String.valueOf(chalet.getNumeroPisos()));
            txtNumeroCuartosChalet.setText(String.valueOf(chalet.getNumeroCuartos()));
            txtNumeroBañosChalet.setText(String.valueOf(chalet.getNumeroBanios()));
            txtMaterialConstruccionChalet.setText(chalet.getMaterialConstruccion());
            txtAreaChalet.setText(chalet.getArea());
            txtDireccionChalet.setText(chalet.getDireccion());
            txtValorChalet.setText(String.valueOf(chalet.getValorTransaccion()));
        }
    }

    private void llenarTablaCasa(List<Chalet> chalet) throws SQLException {
        tblChalet.setItems(FXCollections.observableArrayList(chalet));
        tblChalet.refresh();
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

    @FXML
    void onSalirClic(MouseEvent event) {

    }

}
