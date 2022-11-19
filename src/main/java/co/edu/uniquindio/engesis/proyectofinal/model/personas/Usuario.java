package co.edu.uniquindio.engesis.proyectofinal.model.personas;

import co.edu.uniquindio.engesis.proyectofinal.model.exceptiones.valorRequeridoException;

import java.util.Objects;

public class Usuario extends Persona {

    private static String userName;
    private static String password;

    public Usuario(){

    }

    public Usuario(int tipoUsuario, int tipoDocumento, String numeroDocumento, String primerNombre,
                   String primerApellido, String telefono, String correo, String userName, String password) {
        this(tipoUsuario, tipoDocumento, numeroDocumento, primerNombre, null, primerApellido, null, telefono, correo, userName, password);
    }

    public Usuario(int tipoUsuario, int tipoDocumento, String numeroDocumento, String primerNombre,
                   String segundoNombre, String primerApellido, String telefono, String correo, String userName, String password) {
        this(tipoUsuario, tipoDocumento, numeroDocumento, primerNombre, segundoNombre, primerApellido, null, telefono, correo, userName, password);
    }

    public Usuario(int tipoUsuario, int tipoDocumento, String numeroDocumento, String primerNombre, String segundoNombre,
                   String primerApellido, String segundoApellido, String telefono, String correo, String userName, String password) {
        super(tipoUsuario, tipoDocumento, numeroDocumento,primerNombre, segundoNombre, primerApellido, segundoApellido, telefono, correo);
        this.userName = userName;
        this.password = password;
    }

    public static Usuario of(int tipoUsuario, int tipodocumento, String numeroIdentificacion, String primerNombre, String segundoNombre, String primerApellido,
                             String segundoApellido, String telefono, String correo, String nombreUsuario,
                             String contrasenia) throws valorRequeridoException {
        if(Objects.requireNonNull(primerNombre,"El primer nombre es requerido").isEmpty()){
            throw new valorRequeridoException(" primer nombre");
        }
        if (Objects.requireNonNull(tipodocumento, "El tipo de documento es requerido") == null){
            throw new valorRequeridoException(" tipo de documento");
        }
        if(Objects.requireNonNull(segundoNombre,"El segundo nombre es requerido").isEmpty()){
            throw new valorRequeridoException("segundo nombre");
        }
        if(Objects.requireNonNull(numeroIdentificacion,"El número de identificación es requerido").isEmpty()){
            throw new valorRequeridoException("número de identificación");
        }
        if(Objects.requireNonNull(primerApellido,"El apellido es requerido").isEmpty()){
            throw new valorRequeridoException("primer apellido");
        }
        if(Objects.requireNonNull(tipoUsuario, "El tipo de usuario es requerido") == null){
            throw new valorRequeridoException(" tipo de usuario");
        }
        if(Objects.requireNonNull(segundoApellido,"El segundo apellido es requerido").isEmpty()){
            throw new valorRequeridoException("segundo apellido");
        }
        if(Objects.requireNonNull(telefono,"El teléfono es requerido").isEmpty()){
            throw new valorRequeridoException("teléfono");
        }
        if(Objects.requireNonNull(correo,"El correo es requerido").isEmpty()){
            throw new valorRequeridoException("correo");
        }
        if(Objects.requireNonNull(nombreUsuario,"El nombre de usuario es requerido").isEmpty()){
            throw new valorRequeridoException("nombre de usuario");
        }
        if(Objects.requireNonNull(contrasenia,"La contraseña es requerido").isEmpty()){
            throw new valorRequeridoException("contraseña");
        }
        return new Usuario(tipoUsuario, tipodocumento, numeroIdentificacion,
                primerNombre, segundoNombre, primerApellido, segundoApellido, telefono, correo, nombreUsuario, contrasenia);
    }

    public static String getUserName() {
        return userName;
    }

    public static void setUserName(String userName) {
        Usuario.userName = userName;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        Usuario.password = password;
    }
}
