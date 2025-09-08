package co.edu.unbosque.model;

public class Electrodomestico extends Producto {
    
    private String modelo;
    private int voltaje;
    private String color;
    
    public Electrodomestico() {
        super();
    }
    
    public Electrodomestico(String nombre, String descripcion, String tipo, float precio, String marca, 
                           String vendedor, String caracteristicas, String calificacion,
                           String modelo, int voltaje, String color) {
        super(nombre, descripcion, tipo, precio, marca, vendedor, caracteristicas, calificacion);
        this.modelo = modelo;
        this.voltaje = voltaje;
        this.color = color;
    }
    
    public Electrodomestico(String modelo, int voltaje, String color) {
        super();
        this.modelo = modelo;
        this.voltaje = voltaje;
        this.color = color;
    }
    
    public Electrodomestico(String modelo, String param1, float param2, String color,
                           float param3, int voltaje, String param4, String param5,
                           String param6, String param7) {
        super();
        this.modelo = modelo;
        this.voltaje = voltaje;
        this.color = color;
    }
    
    public Electrodomestico(String modelo, String param1, float param2, String param3,
                           float param4, int voltaje, String param5, String param6,
                           String param7, String param8, String color, int param9, String param10) {
        super();
        this.modelo = modelo;
        this.voltaje = voltaje;
        this.color = color;
    }
    
    @Override
    public String usarProducto(String forma) {
        // TODO Auto-generated method stub
        return null;
    }
    
    public String getModelo() {
        return modelo;
    }
    
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    
    public String getVoltaje() {
        return String.valueOf(voltaje);
    }
    
    public void setVoltaje(String voltaje) {
        this.voltaje = Integer.parseInt(voltaje);
    }
    
    public String getColor() {
        return color;
    }
    
    public void setColor(String color) {
        this.color = color;
    }
    
    @Override
    public String toString() {
        return "Electrodomestico [" + super.toString() + ", modelo=" + modelo + 
               ", voltaje=" + voltaje + ", color=" + color + "]";
    }
}
