package co.edu.uniquindio.engesis.proyectofinal.model.propiedades;

public class Material extends Mobiliario{

    private String materialConstruccion;

    public Material(){

    }

    public Material(String materialConstruccion) {
        this.materialConstruccion = materialConstruccion;
    }

    public Material(String numeroCuartos, String numeroBanios, String materialConstruccion) {
        super(numeroCuartos, numeroBanios);
        this.materialConstruccion = materialConstruccion;
    }

    public Material(String numeroPisos, String numeroCuartos, String numeroBanios, String materialConstruccion) {
        super(numeroPisos, numeroCuartos, numeroBanios);
        this.materialConstruccion = materialConstruccion;
    }

    public Material(int propietario, String direccion, int venta, int arriendo, float valorTransaccion, String area, String descripcion, String numeroPisos, String numeroCuartos, String numeroBanios, String materialConstruccion) {
        super(propietario, direccion, venta, arriendo, valorTransaccion, area, descripcion, numeroPisos, numeroCuartos, numeroBanios);
        this.materialConstruccion = materialConstruccion;
    }

    public String getMaterialConstruccion() {
        return materialConstruccion;
    }

    public void setMaterialConstruccion(String materialConstruccion) {
        this.materialConstruccion = materialConstruccion;
    }


}
