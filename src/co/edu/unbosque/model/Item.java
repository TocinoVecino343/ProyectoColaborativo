package co.edu.unbosque.model;

public class Item {

	private String nombreProducto;
	private float precioProducto;

	public Item() {
		// TODO Auto-generated constructor stub
	}

	public Item(String nombreProducto, float precioProducto) {
		super();
		this.nombreProducto = nombreProducto;
		this.precioProducto = precioProducto;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public float getPrecioProducto() {
		return precioProducto;
	}

	public void setPrecioProducto(float precioProducto) {
		this.precioProducto = precioProducto;
	}

	@Override
	public String toString() {
		return "Item [nombreProducto=" + nombreProducto + ", precioProducto=" + precioProducto + "]";
	}

}
