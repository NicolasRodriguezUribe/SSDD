package es.ssdd.EjercicioSpringData.entities;

import lombok.*;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;


@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class Cerveza {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String tipo;
    private Double alcohol;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cervecero_id")
    private Cervecero cervecero;

    @ManyToMany(cascade = { CascadeType.MERGE, CascadeType.MERGE })
    @JoinTable(
            name = "cerveza_ingrediente",
            joinColumns = @JoinColumn(name = "cerveza_id"),
            inverseJoinColumns = @JoinColumn(name = "ingrediente_id")
    )
    private Set<Ingrediente> ingredientes = new HashSet<>();

    public Cerveza(String nombre, String tipo, Double alcohol, Cervecero cervecero, Set<Ingrediente> ingredientes) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.alcohol = alcohol;
        this.cervecero = cervecero;
        this.ingredientes = ingredientes;
    }
}
