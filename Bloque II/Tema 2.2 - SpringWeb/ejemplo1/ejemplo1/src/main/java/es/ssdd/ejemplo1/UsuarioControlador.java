package es.ssdd.ejemplo1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UsuarioControlador {
    @GetMapping("/perfil")
    public String perfil(Model model) {
        Usuario usuario = new Usuario("JD", "juan@example.com", "DevOps.");
        model.addAttribute("usuario", usuario);
        return "perfil";
    }
}
