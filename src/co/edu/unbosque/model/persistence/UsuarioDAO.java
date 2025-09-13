package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.Usuario;

public class UsuarioDAO<Usuario> {

	private ArrayList<Usuario> listaUsuarios;
	private final String SERIAL_FILE_NAME = "Usuarios.bin";

	public UsuarioDAO() {
		listaUsuarios = new ArrayList<Usuario>();
		cargarDesdeArchivoSerializado(SERIAL_FILE_NAME);
	}

	public void crear(Usuario nuevoUsuario) {
		listaUsuarios.add(nuevoUsuario);
		escribirArchivoSerializado();
	}

	public boolean actualizar(int indice, Usuario usuarioActualizado) {
		if (indice < 0 || indice >= listaUsuarios.size()) {
			return false;
		} else {
			listaUsuarios.set(indice, usuarioActualizado);
			escribirArchivoSerializado();
			return true;
		}
	}

	public boolean eliminar(int indice) {
		if (indice < 0 || indice >= listaUsuarios.size()) {
			return false;
		} else {
			listaUsuarios.remove(indice);
			escribirArchivoSerializado();
			return true;
		}
	}

	public void cargarDesdeArchivoSerializado(String url) {
		Object contenido = FileHandler.leerDesdeArchivoSerializado(url);
		if (contenido != null) {
			listaUsuarios = (ArrayList<Usuario>) contenido;
		} else {
			listaUsuarios = new ArrayList<Usuario>();
		}
	}

	public void escribirArchivoSerializado() {
		FileHandler.escribirEnArchivoSerializado(SERIAL_FILE_NAME, listaUsuarios);
	}

}