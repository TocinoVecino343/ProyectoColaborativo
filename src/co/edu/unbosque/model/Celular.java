package co.edu.unbosque.model;

public class Celular extends Producto {
    
    private String color;
    private int memoriaInterna;
    private int memoriaRam;
    private float largoPantalla;
    private float anchoPantalla;
    private float altoPantalla;
    private int camaraFrontal;
    private int camaraTrasera;
    private boolean poseeNfc;
    
    public Celular() {
        super();
    }
    
    public Celular(String nombre, String descripcion, String tipo, float precio, String marca, 
                  String vendedor, String caracteristicas, String calificacion,
                  String color, int memoriaInterna, int memoriaRam, float largoPantalla,
                  float anchoPantalla, float altoPantalla, int camaraFrontal, int camaraTrasera, boolean poseeNfc) {
        super(nombre, descripcion, tipo, precio, marca, vendedor, caracteristicas, calificacion);
        this.color = color;
        this.memoriaInterna = memoriaInterna;
        this.memoriaRam = memoriaRam;
        this.largoPantalla = largoPantalla;
        this.anchoPantalla = anchoPantalla;
        this.altoPantalla = altoPantalla;
        this.camaraFrontal = camaraFrontal;
        this.camaraTrasera = camaraTrasera;
        this.poseeNfc = poseeNfc;
    }
    
    public Celular(String color, int memoriaInterna, int memoriaRam, float largoPantalla,
                  float anchoPantalla, float altoPantalla, int camaraFrontal, int camaraTrasera, boolean poseeNfc) {
        super();
        this.color = color;
        this.memoriaInterna = memoriaInterna;
        this.memoriaRam = memoriaRam;
        this.largoPantalla = largoPantalla;
        this.anchoPantalla = anchoPantalla;
        this.altoPantalla = altoPantalla;
        this.camaraFrontal = camaraFrontal;
        this.camaraTrasera = camaraTrasera;
        this.poseeNfc = poseeNfc;
    }
    
    public Celular(String color, String param1, float largoPantalla, String param2, float anchoPantalla,
                  int memoriaInterna, String param3, String param4, String param5, String param6) {
        super();
        this.color = color;
        this.memoriaInterna = memoriaInterna;
        this.largoPantalla = largoPantalla;
        this.anchoPantalla = anchoPantalla;
    }
    
    public Celular(String color, String param1, float largoPantalla, String param2, float anchoPantalla,
                  int memoriaInterna, String param3, String param4, String param5, String param6,
                  String param7, int memoriaRam, int param8, float altoPantalla, float param9,
                  float param10, int camaraFrontal, int camaraTrasera, boolean poseeNfc) {
        super();
        this.color = color;
        this.memoriaInterna = memoriaInterna;
        this.memoriaRam = memoriaRam;
        this.largoPantalla = largoPantalla;
        this.anchoPantalla = anchoPantalla;
        this.altoPantalla = altoPantalla;
        this.camaraFrontal = camaraFrontal;
        this.camaraTrasera = camaraTrasera;
        this.poseeNfc = poseeNfc;
    }
    
    @Override
    public String usarProducto(String forma) {
        // TODO Auto-generated method stub
        return null;
    }
    
    public String getColor() {
        return color;
    }
    
    public void setColor(String color) {
        this.color = color;
    }
    
    public int getMemoriaInterna() {
        return memoriaInterna;
    }
    
    public void setMemoriaInterna(int memoriaInterna) {
        this.memoriaInterna = memoriaInterna;
    }
    
    public int getMemoriaRam() {
        return memoriaRam;
    }
    
    public void setMemoriaRam(int memoriaRam) {
        this.memoriaRam = memoriaRam;
    }
    
    public float getLargoPantalla() {
        return largoPantalla;
    }
    
    public void setLargoPantalla(float largoPantalla) {
        this.largoPantalla = largoPantalla;
    }
    
    public float getAnchoPantalla() {
        return anchoPantalla;
    }
    
    public void setAnchoPantalla(float anchoPantalla) {
        this.anchoPantalla = anchoPantalla;
    }
    
    public float getAltoPantalla() {
        return altoPantalla;
    }
    
    public void setAltoPantalla(float altoPantalla) {
        this.altoPantalla = altoPantalla;
    }
    
    public int getCamaraFrontal() {
        return camaraFrontal;
    }
    
    public void setCamaraFrontal(int camaraFrontal) {
        this.camaraFrontal = camaraFrontal;
    }
    
    public int getCamaraTrasera() {
        return camaraTrasera;
    }
    
    public void setCamaraTrasera(int camaraTrasera) {
        this.camaraTrasera = camaraTrasera;
    }
    
    public boolean isPoseeNfc() {
        return poseeNfc;
    }
    
    public void setPoseeNfc(boolean poseeNfc) {
        this.poseeNfc = poseeNfc;
    }
    
    @Override
    public String toString() {
        return "Celular [" + super.toString() + ", color=" + color + ", memoriaInterna=" + memoriaInterna + 
               ", memoriaRam=" + memoriaRam + ", largoPantalla=" + largoPantalla + 
               ", anchoPantalla=" + anchoPantalla + ", altoPantalla=" + altoPantalla + 
               ", camaraFrontal=" + camaraFrontal + ", camaraTrasera=" + camaraTrasera + 
               ", poseeNfc=" + poseeNfc + "]";
    }
}