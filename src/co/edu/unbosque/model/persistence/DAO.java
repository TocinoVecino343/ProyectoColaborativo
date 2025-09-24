package co.edu.unbosque.model.persistence;

public interface DAO<E> {

	public void crear(E objeto);

	public String mostrarDatos();

	public boolean eliminarDato(int indice);

	public boolean actualizar(int indice, E nuevoObjeto);

	public String filtrarLetra(char letra);

	public String filtrarNombre(String nombre);

	public String filtrarMarca(String marca);

	public int contar();

	public void cargarDesdeArchivoSerializado(String url);

	public void escribirArchivoSerializado();
	
	public int buscarIndicePorId(int id);
}
