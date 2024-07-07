package edu.utvt.attendance;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.data.web.config.EnableSpringDataWebSupport.PageSerializationMode;

import com.github.javafaker.Faker;

import edu.utvt.attendance.persistence.entities.Item;
import edu.utvt.attendance.persistence.entities.Persona;
import edu.utvt.attendance.persistence.repositories.ItemRepository;
import edu.utvt.attendance.persistence.repositories.PeronsaRepository;

@SpringBootApplication
@EnableSpringDataWebSupport(pageSerializationMode = PageSerializationMode.VIA_DTO)
public class ExamenUnidadLlApplication implements CommandLineRunner {

    private final ItemRepository itemRepository;
    private final PeronsaRepository peronsaRepository;

    public ExamenUnidadLlApplication(ItemRepository itemRepository, PeronsaRepository peronsaRepository) {
        this.itemRepository = itemRepository;
        this.peronsaRepository = peronsaRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(ExamenUnidadLlApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Faker faker = new Faker();

        // Generar datos Persona
        List<Persona> personas = new ArrayList<>();
        for (int i = 0; i < 10; i++) { // Generamos 10 personas
            Persona persona = new Persona();
            persona.setNombre(faker.name().firstName());
            persona.setEdad(faker.number().numberBetween(18, 25)); 
            persona.setUniversidad(faker.university().name());
            persona.setCorreo(faker.internet().emailAddress());
            personas.add(persona);
        }
        
        peronsaRepository.saveAll(personas);

        // Generar datos Item
        List<Item> items = new ArrayList<>();
        for (Persona persona : personas) {
            for (int i = 0; i < 5; i++) { // Cada persona tiene 5 items asociados
                Item item = new Item();
                item.setNombre(faker.commerce().productName());
                item.setPersona(persona);
                item.setPrecio(1000);
                items.add(item);
            }
        }
        itemRepository.saveAll(items);
    }
}
