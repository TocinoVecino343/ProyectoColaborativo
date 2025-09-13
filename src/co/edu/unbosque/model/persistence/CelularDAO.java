package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.Celular;

public class CelularDAO implements DAO<Celular> {

	private ArrayList<Celular> listaCelulares;
	private final String SERIAL_FILE_NAME = "Celulares.bin";

	public CelularDAO() {
		listaCelulares = new ArrayList<Celular>();
		cargarDesdeArchivoSerializado(SERIAL_FILE_NAME);
	}

	@Override
	public void crear(Celular objeto) {
		listaCelulares.add(objeto);
		escribirArchivoSerializado();
	}

	@Override
	public String mostrarDatos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean eliminarDato(int indice) {
		if (indice < 0 || indice >= listaCelulares.size()) {
			return false;
		} else {
			listaCelulares.remove(indice);
			escribirArchivoSerializado();
			return true;
		}
	}

	@Override
	public boolean actualizar(int indice, Celular nuevoObjeto) {
		if (indice < 0 || indice >= listaCelulares.size()) {
			return false;
		} else {
			listaCelulares.set(indice, nuevoObjeto);
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
		return listaCelulares.size();
	}

	@Override
	public void cargarDesdeArchivoSerializado(String url) {
		Object contenido = FileHandler.leerDesdeArchivoSerializado(url);
		if (contenido != null) {
			listaCelulares = (ArrayList<Celular>) contenido;
		} else {
			listaCelulares = new ArrayList<Celular>();
		}
	}

	@Override
	public void escribirArchivoSerializado() {
		FileHandler.escribirEnArchivoSerializado(SERIAL_FILE_NAME, listaCelulares);

	}

}
