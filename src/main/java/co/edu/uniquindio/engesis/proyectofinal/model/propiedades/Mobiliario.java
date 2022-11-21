package co.edu.uniquindio.engesis.proyectofinal.model.propiedades;

public class Mobiliario extends Edificacion{

    private int numeroCuartos;
    private int numeroBanios;

    public Mobiliario(){

    }

    public Mobiliario(int numeroCuartos, int numeroBanios) {
        this.numeroCuartos = numeroCuartos;
        this.numeroBanios = numeroBanios;
    }

    public Mobiliario(int numeroPisos, int numeroCuartos, int numeroBanios) {
        super(numeroPisos);
        this.numeroCuartos = numeroCuartos;
        this.numeroBanios = numeroBanios;
    }

    public Mobiliario(int propietario, String direccion, int venta, int arriendo, float valorTransaccion, String area, String descripcion, int numeroPisos, int numeroCuartos, int numeroBanios) {
        super(propietario, direccion, venta, arriendo, valorTransaccion, area, descripcion, numeroPisos);
        this.numeroCuartos = numeroCuartos;
        this.numeroBanios = numeroBanios;
    }

    public int getNumeroCuartos() {
        return numeroCuartos;
    }

    public void setNumeroCuartos(int numeroCuartos) {
        this.numeroCuartos = numeroCuartos;
    }

    public int getNumeroBanios() {
        return numeroBanios;
    }

    public void setNumeroBanios(int numeroBanios) {
        this.numeroBanios = numeroBanios;
    }
}
