package es.ssdd.ejemplo1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SaludoController {
    @GetMapping("/saludo")
    public String saludo(Model model) {
        model.addAttribute("mensaje", "Hola, Mundo!");
        return "saludo";
    }
}
