package edu.utvt.attendance.persistence.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import edu.utvt.attendance.persistence.entities.Item;


public interface ItemService {
	
	Item save(Long id, Item item);

	Item update(Long id, Item item);
	
	List<Item> finAll();
	
	Optional<Item> findById(Long id);
	
	ResponseEntity<Item> deleteById(Long id);
	
	Page<Item> get(Integer page, Integer size);
	
	Page<Item>findAll(Integer page, Integer size);
	
	List<Item> getAll();
	
	Page<Item> getPersona(Integer page, Integer size);
	
	Item save(Item item);
	
	static Optional<Item>getItemById(Long id){
		return null;
	
	}

	List<Item> findAll();

}
