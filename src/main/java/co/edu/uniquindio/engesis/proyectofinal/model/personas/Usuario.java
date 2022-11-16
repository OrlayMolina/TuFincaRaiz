package co.edu.uniquindio.engesis.proyectofinal.model.personas;

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
