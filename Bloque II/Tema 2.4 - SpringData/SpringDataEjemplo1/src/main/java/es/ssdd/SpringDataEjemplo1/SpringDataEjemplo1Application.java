package es.ssdd.SpringDataEjemplo1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringDataEjemplo1Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SpringDataEjemplo1Application.class, args);
		CervezaRepository cervezaRepository = context.getBean(CervezaRepository.class);

		// Añadir algunas cervezas
		Cerveza cerveza1 = new Cerveza();
		cerveza1.setNombre("Corona");
		cerveza1.setTipo("Lager");
		cerveza1.setAlcohol(4.5);
		cervezaRepository.save(cerveza1);

		Cerveza cerveza2 = new Cerveza();
		cerveza2.setNombre("Guinness");
		cerveza2.setTipo("Stout");
		cerveza2.setAlcohol(4.2);
		cervezaRepository.save(cerveza2);

		// Leer y mostrar las cervezas
		cervezaRepository.findAll().forEach(cerveza -> System.out.println(cerveza.getNombre() + " - " + cerveza.getTipo() + " - " + cerveza.getAlcohol() + "%"));
	}
}
