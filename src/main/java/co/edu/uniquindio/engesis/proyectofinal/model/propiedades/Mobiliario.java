package co.edu.uniquindio.engesis.proyectofinal.model.propiedades;

public class Mobiliario extends Edificacion{

    private String numeroCuartos;
    private String numeroBanios;

    public Mobiliario(){

    }

    public Mobiliario(String numeroCuartos, String numeroBanios) {
        this.numeroCuartos = numeroCuartos;
        this.numeroBanios = numeroBanios;
    }

    public Mobiliario(String numeroPisos, String numeroCuartos, String numeroBanios) {
        super(numeroPisos);
        this.numeroCuartos = numeroCuartos;
        this.numeroBanios = numeroBanios;
    }

    public Mobiliario(int propietario, String direccion, int venta, int arriendo, float valorTransaccion, String area, String descripcion, String numeroPisos, String numeroCuartos, String numeroBanios) {
        super(propietario, direccion, venta, arriendo, valorTransaccion, area, descripcion, numeroPisos);
        this.numeroCuartos = numeroCuartos;
        this.numeroBanios = numeroBanios;
    }

    public String getNumeroCuartos() {
        return numeroCuartos;
    }

    public void setNumeroCuartos(String numeroCuartos) {
        this.numeroCuartos = numeroCuartos;
    }

    public String getNumeroBanios() {
        return numeroBanios;
    }

    public void setNumeroBanios(String numeroBanios) {
        this.numeroBanios = numeroBanios;
    }
}
