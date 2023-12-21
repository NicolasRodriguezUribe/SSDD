package es.ssdd.SpringDataEjemplo3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private EstudianteRepository estudianteRepository;

    @Override
    public void run(String... args) throws Exception {
        // Crear estudiantes
        Estudiante estudiante1 = new Estudiante();
        estudiante1.setNombre("Ana");

        Estudiante estudiante2 = new Estudiante();
        estudiante2.setNombre("Luis");

        // Crear cursos
        Curso curso1 = new Curso();
        curso1.setTitulo("Matemáticas");

        Curso curso2 = new Curso();
        curso2.setTitulo("Literatura");

        // Asignar estudiantes a cursos
        curso1.getEstudiantes().add(estudiante1);
        curso1.getEstudiantes().add(estudiante2);
        curso2.getEstudiantes().add(estudiante1);
        // ...

        estudiante1.getCursos().add(curso1);
        estudiante1.getCursos().add(curso2);
        estudiante2.getCursos().add(curso1);
        // ...

        // Guardar en la base de datos
        estudianteRepository.save(estudiante1);
        estudianteRepository.save(estudiante2);
        cursoRepository.save(curso1);
        cursoRepository.save(curso2);
    }
}
