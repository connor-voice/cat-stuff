package com.bae.cats.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.bae.cats.domain.Cat;
import com.bae.cats.service.CatService;

@RestController
public class CatController {

	private CatService service;

	@Autowired
	public CatController(CatService service) {
		super();
		this.service = service;
	}

	@GetMapping("/helloworld")
	public String hello() {
		return "Hello, World!";
	}

	@PostMapping("/create")
	public ResponseEntity<Cat> createCat(@RequestBody Cat cat) {
		Cat created = this.service.createCat(cat);
		ResponseEntity<Cat> response = new ResponseEntity<Cat>(created, HttpStatus.CREATED);
		return response;
	}

	@GetMapping("/get")
	public List<Cat> getCats() {
		return this.service.getCats();

	}

	@GetMapping("/get/{id}")
	public Cat getCat(@PathVariable Integer id) {
		Cat getCat = this.service.getCat(id);
		return getCat;
	}

	@PutMapping("/replace/{id}")
	public ResponseEntity<Cat> replaceCat(@PathVariable Integer id, @RequestBody Cat newCat) {
		Cat replaceCat = this.service.replaceCat(id, newCat);
		ResponseEntity<Cat> response = new ResponseEntity<Cat>(replaceCat, HttpStatus.ACCEPTED);
		return response;
	}

	@DeleteMapping("/remove/{id}")
	public ResponseEntity<Cat> removeCat(@PathVariable Integer id) {
		this.service.removeCat(id);
		ResponseEntity<Cat> response = new ResponseEntity<Cat>(HttpStatus.NO_CONTENT);
		return response;
	}
}
