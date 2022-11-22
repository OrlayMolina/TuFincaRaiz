package co.edu.uniquindio.engesis.proyectofinal.model.propiedades;

public class Edificacion extends  Propiedad{

    private String numeroPisos;

    public Edificacion() {

    }

    public Edificacion(String numeroPisos) {
        this.numeroPisos = numeroPisos;
    }

    public Edificacion(int propietario, String direccion, int venta, int arriendo, float valorTransaccion, String area, String descripcion, String numeroPisos) {
        super(propietario, direccion, venta, arriendo, valorTransaccion, area, descripcion);
        this.numeroPisos = numeroPisos;
    }

    public String getNumeroPisos() {
        return numeroPisos;
    }

    public void setNumeroPisos(String numeroPisos) {
        this.numeroPisos = numeroPisos;
    }
}
