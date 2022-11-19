package co.edu.uniquindio.engesis.proyectofinal.model.util;

import javafx.scene.control.TextFormatter;

public class TextFormatterUtil {

    public static TextFormatter.Change upperCaseFormat(TextFormatter.Change change){
        change.setText(change.getText().toUpperCase());
        return change;
    }

    public static TextFormatter.Change integerFormat(TextFormatter.Change change){
        if (change.getText().matches("[0-9]*")) {
            return change;
        }
        return null;
    }
}
