package co.edu.unbosque.model;

public class Juguete extends Producto {
    
    private String color;
    private String talla;
    private String material;
    private String rangoDeEdad;
    
    public Juguete() {
        super();
    }
    
    public Juguete(String nombre, String descripcion, String tipo, float precio, String marca, 
                   String vendedor, String caracteristicas, String calificacion,
                   String color, String talla, String material, String rangoDeEdad) {
        super(nombre, descripcion, tipo, precio, marca, vendedor, caracteristicas, calificacion);
        this.color = color;
        this.talla = talla;
        this.material = material;
        this.rangoDeEdad = rangoDeEdad;
    }
    
    public Juguete(String color, String talla, String material, String rangoDeEdad) {
        super();
        this.color = color;
        this.talla = talla;
        this.material = material;
        this.rangoDeEdad = rangoDeEdad;
    }
    
    public Juguete(String color, String talla, float param1, String material, float param2,
                   int param3, String rangoDeEdad, String param4, String param5, String param6) {
        super();
        this.color = color;
        this.talla = talla;
        this.material = material;
        this.rangoDeEdad = rangoDeEdad;
    }
    
    public Juguete(String color, String talla, float param1, String material, float param2,
                   int param3, String rangoDeEdad, String param4, String param5, String param6,
                   String param7, String param8, String param9, String param10) {
        super();
        this.color = color;
        this.talla = talla;
        this.material = material;
        this.rangoDeEdad = rangoDeEdad;
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
    
    public String getRangoDeEdad() {
        return rangoDeEdad;
    }
    
    public void setRangoDeEdad(String rangoDeEdad) {
        this.rangoDeEdad = rangoDeEdad;
    }
    
    @Override
    public String toString() {
        return "Juguete [" + super.toString() + ", color=" + color + ", talla=" + talla + 
               ", material=" + material + ", rangoDeEdad=" + rangoDeEdad + "]";
    }
}
