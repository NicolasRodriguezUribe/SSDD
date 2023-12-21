package es.ssdd.EjercicioSpringData.repositories;

import es.ssdd.EjercicioSpringData.entities.Cerveza;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CervezaRepository extends JpaRepository<Cerveza, Long> {
}
