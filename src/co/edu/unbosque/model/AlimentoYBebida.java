package co.edu.unbosque.model;

public class AlimentoYBebida extends Producto {
    
    private boolean esLiquido;
    private int cantidadProducto;
    private String tipoEnvase;
    private int unidadesEnvase;
    
    public AlimentoYBebida() {
        super();
    }
    
    public AlimentoYBebida(String nombre, String descripcion, String tipo, float precio, String marca, 
                            String vendedor, String caracteristicas, String calificacion,
                            boolean esLiquido, int cantidadProducto, String tipoEnvase, int unidadesEnvase) {
        super(nombre, descripcion, tipo, precio, marca, vendedor, caracteristicas, calificacion);
        this.esLiquido = esLiquido;
        this.cantidadProducto = cantidadProducto;
        this.tipoEnvase = tipoEnvase;
        this.unidadesEnvase = unidadesEnvase;
    }
    
    public AlimentoYBebida(boolean esLiquido, int cantidadProducto, String tipoEnvase, int unidadesEnvase) {
        super();
        this.esLiquido = esLiquido;
        this.cantidadProducto = cantidadProducto;
        this.tipoEnvase = tipoEnvase;
        this.unidadesEnvase = unidadesEnvase;
    }
    
    public AlimentoYBebida(String param1, String param2, float param3, String tipoEnvase,
                            float param4, int cantidadProducto, String param5, String param6,
                            String param7, boolean esLiquido, int unidadesEnvase, String param8) {
        super();
        this.esLiquido = esLiquido;
        this.cantidadProducto = cantidadProducto;
        this.tipoEnvase = tipoEnvase;
        this.unidadesEnvase = unidadesEnvase;
    }
    
    public AlimentoYBebida(String param1, String param2, String tipoEnvase, String param3, float param4,
                            String param5, float param6, int cantidadProducto, String param7, String param8,
                            String param9, boolean esLiquido, int unidadesEnvase) {
        super();
        this.esLiquido = esLiquido;
        this.cantidadProducto = cantidadProducto;
        this.tipoEnvase = tipoEnvase;
        this.unidadesEnvase = unidadesEnvase;
    }
    
    @Override
    public String usarProducto(String forma) {
        // TODO Auto-generated method stub
        return null;
    }
    
    public boolean isEsLiquido() {
        return esLiquido;
    }
    
    public void setEsLiquido(boolean esLiquido) {
        this.esLiquido = esLiquido;
    }
    
    public int getCantidadProducto() {
        return cantidadProducto;
    }
    
    public void setCantidadProducto(int cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }
    
    public String getTipoEnvase() {
        return tipoEnvase;
    }
    
    public void setTipoEnvase(String tipoEnvase) {
        this.tipoEnvase = tipoEnvase;
    }
    
    public int getUnidadesEnvase() {
        return unidadesEnvase;
    }
    
    public void setUnidadesEnvase(int unidadesEnvase) {
        this.unidadesEnvase = unidadesEnvase;
    }
    
    @Override
    public String toString() {
        return "AlimentosYBebidas [" + super.toString() + ", esLiquido=" + esLiquido + 
               ", cantidadProducto=" + cantidadProducto + ", tipoEnvase=" + tipoEnvase + 
               ", unidadesEnvase=" + unidadesEnvase + "]";
    }
}
