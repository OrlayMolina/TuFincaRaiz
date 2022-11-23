package co.edu.uniquindio.engesis.proyectofinal.model;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

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
    void onSalirInformesClick(ActionEvent event) {

    }

}
