package edu.utvt.attendance.persistence.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import edu.utvt.attendance.persistence.entities.Persona;

public interface PersonaService {

	
	Persona save(Long id, Persona persona);

	Persona update(Long id, Persona persona);
	
	List<Persona> finAll();
	
	Optional<Persona> findById(Long id);
	
	ResponseEntity<Persona> deleteById(Long id);
	
	Page<Persona> get(Integer page, Integer size);
	
	Page<Persona>findAll(Integer page, Integer size);
	
	List<Persona> getAll();
	
	Page<Persona> getPersona(Integer page, Integer size);
	
	Persona save(Persona persona);
	
	static Optional<Persona>getPersonaById(Long id){
		return null;
	
	}

	List<Persona> findAll();
}
