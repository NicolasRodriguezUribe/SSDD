package es.ssdd.ejemplo3;

public class Mensaje {
    private String nombre;
    private String correo;
    private String contenido;
// Constructor, getters y setters


    public Mensaje() {
    }

    public Mensaje(String nombre, String correo, String contenido) {
        this.nombre = nombre;
        this.correo = correo;
        this.contenido = contenido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
}
