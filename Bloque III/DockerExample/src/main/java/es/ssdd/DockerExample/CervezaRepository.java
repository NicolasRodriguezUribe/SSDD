package es.ssdd.DockerExample;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CervezaRepository extends CrudRepository<Cerveza, Long> {
}
