package co.edu.unbosque.model;

public class Vehiculo extends Producto {
    
    private boolean esFinanciable;
    
    public Vehiculo() {
        super();
    }
    
    public Vehiculo(String nombre, String descripcion, String tipo, float precio, String marca, 
                   String vendedor, String caracteristicas, String calificacion,
                   boolean esFinanciable) {
        super(nombre, descripcion, tipo, precio, marca, vendedor, caracteristicas, calificacion);
        this.esFinanciable = esFinanciable;
    }
    
    public Vehiculo(boolean esFinanciable) {
        super();
        this.esFinanciable = esFinanciable;
    }
    
    public Vehiculo(String param1, String param2, float param3, String param4,
                   float param5, int param6, String param7, String param8, String param9, String param10) {
        super();
    }
    
    public Vehiculo(String param1, String param2, float param3, String param4,
                   float param5, int param6, String param7, String param8, String param9,
                   String param10, boolean esFinanciable) {
        super();
        this.esFinanciable = esFinanciable;
    }
    
    @Override
    public String usarProducto(String forma) {
        // TODO Auto-generated method stub
        return null;
    }
    
    public boolean isEsFinanciable() {
        return esFinanciable;
    }
    
    public void setEsFinanciable(boolean esFinanciable) {
        this.esFinanciable = esFinanciable;
    }
    
    @Override
    public String toString() {
        return "Vehiculo [" + super.toString() + ", esFinanciable=" + esFinanciable + "]";
    }
}

