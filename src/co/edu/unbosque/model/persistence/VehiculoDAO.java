package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.Vehiculo;

public class VehiculoDAO implements DAO<Vehiculo> {

	private ArrayList<Vehiculo> listaVehiculos;
	private final String SERIAL_FILE_NAME = "Vehiculos.bin";

	public VehiculoDAO() {
		listaVehiculos = new ArrayList<Vehiculo>();
		cargarDesdeArchivoSerializado(SERIAL_FILE_NAME);
	}

	@Override
	public void crear(Vehiculo objeto) {
		listaVehiculos.add(objeto);
		escribirArchivoSerializado();

	}

	@Override
	public String mostrarDatos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean eliminarDato(int indice) {
		if (indice < 0 || indice >= listaVehiculos.size()) {
			return false;
		} else {
			listaVehiculos.remove(indice);
			escribirArchivoSerializado();
			return true;
		}
	}

	@Override
	public boolean actualizar(int indice, Vehiculo nuevoObjeto) {
		if (indice < 0 || indice >= listaVehiculos.size()) {
			return false;
		} else {
			listaVehiculos.set(indice, nuevoObjeto);
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
		return listaVehiculos.size();
	}

	@Override
	public void cargarDesdeArchivoSerializado(String url) {
		Object contenido = FileHandler.leerDesdeArchivoSerializado(url);
		if (contenido != null) {
			listaVehiculos = (ArrayList<Vehiculo>) contenido;
		} else {
			listaVehiculos = new ArrayList<Vehiculo>();
		}

	}

	@Override
	public void escribirArchivoSerializado() {
		FileHandler.escribirEnArchivoSerializado(SERIAL_FILE_NAME, listaVehiculos);

	}

	public ArrayList<Vehiculo> getListaVehiculos() {
		return listaVehiculos;
	}

	public void setListaVehiculos(ArrayList<Vehiculo> listaVehiculos) {
		this.listaVehiculos = listaVehiculos;
	}

	@Override
	public int buscarIndicePorId(int id) {
		ArrayList<Vehiculo> lista = getListaVehiculos();
		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i).getId() == id) {
				return i;
			}
		}
		return -1;
	}

}
