package es.ssdd.SpringDataEjemplo2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    private LibroRepository libroRepository;

    @Override
    public void run(String... args) throws Exception {
        Autor autor = new Autor();
        autor.setNombre("Gabriel García Márquez");

        Libro libro = new Libro();
        libro.setTitulo("Cien años de soledad");
        libro.setAutor(autor);

        autor.getLibros().add(libro);

        autorRepository.save(autor);
    }
}