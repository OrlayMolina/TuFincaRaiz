package co.edu.uniquindio.engesis.proyectofinal.model.propiedades;

public class Casa extends Material{

    public Casa() {
    }

    public Casa(String materialConstruccion) {
        super(materialConstruccion);
    }

    public Casa(int numeroCuartos, int numeroBanios, String materialConstruccion) {
        super(numeroCuartos, numeroBanios, materialConstruccion);
    }

    public Casa(int numeroPisos, int numeroCuartos, int numeroBanios, String materialConstruccion) {
        super(numeroPisos, numeroCuartos, numeroBanios, materialConstruccion);
    }

    public Casa(int propietario, String direccion, int venta, int arriendo, float valorTransaccion, String area, String descripcion, int numeroPisos, int numeroCuartos, int numeroBanios, String materialConstruccion) {
        super(propietario, direccion, venta, arriendo, valorTransaccion, area, descripcion, numeroPisos, numeroCuartos, numeroBanios, materialConstruccion);
    }

    public Casa(int propietario, String direccion, int venta, int arriendo, float valorTransaccion, String area, int numeroPisos, int numeroCuartos, int numeroBanios, String materialConstruccion) {
        super(propietario, direccion, venta, arriendo, valorTransaccion, area, null, numeroPisos, numeroCuartos, numeroBanios, materialConstruccion);
    }
}
