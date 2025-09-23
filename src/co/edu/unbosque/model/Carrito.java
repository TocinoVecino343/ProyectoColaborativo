package co.edu.unbosque.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Carrito implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3900628835051746652L;
	private String nombreCarrito;
	private int idAsociado;
	private ArrayList<ItemCarrito> listaItems;

	public Carrito() {
		// TODO Auto-generated constructor stub
	}

	public Carrito(String nombreCarrito, int idAsociado, ArrayList<ItemCarrito> listaItems) {
		super();
		this.nombreCarrito = nombreCarrito;
		this.idAsociado = idAsociado;
		this.listaItems = listaItems;
	}

	public String getNombreCarrito() {
		return nombreCarrito;
	}

	public void setNombreCarrito(String nombreCarrito) {
		this.nombreCarrito = nombreCarrito;
	}

	public int getIdAsociado() {
		return idAsociado;
	}

	public void setIdAsociado(int idAsociado) {
		this.idAsociado = idAsociado;
	}

	public ArrayList<ItemCarrito> getListaItems() {
		return listaItems;
	}

	public void setListaItems(ArrayList<ItemCarrito> listaItems) {
		this.listaItems = listaItems;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Carrito [nombreCarrito=" + nombreCarrito + ", idAsociado=" + idAsociado + ", listaItems=" + listaItems
				+ "]";
	}

}
