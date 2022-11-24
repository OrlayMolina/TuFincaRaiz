package co.edu.uniquindio.engesis.proyectofinal.model;

import co.edu.uniquindio.engesis.proyectofinal.model.propiedades.Casa;
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
import java.sql.SQLException;
import java.util.List;

import static co.edu.uniquindio.engesis.proyectofinal.model.InmobiliariaController.INSTANCIA;

public class Informes {

    @FXML
    private Button btnGenerarInforme;

    @FXML
    private Button btnLimpiarCampos;

    @FXML
    private Button btnSalir;

    @FXML
    private ComboBox<?> cbTipoPropiedad;

    @FXML
    private Label lblHeaderName;

    @FXML
    private Label lblPrincipal;

    @FXML
    private TableColumn<?, ?> tblDireccionInforme;

    @FXML
    private TableView<?> tblInforme;

    @FXML
    private TableColumn<?, ?> tblPropiedadInforme;

    @FXML
    private TableColumn<?, ?> tblPropietarioInforme;

    @FXML
    private TableColumn<?, ?> tblValorInforme;

    @FXML
    private TextField txPropietarioInforme;

    @FXML
    void onBuscar(ActionEvent event) {

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
    void onSalirInformesClick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("InicioForm.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Tu Finca Raíz | Inicio");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.centerOnScreen();
        stage.show();

    }



    private void llenarTablaInforme(List<Casa> buscarCasa) {
    }

}
