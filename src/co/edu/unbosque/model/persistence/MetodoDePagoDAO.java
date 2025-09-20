package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.MetodoDePago;

public class MetodoDePagoDAO {

	private ArrayList<MetodoDePago> listaMetodosDePago;
	private final String SERIAL_FILE_NAME = "MetodosDePago.bin";

	public MetodoDePagoDAO() {
		listaMetodosDePago = new ArrayList<MetodoDePago>();
		cargarDesdeArchivoSerializado(SERIAL_FILE_NAME);
	}

	public void crear(MetodoDePago nuevoMetodoDePago) {
		listaMetodosDePago.add(nuevoMetodoDePago);
		escribirArchivoSerializado();
	}

	public boolean actualizar(int indice, MetodoDePago metodoDePagoActualizado) {
		if (indice < 0 || indice >= listaMetodosDePago.size())
			return false;
		listaMetodosDePago.set(indice, metodoDePagoActualizado);
		escribirArchivoSerializado();
		return true;
	}

	public boolean eliminar(int indice) {
		if (indice < 0 || indice >= listaMetodosDePago.size())
			return false;
		listaMetodosDePago.remove(indice);
		escribirArchivoSerializado();
		return true;
	}

	public void cargarDesdeArchivoSerializado(String url) {
		Object contenido = FileHandler.leerDesdeArchivoSerializado(url);
		if (contenido != null) {
			listaMetodosDePago = (ArrayList<MetodoDePago>) contenido;
		} else {
			listaMetodosDePago = new ArrayList<>();
		}
	}

	public void escribirArchivoSerializado() {
		FileHandler.escribirEnArchivoSerializado(SERIAL_FILE_NAME, listaMetodosDePago);
	}

	public ArrayList<MetodoDePago> getListaMetodosDePago() {
		return listaMetodosDePago;
	}

	public void setListaMetodosDePago(ArrayList<MetodoDePago> listaMetodosDePago) {
		this.listaMetodosDePago = listaMetodosDePago;
	}
	
	
}
