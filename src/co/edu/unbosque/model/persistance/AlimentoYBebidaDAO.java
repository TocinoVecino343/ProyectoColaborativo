package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.AlimentoYBebida;

public class AlimentoYBebidaDAO extends DAO<AlimentoYBebida> {
	
	private ArrayList<AlimentoYBebida> listaAlimentosYBebidas;

	public AlimentoYBebidaDAO() {
		super();
		this.listaAlimentosYBebidas = listaAlimentosYBebidas;
	}
	
	@Override
	public void crear(AlimentoYBebida objeto) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public String mostrarDatos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean eliminarDato(int indice) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean actualizar(int indice, AlimentoYBebida objeto) {
		// TODO Auto-generated method stub
		return false;
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
		// TODO Auto-generated method stub
		return 0;
	}

	
}