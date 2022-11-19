package co.edu.uniquindio.engesis.proyectofinal.model;

public enum InmobiliariaController {
    INSTANCIA;
    private final Inmobiliaria inmobiliaria;

    InmobiliariaController() {
        inmobiliaria = new Inmobiliaria();
    }

    public Inmobiliaria getInmobiliaria() {
        return inmobiliaria;
    }
}
