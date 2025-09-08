package co.edu.unbosque.model;

public class Usuario {
    
    private String nombre;
    private String nombreDeUsuario;
    private int documentoDeIdentidad;
    private String email;
    private int telefono;
    private String contrasenia;
    private String rutaImagenDePerfil;
    
    public Usuario() {
        super();
    }
    
    public Usuario(String nombre, String nombreDeUsuario, int documentoDeIdentidad, String email, 
                   int telefono, String contrasenia, String rutaImagenDePerfil) {
        super();
        this.nombre = nombre;
        this.nombreDeUsuario = nombreDeUsuario;
        this.documentoDeIdentidad = documentoDeIdentidad;
        this.email = email;
        this.telefono = telefono;
        this.contrasenia = contrasenia;
        this.rutaImagenDePerfil = rutaImagenDePerfil;
    }
    
    public Usuario(String nombre, String nombreDeUsuario, int documentoDeIdentidad, String email, int telefono, String contrasenia) {
        super();
        this.nombre = nombre;
        this.nombreDeUsuario = nombreDeUsuario;
        this.documentoDeIdentidad = documentoDeIdentidad;
        this.email = email;
        this.telefono = telefono;
        this.contrasenia = contrasenia;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getNombreDeUsuario() {
        return nombreDeUsuario;
    }
    
    public void setNombreDeUsuario(String nombreDeUsuario) {
        this.nombreDeUsuario = nombreDeUsuario;
    }
    
    public int getDocumentoDeIdentidad() {
        return documentoDeIdentidad;
    }
    
    public void setDocumentoDeIdentidad(int documentoDeIdentidad) {
        this.documentoDeIdentidad = documentoDeIdentidad;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public int getTelefono() {
        return telefono;
    }
    
    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
    
    public String getContrasenia() {
        return contrasenia;
    }
    
    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
    
    public String getRutaImagenDePerfil() {
        return rutaImagenDePerfil;
    }
    
    public void setRutaImagenDePerfil(String rutaImagenDePerfil) {
        this.rutaImagenDePerfil = rutaImagenDePerfil;
    }
    
    @Override
    public String toString() {
        return "Usuario [nombre=" + nombre + ", nombreDeUsuario=" + nombreDeUsuario + 
               ", documentoDeIdentidad=" + documentoDeIdentidad + ", email=" + email + 
               ", telefono=" + telefono + ", contrasenia=" + contrasenia + 
               ", rutaImagenDePerfil=" + rutaImagenDePerfil + "]";
    }
    
}
