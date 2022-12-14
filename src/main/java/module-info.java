module com.example.ejemplo {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires java.sql;
    requires javax.mail.api;

    opens co.edu.uniquindio.engesis.proyectofinal.model to javafx.fxml;
    exports co.edu.uniquindio.engesis.proyectofinal.model;
    opens co.edu.uniquindio.engesis.proyectofinal.model.personas to javafx.fxml;
    exports co.edu.uniquindio.engesis.proyectofinal.model.personas;
    opens co.edu.uniquindio.engesis.proyectofinal.model.propiedades to javafx.fxml;
    exports co.edu.uniquindio.engesis.proyectofinal.model.propiedades;
    opens co.edu.uniquindio.engesis.proyectofinal.model.util to javafx.fxml;
    exports co.edu.uniquindio.engesis.proyectofinal.model.util;
    exports co.edu.uniquindio.engesis.proyectofinal.model.exceptiones;
    opens co.edu.uniquindio.engesis.proyectofinal.model.exceptiones to javafx.fxml;
    exports co.edu.uniquindio.engesis.proyectofinal.model.base.datos;
    opens co.edu.uniquindio.engesis.proyectofinal.model.base.datos to javafx.fxml;



}