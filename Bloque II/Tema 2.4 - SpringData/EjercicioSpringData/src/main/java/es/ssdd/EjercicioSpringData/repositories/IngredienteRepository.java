package es.ssdd.EjercicioSpringData.repositories;

import es.ssdd.EjercicioSpringData.entities.Ingrediente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredienteRepository extends JpaRepository<Ingrediente, Long> {
}
