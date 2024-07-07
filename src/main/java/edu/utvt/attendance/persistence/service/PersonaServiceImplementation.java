package edu.utvt.attendance.persistence.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.utvt.attendance.persistence.entities.Persona;
import edu.utvt.attendance.persistence.repositories.PeronsaRepository;

@Service
@Transactional
public class PersonaServiceImplementation implements PersonaService {

    @Autowired
    private PeronsaRepository repository;

    @Override
    public Persona save(Long id, Persona persona) {
        return null;
    }

    @Override
    public Persona update(Long id, Persona persona) {
    	
    	Optional<Persona> personaOptional = null;
		personaOptional = this.findById(id);
		
		if(personaOptional.isPresent()) {
			
			personaOptional.get().setNombre(persona.getNombre());
			personaOptional.get().setEdad(persona.getEdad());
			personaOptional.get().setUniversidad(persona.getUniversidad());
			personaOptional.get().setCorreo(persona.getCorreo());
			personaOptional.get().setBirthDate(persona.getBirthDate());
			personaOptional.get().setItem(persona.getItem());


			return repository.save(persona);
			
		}
        return null;
    }

    @Override
    public List<Persona> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Persona> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public ResponseEntity<Persona> deleteById(Long id) {
        Optional<Persona> personaOptional = repository.findById(id);
        if (personaOptional.isPresent()) {
            repository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public Page<Persona> get(Integer page, Integer size) {
        return repository.findAll(PageRequest.of(page, size));
    }

    @Override
    public Page<Persona> findAll(Integer page, Integer size) {
        return repository.findAll(PageRequest.of(page, size));
    }

    @Override
    public List<Persona> getAll() {
        return repository.findAll();
    }

    @Override
    public Page<Persona> getPersona(Integer page, Integer size) {
        return repository.findAll(PageRequest.of(page, size));
    }

    @Override
    public Persona save(Persona persona) {
        return repository.save(persona);
    }

	@Override
	public List<Persona> finAll() {
		// TODO Auto-generated method stub
		return null;
	}

}


