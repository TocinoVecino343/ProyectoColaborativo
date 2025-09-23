package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.AlimentoYBebida;
import co.edu.unbosque.model.DeporteYFitness;

public class DeporteYFitnessDAO implements DAO<DeporteYFitness> {

	private ArrayList<DeporteYFitness> listaDeportesYFitness;
	private final String SERIAL_FILE_NAME = "DeportesYFitness.bin";

	public DeporteYFitnessDAO() {
		listaDeportesYFitness = new ArrayList<>();
		cargarDesdeArchivoSerializado(SERIAL_FILE_NAME);
	}

	@Override
	public void crear(DeporteYFitness objeto) {
		listaDeportesYFitness.add(objeto);
		escribirArchivoSerializado();
	}

	@Override
	public String mostrarDatos() {
		String contenido = "";
		for (DeporteYFitness deporteYFitness : listaDeportesYFitness) {
			
			contenido+= listaDeportesYFitness.toString() + "\n";
		}
		return contenido;
	}

	@Override
	public boolean eliminarDato(int indice) {
		if (indice < 0 || indice >= listaDeportesYFitness.size()) {
			return false;
		} else {
			listaDeportesYFitness.remove(indice);
			escribirArchivoSerializado();
			return true;
		}
	}

	@Override
	public boolean actualizar(int indice, DeporteYFitness nuevoObjeto) {
		if (indice < 0 || indice >= listaDeportesYFitness.size()) {
			return false;
		} else {
			listaDeportesYFitness.set(indice, nuevoObjeto);
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
		return listaDeportesYFitness.size();
	}

	@Override
	public void cargarDesdeArchivoSerializado(String url) {
		Object contenido = FileHandler.leerDesdeArchivoSerializado(url);
		if (contenido != null) {
			listaDeportesYFitness = (ArrayList<DeporteYFitness>) contenido;
		} else {
			listaDeportesYFitness = new ArrayList<DeporteYFitness>();
		}
	}

	@Override
	public void escribirArchivoSerializado() {
		FileHandler.escribirEnArchivoSerializado(SERIAL_FILE_NAME, listaDeportesYFitness);

	}

	public ArrayList<DeporteYFitness> getListaDeportesYFitness() {
		return listaDeportesYFitness;
	}

	public void setListaDeportesYFitness(ArrayList<DeporteYFitness> listaDeportesYFitness) {
		this.listaDeportesYFitness = listaDeportesYFitness;
	}
	
	public int buscarIndicePorId(int id) {
	    ArrayList<DeporteYFitness> lista = getListaDeportesYFitness();
	    for (int i = 0; i < lista.size(); i++) {
	        if (lista.get(i).getId() == id) {
	            return i;
	        }
	    }
	    return -1;
	}
	

}
