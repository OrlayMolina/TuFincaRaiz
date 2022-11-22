package co.edu.uniquindio.engesis.proyectofinal.model.propiedades;

public class Casa extends Material{

    public Casa() {
    }

    public Casa(String materialConstruccion) {
        super(materialConstruccion);
    }

    public Casa(String numeroCuartos, String numeroBanios, String materialConstruccion) {
        super(numeroCuartos, numeroBanios, materialConstruccion);
    }

    public Casa(String numeroPisos, String numeroCuartos, String numeroBanios, String materialConstruccion) {
        super(numeroPisos, numeroCuartos, numeroBanios, materialConstruccion);
    }

    public Casa(int propietario, String direccion, int venta, int arriendo, float valorTransaccion, String area, String descripcion, String numeroPisos, String numeroCuartos, String numeroBanios, String materialConstruccion) {
        super(propietario, direccion, venta, arriendo, valorTransaccion, area, descripcion, numeroPisos, numeroCuartos, numeroBanios, materialConstruccion);
    }

    public Casa(int propietario, String direccion, int venta, int arriendo, float valorTransaccion, String area, String numeroPisos, String numeroCuartos, String numeroBanios, String materialConstruccion) {
        super(propietario, direccion, venta, arriendo, valorTransaccion, area, null, numeroPisos, numeroCuartos, numeroBanios, materialConstruccion);
    }

}
