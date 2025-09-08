package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

public abstract class DAO<T> {
    
    protected ArrayList<T> lista;
    
    public DAO() {
        super();
    }
    
    public abstract void crear(T objeto);
    public abstract String mostrarDatos();
    public abstract boolean eliminarDato(int indice);
    public abstract boolean actualizar(int indice, T objeto);
    public abstract String filtrarLetra(char letra);
    public abstract String filtrarNombre(String nombre);
    public abstract String filtrarMarca(String marca);
    public abstract int contar();
}
