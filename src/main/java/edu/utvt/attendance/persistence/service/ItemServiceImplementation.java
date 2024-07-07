package edu.utvt.attendance.persistence.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import edu.utvt.attendance.persistence.entities.Item;
import edu.utvt.attendance.persistence.repositories.ItemRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class ItemServiceImplementation implements ItemService {
	

	    @Autowired
	    private ItemRepository repository;

	    @Override
	    public Item save(Long id, Item item) {
	        return null;
	    }

	    @Override
	    public Item update(Long id, Item item) {
	    	
	    	Optional<Item> ItemOptional = null;
			ItemOptional = this.findById(id);
			
			if(ItemOptional.isPresent()) {
				
				ItemOptional.get().setNombre(item.getNombre());
				ItemOptional.get().setPrecio(item.getPrecio());
				ItemOptional.get().setPersona(item.getPersona());
				
				return repository.save(item);
				
			}
	        return null;
	    }

	    @Override
	    public List<Item> findAll() {
	        return repository.findAll();
	    }

	    @Override
	    public Optional<Item> findById(Long id) {
	        return repository.findById(id);
	    }

	    @Override
	    public ResponseEntity<Item> deleteById(Long id) {
	        Optional<Item> ItemOptional = repository.findById(id);
	        if (ItemOptional.isPresent()) {
	            repository.deleteById(id);
	            return ResponseEntity.ok().build();
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }

	    @Override
	    public Page<Item> get(Integer page, Integer size) {
	        return repository.findAll(PageRequest.of(page, size));
	    }

	    @Override
	    public Page<Item> findAll(Integer page, Integer size) {
	        return repository.findAll(PageRequest.of(page, size));
	    }

	    @Override
	    public List<Item> getAll() {
	        return repository.findAll();
	    }

	    @Override
	    public Page<Item> getPersona(Integer page, Integer size) {
	        return repository.findAll(PageRequest.of(page, size));
	    }

	    @Override
	    public Item save(Item item) {
	        return repository.save(item);
	    }

		@Override
		public List<Item> finAll() {
			// TODO Auto-generated method stub
			return null;
		}

	}



	
