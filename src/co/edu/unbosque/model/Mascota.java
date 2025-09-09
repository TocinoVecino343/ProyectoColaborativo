package co.edu.unbosque.model;

public class Mascota extends Producto {

	private String tipoAnimal;
	private String raza;
	private String color;
	private String formatoDeVenta;

	public Mascota() {
		super();
	}

	public Mascota(String tipoAnimal, String raza, String color, String formatoDeVenta) {
		super();
		this.tipoAnimal = tipoAnimal;
		this.raza = raza;
		this.color = color;
		this.formatoDeVenta = formatoDeVenta;
	}

	public Mascota(String nombre, String descripcion, String tipo, float precio, String marca, String vendedor,
			String caracteristicas, int stock, String tipoAnimal, String raza, String color, String formatoDeVenta) {
		super(nombre, descripcion, tipo, precio, marca, vendedor, caracteristicas, stock);
		this.tipoAnimal = tipoAnimal;
		this.raza = raza;
		this.color = color;
		this.formatoDeVenta = formatoDeVenta;
	}

	public Mascota(String nombre, String descripcion, String tipo, float precio, String marca, String vendedor,
			String caracteristicas, int stock) {
		super(nombre, descripcion, tipo, precio, marca, vendedor, caracteristicas, stock);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String usarProducto(String forma) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getTipoAnimal() {
		return tipoAnimal;
	}

	public void setTipoAnimal(String tipoAnimal) {
		this.tipoAnimal = tipoAnimal;
	}

	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getFormatoDeVenta() {
		return formatoDeVenta;
	}

	public void setFormatoDeVenta(String formatoDeVenta) {
		this.formatoDeVenta = formatoDeVenta;
	}

	@Override
	public String toString() {
		return "Mascota [" + super.toString() + ", tipoAnimal=" + tipoAnimal + ", raza=" + raza + ", color=" + color
				+ ", formatoDeVenta=" + formatoDeVenta + "]";
	}
}
