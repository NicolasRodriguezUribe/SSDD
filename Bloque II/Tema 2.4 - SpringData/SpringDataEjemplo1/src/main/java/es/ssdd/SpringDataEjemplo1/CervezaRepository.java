package es.ssdd.SpringDataEjemplo1;

import org.springframework.data.repository.CrudRepository;

public interface CervezaRepository extends CrudRepository<Cerveza, Long> {
}
