package es.ssdd.ejemplo1;

public class Usuario {
    private String nombre;
    private String correo;
    private String biografia;
// Constructor, getters y setters


    public Usuario(String nombre, String correo, String biografia) {
        this.nombre = nombre;
        this.correo = correo;
        this.biografia = biografia;
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

    public String getBiografia() {
        return biografia;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }
}
