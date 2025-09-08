package co.edu.unbosque.model.persistence;

import java.util.ArrayList;
import co.edu.unbosque.model.Juguete;

public class JugueteDAO extends DAO<Juguete> {
    
    private ArrayList<Juguete> listaJuguetes;
    
    public JugueteDAO() {
        super();
        this.listaJuguetes = new ArrayList<>();
        this.lista = this.listaJuguetes;
    }
    
    @Override
    public void crear(Juguete objeto) {
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
    public boolean actualizar(int indice, Juguete objeto) {
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
