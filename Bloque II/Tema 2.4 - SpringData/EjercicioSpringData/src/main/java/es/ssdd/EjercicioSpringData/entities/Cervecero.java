package es.ssdd.EjercicioSpringData.entities;

import jakarta.persistence.*;
import lombok.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class Cervecero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @OneToMany(mappedBy = "cervecero", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Cerveza> cervezas = new HashSet<>();

    public Cervecero(String nombre) {
        this.nombre = nombre;
    }
}
