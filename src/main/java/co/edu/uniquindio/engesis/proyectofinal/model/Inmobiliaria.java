package co.edu.uniquindio.engesis.proyectofinal.model;

import co.edu.uniquindio.engesis.proyectofinal.model.base.datos.ConversionBD;
import co.edu.uniquindio.engesis.proyectofinal.model.exceptiones.PersonaExisteException;
import co.edu.uniquindio.engesis.proyectofinal.model.exceptiones.PersonaNoExisteException;
import co.edu.uniquindio.engesis.proyectofinal.model.exceptiones.valorRequeridoException;
import co.edu.uniquindio.engesis.proyectofinal.model.personas.Cliente;
import co.edu.uniquindio.engesis.proyectofinal.model.personas.Persona;
import co.edu.uniquindio.engesis.proyectofinal.model.personas.Propietario;
import co.edu.uniquindio.engesis.proyectofinal.model.propiedades.Propiedad;
import co.edu.uniquindio.engesis.proyectofinal.model.util.PersonaUtil;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class Inmobiliaria {

    private final List<Propiedad> propiedades;
    private List<Persona> personas;
    private List<Persona> terceros;


    //private List<Transaccion> transacciones;
    //private List<Informes> informes;

    public Inmobiliaria() throws SQLException {
        propiedades = new ArrayList<>();
        List<Persona> admin = ConversionBD.getAdministradoresBD();
        List<Persona> empleados = ConversionBD.getEmpleadosBD();
        personas = ConversionBD.sumarListas( admin, empleados);
        List<Persona> clientes = ConversionBD.getClientesBD();
        List<Persona> propietarios = ConversionBD.getPropietariosBD();
        terceros = ConversionBD.sumarListasTerceros(clientes, propietarios);

    }


    public void adicionarPersona(Persona persona) throws PersonaExisteException {
        if( buscarPersonaByNumeroIdentificacion( persona.getNumeroDocumento() ).isPresent() ){
            throw new PersonaExisteException();
        }
        personas.add(persona);
    }

    public void removerPersona(String numeroIdentificacion) throws PersonaNoExisteException, valorRequeridoException {
        if(Objects.requireNonNull(numeroIdentificacion,"El número de identificación es requerido").isEmpty()){
            throw new valorRequeridoException("número de identificación");
        }
        Optional<Persona> persona = buscarPersonaByNumeroIdentificacion(numeroIdentificacion);
        if( persona.isEmpty() ){
            throw new PersonaNoExisteException();
        }
        personas.remove(persona.get());
    }

    public Optional<Persona> buscarPersonaByNumeroIdentificacion(String numeroIdentificacion) {
        return personas.stream()
                .filter(PersonaUtil.buscarPorNumeroIdentificacion(numeroIdentificacion))
                .findFirst();
    }

    public void adicionarPersonaTerceros(Persona persona) throws PersonaExisteException {
        if( buscarPersonaByNumeroIdentificacionTerceros( persona.getNumeroDocumento() ).isPresent() ){
            throw new PersonaExisteException();
        }
        terceros.add(persona);
    }

    public void removerPersonaTerceros(String numeroIdentificacion) throws PersonaNoExisteException, valorRequeridoException {
        if(Objects.requireNonNull(numeroIdentificacion,"El número de identificación es requerido").isEmpty()){
            throw new valorRequeridoException("número de identificación");
        }
        Optional<Persona> tercero = buscarPersonaByNumeroIdentificacionTerceros(numeroIdentificacion);
        if( tercero.isEmpty() ){
            throw new PersonaNoExisteException();
        }
        terceros.remove(tercero.get());
    }

    public Optional<Persona> buscarPersonaByNumeroIdentificacionTerceros(String numeroIdentificacion) {
        return terceros.stream()
                .filter(PersonaUtil.buscarPorNumeroIdentificacion(numeroIdentificacion))
                .findFirst();
    }

    public  List<Persona> buscar(String numeroIdentificacion, String primerNombre, String segundoNombre, String primerApellido,
                                 String segundoApellido, String telefono, String correo) throws SQLException {


            return personas.stream()
                .filter(PersonaUtil.buscarPorTodo(numeroIdentificacion, primerNombre, segundoNombre, primerApellido, segundoApellido, telefono, correo))
                .collect(Collectors.toUnmodifiableList());
    }

    public  List<Persona> buscarTercero(String numeroIdentificacion, String primerNombre, String segundoNombre, String primerApellido,
                                 String segundoApellido, String telefono, String correo) throws SQLException {


        return terceros.stream()
                .filter(PersonaUtil.buscarPorTodo(numeroIdentificacion, primerNombre, segundoNombre, primerApellido, segundoApellido, telefono, correo))
                .collect(Collectors.toUnmodifiableList());
    }

}
