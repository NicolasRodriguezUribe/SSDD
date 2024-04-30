package es.ssdd.DockerExample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cervezas")
public class CervezaRESTController {
    @Autowired
    public CervezaService cervezaService;
    @PostMapping
    public Cerveza agregarCerveza(@RequestBody Cerveza cerveza) {
        return cervezaService.agregarCerveza(cerveza);
    }

    @GetMapping
    public Iterable<Cerveza> obtenerCervezas() {
        return cervezaService.obtenerCervezas();
    }
}
