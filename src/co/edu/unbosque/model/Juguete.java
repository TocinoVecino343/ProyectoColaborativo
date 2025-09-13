package co.edu.unbosque.model;

public class Juguete extends Producto {

	private static final long serialVersionUID = 3785398777901755972L;
	private String color;
	private String material;
	private String rangoDeEdad;

	public Juguete() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Juguete(String color, String material, String rangoDeEdad) {
		super();
		this.color = color;
		this.material = material;
		this.rangoDeEdad = rangoDeEdad;
	}

	public Juguete(String nombre, String descripcion, String tipo, float precio, String marca, String vendedor,
			String caracteristicas, int stock, int idAsociado, String color, String material, String rangoDeEdad) {
		super(nombre, descripcion, tipo, precio, marca, vendedor, caracteristicas, stock, idAsociado);
		this.color = color;
		this.material = material;
		this.rangoDeEdad = rangoDeEdad;
	}

	public Juguete(String nombre, String descripcion, String tipo, float precio, String marca, String vendedor,
			String caracteristicas, int stock, int idAsociado) {
		super(nombre, descripcion, tipo, precio, marca, vendedor, caracteristicas, stock, idAsociado);
		// TODO Auto-generated constructor stub
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

	public String getRangoDeEdad() {
		return rangoDeEdad;
	}

	public void setRangoDeEdad(String rangoDeEdad) {
		this.rangoDeEdad = rangoDeEdad;
	}

	@Override
	public String toString() {
		return "Juguete [" + super.toString() + ", color=" + color + ", material=" + material + ", rangoDeEdad="
				+ rangoDeEdad + "]";
	}
}
