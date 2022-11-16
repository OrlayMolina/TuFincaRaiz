package co.edu.uniquindio.engesis.proyectofinal.model;

public class Empleado extends Usuario {

    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;
    private static String userName;
    private static String password;

    public Empleado() {

    }

    public Empleado(int tipoUsuario, int tipoDocumento, String numeroDocumento, String primerNombre, String primerApellido, String telefono, String correo, String userName, String password) {
        super(tipoUsuario, tipoDocumento, numeroDocumento, primerNombre, primerApellido, telefono, correo, userName, password);
    }

    public Empleado(int tipoUsuario, int tipoDocumento, String numeroDocumento, String primerNombre, String segundoNombre, String primerApellido, String telefono, String correo, String userName, String password) {
        super(tipoUsuario, tipoDocumento, numeroDocumento, primerNombre, segundoNombre, primerApellido, telefono, correo, userName, password);
    }

    public Empleado(int tipoUsuario, int tipoDocumento, String numeroDocumento, String primerNombre, String segundoNombre, String primerApellido, String segundoApellido, String telefono, String correo, String userName, String password) {
        super(tipoUsuario, tipoDocumento, numeroDocumento, primerNombre, segundoNombre, primerApellido, segundoApellido, telefono, correo, userName, password);
    }

    public boolean verificarUsuarioEmpleado(String username, String passwordUser) {
        boolean valido = false;
        if ((username.equals(Empleado.userName)) && (passwordUser.equals(Empleado.password))) {
            valido = true;
        }
        return valido;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public static String getUserName() {
        return userName;
    }

    public static void setUserName(String userName) {
        Empleado.userName = userName;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        Empleado.password = password;
    }
}
