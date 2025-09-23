package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.Mascota;

public class MascotaDAO implements DAO<Mascota> {

	private ArrayList<Mascota> listaMascotas;
	private final String SERIAL_FILE_NAME = "Mascotas.bin";

	public MascotaDAO() {
		listaMascotas = new ArrayList<Mascota>();
		cargarDesdeArchivoSerializado(SERIAL_FILE_NAME);
	}

	@Override
	public void crear(Mascota objeto) {
		listaMascotas.add(objeto);
		escribirArchivoSerializado();

	}

	@Override
	public String mostrarDatos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean eliminarDato(int indice) {
		if (indice < 0 || indice >= listaMascotas.size()) {
			return false;
		} else {
			listaMascotas.remove(indice);
			escribirArchivoSerializado();
			return true;
		}
	}

	@Override
	public boolean actualizar(int indice, Mascota nuevoObjeto) {
		if (indice < 0 || indice >= listaMascotas.size()) {
			return false;
		} else {
			listaMascotas.set(indice, nuevoObjeto);
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
		return listaMascotas.size();
	}

	@Override
	public void cargarDesdeArchivoSerializado(String url) {
		Object contenido = FileHandler.leerDesdeArchivoSerializado(url);
		if (contenido != null) {
			listaMascotas = (ArrayList<Mascota>) contenido;
		} else {
			listaMascotas = new ArrayList<Mascota>();
		}

	}

	@Override
	public void escribirArchivoSerializado() {
		FileHandler.escribirEnArchivoSerializado(SERIAL_FILE_NAME, listaMascotas);

	}

	public ArrayList<Mascota> getListaMascotas() {
		return listaMascotas;
	}

	public void setListaMascotas(ArrayList<Mascota> listaMascotas) {
		this.listaMascotas = listaMascotas;
	}
	
	public int buscarIndicePorId(int id) {
	    ArrayList<Mascota> lista = getListaMascotas();
	    for (int i = 0; i < lista.size(); i++) {
	        if (lista.get(i).getId() == id) {
	            return i;
	        }
	    }
	    return -1;
	}
	

}
