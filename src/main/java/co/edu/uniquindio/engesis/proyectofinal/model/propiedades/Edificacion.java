package co.edu.uniquindio.engesis.proyectofinal.model.propiedades;

public class Edificacion extends  Propiedad{

    private int numeroPisos;

    public Edificacion() {

    }

    public Edificacion(int numeroPisos) {
        this.numeroPisos = numeroPisos;
    }

    public Edificacion(int propietario, String direccion, int venta, int arriendo, float valorTransaccion, String area, String descripcion, int numeroPisos) {
        super(propietario, direccion, venta, arriendo, valorTransaccion, area, descripcion);
        this.numeroPisos = numeroPisos;
    }

    public int getNumeroPisos() {
        return numeroPisos;
    }

    public void setNumeroPisos(int numeroPisos) {
        this.numeroPisos = numeroPisos;
    }
}
