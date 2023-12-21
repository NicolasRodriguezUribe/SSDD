package es.ssdd.ejemplo2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class ProductoControlador {
    @GetMapping("/productos")
    public String listarProductos(Model model) {
        List<Producto> productos = Arrays.asList(
                new Producto(1L, "Producto 1", 10.0, true),
                new Producto(2L, "Producto 2", 15.0, false));
        model.addAttribute("productos", productos);
        return "productos";
    }
}
