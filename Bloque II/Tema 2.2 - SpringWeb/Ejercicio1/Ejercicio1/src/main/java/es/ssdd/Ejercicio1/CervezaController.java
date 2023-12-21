package es.ssdd.Ejercicio1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.concurrent.atomic.AtomicLong;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Controller
public class CervezaController {
    private Map<Long, Cerveza> cervezas = new ConcurrentHashMap<>();
    private AtomicLong contador = new AtomicLong();

    @GetMapping("/cervezas")
    public String listarCervezas(Model model) {
        model.addAttribute("cervezas", cervezas.values());
        return "cervezas";
    }

    @GetMapping("/cerveza/agregar")
    public String mostrarFormularioAgregar(Model model) {
        model.addAttribute("cerveza", new Cerveza());
        return "agregar-cerveza";
    }

    @PostMapping("/cerveza/agregar")
    public String agregarCerveza(Cerveza cerveza) {
        long id = contador.incrementAndGet();
        cerveza.setId(id);
        cervezas.put(id, cerveza);
        return "redirect:/cervezas";
    }

    @GetMapping("/cerveza/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id, Model model) {
        Cerveza cerveza = cervezas.get(id);
        if (cerveza == null) {
            return "redirect:/cervezas";
        }

        model.addAttribute("cerveza", cerveza);
        return "editar-cerveza";
    }

    @PostMapping("/cerveza/editar")
    public String editarCerveza(Cerveza cerveza) {
        cervezas.put(cerveza.getId(), cerveza);
        return "redirect:/cervezas";
    }

    @GetMapping("/cerveza/eliminar/{id}")
    public String eliminarCerveza(@PathVariable Long id) {
        cervezas.remove(id);
        return "redirect:/cervezas";
    }

    @GetMapping("/cerveza/detalles/{id}")
    public String mostrarDetallesCerveza(@PathVariable Long id, Model model) {
        Cerveza cerveza = cervezas.get(id);
        if (cerveza == null) {
            return "redirect:/cervezas";
        }

        model.addAttribute("cerveza", cerveza);
        return "detalles-cerveza";
    }

}
