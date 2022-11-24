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

public class Operaciones {

    @FXML
    private Button btnActualizar;

    @FXML
    private Button btnCancelar;

    @FXML
    private Button btnEliminar;

    @FXML
    private Button btnGuardar;

    @FXML
    private Button btnSalir;

    @FXML
    private ComboBox<?> cbTipoOfertaOperaciones;

    @FXML
    private ComboBox<?> cbTipoPropiedadOperaciones;

    @FXML
    private Label lblHeaderName;

    @FXML
    private Label lblPrincipal;

    @FXML
    private TableColumn<?, ?> tblComisionOperaciones;

    @FXML
    private TableView<?> tblInforme;

    @FXML
    private TableColumn<?, ?> tblPropiedadOperaciones;

    @FXML
    private TableColumn<?, ?> tblPropietarioOperaciones;

    @FXML
    private TableColumn<?, ?> tblTipoOfertaOperaciones;

    @FXML
    private TableColumn<?, ?> tblValorOperaciones;

    @FXML
    private TextField txComisionOperaciones;

    @FXML
    private TextField txPropietarioOperaciones;

    @FXML
    private TextField txTransaccionOperaciones;

    @FXML
    void onActualizar(ActionEvent event) {

    }

    @FXML
    void onCancelar(ActionEvent event) {

    }

    @FXML
    void onComboBoxTipoOfertaLote(ActionEvent event) {

    }

    @FXML
    void onEliminar(ActionEvent event) {

    }

    @FXML
    void onGuardar(ActionEvent event) {

    }

    @FXML
    void onSalirClic(MouseEvent event) {

    }

    @FXML
    void onSalirOperaciones(ActionEvent event) throws IOException {
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

}

