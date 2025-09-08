package co.edu.unbosque.model;

public class Moda extends Producto {
    
    private String color;
    private String talla;
    private String material;
    
    public Moda() {
        super();
    }
    
    public Moda(String nombre, String descripcion, String tipo, float precio, String marca, 
               String vendedor, String caracteristicas, String calificacion,
               String color, String talla, String material) {
        super(nombre, descripcion, tipo, precio, marca, vendedor, caracteristicas, calificacion);
        this.color = color;
        this.talla = talla;
        this.material = material;
    }
    
    public Moda(String color, String talla, String material) {
        super();
        this.color = color;
        this.talla = talla;
        this.material = material;
    }
    
    public Moda(String color, String talla, float param1, String material, float param2,
               int param3, String param4, String param5, String param6, String param7) {
        super();
        this.color = color;
        this.talla = talla;
        this.material = material;
    }
    
    public Moda(String color, String talla, float param1, String param2, float param3,
               int param4, String param5, String param6, String param7, String material,
               String param8, String param9, String param10) {
        super();
        this.color = color;
        this.talla = talla;
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
    
    public String getTalla() {
        return talla;
    }
    
    public void setTalla(String talla) {
        this.talla = talla;
    }
    
    public String getMaterial() {
        return material;
    }
    
    public void setMaterial(String material) {
        this.material = material;
    }
    
    @Override
    public String toString() {
        return "Moda [" + super.toString() + ", color=" + color + ", talla=" + talla + 
               ", material=" + material + "]";
    }
}
