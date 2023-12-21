package es.ssdd.APIRESTEjer2.controllers;

import es.ssdd.APIRESTEjer2.entities.Cerveza;
import es.ssdd.APIRESTEjer2.service.CervezaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;

@RestController
@RequestMapping("/api/cervezas")
public class CervezaRESTController {

    @Autowired
    private CervezaService cervezaService;

    @PostMapping
    public ResponseEntity<Cerveza> crearCerveza(@RequestBody Cerveza cerveza) {
        return ResponseEntity.status(201).body(cervezaService.crearCerveza(cerveza));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cerveza> obtenerCerveza(@PathVariable Long id) {
        Cerveza cerveza = cervezaService.obtenerCerveza(id);
        if (cerveza == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(cerveza);
    }

    @GetMapping
    public ResponseEntity<Collection<Cerveza>> obtenerTodasLasCervezas() {
        return ResponseEntity.ok(cervezaService.obtenerTodasLasCervezas());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cerveza> actualizarCerveza(@PathVariable Long id, @RequestBody Cerveza cerveza) {
        Cerveza actualizada = cervezaService.actualizarCerveza(id, cerveza);
        if (actualizada == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(actualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCerveza(@PathVariable Long id) {
        cervezaService.eliminarCerveza(id);
        return ResponseEntity.ok().build();
    }
}

