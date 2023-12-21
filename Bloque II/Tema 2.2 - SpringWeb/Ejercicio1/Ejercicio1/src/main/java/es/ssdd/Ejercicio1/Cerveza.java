package es.ssdd.Ejercicio1;
public class Cerveza {
    private Long id;
    private String nombre;
    private String tipo;
    private Double alcohol; // Porcentaje de alcohol

    public Cerveza() {
    }

    public Cerveza(Long id, String nombre, String tipo, Double alcohol) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.alcohol = alcohol;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Double getAlcohol() {
        return alcohol;
    }

    public void setAlcohol(Double alcohol) {
        this.alcohol = alcohol;
    }

    // Constructor, getters y setters
}
