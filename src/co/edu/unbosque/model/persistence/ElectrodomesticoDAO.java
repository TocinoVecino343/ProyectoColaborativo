package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.Electrodomestico;

public class ElectrodomesticoDAO implements DAO<Electrodomestico> {

	private ArrayList<Electrodomestico> listaElectrodomesticos;
	private final String SERIAL_FILE_NAME = "Electrodomesticos.bin";

	public ElectrodomesticoDAO() {
		listaElectrodomesticos = new ArrayList<Electrodomestico>();
		cargarDesdeArchivoSerializado(SERIAL_FILE_NAME);
	}

	@Override
	public void crear(Electrodomestico objeto) {
		listaElectrodomesticos.add(objeto);
		escribirArchivoSerializado();

	}

	@Override
	public String mostrarDatos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean eliminarDato(int indice) {
		if (indice < 0 || indice >= listaElectrodomesticos.size()) {
			return false;
		} else {
			listaElectrodomesticos.remove(indice);
			escribirArchivoSerializado();
			return true;
		}
	}

	@Override
	public boolean actualizar(int indice, Electrodomestico nuevoObjeto) {
		if (indice < 0 || indice >= listaElectrodomesticos.size()) {
			return false;
		} else {
			listaElectrodomesticos.set(indice, nuevoObjeto);
			escribirArchivoSerializado();
			return true;
		}
	}

	@Override
	public String filtrarLetra(char letra) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String filtrarNombre(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String filtrarMarca(String marca) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int contar() {
		return listaElectrodomesticos.size();
	}

	@Override
	public void cargarDesdeArchivoSerializado(String url) {
		Object contenido = FileHandler.leerDesdeArchivoSerializado(url);
		if (contenido != null) {
			listaElectrodomesticos = (ArrayList<Electrodomestico>) contenido;
		} else {
			listaElectrodomesticos = new ArrayList<Electrodomestico>();
		}

	}

	@Override
	public void escribirArchivoSerializado() {
		FileHandler.escribirEnArchivoSerializado(SERIAL_FILE_NAME, listaElectrodomesticos);

	}

}
