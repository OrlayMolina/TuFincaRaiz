package co.edu.uniquindio.engesis.proyectofinal.model.exceptiones;

public class PersonaNoExisteException extends Exception{
    public PersonaNoExisteException() {
        super("La persona no existe");
    }
}
