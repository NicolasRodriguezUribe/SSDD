package es.ssdd.APIRESTEjer2.controllers;

import es.ssdd.APIRESTEjer2.entities.Cerveza;
import es.ssdd.APIRESTEjer2.service.CervezaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CervezaController {
    @Autowired
    private CervezaService cervezaService;

    @GetMapping("/cervezas")
    public String listarCervezas(Model model) {
        model.addAttribute("cervezas", cervezaService.obtenerTodasLasCervezas());
        return "cervezas";
    }

    @GetMapping("/cerveza/agregar")
    public String mostrarFormularioAgregar(Model model) {
        model.addAttribute("cerveza", new Cerveza());
        return "agregar-cerveza";
    }

    @PostMapping("/cerveza/agregar")
    public String agregarCerveza(Cerveza cerveza) {
        cervezaService.crearCerveza(cerveza);
        return "redirect:/cervezas";
    }

    @GetMapping("/cerveza/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id, Model model) {
        Cerveza cerveza = cervezaService.obtenerCerveza(id);
        if (cerveza == null) {
            return "redirect:/cervezas";
        }
        model.addAttribute("cerveza", cerveza);
        return "editar-cerveza";
    }

    @PostMapping("/cerveza/editar")
    public String editarCerveza(Cerveza cerveza) {
        cervezaService.actualizarCerveza(cerveza.getId(), cerveza);
        return "redirect:/cervezas";
    }

    @GetMapping("/cerveza/eliminar/{id}")
    public String eliminarCerveza(@PathVariable Long id) {
        cervezaService.eliminarCerveza(id);
        return "redirect:/cervezas";
    }

    @GetMapping("/cerveza/detalles/{id}")
    public String mostrarDetallesCerveza(@PathVariable Long id, Model model) {
        Cerveza cerveza = cervezaService.obtenerCerveza(id);
        if (cerveza == null) {
            return "redirect:/cervezas";
        }
        model.addAttribute("cerveza", cerveza);
        return "detalles-cerveza";
    }
}
