package es.ssdd.APIREST2;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class UsuarioRESTController {
    private Map<Integer, Usuario> usuarios = new HashMap<>();
    private AtomicInteger idCounter = new AtomicInteger();

    @PostMapping("/usuario")
    public ResponseEntity<String> agregarUsuario(@RequestBody Usuario usuario) {
        int userId = idCounter.incrementAndGet();
        usuarios.put(userId, usuario);
        return ResponseEntity.status(201).body("Usuario agregado con ID: " + userId);
    }
}
