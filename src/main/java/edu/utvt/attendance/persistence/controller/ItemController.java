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

import edu.utvt.attendance.persistence.entities.Item;
import edu.utvt.attendance.persistence.service.ItemService;

@RestController
@RequestMapping("/api/v2/ITEM")
public class ItemController {
	

	@Autowired
	private ItemService ItemService;
	
	@GetMapping("/All")
	public List<Item> get(){
		return this.ItemService.getAll();
	}
	
	@GetMapping
	public Page<Item>findAll(@RequestParam(defaultValue = "1", value = "page") Integer page, Integer size){
		return this.ItemService.findAll(page,size);
	}
	
	@PostMapping
	public ResponseEntity<Item>save(@RequestBody Item item){
		return ResponseEntity.created(null).body(this.ItemService.save(item));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Item> update(@PathVariable("id") Long id,@RequestBody Item item){
		return ResponseEntity.ok(this.ItemService.update(id, item));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Item> findById(@PathVariable("id") Long id){
		return ResponseEntity.of(this.ItemService.findById(id));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable("id") Long id){
		this.ItemService.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}
