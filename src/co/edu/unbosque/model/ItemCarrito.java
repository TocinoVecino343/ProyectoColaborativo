package co.edu.unbosque.model;

import java.io.Serializable;

public class ItemCarrito implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2992848633863723321L;
	private String nombreProducto;
	private String descripcionProducto;
	private float precio;

	public ItemCarrito() {
		// TODO Auto-generated constructor stub
	}

	public ItemCarrito(String nombreProducto, String descripcionProducto, float precio) {
		super();
		this.nombreProducto = nombreProducto;
		this.descripcionProducto = descripcionProducto;
		this.precio = precio;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public String getDescripcionProducto() {
		return descripcionProducto;
	}

	public void setDescripcionProducto(String descripcionProducto) {
		this.descripcionProducto = descripcionProducto;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "ItemCarrito [nombreProducto=" + nombreProducto + ", descripcionProducto=" + descripcionProducto
				+ ", precio=" + precio + "]";
	}

}
