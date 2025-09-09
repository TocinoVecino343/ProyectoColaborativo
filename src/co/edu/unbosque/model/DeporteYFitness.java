package co.edu.unbosque.model;

public class DeporteYFitness extends Producto {

	private String color;
	private String material;

	public DeporteYFitness() {
		super();
	}

	public DeporteYFitness(String color, String material) {
		super();
		this.color = color;
		this.material = material;
	}

	public DeporteYFitness(String nombre, String descripcion, String tipo, float precio, String marca, String vendedor,
			String caracteristicas, int stock, String color, String material) {
		super(nombre, descripcion, tipo, precio, marca, vendedor, caracteristicas, stock);
		this.color = color;
		this.material = material;
	}

	public DeporteYFitness(String nombre, String descripcion, String tipo, float precio, String marca, String vendedor,
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
