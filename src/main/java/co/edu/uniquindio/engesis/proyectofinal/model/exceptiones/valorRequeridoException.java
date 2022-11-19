package co.edu.uniquindio.engesis.proyectofinal.model.exceptiones;

public class valorRequeridoException extends Exception {

    public valorRequeridoException(String nombre) {
        super(String.format("El %s es requerido",nombre));
    }
}
