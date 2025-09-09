package co.edu.unbosque.model;

public class Juguete extends Producto {

	private String color;
	private String talla;
	private String material;
	private String rangoDeEdad;

	public Juguete() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Juguete(String color, String talla, String material, String rangoDeEdad) {
		super();
		this.color = color;
		this.talla = talla;
		this.material = material;
		this.rangoDeEdad = rangoDeEdad;
	}

	public Juguete(String nombre, String descripcion, String tipo, float precio, String marca, String vendedor,
			String caracteristicas, int stock, String color, String talla, String material, String rangoDeEdad) {
		super(nombre, descripcion, tipo, precio, marca, vendedor, caracteristicas, stock);
		this.color = color;
		this.talla = talla;
		this.material = material;
		this.rangoDeEdad = rangoDeEdad;
	}

	public Juguete(String nombre, String descripcion, String tipo, float precio, String marca, String vendedor,
			String caracteristicas, int stock) {
		super(nombre, descripcion, tipo, precio, marca, vendedor, caracteristicas, stock);
		// TODO Auto-generated constructor stub
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
		return "Juguete [" + super.toString() + ", color=" + color + ", talla=" + talla + ", material=" + material
				+ ", rangoDeEdad=" + rangoDeEdad + "]";
	}
}
