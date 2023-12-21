package es.ssdd.APIRESTEjer2.service;

import es.ssdd.APIRESTEjer2.entities.Cerveza;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Service
    public class CervezaService {
    private final Map<Long, Cerveza> cervezas = new HashMap<>();
    private final AtomicLong nextId = new AtomicLong();

    public Cerveza crearCerveza(Cerveza cerveza) {
        long id = nextId.incrementAndGet();
        cerveza.setId(id);
        cervezas.put(id, cerveza);
        return cerveza;
    }

    public Cerveza obtenerCerveza(Long id) {
        return cervezas.get(id);
    }

    public Collection<Cerveza> obtenerTodasLasCervezas() {
        return cervezas.values();
    }

    public Cerveza actualizarCerveza(Long id, Cerveza cerveza) {
        if (!cervezas.containsKey(id)) {
            return null;
        }
        cerveza.setId(id);
        cervezas.put(id, cerveza);
        return cerveza;
    }

    public void eliminarCerveza(Long id) {
        cervezas.remove(id);
    }
}
