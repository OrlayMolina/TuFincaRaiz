package co.edu.uniquindio.engesis.proyectofinal.model;

import java.sql.SQLException;

public enum InmobiliariaController {
    INSTANCIA;
    private Inmobiliaria inmobiliaria;

    InmobiliariaController() {
        try {
            inmobiliaria = new Inmobiliaria();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Inmobiliaria getInmobiliaria() {
        return inmobiliaria;
    }
}
