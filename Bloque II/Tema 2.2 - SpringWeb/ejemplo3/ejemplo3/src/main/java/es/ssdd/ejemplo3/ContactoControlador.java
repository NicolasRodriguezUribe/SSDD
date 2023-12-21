package es.ssdd.ejemplo3;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ContactoControlador {
    @GetMapping("/contacto")
    public String mostrarFormulario(Model model) {
        model.addAttribute("mensaje", new Mensaje());
        return "contacto";
    }
    @PostMapping("/contacto")
    public String procesarFormulario(Mensaje mensaje, Model model) {
        System.out.println("El mensaje de:" + mensaje.getCorreo() + " se ha mandado");
        model.addAttribute("exito", true);
        return "contacto"; }
}

