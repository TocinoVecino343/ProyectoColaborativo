package co.edu.unbosque.model;

public abstract class Producto {

	private String nombre;
	private String descripcion;
	private String tipo;
	private float precio;
	private String marca;
	private String vendedor;
	private String caracteristicas;
	private int stock;

	public Producto() {
		super();
	}

	public Producto(String nombre, String descripcion, String tipo, float precio, String marca, String vendedor,
			String caracteristicas, int stock) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.tipo = tipo;
		this.precio = precio;
		this.marca = marca;
		this.vendedor = vendedor;
		this.caracteristicas = caracteristicas;
		this.stock = stock;
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

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "Producto [nombre=" + nombre + ", descripcion=" + descripcion + ", tipo=" + tipo + ", precio=" + precio
				+ ", marca=" + marca + ", vendedor=" + vendedor + ", caracteristicas=" + caracteristicas + ", stock="
				+ stock + "]";
	}

	public String comprar(String metodoPago) {
		// TODO Auto-generated method stub
		return null;
	}

	public String valorar(String comentario) {
		return null;
	}
}
