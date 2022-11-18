package co.edu.uniquindio.engesis.proyectofinal.model.util;

import co.edu.uniquindio.engesis.proyectofinal.model.personas.Persona;

import java.util.function.Predicate;

public class PersonaUtil {

    public static Predicate<Persona> buscarPorNumeroIdentificacion(String numeroIdentificacion){
        return persona -> persona.getNumeroDocumento().equals(numeroIdentificacion);
    }

    public static Predicate<Persona> buscarPorPrimerNombre(String primerNombre){
        return persona -> persona.getPrimerNombre().contains(primerNombre);
    }

    public static Predicate<Persona> buscarPorSegundoNombre(String segundoNombre){
        return persona -> persona.getPrimerNombre().contains(segundoNombre);
    }

    public static Predicate<Persona> buscarPorPrimerApellido(String primerApellido){
        return persona -> persona.getPrimerApellido().contains(primerApellido);
    }

    public static Predicate<Persona> buscarPorSegundoApellido(String segundoApellido){
        return persona -> persona.getPrimerApellido().contains(segundoApellido);
    }

    public static Predicate<Persona> buscarPorTelefono(String telefono){
        return persona -> persona.getTelefono().contains(telefono);
    }

    public static Predicate<Persona> buscarPorCorreo(String correo){
        return persona -> persona.getTelefono().contains(correo);
    }

    public static Predicate<Persona> buscarPorTodo(String numeroDocumento, String primerNombre, String segundoNombre,
                                                   String primerApellido, String segundoApellido, String telefono, String correo) {
        Predicate<Persona> predicado = persona -> true;
        if( numeroDocumento != null && !numeroDocumento.isEmpty() ){
            predicado = predicado.and(buscarPorNumeroIdentificacion(numeroDocumento));
        }
        if( primerNombre != null && !primerNombre.isEmpty() ){
            predicado = predicado.and(buscarPorPrimerNombre(primerNombre));
        }
        if( segundoNombre != null && !segundoNombre.isEmpty() ){
            predicado = predicado.and(buscarPorSegundoNombre(segundoNombre));
        }
        if( primerApellido != null && !primerApellido.isEmpty() ){
            predicado = predicado.and(buscarPorPrimerApellido(primerApellido));
        }
        if( segundoApellido != null && !segundoApellido.isEmpty() ){
            predicado = predicado.and(buscarPorSegundoApellido(segundoApellido));
        }
        if( telefono != null && !telefono.isEmpty() ){
            predicado = predicado.and(buscarPorTelefono(telefono));
        }
        if( correo != null && !correo.isEmpty() ){
            predicado = predicado.and(buscarPorCorreo(correo));
        }
        return predicado;
    }
}
