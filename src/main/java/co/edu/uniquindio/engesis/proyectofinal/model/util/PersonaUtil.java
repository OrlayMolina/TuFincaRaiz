package co.edu.uniquindio.engesis.proyectofinal.model.util;

import co.edu.uniquindio.engesis.proyectofinal.model.personas.Persona;

import java.time.LocalDate;
import java.util.function.Predicate;

public class PersonaUtil {

    public static Predicate<Persona> buscarPorNumeroIdentificacion(String numeroIdentificacion){
        return persona -> persona.getNumeroDocumento().equals(numeroIdentificacion);
    }

    public static Predicate<Persona> buscarPorNombre(String nombre){
        return persona -> persona.getPrimerNombre().contains(nombre);
    }

    public static Predicate<Persona> buscarPorApellido(String apellido){
        return persona -> persona.getPrimerApellido().contains(apellido);
    }

    public static Predicate<Persona> buscarPorTodo(String numeroDocumento, String primerNombre, String primerApellido) {
        Predicate<Persona> predicado = persona -> true;
        if( numeroDocumento != null && !numeroDocumento.isEmpty() ){
            predicado = predicado.and(buscarPorNumeroIdentificacion(numeroDocumento));
        }
        if( primerNombre != null && !primerNombre.isEmpty() ){
            predicado = predicado.and(buscarPorNombre(primerNombre));
        }
        if( primerApellido != null && !primerApellido.isEmpty() ){
            predicado = predicado.and(buscarPorApellido(primerApellido));
        }
        return predicado;
    }
}
