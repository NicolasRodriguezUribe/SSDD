package es.ssdd.EjercicioSpringData.repositories;

import es.ssdd.EjercicioSpringData.entities.Cervecero;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CerveceroRepository extends JpaRepository<Cervecero, Long> {
}
