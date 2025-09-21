package co.edu.unbosque.model.persistence;

import java.util.ArrayList;
import co.edu.unbosque.model.Usuario;

public class UsuarioDAO {

    private ArrayList<Usuario> listaUsuarios;
    private final String SERIAL_FILE_NAME = "Usuarios.bin";

    public UsuarioDAO() {
        listaUsuarios = new ArrayList<>();
        cargarDesdeArchivoSerializado(SERIAL_FILE_NAME);
    }

    public void crear(Usuario nuevoUsuario) {
        listaUsuarios.add(nuevoUsuario);
        escribirArchivoSerializado();
    }

    public boolean actualizar(int indice, Usuario usuarioActualizado) {
        if (indice < 0 || indice >= listaUsuarios.size()) return false;
        listaUsuarios.set(indice, usuarioActualizado);
        escribirArchivoSerializado();
        return true;
    }

    public boolean eliminar(int indice) {
        if (indice < 0 || indice >= listaUsuarios.size()) return false;
        listaUsuarios.remove(indice);
        escribirArchivoSerializado();
        return true;
    }

    public boolean existeCorreo(String email) {
        for (Usuario u : listaUsuarios) {
            if (u.getEmail().equalsIgnoreCase(email)) {
                return true;
            }
        }
        return false;
    }

    public Usuario login(String email, String contrasenia) {
        for (Usuario u : listaUsuarios) {
            if (u.getEmail().equalsIgnoreCase(email) && u.getContrasenia().equals(contrasenia)) {
                return u;
            }
        }
        return null;
    }

    public Usuario buscarPorEmail(String email) {
        for (Usuario u : listaUsuarios) {
            if (u.getEmail().equalsIgnoreCase(email)) {
                return u;
            }
        }
        return null;
    }

    public ArrayList<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void cargarDesdeArchivoSerializado(String url) {
        Object contenido = FileHandler.leerDesdeArchivoSerializado(url);
        if (contenido != null) {
            listaUsuarios = (ArrayList<Usuario>) contenido;
        } else {
            listaUsuarios = new ArrayList<>();
        }
    }
    public int buscarIndicePorId(int id) {
        for (int i = 0; i < listaUsuarios.size(); i++) {
            if (listaUsuarios.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    public void escribirArchivoSerializado() {
        FileHandler.escribirEnArchivoSerializado(SERIAL_FILE_NAME, listaUsuarios);
    }
}