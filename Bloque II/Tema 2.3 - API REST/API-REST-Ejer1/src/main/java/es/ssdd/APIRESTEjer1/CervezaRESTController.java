package es.ssdd.APIRESTEjer1;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/cervezas")
public class CervezaRESTController {
    private Map<Long, Cerveza> cervezas = new HashMap<>();
    private AtomicLong nextId = new AtomicLong();

    @PostMapping
    public ResponseEntity<Cerveza> crearCerveza(@RequestBody Cerveza cerveza) {
        long id = nextId.incrementAndGet();
        cerveza.setId(id);
        cervezas.put(id, cerveza);
        return ResponseEntity.status(201).body(cerveza); // 201 Created
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cerveza> obtenerCerveza(@PathVariable Long id) {
        Cerveza cerveza = cervezas.get(id);
        if (cerveza == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(cerveza);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cerveza> actualizarCerveza(@PathVariable Long id, @RequestBody Cerveza cerveza) {
        if (!cervezas.containsKey(id)) {
            return ResponseEntity.notFound().build();
        }
        cerveza.setId(id);
        cervezas.put(id, cerveza);
        return ResponseEntity.ok(cerveza);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCerveza(@PathVariable Long id) {
        if (!cervezas.containsKey(id)) {
            return ResponseEntity.notFound().build();
        }
        cervezas.remove(id);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Cerveza> actualizarParcialmenteCerveza(@PathVariable Long id, @RequestBody Cerveza parcialCerveza) {
        if (!cervezas.containsKey(id)) {
            return ResponseEntity.notFound().build();
        }
        Cerveza existente = cervezas.get(id);
        if (parcialCerveza.getNombre() != null) {
            existente.setNombre(parcialCerveza.getNombre());
        }
        if (parcialCerveza.getTipo() != null) {
            existente.setTipo(parcialCerveza.getTipo());
        }
        if (parcialCerveza.getAlcohol() != null) {
            existente.setAlcohol(parcialCerveza.getAlcohol());
        }
        cervezas.put(id, existente);
        return ResponseEntity.ok(existente);
    }

    @GetMapping
    public ResponseEntity<List<Cerveza>> obtenerTodasLasCervezas() {
        return ResponseEntity.ok(new ArrayList<>(cervezas.values()));
    }
}
