package co.edu.uniquindio.engesis.proyectofinal.model.propiedades;

public class Propiedad {

    private int propietario;
    private String direccion;
    private String tipoOferta;
    private int venta;
    private int arriendo;
    private float valorTransaccion;
    private String area;
    private String descripcion;

    Propiedad() {
    }

    public Propiedad(int propietario, String direccion, int venta, int arriendo, float valorTransaccion, String area, String descripcion) {
        this.propietario = propietario;
        this.direccion = direccion;
        this.venta = venta;
        this.arriendo = arriendo;
        this.valorTransaccion = valorTransaccion;
        this.area = area;
        this.descripcion = descripcion;
    }

    public Propiedad(int propietario, String direccion, String tipoOferta, int venta, int arriendo, float valorTransaccion, String area, String descripcion) {
        this.propietario = propietario;
        this.direccion = direccion;
        this.tipoOferta = tipoOferta;
        this.venta = venta;
        this.arriendo = arriendo;
        this.valorTransaccion = valorTransaccion;
        this.area = area;
        this.descripcion = descripcion;
    }

    public int getPropietario() {
        return propietario;
    }

    public void setPropietario(int propietario) {
        this.propietario = propietario;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getVenta() {
        return venta;
    }

    public void setVenta(int venta) {
        this.venta = venta;
    }

    public int getArriendo() {
        return arriendo;
    }

    public void setArriendo(int arriendo) {
        this.arriendo = arriendo;
    }

    public float getValorTransaccion() {
        return valorTransaccion;
    }

    public void setValorTransaccion(float valorTransaccion) {
        this.valorTransaccion = valorTransaccion;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipoOferta() {
        return tipoOferta;
    }

    public void setTipoOferta(String tipoOferta) {
        this.tipoOferta = tipoOferta;
    }
}
