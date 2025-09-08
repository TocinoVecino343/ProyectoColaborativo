package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.Vehiculo;

public class VehiculoDAO extends DAO<Vehiculo> {
    
    private ArrayList<Vehiculo> listaVehiculos;
    
    public VehiculoDAO() {
        super();
        this.listaVehiculos = new ArrayList<>();
        this.lista = this.listaVehiculos;
    }
    
    @Override
    public void crear(Vehiculo objeto) {
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
    public boolean actualizar(int indice, Vehiculo objeto) {
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
