package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.AlimentoYBebida;

public class AlimentoYBebidaDAO implements DAO<AlimentoYBebida> {

	private ArrayList<AlimentoYBebida> listaAlimentosYBebidas;
	private final String SERIAL_FILE_NAME = "AlimentosYBebidas.bin";

	public AlimentoYBebidaDAO() {
		listaAlimentosYBebidas = new ArrayList<AlimentoYBebida>();
		cargarDesdeArchivoSerializado(SERIAL_FILE_NAME);
	}

	@Override
	public void crear(AlimentoYBebida objeto) {
		listaAlimentosYBebidas.add(objeto);
		escribirArchivoSerializado();
	}

	@Override
	public String mostrarDatos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean eliminarDato(int indice) {
		if (indice < 0 || indice >= listaAlimentosYBebidas.size()) {
			return false;
		} else {
			listaAlimentosYBebidas.remove(indice);
			escribirArchivoSerializado();
			return true;
		}
	}

	@Override
	public boolean actualizar(int indice, AlimentoYBebida nuevoObjeto) {
		if (indice < 0 || indice >= listaAlimentosYBebidas.size()) {
			return false;
		} else {
			listaAlimentosYBebidas.set(indice, nuevoObjeto);
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
		return listaAlimentosYBebidas.size();
	}

	@Override
	public void cargarDesdeArchivoSerializado(String url) {
		Object contenido = FileHandler.leerDesdeArchivoSerializado(url);
		if (contenido != null) {
			listaAlimentosYBebidas = (ArrayList<AlimentoYBebida>) contenido;
		} else {
			listaAlimentosYBebidas = new ArrayList<AlimentoYBebida>();
		}
	}

	@Override
	public void escribirArchivoSerializado() {
		FileHandler.escribirEnArchivoSerializado(SERIAL_FILE_NAME, listaAlimentosYBebidas);

	}

}