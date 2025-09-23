package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.Construccion;

public class ConstruccionDAO implements DAO<Construccion> {

	private ArrayList<Construccion> listaConstruccion;
	private final String SERIAL_FILE_NAME = "Construccion.bin";

	public ConstruccionDAO() {
		listaConstruccion = new ArrayList<>();
		cargarDesdeArchivoSerializado(SERIAL_FILE_NAME);
	}

	@Override
	public void crear(Construccion objeto) {
		listaConstruccion.add(objeto);
		escribirArchivoSerializado();
	}

	@Override
	public String mostrarDatos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean eliminarDato(int indice) {
		if (indice < 0 || indice >= listaConstruccion.size()) {
			return false;
		} else {
			listaConstruccion.remove(indice);
			escribirArchivoSerializado();
			return true;
		}
	}

	@Override
	public boolean actualizar(int indice, Construccion nuevoObjeto) {
		if (indice < 0 || indice >= listaConstruccion.size()) {
			return false;
		} else {
			listaConstruccion.set(indice, nuevoObjeto);
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
		return listaConstruccion.size();
	}

	@Override
	public void cargarDesdeArchivoSerializado(String url) {
		Object contenido = FileHandler.leerDesdeArchivoSerializado(url);
		if (contenido != null) {
			listaConstruccion = (ArrayList<Construccion>) contenido;
		} else {
			listaConstruccion = new ArrayList<Construccion>();
		}

	}

	@Override
	public void escribirArchivoSerializado() {
		FileHandler.escribirEnArchivoSerializado(SERIAL_FILE_NAME, listaConstruccion);

	}

	public ArrayList<Construccion> getListaConstruccion() {
		return listaConstruccion;
	}

	public void setListaConstruccion(ArrayList<Construccion> listaConstruccion) {
		this.listaConstruccion = listaConstruccion;
	}
	
	public int buscarIndicePorId(int id) {
	    ArrayList<Construccion> lista = getListaConstruccion();
	    for (int i = 0; i < lista.size(); i++) {
	        if (lista.get(i).getId() == id) {
	            return i;
	        }
	    }
	    return -1;
	}

}
