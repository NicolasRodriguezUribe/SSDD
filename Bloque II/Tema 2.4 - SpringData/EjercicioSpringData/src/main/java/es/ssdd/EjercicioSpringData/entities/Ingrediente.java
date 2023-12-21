package es.ssdd.EjercicioSpringData.entities;

import es.ssdd.EjercicioSpringData.entities.Cerveza;
import lombok.*;
import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class Ingrediente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @ManyToMany(mappedBy = "ingredientes")
    private Set<Cerveza> cervezas = new HashSet<>();

    public Ingrediente(String nombre) {
        this.nombre = nombre;
    }
}
