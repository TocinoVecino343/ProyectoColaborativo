package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.Juguete;

public class JugueteDAO implements DAO<Juguete> {

	private ArrayList<Juguete> listaJuguetes;
	private final String SERIAL_FILE_NUMBER = "Juguetes.bin";

	public JugueteDAO() {
		listaJuguetes = new ArrayList<Juguete>();
		cargarDesdeArchivoSerializado(SERIAL_FILE_NUMBER);

	}

	@Override
	public void crear(Juguete objeto) {
		listaJuguetes.add(objeto);
		escribirArchivoSerializado();

	}

	@Override
	public String mostrarDatos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean eliminarDato(int indice) {
		if (indice < 0 || indice >= listaJuguetes.size()) {
			return false;
		} else {
			listaJuguetes.remove(indice);
			escribirArchivoSerializado();
			return true;
		}
	}

	@Override
	public boolean actualizar(int indice, Juguete nuevoObjeto) {
		if (indice < 0 || indice >= listaJuguetes.size()) {
			return false;
		} else {
			listaJuguetes.set(indice, nuevoObjeto);
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
		return listaJuguetes.size();
	}

	@Override
	public void cargarDesdeArchivoSerializado(String url) {
		Object contenido = FileHandler.leerDesdeArchivoSerializado(url);
		if (contenido != null) {
			listaJuguetes = (ArrayList<Juguete>) contenido;
		} else {
			listaJuguetes = new ArrayList<Juguete>();
		}
	}

	@Override
	public void escribirArchivoSerializado() {
		FileHandler.escribirEnArchivoSerializado(SERIAL_FILE_NUMBER, listaJuguetes);

	}

	public ArrayList<Juguete> getListaJuguetes() {
		return listaJuguetes;
	}

	public void setListaJuguetes(ArrayList<Juguete> listaJuguetes) {
		this.listaJuguetes = listaJuguetes;
	}

}
