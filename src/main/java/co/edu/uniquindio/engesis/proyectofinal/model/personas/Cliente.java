package co.edu.uniquindio.engesis.proyectofinal.model.personas;

public class Cliente extends Persona{

    public Cliente() {
    }

    public Cliente(int tipoUsuario, int tipoDocumento, String numeroDocumento, String primerNombre, String segundoNombre, String primerApellido, String segundoApellido, String telefono, String correo) {
        super(tipoUsuario, tipoDocumento, numeroDocumento, primerNombre, segundoNombre, primerApellido, segundoApellido, telefono, correo);
    }

    public Cliente(int tipoUsuario, int tipoDocumento, String numeroDocumento, String primerNombre, String primerApellido, String segundoApellido, String telefono, String correo) {
        super(tipoUsuario, tipoDocumento, numeroDocumento, primerNombre, null, primerApellido, segundoApellido, telefono, correo);
    }

    public Cliente(int tipoUsuario, int tipoDocumento, String numeroDocumento, String primerNombre, String primerApellido, String telefono, String correo) {
        super(tipoUsuario, tipoDocumento, numeroDocumento, primerNombre, null, primerApellido, null, telefono, correo);
    }

}
