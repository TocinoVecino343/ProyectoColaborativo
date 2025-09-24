package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.Carrito;
import co.edu.unbosque.model.Item;

public class CarritoDAO {

	private ArrayList<Carrito> listaCarritos;
	private final String SERIAL_FILE_NAME = "Carritos.bin";

	public CarritoDAO() {
		listaCarritos = new ArrayList<>();
		cargarDesdeArchivoSerializado(SERIAL_FILE_NAME);
	}

	public void crear(Carrito nuevoCarrito) {
		listaCarritos.add(nuevoCarrito);
		escribirArchivoSerializado();
	}

	public boolean actualizar(int indice, Carrito carritoActualizado) {
		if (indice < 0 || indice >= listaCarritos.size())
			return false;
		listaCarritos.set(indice, carritoActualizado);
		escribirArchivoSerializado();
		return true;
	}

	public boolean eliminar(int indice) {
		if (indice < 0 || indice >= listaCarritos.size())
			return false;
		listaCarritos.remove(indice);
		escribirArchivoSerializado();
		return true;
	}

	public boolean buscarCarrito(int idAsociado) {
		boolean resultado = false;
		for (int i = -0; i < listaCarritos.size(); i++) {
			if (listaCarritos.get(i).getIdAsociado() == idAsociado) {
				resultado = true;
				break;
			}
		}
		return resultado;

	}

	public int buscarIndiceCarrito(int idUsuario) {
		int indice = -1;
		for (int i = 0; i < listaCarritos.size(); i++) {
			if (listaCarritos.get(i).getIdAsociado() == idUsuario) {
				indice = i;
				break;
			}
		}
		if (indice == -1) {
			ArrayList<Item> listaItems = new ArrayList<Item>();
			Carrito temp = new Carrito(idUsuario, listaItems);
			crear(temp);
		}

		for (int i = 0; i < listaCarritos.size(); i++) {
			if (listaCarritos.get(i).getIdAsociado() == idUsuario) {
				indice = i;
				break;
			}
		}
		return indice;

	}

	public void cargarDesdeArchivoSerializado(String url) {
		Object contenido = FileHandler.leerDesdeArchivoSerializado(url);
		if (contenido != null) {
			listaCarritos = (ArrayList<Carrito>) contenido;
		} else {
			listaCarritos = new ArrayList<>();
		}
	}

	public void escribirArchivoSerializado() {
		FileHandler.escribirEnArchivoSerializado(SERIAL_FILE_NAME, listaCarritos);
	}

	public ArrayList<Carrito> getListaCarritos() {
		return listaCarritos;
	}

	public void setListaCarritos(ArrayList<Carrito> listaCarritos) {
		this.listaCarritos = listaCarritos;
	}

}
