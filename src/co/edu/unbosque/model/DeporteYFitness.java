package co.edu.unbosque.model;

public class DeporteYFitness extends Producto {
    
    private String color;
    private String material;
    
    public DeporteYFitness() {
        super();
    }
    
    public DeporteYFitness(String nombre, String descripcion, String tipo, float precio, String marca, 
                          String vendedor, String caracteristicas, String calificacion,
                          String color, String material) {
        super(nombre, descripcion, tipo, precio, marca, vendedor, caracteristicas, calificacion);
        this.color = color;
        this.material = material;
    }
    
    public DeporteYFitness(String color, String material) {
        super();
        this.color = color;
        this.material = material;
    }
    
    public DeporteYFitness(String color, String material, float param1, String param2,
                          float param3, int param4, String param5, String param6,
                          String param7, String param8) {
        super();
        this.color = color;
        this.material = material;
    }
    
    public DeporteYFitness(String color, String material, float param1, String param2,
                          float param3, int param4, String param5, String param6,
                          String param7, String param8, String param9, String param10) {
        super();
        this.color = color;
        this.material = material;
    }
    
    @Override
    public String usarProducto(String forma) {
        // TODO Auto-generated method stub
        return null;
    }
    
    public String getColor() {
        return color;
    }
    
    public void setColor(String color) {
        this.color = color;
    }
    
    public String getMaterial() {
        return material;
    }
    
    public void setMaterial(String material) {
        this.material = material;
    }
    
    @Override
    public String toString() {
        return "DeporteYFitness [" + super.toString() + ", color=" + color + ", material=" + material + "]";
    }
}
