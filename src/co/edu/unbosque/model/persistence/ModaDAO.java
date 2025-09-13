package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.Moda;

public class ModaDAO implements DAO<Moda> {

	private ArrayList<Moda> listaModa;
	private final String SERIAL_FILE_NAME = "Moda.bin";

	public ModaDAO() {
		listaModa = new ArrayList<Moda>();
		cargarDesdeArchivoSerializado(SERIAL_FILE_NAME);
	}

	@Override
	public void crear(Moda objeto) {
		listaModa.add(objeto);
		escribirArchivoSerializado();

	}

	@Override
	public String mostrarDatos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean eliminarDato(int indice) {
		if (indice < 0 || indice >= listaModa.size()) {
			return false;
		} else {
			listaModa.remove(indice);
			escribirArchivoSerializado();
			return true;
		}
	}

	@Override
	public boolean actualizar(int indice, Moda nuevoObjeto) {
		if (indice < 0 || indice >= listaModa.size()) {
			return false;
		} else {
			listaModa.set(indice, nuevoObjeto);
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
		return listaModa.size();
	}

	@Override
	public void cargarDesdeArchivoSerializado(String url) {
		Object contenido = FileHandler.leerDesdeArchivoSerializado(url);
		if (contenido != null) {
			listaModa = (ArrayList<Moda>) contenido;
		} else {
			listaModa = new ArrayList<Moda>();
		}

	}

	@Override
	public void escribirArchivoSerializado() {
		FileHandler.escribirEnArchivoSerializado(SERIAL_FILE_NAME, listaModa);

	}

}
