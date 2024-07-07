package edu.utvt.attendance.persistence.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.utvt.attendance.persistence.entities.Persona;
import edu.utvt.attendance.persistence.service.PersonaService;

@RestController
@RequestMapping("/api/v1/PERSONA")
public class PersonaController {
	
	@Autowired
	private PersonaService PersonaService;
	
	@GetMapping("/All")
	public List<Persona> get(){
		return this.PersonaService.getAll();
	}
	
	@GetMapping
	public Page<Persona>findAll(@RequestParam(defaultValue = "1", value = "page") Integer page, Integer size){
		return this.PersonaService.findAll(page,size);
	}
	
	@PostMapping
	public ResponseEntity<Persona>save(@RequestBody Persona persona){
		return ResponseEntity.created(null).body(this.PersonaService.save(persona));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Persona> update(@PathVariable("id") Long id,@RequestBody Persona persona){
		return ResponseEntity.ok(this.PersonaService.update(id, persona));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Persona> findById(@PathVariable("id") Long id){
		return ResponseEntity.of(this.PersonaService.findById(id));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable("id") Long id){
		this.PersonaService.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}
	
	

