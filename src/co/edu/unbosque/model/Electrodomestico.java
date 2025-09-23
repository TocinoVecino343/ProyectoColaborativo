package co.edu.unbosque.model;

public class Electrodomestico extends Producto {

    private static final long serialVersionUID = 6010425774154593520L;
    private String modelo;
    private int voltaje;
    private String color;

    public Electrodomestico() {
        super();
    }

    public Electrodomestico(String modelo, int voltaje, String color) {
        super();
        this.modelo = modelo;
        this.voltaje = voltaje;
        this.color = color;
    }

    public Electrodomestico(String nombre, String descripcion, String tipo, float precio, String marca, String vendedor,
            String caracteristicas, int stock,int id, int idAsociado, String modelo, int voltaje, String color, String fotoProducto) {
        super(nombre, descripcion, tipo, precio, marca, vendedor, caracteristicas, stock, id, idAsociado, fotoProducto);
        this.modelo = modelo;
        this.voltaje = voltaje;
        this.color = color;
    }

    public Electrodomestico(String nombre, String descripcion, String tipo, float precio, String marca, String vendedor,
            String caracteristicas, int stock,int id, int idAsociado) {
        super(nombre, descripcion, tipo, precio, marca, vendedor, caracteristicas, stock, id, idAsociado, null);
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getVoltaje() {
        return voltaje;
    }

    public void setVoltaje(int voltaje) {
        this.voltaje = voltaje;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Electrodomestico [" + super.toString() + ", modelo=" + modelo + ", voltaje=" + voltaje + ", color="
                + color + "]";
    }
}