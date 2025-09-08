package co.edu.unbosque.model;

public class Farmacia extends Producto {
    
    private String laboratorio;
    private String formatoMedicamento;
    private String formatoDeVenta;
    
    public Farmacia() {
        super();
    }
    
    public Farmacia(String nombre, String descripcion, String tipo, float precio, String marca, 
                   String vendedor, String caracteristicas, String calificacion,
                   String laboratorio, String formatoMedicamento, String formatoDeVenta) {
        super(nombre, descripcion, tipo, precio, marca, vendedor, caracteristicas, calificacion);
        this.laboratorio = laboratorio;
        this.formatoMedicamento = formatoMedicamento;
        this.formatoDeVenta = formatoDeVenta;
    }
    
    public Farmacia(String laboratorio, String formatoMedicamento, String formatoDeVenta) {
        super();
        this.laboratorio = laboratorio;
        this.formatoMedicamento = formatoMedicamento;
        this.formatoDeVenta = formatoDeVenta;
    }
    
    public Farmacia(String laboratorio, String formatoMedicamento, float param1, String formatoDeVenta,
                   float param2, int param3, String param4, String param5, String param6, String param7) {
        super();
        this.laboratorio = laboratorio;
        this.formatoMedicamento = formatoMedicamento;
        this.formatoDeVenta = formatoDeVenta;
    }
    
    public Farmacia(String laboratorio, String formatoMedicamento, float param1, String param2,
                   float param3, int param4, String param5, String param6, String param7,
                   String formatoDeVenta, String param8, String param9, String param10) {
        super();
        this.laboratorio = laboratorio;
        this.formatoMedicamento = formatoMedicamento;
        this.formatoDeVenta = formatoDeVenta;
    }
    
    @Override
    public String usarProducto(String forma) {
        // TODO Auto-generated method stub
        return null;
    }
    
    public String getLaboratorio() {
        return laboratorio;
    }
    
    public void setLaboratorio(String laboratorio) {
        this.laboratorio = laboratorio;
    }
    
    public String getFormatoMedicamento() {
        return formatoMedicamento;
    }
    
    public void setFormatoMedicamento(String formatoMedicamento) {
        this.formatoMedicamento = formatoMedicamento;
    }
    
    public String getFormatoDeVenta() {
        return formatoDeVenta;
    }
    
    public void setFormatoDeVenta(String formatoDeVenta) {
        this.formatoDeVenta = formatoDeVenta;
    }
    
    @Override
    public String toString() {
        return "Farmacia [" + super.toString() + ", laboratorio=" + laboratorio + 
               ", formatoMedicamento=" + formatoMedicamento + ", formatoDeVenta=" + formatoDeVenta + "]";
    }
}
