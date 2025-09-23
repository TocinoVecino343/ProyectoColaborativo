package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.ItemCarrito;

public class ItemDAO {

	private ArrayList<ItemCarrito> listaItems;
	private final String SERIAL_FILE_NAME = "ItemsCarrito.bin";

	public ItemDAO() {
		listaItems = new ArrayList<>();
		cargarDesdeArchivoSerializado(SERIAL_FILE_NAME);
	}

	public void crear(ItemCarrito nuevoItem) {
		listaItems.add(nuevoItem);
		escribirArchivoSerializado();
	}

	public boolean actualizar(int indice, ItemCarrito itemActualizado) {
		if (indice < 0 || indice >= listaItems.size())
			return false;
		listaItems.set(indice, itemActualizado);
		escribirArchivoSerializado();
		return true;
	}

	public boolean eliminar(int indice) {
		if (indice < 0 || indice >= listaItems.size())
			return false;
		listaItems.remove(indice);
		escribirArchivoSerializado();
		return true;
	}

	public void cargarDesdeArchivoSerializado(String url) {
		Object contenido = FileHandler.leerDesdeArchivoSerializado(url);
		if (contenido != null) {
			listaItems = (ArrayList<ItemCarrito>) contenido;
		} else {
			listaItems = new ArrayList<>();
		}
	}

	public void escribirArchivoSerializado() {
		FileHandler.escribirEnArchivoSerializado(SERIAL_FILE_NAME, listaItems);
	}
}
