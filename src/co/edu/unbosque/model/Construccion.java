package co.edu.unbosque.model;

public class Construccion extends Producto {
    
    private String modelo;
    private String material;
    private String color;
    private float largo;
    private float ancho;
    private float altura;
    
    public Construccion() {
        super();
    }
    
    public Construccion(String nombre, String descripcion, String tipo, float precio, String marca, 
                       String vendedor, String caracteristicas, String calificacion,
                       String modelo, String material, String color, float largo, float ancho, float altura) {
        super(nombre, descripcion, tipo, precio, marca, vendedor, caracteristicas, calificacion);
        this.modelo = modelo;
        this.material = material;
        this.color = color;
        this.largo = largo;
        this.ancho = ancho;
        this.altura = altura;
    }
    
    public Construccion(String modelo, String material, String color, float largo, float ancho, float altura) {
        super();
        this.modelo = modelo;
        this.material = material;
        this.color = color;
        this.largo = largo;
        this.ancho = ancho;
        this.altura = altura;
    }
    
    public Construccion(String modelo, String material, float largo, String color,
                       float ancho, int param1, String param2, String param3,
                       String param4, String param5, String param6, String param7,
                       String param8, float altura, float param9, float param10) {
        super();
        this.modelo = modelo;
        this.material = material;
        this.color = color;
        this.largo = largo;
        this.ancho = ancho;
        this.altura = altura;
    }
    
    public Construccion(String modelo, String material, float largo, String color,
                       float ancho, int param1, String param2, String param3,
                       String param4, String param5) {
        super();
        this.modelo = modelo;
        this.material = material;
        this.color = color;
        this.largo = largo;
        this.ancho = ancho;
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
    
    public String getMaterial() {
        return material;
    }
    
    public void setMaterial(String material) {
        this.material = material;
    }
    
    public String getColor() {
        return color;
    }
    
    public void setColor(String color) {
        this.color = color;
    }
    
    public float getLargo() {
        return largo;
    }
    
    public void setLargo(float largo) {
        this.largo = largo;
    }
    
    public float getAncho() {
        return ancho;
    }
    
    public void setAncho(float ancho) {
        this.ancho = ancho;
    }
    
    public float getAltura() {
        return altura;
    }
    
    public void setAltura(float altura) {
        this.altura = altura;
    }
    
    @Override
    public String toString() {
        return "Construccion [" + super.toString() + ", modelo=" + modelo + ", material=" + material + 
               ", color=" + color + ", largo=" + largo + ", ancho=" + ancho + ", altura=" + altura + "]";
    }
}
