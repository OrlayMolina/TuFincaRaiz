package co.edu.uniquindio.engesis.proyectofinal.model.exceptiones;

public class PersonaExisteException extends Exception{

    public PersonaExisteException() {
        super("La persona ya esta en el bus");
    }
}
