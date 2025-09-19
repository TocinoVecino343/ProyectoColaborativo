package co.edu.unbosque.model;

public class Moda extends Producto {

    private static final long serialVersionUID = 1266125009253022459L;
    private String color;
    private String talla;
    private String material;

    public Moda() {
        super();
    }

    public Moda(String color, String talla, String material) {
        super();
        this.color = color;
        this.talla = talla;
        this.material = material;
    }

    public Moda(String nombre, String descripcion, String tipo, float precio, String marca, String vendedor,
            String caracteristicas, int stock, int idAsociado, String color, String talla, String material, String fotoProducto) {
        super(nombre, descripcion, tipo, precio, marca, vendedor, caracteristicas, stock, idAsociado, fotoProducto);
        this.color = color;
        this.talla = talla;
        this.material = material;
    }

    public Moda(String nombre, String descripcion, String tipo, float precio, String marca, String vendedor,
            String caracteristicas, int stock, int idAsociado) {
        super(nombre, descripcion, tipo, precio, marca, vendedor, caracteristicas, stock, idAsociado, null);
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
        return "Moda [" + super.toString() + ", color=" + color + ", talla=" + talla + ", material=" + material + "]";
    }
}