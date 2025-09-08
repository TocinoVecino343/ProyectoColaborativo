package co.edu.unbosque.model;

public abstract class Producto {
    
    protected String nombre;
    protected String descripcion;
    protected String tipo;
    protected float precio;
    protected String marca;
    protected String vendedor;
    protected String caracteristicas;
    protected String calificacion;
    
    public Producto() {
        super();
    }
    
    public Producto(String nombre, String descripcion, String tipo, float precio, String marca, 
                   String vendedor, String caracteristicas, String calificacion) {
        super();
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.precio = precio;
        this.marca = marca;
        this.vendedor = vendedor;
        this.caracteristicas = caracteristicas;
        this.calificacion = calificacion;
    }
    
    public abstract String usarProducto(String forma);
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getDescripcion() {
        return descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public String getTipo() {
        return tipo;
    }
    
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public float getPrecio() {
        return precio;
    }
    
    public void setPrecio(float precio) {
        this.precio = precio;
    }
    
    public String getMarca() {
        return marca;
    }
    
    public void setMarca(String marca) {
        this.marca = marca;
    }
    
    public String getVendedor() {
        return vendedor;
    }
    
    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }
    
    public String getCaracteristicas() {
        return caracteristicas;
    }
    
    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }
    
    public String getCalificacion() {
        return calificacion;
    }
    
    public void setCalificacion(String calificacion) {
        this.calificacion = calificacion;
    }
    
    @Override
    public String toString() {
        return "Producto [nombre=" + nombre + ", descripcion=" + descripcion + ", tipo=" + tipo + 
               ", precio=" + precio + ", marca=" + marca + ", vendedor=" + vendedor + 
               ", caracteristicas=" + caracteristicas + ", calificacion=" + calificacion + "]";
    }
    
    public String comprar(String metodoPago) {
        // TODO Auto-generated method stub
        return null;
    }
    
    public String valorar(String comentario) {
        return null;
    }
}
