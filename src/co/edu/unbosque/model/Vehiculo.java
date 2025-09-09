package co.edu.unbosque.model;

public class Vehiculo extends Producto {

	private boolean esFinanciable;
	private int kilometraje;

	public Vehiculo() {
		super();
	}

	public Vehiculo(boolean esFinanciable, int kilometraje) {
		super();
		this.esFinanciable = esFinanciable;
		this.kilometraje = kilometraje;
	}

	public Vehiculo(String nombre, String descripcion, String tipo, float precio, String marca, String vendedor,
			String caracteristicas, int stock, boolean esFinanciable, int kilometraje) {
		super(nombre, descripcion, tipo, precio, marca, vendedor, caracteristicas, stock);
		this.esFinanciable = esFinanciable;
		this.kilometraje = kilometraje;
	}

	public Vehiculo(String nombre, String descripcion, String tipo, float precio, String marca, String vendedor,
			String caracteristicas, int stock) {
		super(nombre, descripcion, tipo, precio, marca, vendedor, caracteristicas, stock);
		// TODO Auto-generated constructor stub
	}

	public boolean isEsFinanciable() {
		return esFinanciable;
	}

	public void setEsFinanciable(boolean esFinanciable) {
		this.esFinanciable = esFinanciable;
	}

	public int getKilometraje() {
		return kilometraje;
	}

	public void setKilometraje(int kilometraje) {
		this.kilometraje = kilometraje;
	}

	@Override
	public String toString() {
		return "Vehiculo [" + super.toString() + "esFinanciable=" + esFinanciable + ", kilometraje=" + kilometraje
				+ "]";
	}

	@Override
	public String usarProducto(String forma) {
		// TODO Auto-generated method stub
		return null;
	}

}
