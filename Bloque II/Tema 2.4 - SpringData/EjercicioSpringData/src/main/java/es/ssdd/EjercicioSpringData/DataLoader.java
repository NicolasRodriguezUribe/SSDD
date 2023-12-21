package es.ssdd.EjercicioSpringData;

import es.ssdd.EjercicioSpringData.entities.Cervecero;
import es.ssdd.EjercicioSpringData.entities.Cerveza;
import es.ssdd.EjercicioSpringData.entities.Ingrediente;
import es.ssdd.EjercicioSpringData.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.Arrays;
import java.util.HashSet;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private CerveceroRepository cerveceroRepository;
    @Autowired
    private CervezaRepository cervezaRepository;
    @Autowired
    private IngredienteRepository ingredienteRepository;

    @Override
    public void run(String... args) throws Exception {
        // Crear y guardar ingredientes
        Ingrediente lupulo = new Ingrediente("Lúpulo");
        Ingrediente malta = new Ingrediente("Malta");
        Ingrediente levadura = new Ingrediente("Levadura");
        ingredienteRepository.saveAll(Arrays.asList(lupulo, malta, levadura));

        // Crear y guardar cervecero
        Cervecero cervecero = new Cervecero("Cervecero Ejemplo");
        cerveceroRepository.save(cervecero);

        // Crear cervezas
        Cerveza alhambra = new Cerveza("Alhambra 1925", "Lager", 6.4, cervecero, new HashSet<>(Arrays.asList(lupulo, malta)));
        Cerveza estrellaGalicia = new Cerveza("Estrella Galicia", "Lager", 5.5, cervecero, new HashSet<>(Arrays.asList(lupulo, levadura)));

        // Guardar cervezas
        cervezaRepository.saveAll(Arrays.asList(alhambra, estrellaGalicia));
    }
}
