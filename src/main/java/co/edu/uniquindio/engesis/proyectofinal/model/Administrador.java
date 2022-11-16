package co.edu.uniquindio.engesis.proyectofinal.model;

import co.edu.uniquindio.engesis.proyectofinal.model.personas.Usuario;

public class Administrador extends Usuario {

    public Administrador() {

    }

    public Administrador(int tipoUsuario, int tipoDocumento, String numeroDocumento, String primerNombre, String primerApellido, String telefono, String correo, String userName, String password) {
        super(tipoUsuario, tipoDocumento, numeroDocumento, primerNombre, primerApellido, telefono, correo, userName, password);
    }

    public Administrador(int tipoUsuario, int tipoDocumento, String numeroDocumento, String primerNombre, String segundoNombre, String primerApellido, String telefono, String correo, String userName, String password) {
        super(tipoUsuario, tipoDocumento, numeroDocumento, primerNombre, segundoNombre, primerApellido, telefono, correo, userName, password);
    }

    public Administrador(int tipoUsuario, int tipoDocumento, String numeroDocumento, String primerNombre, String segundoNombre, String primerApellido, String segundoApellido, String telefono, String correo, String userName, String password) {
        super(tipoUsuario, tipoDocumento, numeroDocumento, primerNombre, segundoNombre, primerApellido, segundoApellido, telefono, correo, userName, password);
    }



}
