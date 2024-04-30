package es.ssdd.DockerExample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CervezaService{
    @Autowired
    private CervezaRepository cervezaRepository;

    public Cerveza agregarCerveza(Cerveza cerveza) {
        return cervezaRepository.save(cerveza);
    }

    public Iterable<Cerveza> obtenerCervezas() {
        return cervezaRepository.findAll();
    }
}
