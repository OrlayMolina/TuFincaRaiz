package co.edu.uniquindio.engesis.proyectofinal.model.personas;

import co.edu.uniquindio.engesis.proyectofinal.model.exceptiones.valorRequeridoException;

import java.util.Objects;

public class Persona {
    private int tipoUsuario;
    private int tipoDocumento;
    private String numeroDocumento;
    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;
    private String telefono;
    private String correo;

    public Persona() {
    }

    public Persona(int tipoUsuario, int tipoDocumento, String numeroDocumento, String primerNombre, String segundoNombre,
                   String primerApellido, String segundoApellido, String telefono, String correo) {
        this.tipoUsuario = tipoUsuario;
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.primerNombre = primerNombre;
        this.segundoNombre = segundoNombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.telefono = telefono;
        this.correo = correo;
    }

    public static Persona of(int tipoUsuario, int tipodocumento, String numeroIdentificacion, String primerNombre, String primerApellido,
                             String telefono, String correo) throws valorRequeridoException {
        if(Objects.requireNonNull(primerNombre,"El primer nombre es requerido").isEmpty()){
            throw new valorRequeridoException(" primer nombre");
        }
        if (Objects.requireNonNull(tipodocumento, "El tipo de documento es requerido") == null){
            throw new valorRequeridoException(" tipo de documento");
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
        if(Objects.requireNonNull(telefono,"El teléfono es requerido").isEmpty()){
            throw new valorRequeridoException("teléfono");
        }
        if(Objects.requireNonNull(correo,"El correo es requerido").isEmpty()){
            throw new valorRequeridoException("correo");
        }
        return new Persona(tipoUsuario, tipodocumento, numeroIdentificacion,
                primerNombre, null, primerApellido, null, telefono, correo);
    }

    public int getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(int tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public int getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(int tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) throws Exception {
        if (primerNombre.matches("[0-9]*")) {
            throw new Exception("El nombre no puede contener números");
        }
        if (primerNombre.matches("[!-@]*")) {
            throw new Exception("El nombre no puede contener caracteres especiales");
        }
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
}
