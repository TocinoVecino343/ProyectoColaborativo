package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.Farmacia;

public class FarmaciaDAO implements DAO<Farmacia> {

	private ArrayList<Farmacia> listaFarmacia;
	private final String SERIAL_FILE_NAME = "Farmacia.bin";

	public FarmaciaDAO() {
		listaFarmacia = new ArrayList<Farmacia>();
		cargarDesdeArchivoSerializado(SERIAL_FILE_NAME);
	}

	@Override
	public void crear(Farmacia objeto) {
		listaFarmacia.add(objeto);
		escribirArchivoSerializado();

	}

	@Override
	public String mostrarDatos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean eliminarDato(int indice) {
		if (indice < 0 || indice >= listaFarmacia.size()) {
			return false;
		} else {
			listaFarmacia.remove(indice);
			escribirArchivoSerializado();
			return true;
		}
	}

	@Override
	public boolean actualizar(int indice, Farmacia nuevoObjeto) {
		if (indice < 0 || indice >= listaFarmacia.size()) {
			return false;
		} else {
			listaFarmacia.set(indice, nuevoObjeto);
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
		return listaFarmacia.size();
	}

	@Override
	public void cargarDesdeArchivoSerializado(String url) {
		Object contenido = FileHandler.leerDesdeArchivoSerializado(url);
		if (contenido != null) {
			listaFarmacia = (ArrayList<Farmacia>) contenido;
		} else {
			listaFarmacia = new ArrayList<Farmacia>();
		}
	}

	@Override
	public void escribirArchivoSerializado() {
		FileHandler.escribirEnArchivoSerializado(SERIAL_FILE_NAME, listaFarmacia);

	}

	public ArrayList<Farmacia> getListaFarmacia() {
		return listaFarmacia;
	}

	public void setListaFarmacia(ArrayList<Farmacia> listaFarmacia) {
		this.listaFarmacia = listaFarmacia;
	}
	
	@Override
	public int buscarIndicePorId(int id) {
	    ArrayList<Farmacia> lista = getListaFarmacia();
	    for (int i = 0; i < lista.size(); i++) {
	        if (lista.get(i).getId() == id) {
	            return i;
	        }
	    }
	    return -1;
	}

}
