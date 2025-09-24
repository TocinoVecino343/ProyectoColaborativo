package co.edu.unbosque.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Carrito implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3900628835051746652L;
	private int idAsociado;
	private ArrayList<Item> listaItems;

	public Carrito() {
	}

	public Carrito(int idAsociado, ArrayList<Item> listaItems) {
		super();
		this.idAsociado = idAsociado;
		this.listaItems = listaItems;
	}

	public int getIdAsociado() {
		return idAsociado;
	}

	public void setIdAsociado(int idAsociado) {
		this.idAsociado = idAsociado;
	}

	public ArrayList<Item> getListaItems() {
		return listaItems;
	}

	public void setListaItems(ArrayList<Item> listaItems) {
		this.listaItems = listaItems;
	}

	@Override
	public String toString() {
		return "Carrito [idAsociado=" + idAsociado + ", listaItems=" + listaItems + "]";
	}

}
