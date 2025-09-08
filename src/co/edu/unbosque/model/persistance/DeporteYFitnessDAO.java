package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.DeporteYFitness;

public class DeporteYFitnessDAO extends DAO<DeporteYFitness> {
    
    private ArrayList<DeporteYFitness> listaDeporteYFitness;
    
    public DeporteYFitnessDAO() {
        super();
        this.listaDeporteYFitness = new ArrayList<>();
        this.lista = this.listaDeporteYFitness;
    }
    
    @Override
    public void crear(DeporteYFitness objeto) {
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
    public boolean actualizar(int indice, DeporteYFitness objeto) {
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
